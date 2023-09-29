import java.util.Scanner;
import java.util.StringTokenizer;

public class EventOrganizer
{
    private EventCalendar eventCalendar;

    public EventOrganizer()
    {
        eventCalendar = new EventCalendar();
    }

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
            processInput(stringTokenizer);
        }

    }

    private void processInput(StringTokenizer stringTokenizer){
        if(stringTokenizer.hasMoreTokens()){

            String command = stringTokenizer.nextToken();
            if(command.equals("A")){
                processACommand(stringTokenizer);
            }
            else if(command.equals("R")){
                processRCommand(stringTokenizer);
            }
            else if(command.equals("P")){
                if(eventCalendar.isEmpty()) {System.out.println("Event calendar is empty!");}
                else {eventCalendar.print();}
            }
            else if(command.equals("PE")){
                if(eventCalendar.isEmpty()) {System.out.println("Event calendar is empty!");}
                else {eventCalendar.printByDate();}
            }
            else if(command.equals("PC")){
                if(eventCalendar.isEmpty()) {System.out.println("Event calendar is empty!");}
                else {eventCalendar.printByCampus();}
            }
            else if(command.equals("PD")){
                if(eventCalendar.isEmpty()) {System.out.println("Event calendar is empty!");}
                else {eventCalendar.printByDepartment();}
            }
            else{
                System.out.println(command+ " is an invalid command!");
            }
        }
    }

    private void processACommand(StringTokenizer stringTokenizer)
    {
        Event event = new Event();

        processDateInput(event,stringTokenizer.nextToken());

        processTimeInput(event,stringTokenizer.nextToken());

        processLocationInput(event,stringTokenizer.nextToken());

        processContactInput(event,stringTokenizer.nextToken(),stringTokenizer.nextToken());

        processDurationInput(event,stringTokenizer.nextToken());

        if(event.getDate() != null && event.getStartTime() != null && event.getLocation() != null && event.getContact() != null && event.getDuration() != 0)
        {
            if (eventCalendar.contains(event))
            {
                System.out.println("The event is already on the calendar.");
            }
            else
            {
                eventCalendar.add(event);
                System.out.println("Event added to the calendar.");
            }
        }
    }
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

    private void processDateInput(Event event, String dateInput)
    {
        StringTokenizer slashSeparator = new StringTokenizer(dateInput, "/");

        Date date = new Date(Integer.parseInt( slashSeparator.nextToken()),Integer.parseInt(slashSeparator.nextToken()), Integer.parseInt(slashSeparator.nextToken()));
        if(!date.isValid(date))
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
            System.out.print("Invalid time slot!");
        }
    }

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
            System.out.print("Invalid location!");
        }
    }

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

    private void processDurationInput(Event event, String durationInput)
    {
        int duration = Integer.parseInt(durationInput);
        if(duration >= 30 && duration <= 120)
        {
            event.setDuration(duration);
        }
        else
        {
            System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
        }
    }


    //Using temporarily for testing
    private static void printTokenizer(StringTokenizer stringTokenizer)
    {

        while (stringTokenizer.hasMoreTokens())
        {
            System.out.println(stringTokenizer.nextToken());
        }
    }
    //Temporary Testbed Main
    public static void main(String[] args)
    {


    }

}
