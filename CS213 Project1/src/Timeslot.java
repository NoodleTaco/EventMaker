public enum Timeslot {
    MORNING(10, 30,"AM"),
    AFTERNOON(2,00,"PM"),
        EVENING(6,30,"PM");

    private final int hours;
    private final int minutes;
    private final String time;

    public String getAmPm() {
        return time;
    }

    Timeslot(int hours, int minutes, String time) {
        this.hours = hours;
        this.minutes = minutes;
        this.time = time;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }
}
