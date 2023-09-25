public enum Timeslot {
    MORNING(10, 30),
    AFTERNOON(14,0),
        EVENING(18,30);

    private final int hours;
    private final int minutes;

    Timeslot(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }
}
