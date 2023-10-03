package project1;
/**
 * This class stores event objects in an array and offers methods to interact with and print the array.
 * An instance of this class holds an array of events and the number of events in the array.
 * The class implements different sorting algorithms for the array of events
 * @author Donald Yubeaton, Micheal Kassie
 */
public class EventCalendar
    //NOTICE: Probably a lot of bugs in this, will test when Event class is working
{
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    public static final int EVENT_ARRAY_STARTING_SIZE = 4;

    public static final int NOT_FOUND = -1;

    /**
     * Default Constructor
    */
    public EventCalendar()
    {
        events = new Event[EVENT_ARRAY_STARTING_SIZE];
        this.numEvents = 0;
    }

    /**
     * Returns if the events array is empty
     * @return true if numEvents = 0, false otherwise
     */
    public boolean isEmpty()
    {
        return numEvents == 0;
    }
    /**
     * Checks if the events array contains a given event
     * @param event the event being searched for
     * @return returns the index of the event if found or -1 if it wasn't found
     */
    private int find(Event event)
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
    /**
     * Increases the size of the events array by 4
     * Initializes a new array and copies the contents of events into it
     */
    private void grow()
    {
        Event[] tempArray = new Event[numEvents + EVENT_ARRAY_STARTING_SIZE];
        for(int i = 0 ; i < numEvents; i++)
        {
            tempArray[i] = events[i];
        }
        events = tempArray;
    }
    /**
     * Adds an event to the end of the events array
     * @param event the event to be added to the array
     * @return false if event is already in the array, true otherwise
     */
    public boolean add(Event event)
    {
        if (find(event) != NOT_FOUND)
        {
            return false;
        }
        events[numEvents] = event;
        numEvents ++;

        if(numEvents == events.length)
        {
            grow();
        }
        return true;
    }
    /**
     * Removes an event in the events array
     * @param event the event to be removed from the array
     * return false if event is not in the array, true otherwise
     */
    public boolean remove(Event event)
    {
        if(find(event) != NOT_FOUND)
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
    /**
     * Prints the contents of the events array
     */
    public void print()
    {
        for(int i = 0; i < numEvents; i ++)
        {
            System.out.println(events[i].toString());
        }
    }
    /**
     * Sorts the events array by Date then prints its contents
     */
    public void printByDate()
    {
        sortByDate();
        print();

    }

    /**
     * Sorts the events array by Location then prints its contents
     */
    public void printByCampus()
    {
        sortByCampus();
        print();
    }

    /**
     * Sorts the events array by Department then prints its contents
     */
    public void printByDepartment()
    {
        sortByDepartment();
        print();
    } //ordered by department

    /**
     * Sorts the events array by Department
     * Order of Departments is in the order they are specified in Department
     * In Place algorithm
     */
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
    /**
     * Sorts the events array by the Date and time they occur
     * The events array is sorted from the earliest ending time to latest
     * In Place algorithm
     */
    public void sortByDate()
    {
        for (int i = 1; i < numEvents; i++)
        {
            Event pointer = events[i];
            int j = i - 1;
            while (j >= 0 && events[j].compareTo(pointer) > 0)
            {
                events[j + 1] = events[j];
                j = j - 1;
            }

            events[j + 1] = pointer;
        }
    }

    /**
     * Sorts the events array by Location
     * Order of Locations is in the order they are specified in Location
     * In Place algorithm
     */
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
