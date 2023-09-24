import java.util.Scanner;
import java.util.StringTokenizer;
public class EventOrganizer
{
    public void run()
    {

    }
    //Testbed main, testing a loop that can handle multiple command line inputs and figuring out how string tokenizer sorts data
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
            while (st.hasMoreTokens())
            {
                System.out.println(st.nextToken());
            }

        }

    }

}
