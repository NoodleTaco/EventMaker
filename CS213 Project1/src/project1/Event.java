package project1;
//import java.util.Objects;
import java.util.Calendar;
import java.text.DecimalFormat;
/**
 This class constructs event objects.
 An event object holds a date, a starting time,a location, contact information, and a duration.
 @author Micheal Kassie, Donald Yubeaton
 */
public class Event implements Comparable<Event> {
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

    public static final int AM_PM_CONVERSION = 12;

    public static final int AM_PM_CONVERSION_PAST_TWELVE = 13;

    /**
     Default Constructor
     */
    public Event(){
    }

    /**
     Returns the Event's date
     @return returns a Date object
     */
    public Date getDate() {
        return date;
    }

    /**
     Returns the Event's contact
     @return returns a Contact object
     */
    public Contact getContact() {
        return contact;
    }

    /**
     Returns the Event's location
     @return returns the location enum
     */
    public Location getLocation() {
        return location;
    }

    /**
     Returns the Event's Starting Time
     @return returns a TimeSlot enum
     */
    public Timeslot getStartTime() {
        return startTime;
    }

    /**
     Returns the Event's duration
     @return returns an integer, representing the duration in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     Sets the event's contact
     @param contact the Contact object to be set as the event's contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     Sets the event's date
     @param date the Date object to be set as the event's date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     Sets the event's location
     @param location the event's new location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     Sets the event's starting time
     @param startTime the event's new starting time
     */
    public void setStartTime(Timeslot startTime) {
        this.startTime = startTime;
    }

    /**
     Sets the event's duration
     @param duration the new duration of the event in minutes
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     Concatenates a string that represents the start and end of the event
     Uses the calendar class to add the duration of the event to the starting Timeslot
     Accounts for changes from AM to PM
     @return a string that states the start and end times of the event
     */
    private String eventStartAndEnd()
    {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        String startingTime = ("[Start: " + decimalFormat.format(this.getStartTime().getHours()) + ":" + decimalFormat.format(this.getStartTime().getMinutes()) + this.getStartTime().getAmPm() + "] ");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, this.getStartTime().getHours());
        calendar.set(Calendar.MINUTE, this.getStartTime().getMinutes());
        if(this.getStartTime().getAmPm().equals("PM"))
        {
            calendar.add(Calendar.HOUR_OF_DAY, AM_PM_CONVERSION);
        }
        calendar.add(Calendar.MINUTE, this.duration);
        String amPm;
        String hour =  decimalFormat.format(calendar.get(Calendar.HOUR_OF_DAY));
        if(calendar.get(Calendar.HOUR_OF_DAY) >= AM_PM_CONVERSION)
        {
            amPm = "PM";
            if(calendar.get(Calendar.HOUR_OF_DAY) >= AM_PM_CONVERSION_PAST_TWELVE)
            {
                hour = decimalFormat.format(calendar.get(Calendar.HOUR_OF_DAY) -AM_PM_CONVERSION);
            }
        }
        else
        {
            amPm = "AM";
        }
        String endingTime = ("[End: " + hour + ":" +decimalFormat.format(calendar.get(Calendar.MINUTE)) + amPm + "] ");
        return startingTime + endingTime;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Event)
        {
            Event event = (Event) obj;
            return this.getDate().equals(event.getDate()) && this.getStartTime().equals(event.getStartTime()) && this.getLocation().equals(event.getLocation());
        }
        return false;

    }

    @Override
     public String toString(){

          String s;
        s = "[Event Date:"+ this.getDate().getMonth()+"/"+this.getDate().getDay()+"/"+this.getDate().getYear()+"] "+ eventStartAndEnd()+ "@"+this.getLocation() +" ("+this.getLocation().getBuilding()+", "+ this.getLocation().getCampus()+") "+ "["+"Contact:"+ this.getContact().getDepartment()+", " +this.getContact().getEmail()+"]";
        return s;
    }


    @Override
    public int compareTo(Event event) {
       if(this.getDate().compareTo(event.getDate())!=0){
           return this.getDate().compareTo(event.getDate());

       }
       if(this.getStartTime().compareTo(event.getStartTime()) != 0){
           return this.getStartTime().compareTo(event.getStartTime());
       }
       if(this.duration > event.duration)
       {
           return 1;
       }
       else if(this.duration < event.duration)
       {
           return -1;
       }
       return 0;
    }
}
