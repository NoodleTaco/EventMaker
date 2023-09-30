package project1;
//import java.util.Objects;
import java.util.Calendar;
import java.text.DecimalFormat;
public class Event implements Comparable<Event> {
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;



public Event(){

}

    public Date getDate() {
        return date;
    }

    public Contact getContact() {
        return contact;
    }

    public Location getLocation() {
        return location;
    }

    public Timeslot getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setStartTime(Timeslot startTime) {
        this.startTime = startTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private String eventStartAndEnd()
    {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        String startingTime = ("[Start: " + decimalFormat.format(this.getStartTime().getHours()) + ":" + decimalFormat.format(this.getStartTime().getMinutes()) + this.getStartTime().getAmPm() + "] ");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, this.getStartTime().getHours());
        calendar.set(Calendar.MINUTE, this.getStartTime().getMinutes());
        if(this.getStartTime().getAmPm().equals("PM"))
        {
            calendar.add(Calendar.HOUR_OF_DAY, 12);
        }
        calendar.add(Calendar.MINUTE, this.duration);
        String amPm;
        String hour =  decimalFormat.format(calendar.get(Calendar.HOUR_OF_DAY));
        if(calendar.get(Calendar.HOUR_OF_DAY) >= 12)
        {
            amPm = "PM";
            if(calendar.get(Calendar.HOUR_OF_DAY) >= 13)
            {
                hour = decimalFormat.format(calendar.get(Calendar.HOUR_OF_DAY) -12);
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
    /*
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;

        return Objects.equals(date, event.date) && Objects.equals(startTime, event.startTime) && Objects.equals(location, event.location);
        */

        if(obj instanceof Event)
        {
            Event event = (Event) obj;
            return this.getDate().equals(event.getDate()) && this.getStartTime().equals(event.getStartTime()) && this.getLocation().equals(event.getLocation());
        }
        return false;

    }
/*
    @Override
    public int hashCode() {
        return Objects.hash(date, startTime, location);
    }
*/
    @Override
     public String toString(){

          String s;
        s = "[Event Date:"+ this.getDate().getMonth()+"/"+this.getDate().getDay()+"/"+this.getDate().getYear()+"] "+ eventStartAndEnd()+ "@"+this.getLocation() +" ("+this.getLocation().getBuilding()+", "+ this.getLocation().getCampus()+") "+ "["+"Contact:"+ this.getContact().getDepartment()+", " +this.getContact().getEmail()+"]";
        return s;
    }


    @Override
    public int compareTo(Event o) {
               if(this.getDate().compareTo(o.getDate())!=0){
                   return this.getDate().compareTo(o.getDate());

               }
               if(this.getStartTime().getHours()<o.getStartTime().getHours()){
                   return -1;
               }
               else if(this.getStartTime().getHours()>o.getStartTime().getHours()){
                   return 1;
               }


               if(this.getStartTime().getMinutes()<o.getStartTime().getMinutes()){
                 return -1;
              }
              else if(this.getStartTime().getMinutes()>o.getStartTime().getMinutes()){
                return 1;
              }

                   return 0;


    }
}
