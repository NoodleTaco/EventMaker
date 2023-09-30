public class EventCalendar
    //NOTICE: Probably a lot of bugs in this, will test when Event class is working
{
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    public static final int EVENT_ARRAY_STARTING_SIZE = 4;

    public static final int NOT_FOUND = -1;

    //Default Constructor
    public EventCalendar()
    {
        events = new Event[EVENT_ARRAY_STARTING_SIZE];
        this.numEvents = 0;
    }
    //Parameterized Constructor
    public EventCalendar(int numEvents)
    {
        events = new Event[numEvents];
        this.numEvents = numEvents;
    }

    public boolean isEmpty()
    {
        return numEvents == 0;
    }
    private int find(Event event) //search an event in the list
    {
        for(int i = 0; i < numEvents; i++)
        {
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
        Event[] tempArray = new Event[numEvents+4];
        for(int i = 0 ; i < numEvents; i++)
        {
            tempArray[i] = events[i];
        }
        events = tempArray;
    }
    public boolean add(Event event)
    {
        events[numEvents] = event;
        numEvents ++;

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
            for(int i = 0; i < numEvents; i++)
            {
                if(events[i].equals(event))
                {
                    for(int j = i; j < numEvents-1; j++)
                    {
                        events[j] = events[j+1];
                    }
                    events[events.length -1] = null;
                }
            }
            numEvents --;
            return true;
        }
        return false;


    }
    public boolean contains(Event event)
    {

        for(int i = 0; i < numEvents; i ++)
        {
            if(events[i].equals(event))
            {
                return true;
            }
        }
        return false;
    }
    public void print()
    {
        for(int i = 0; i < numEvents; i ++)
        {
            System.out.println(events[i].toString());
        }

    } //print the array as is
    public void printByDate()
    {
        sortByDate();
        print();

    } //ordered by date and timeslot
    public void printByCampus()
    {
        sortByCampus();
        print();
    } //ordered by campus and building/room
    public void printByDepartment()
    {
        sortByDepartment();
        print();
    } //ordered by department

    public void sortByDepartment()
    {
        for (int i = 1; i < numEvents; i++)
        {
            Event pointer = events[i];
            int j = i - 1;
            while (j >= 0 && events[j].getContact().getDepartment().compareTo(pointer.getContact().getDepartment()) > 0)
            {
                events[j + 1] = events[j];
                j = j - 1;
            }

            events[j + 1] = pointer;
        }
    }
    public void sortByDate()
    {
        for (int i = 1; i < numEvents; i++)
        {
            Event pointer = events[i];
            int j = i - 1;
            while (j >= 0 )
            {
                int dateAndTimeCompare = events[j].getDate().compareTo(pointer.getDate());
                if (dateAndTimeCompare == 0)
                {
                    dateAndTimeCompare = events[j].getStartTime().compareTo(pointer.getStartTime());
                }
                if(dateAndTimeCompare > 0)
                {
                    events[j + 1] = events[j];
                    j = j - 1;
                }
                else
                {
                    break;
                }

            }
            events[j + 1] = pointer;
        }
    }

    public void sortByCampus()
    {
        for (int i = 1; i < numEvents; i++)
        {
            Event pointer = events[i];
            int j = i - 1;
            while (j >= 0 && events[j].getLocation().compareTo(pointer.getLocation()) > 0)
            {
                events[j + 1] = events[j];
                j = j - 1;
            }

            events[j + 1] = pointer;
        }
    }

}
