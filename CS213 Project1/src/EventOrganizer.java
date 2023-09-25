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

    private void processInput(StringTokenizer stringTokenizer)
    {
        if(stringTokenizer.hasMoreTokens())
        {
            String command = stringTokenizer.nextToken();
            if(command.equals("A"))
            {

            }
            else if(command.equals("R"))
            {

            }
            else if(command.equals("P"))
            {
                eventCalendar.print();
            }
            else if(command.equals("PE"))
            {
                eventCalendar.printByDate();
            }
            else if(command.equals("PC"))
            {
                eventCalendar.printByCampus();
            }
            else if(command.equals("PD"))
            {
                eventCalendar.printByDepartment();
            }
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Input:");
        while(true)
        {
            String line = scanner.nextLine();
            if (line.equals("Q"))
            {
                System.out.println("Closing EventOrganizer");
                break; // Exit the loop
            }
            StringTokenizer st = new StringTokenizer(line);


        }

    }

}
