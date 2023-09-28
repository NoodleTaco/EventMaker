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
        numEvents ++;
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
            numEvents --;
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
        for(Event event: events)
        {
            System.out.println(event.toString());
        }
    } //print the array as is
    public void printByDate()
    {
        sortEventsByDate();
        print();

    } //ordered by date and timeslot
    public void printByCampus()
    {

    } //ordered by campus and building/room
    public void printByDepartment()
    {

    } //ordered by department

    public void sortEventsByDate() {
        quickSortByDate(0, numEvents - 1);
    }
    private void quickSortByDate(int low, int high) {
        if (low < high) {
            int pivotIndex = partitionByDate(low, high);
            quickSortByDate(low, pivotIndex - 1);
            quickSortByDate(pivotIndex + 1, high);
        }
    }
    private int partitionByDate(int low, int high) {
        Event pivot = events[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (events[j].getDate().compareTo(pivot.getDate()) < 0) { // Compare for closer date
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Event temp = events[i];
        events[i] = events[j];
        events[j] = temp;
    }

}
