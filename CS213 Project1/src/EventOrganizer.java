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

        String timeSlotCheck = stringTokenizer.nextToken();

        String locationCheck = stringTokenizer.nextToken();
        String departmentCheck = stringTokenizer.nextToken();
        String contactCheck = stringTokenizer.nextToken();
        String durationCheck = stringTokenizer.nextToken();

    }
    private void processRCommand(StringTokenizer stringTokenizer)
    {

    }

    private void processDateInput(Event event, String dateInput)
    {
        StringTokenizer slashSeparator = new StringTokenizer(dateInput, "/");
        Date date = new Date(Integer.parseInt( slashSeparator.nextToken()),Integer.parseInt(slashSeparator.nextToken()), Integer.parseInt(slashSeparator.nextToken()));
        if(date.isValid(date))
        {
            event.setDate(date);
        }
        else
        {
            System.out.println(date.toString() + ": Invalid calendar date!");
        }
    }

    private void processTimeInput(Event event, String timeSlotInput)
    {

    }

    private void processLocationInput(Event event, String locationInput)
    {

    }

    private void processDepartmentInput(Event event, String departmentInput)
    {

    }
    private void processContactInput(Event event, String contactInput)
    {

    }

    private void processDurationInput(Event event, String durationInput)
    {

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
        String testDate = ("10/21/2023");

        StringTokenizer strToken = new StringTokenizer(testDate, "/");
        printTokenizer(strToken);

    }

}
