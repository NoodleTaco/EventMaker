package project1;
//import java.util.Objects;
import java.util.Calendar;
import java.text.DecimalFormat;
/**
 * This class constructs event objects.
 * An event object holds a date, a starting time,a location, contact information, and a duration.
 * @author Micheal Kassie, Donald Yubeaton
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
     * Default Constructor
     */
    public Event() {
    }

    /**
     * creates an instance of the event with all its instance variables.
     * @param date date of the event creates
     * @param startTime starting time of the event creates
     * @param duration duration of the event creates
     * @param location location of the event creates
     */
    public Event(Date date,Timeslot startTime, int duration,Location location) {
        this.date = date;
        this.startTime= startTime;
        this.duration=duration;
        this.location= location;

    }

    /**
     * Returns the Event's date
     *
     * @return returns a Date object
     */
    public Date getDate() {
        return date;
    }

    /**
     * Returns the Event's contact
     *
     * @return returns a Contact object
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Returns the Event's location
     *
     * @return returns the location enum
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Returns the Event's Starting Time
     *
     * @return returns a TimeSlot enum
     */
    public Timeslot getStartTime() {
        return startTime;
    }

    /**
     * Returns the Event's duration
     *
     * @return returns an integer, representing the duration in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the event's contact
     *
     * @param contact the Contact object to be set as the event's contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * Sets the event's date
     *
     * @param date the Date object to be set as the event's date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets the event's location
     *
     * @param location the event's new location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Sets the event's starting time
     *
     * @param startTime the event's new starting time
     */
    public void setStartTime(Timeslot startTime) {
        this.startTime = startTime;
    }

    /**
     * Sets the event's duration
     *
     * @param duration the new duration of the event in minutes
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Concatenates a string that represents the start and end of the event
     * Uses the calendar class to add the duration of the event to the starting Timeslot
     * Accounts for changes from AM to PM
     *
     * @return a string that states the start and end times of the event
     */
    private String eventStartAndEnd() {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        String startingTime = ("[Start: " + decimalFormat.format(this.getStartTime().getHours()) + ":"
                + decimalFormat.format(this.getStartTime().getMinutes()) + this.getStartTime().getAmPm() + "] ");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, this.getStartTime().getHours());
        calendar.set(Calendar.MINUTE, this.getStartTime().getMinutes());
        if (this.getStartTime().getAmPm().equals("PM")) {
            calendar.add(Calendar.HOUR_OF_DAY, AM_PM_CONVERSION);
        }
        calendar.add(Calendar.MINUTE, this.duration);
        String amPm;
        String hour = decimalFormat.format(calendar.get(Calendar.HOUR_OF_DAY));
        if (calendar.get(Calendar.HOUR_OF_DAY) >= AM_PM_CONVERSION) {
            amPm = "PM";
            if (calendar.get(Calendar.HOUR_OF_DAY) >= AM_PM_CONVERSION_PAST_TWELVE) {
                hour = decimalFormat.format(calendar.get(Calendar.HOUR_OF_DAY) - AM_PM_CONVERSION);
            }
        } else {
            amPm = "AM";
        }
        String endingTime = ("[End: " + hour + ":" + decimalFormat.format(calendar.get(Calendar.MINUTE)) + amPm + "] ");
        return startingTime + endingTime;
    }

    /**
     * determines if the given event and an object passed are equal.
     * @param obj compared to instance of event to see if they are equal.
     * @return true if the parameter and the given instance of event are equal else returns false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            Event event = (Event) obj;
            return this.getDate().equals(event.getDate()) && this.getStartTime().equals(event.getStartTime()) &&
                    this.getLocation().equals(event.getLocation());
        }
        return false;

    }

    /**
     * it returns a string with its date, location, department and email.
     * @return a string containing all the information of an event.
     */
    @Override
    public String toString() {
        return "[Event Date:" + this.getDate().getMonth() + "/" + this.getDate().getDay() + "/" + this.getDate().getYear()
                + "] " + eventStartAndEnd() + "@" + this.getLocation() + " (" + this.getLocation().getBuilding() + ", "
                + this.getLocation().getCampus() + ") " + "[" + "Contact:" + this.getContact().getDepartment() + ", "
                + this.getContact().getEmail() + "]";
    }

    /**
     * it compares a given instance of an event with another instance of an event based on its date, time and duration.
     * @param event given instance of event and -1 or 1 based which event occurs first or ends first.
     * @return 0 if the events happen at the same time with same duration.
     */
    @Override
    public int compareTo(Event event) {
        if (this.getDate().compareTo(event.getDate()) != 0) {
            return this.getDate().compareTo(event.getDate());
        }
        if (this.getStartTime().compareTo(event.getStartTime()) != 0) {
            return this.getStartTime().compareTo(event.getStartTime());
        }
        if (this.duration > event.duration) {
            return 1;
        } else if (this.duration < event.duration) {
            return -1;
        }
        return 0;
    }

    /**
     * The test bed function calls test case methods to test the equals() method of the event class.
     * @param args string arguments passed from the command line.
     */
    public static void main(String[] args) {
        checkDateA();
        checkDateB();
        checkTimeA();
        checkLocationA();
        checkDateTimeLocationA();

    }

    /**
     * Test case #1 creates two event instances with different dates but with everything else same.
     * Calls test result and prints pass or fail if the expected and actual outputs are the same.
     */
    private static void checkDateA(){
        Date date1= new Date(2,2,2023);
        Date date2= new Date(8,13,2023);
        Event event1= new Event(date1,Timeslot.MORNING,30,Location.HLL114);
        Event event2= new Event(date2,Timeslot.MORNING,30,Location.HLL114);
        String s="CheckDateA";
        boolean expectedOutput= false;
        boolean actualOutput= event1.equals(event2);
        testResult(expectedOutput, actualOutput, s);

    }

    /**
     * Test case #2 creates two event instances with the same fields.
     * Calls test result and prints pass or fail if the expected and actual outputs are the same.
     */
    private static void checkDateB(){
        Date date1= new Date(2,2,2023);
        Date date2= new Date(2,2,2023);
        Event event1= new Event(date1,Timeslot.MORNING,30,Location.HLL114);
        Event event2= new Event(date2,Timeslot.MORNING,30,Location.HLL114);
        String s="CheckDateA";
        boolean expectedOutput= true;
        boolean actualOutput= event1.equals(event2);
        testResult(expectedOutput, actualOutput, s);


    }

    /**
     * Test case #3 creates two event instances with different starting times but with everything else same.
     * Calls test result and prints pass or fail if the expected and actual outputs are the same.
     */
    private static void checkTimeA(){
        Date date1= new Date(2,2,2023);
        Date date2= new Date(2,2,2023);
        Event event1= new Event(date1,Timeslot.AFTERNOON,30,Location.HLL114);
        Event event2= new Event(date2,Timeslot.MORNING,30,Location.HLL114);
        String s="CheckTimeA";
        boolean expectedOutput= false;
        boolean actualOutput= event1.equals(event2);
        testResult(expectedOutput, actualOutput, s);

    }

    /**
     * Test case #4 creates two event instances with different locations but with everything else same.
     * Calls test result and prints pass or fail if the expected and actual outputs are the same.
     */
    private static void checkLocationA(){
        Date date1= new Date(2,2,2023);
        Date date2= new Date(2,2,2023);
        Event event1= new Event(date1,Timeslot.AFTERNOON,30,Location.HLL114);
        Event event2= new Event(date2,Timeslot.AFTERNOON,30,Location.ARC103);
        String s="CheckLocationA";
        boolean expectedOutput= false;
        boolean actualOutput= event1.equals(event2);
        testResult(expectedOutput, actualOutput, s);


    }

    /**
     * Test case #5 creates two event instances with the same date, location, and timeslot but different durations
     * Calls test result and prints pass or fail if the expected and actual outputs are the same.
     */
    private static void checkDateTimeLocationA(){
        Date date1= new Date(2,2,2023);
        Date date2= new Date(2,2,2023);
        Event event1= new Event(date1,Timeslot.AFTERNOON,10,Location.HLL114);
        Event event2= new Event(date2,Timeslot.AFTERNOON,30,Location.HLL114);
        String s="CheckDateTimeLocationA";
        boolean expectedOutput= true;
        boolean actualOutput= event1.equals(event2);
        testResult(expectedOutput, actualOutput, s);

    }

    /**
    * Prints test passed if expected and actual outputs match otherwise prints failed.
     * @param expectedOutput to be compared with actualOutput
     * @param actualOutput to be compared with expectedOutput
     * @param s inserts the testcase for which the result is to be printed into the print statements.
     */
    private static void testResult(boolean expectedOutput, boolean actualOutput, String s){
        if(expectedOutput!=actualOutput){
            System.out.println("Test case "+s+" failed");
            return;

        }
        System.out.println("Test case "+s+" passed");

    }
}
