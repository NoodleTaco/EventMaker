import java.util.Objects;

public class Event implements Comparable<Event> {
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

public  Event(date,startTime, location, contact, duration){
    date= this.date;
    startTime= this.startTime;
    contact= this.contact;
    duration= this.duration;

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



    @Override
    public int compareTo(Event o){
    return ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;

        return Objects.equals(date, event.date) && Objects.equals(startTime, event.startTime) && Objects.equals(location, event.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, startTime, location);
    }
    @Override
     public String toString(){
         return;

    }







}
