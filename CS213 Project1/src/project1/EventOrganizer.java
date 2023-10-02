package project1;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 This class interprets user commands to interact with EventCalendar
 An instance of this class can process a single or multiple command lines.
 Processes command line inputs until Q is inputted.
 @author Donald Yubeaton, Micheal Kassie
 */
public class EventOrganizer
{
    private EventCalendar eventCalendar;

    public static final int MIN_DURATION = 30;

    public static final int MAX_DURATION = 120;


    /**
     Default Constructor
     Initializes a default EventCalendar
     */
    public EventOrganizer()
    {
        eventCalendar = new EventCalendar();
    }

    /**
     Starts the command line reader
     Stops when 'Q' is entered
     */
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Event Organizer running....");
        while(true)
        {
            String line = scanner.nextLine();
            if (line.equals("Q"))
            {
                System.out.println("Event Organizer terminated");
                break; // Exit the loop
            }
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            processCommand(stringTokenizer);
        }
    }

    /**
     Processes a single Command
     Calls upon other input processing methods based on the command
     @param stringTokenizer The StringTokenizer instance holding the command line input
     */
    private void processCommand(StringTokenizer stringTokenizer){
        if(stringTokenizer.hasMoreTokens()){
            String command = stringTokenizer.nextToken();
            switch (command) {
                case "A" -> processACommand(stringTokenizer);
                case "R" -> processRCommand(stringTokenizer);
                case "P" -> processPCommand();
                case "PE" -> processPECommand();
                case "PC" -> processPCCommand();
                case "PD" -> processPDCommand();
                default -> System.out.println(command + " is an invalid command!");
            }
        }
    }
    /**
     Prints the contents of eventCalendar
     Prints an error message if eventCalendar is empty
     */
    private void processPCommand()
    {
        if(eventCalendar.isEmpty())
        {
            System.out.println("Event calendar is empty!");
        }
        else
        {
            System.out.println("* Event calendar *");
            eventCalendar.print();
            System.out.println("* end of event calendar *");
        }
    }

    /**
     Prints the contents of eventCalendar sorted by date
     Prints an error message if eventCalendar is empty
     */
    private void processPECommand()
    {
        if(eventCalendar.isEmpty())
        {
            System.out.println("Event calendar is empty!");
        }
        else
        {
            System.out.println("* Event calendar by event date and start time *");
            eventCalendar.printByDate();
            System.out.println("* end of event calendar *");
        }
    }
    /**
     Prints the contents of eventCalendar sorted by location
     Prints an error message if eventCalendar is empty
     */
    private void processPCCommand()
    {
        if(eventCalendar.isEmpty())
        {
            System.out.println("Event calendar is empty!");
        }
        else
        {
            System.out.println("* Event calendar by campus and building *");
            eventCalendar.printByCampus();
            System.out.println("* end of event calendar *");
        }
    }
    /**
     Prints the contents of eventCalendar sorted by department
     Prints an error message if eventCalendar is empty
     */
    private void processPDCommand()
    {
        if(eventCalendar.isEmpty())
        {
            System.out.println("Event calendar is empty!");
        }
        else
        {
            System.out.println("* Event calendar by department *");
            eventCalendar.printByDepartment();
            System.out.println("* end of event calendar *");
        }
    }
    /**
     Processes the command to add an event to eventCalendar
     Creates a new event based on the input
     If the event already exists in eventCalendar, then an error message is printed, otherwise the event is added
     @param stringTokenizer the StringTokenizer instance that holds the appropriate arguments for the 'A' command
     */
    private void processACommand(StringTokenizer stringTokenizer)
    {
        Event event = new Event();

        processDateInput(event,stringTokenizer.nextToken());

        processTimeInput(event,stringTokenizer.nextToken());

        processLocationInput(event,stringTokenizer.nextToken());

        processContactInput(event,stringTokenizer.nextToken(),stringTokenizer.nextToken());

        processDurationInput(event,stringTokenizer.nextToken());

        if(event.getDate() != null && event.getStartTime() != null && event.getLocation() != null && event.getContact()
                != null && event.getDuration() != 0)
        {
            if (eventCalendar.add(event))
            {
                eventCalendar.add(event);
                System.out.println("Event added to the calendar.");

            }
            else
            {
                System.out.println("The event is already on the calendar.");
            }
        }
    }
    /**
     Processes the command to remove an event from eventCalendar
     Creates a new event based on the input
     If the event does not exist in eventCalendar, an error message is printed, otherwise it removes the event
     @param stringTokenizer the StringTokenizer instance that holds the appropriate arguments for the 'R' command
     */
    private void processRCommand(StringTokenizer stringTokenizer)
    {
        Event event = new Event();

        processDateInput(event,stringTokenizer.nextToken());

        processTimeInput(event,stringTokenizer.nextToken());

        processLocationInput(event,stringTokenizer.nextToken());

        if(event.getDate() != null && event.getStartTime() != null && event.getLocation() != null )
        {
            if (eventCalendar.remove(event))
            {
                System.out.println("Event has been removed from the calendar!");
            }
            else
            {
                System.out.println("Cannot remove; event is not in the calendar!");
            }
        }

    }

    /**
     Creates a Date object based on an input and sets it as an event's date
     Returns an appropriate error message if the date is invalid, a past date, or not within 6 months
     @param event the event to have its date set
     @param dateInput a string input that forms a Date object
     */
    private void processDateInput(Event event, String dateInput)
    {
        StringTokenizer slashSeparator = new StringTokenizer(dateInput, "/");

        Date date = new Date(Integer.parseInt( slashSeparator.nextToken()),Integer.parseInt(slashSeparator.nextToken()),
                Integer.parseInt(slashSeparator.nextToken()));
        if(!date.isValid())
        {
            System.out.println(date.toString() + ": Invalid calendar date!");
            return;
        }
        if(!date.notPast())
        {
            System.out.println(date.toString() + ": Event date must be a future date!");
            return;
        }
        if(!date.notLate())
        {
            System.out.println(date.toString() + ": Event date must be within 6 months!");
            return;
        }
        event.setDate(date);
    }

    /**
     Sets an event's StartingTime based on an input
     Prints an error message if the TimeSlot input is invalid
     @param event the event to have its StartingTime set
     @param timeSlotInput a string input that forms a TimeSlot
     */
    private void processTimeInput(Event event, String timeSlotInput)
    {
        if(timeSlotInput.equalsIgnoreCase("morning"))
        {
            event.setStartTime(Timeslot.MORNING);
        }
        else if(timeSlotInput.equalsIgnoreCase("afternoon"))
        {
            event.setStartTime(Timeslot.AFTERNOON);
        }
        else if(timeSlotInput.equalsIgnoreCase("evening"))
        {
            event.setStartTime(Timeslot.EVENING);
        }
        else
        {
            System.out.println("Invalid time slot!");
        }
    }
    /**
     Sets an event's Location based on an input
     Prints an error message if the Location input is invalid
     @param event the event to have its Location set
     @param locationInput a string input that forms a Location
     */
    private void processLocationInput(Event event, String locationInput)
    {
        if(locationInput.equalsIgnoreCase("arc103"))
        {
            event.setLocation(Location.ARC103);
        }
        else if(locationInput.equalsIgnoreCase("hll114"))
        {
            event.setLocation(Location.HLL114);
        }
        else if(locationInput.equalsIgnoreCase("ab2225"))
        {
            event.setLocation(Location.AB2225);
        }
        else if(locationInput.equalsIgnoreCase("mu302"))
        {
            event.setLocation(Location.MU302);
        }
        else if(locationInput.equalsIgnoreCase("be_aud"))
        {
            event.setLocation(Location.BE_AUD);
        }
        else if(locationInput.equalsIgnoreCase("til232"))
        {
            event.setLocation(Location.TIL232);
        }
        else
        {
            System.out.println("Invalid location!");
        }
    }

    /**
     Creates a Contact object based on an input and sets it as an event's contact
     Returns an appropriate error message if the email or department is invalid
     @param event the event to have its contact set
     @param departmentInput a string input that forms the department field in the contact object
     @param emailInput a string input that forms the email field in the contact object
     */
    private void processContactInput(Event event, String departmentInput, String emailInput)
    {
        //Error right now since Contact does not have default constructor
        Contact contact = new Contact();

        if(departmentInput.equalsIgnoreCase("bait"))
        {
            contact.setDepartment(Department.BAIT);
        }
        else if(departmentInput.equalsIgnoreCase("cs"))
        {
            contact.setDepartment(Department.CS);
        }
        else if(departmentInput.equalsIgnoreCase("ee"))
        {
            contact.setDepartment(Department.EE);
        }
        else if(departmentInput.equalsIgnoreCase("iti"))
        {
            contact.setDepartment(Department.ITI);
        }
        else if(departmentInput.equalsIgnoreCase("math"))
        {
            contact.setDepartment(Department.MATH);
        }
        else
        {
            System.out.println("Invalid contact information!");
            return;
        }

        contact.setEmail(emailInput);
        if(contact.isValid(contact))
        {
            event.setContact(contact);
        }
        else
        {
            System.out.println("Invalid contact information!");
        }
    }

    /**
     Sets an event's duration based on an input
     Prints an error message if the duration is not between 30 and 120 minutes
     @param event the event to have its duration set
     @param durationInput integer that forms the event's duration
     */
    private void processDurationInput(Event event, String durationInput)
    {
        int duration = Integer.parseInt(durationInput);
        if(duration >= MIN_DURATION && duration <= MAX_DURATION)
        {
            event.setDuration(duration);
        }
        else
        {
            System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
        }

    }
}
