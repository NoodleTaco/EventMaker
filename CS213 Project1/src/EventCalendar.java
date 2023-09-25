public class EventCalendar
    //NOTICE: Probably a lot of bugs in this, will test when Event class is working
{
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    public static final int NOT_FOUND = -1;

    //Default Constructor
    public EventCalendar()
    {
        events = new Event[4];
        this.numEvents = 0;
    }
    //Parameterized Constructor
    public EventCalendar(int numEvents)
    {
        events = new Event[4];
        this.numEvents = numEvents;
    }
    private int find(Event event) //search an event in the list
    {
        for(int i = 0; i < events.length; i++)
        {
            if(events[i] == null)
            {
                return NOT_FOUND;
            }
            if(events[i].equals(event))
            {
                return i;
            }
        }
        return NOT_FOUND;

    }
    //increase events capacity by 4
    private void grow()
    {
        Event[] tempArray = new Event[events.length+4];
        for(int i = 0 ; i < events.length; i++)
        {
            tempArray[i] = events[i];
        }
        events = tempArray;
    }
    public boolean add(Event event)
    {
        events[numEvents] = event;
        if(numEvents == events.length)
        {
            grow();
        }
        return true;
    }
    public boolean remove(Event event)
    {
        if(contains(event))
        {
            for(int i = 0; i < events.length; i++)
            {
                if(events[i].equals(event))
                {
                    for(int j = i; j < events.length-1; j++)
                    {
                        events[j] = events[j+1];
                    }
                    events[events.length -1] = null;
                }
            }
            return true;
        }
        return false;


    }
    public boolean contains(Event event)
    {
        for(Event pointer: events)
        {
            if(pointer.equals(event))
            {
                return true;
            }
        }
        return false;
    }
    public void print()
    {

    } //print the array as is
    public void printByDate()
    {

    } //ordered by date and timeslot
    public void printByCampus()
    {

    } //ordered by campus and building/room
    public void printByDepartment()
    {

    } //ordered by department
}
