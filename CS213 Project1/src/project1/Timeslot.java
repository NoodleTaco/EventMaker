package project1;
/**
 * Timeslots representing the starting times of events
 * @author Micheal Kassie, Donald Yubeaton
 */
public enum Timeslot {
    MORNING(10, 30,"AM"),
    AFTERNOON(2,00,"PM"),
        EVENING(6,30,"PM");

    private final int hour;
    private final int minute;
    private final String amPm;


    /**
     * Enum Constructor
     */
    Timeslot(int hour, int minute, String amPm) {
        this.hour = hour;
        this.minute = minute;
        this.amPm = amPm;
    }

    /**
     * Returns the Timeslot's amPM
     * @return a string value representing if the Timeslot is in AM or PM
     */
    public String getAmPm() {
        return amPm;
    }

    /**
     * Returns the Timeslot's minute value
     * @return the Timeslot's minute value
     */
    public int getMinutes() {
        return minute;
    }

    /**
     * Returns the Timeslot's hour value
     * @return the Timeslot's hour value
     */
    public int getHours() {
        return hour;
    }
}
