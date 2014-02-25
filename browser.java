import java.io.*;
import java.util.*;
/**
 * Write a description of class browser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class browser
{
    public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2006\\browser.in");
        Scanner scanner = new Scanner(file);
        
        ArrayList session = new ArrayList();
        String line;
        int index = 0;
        int back = 2;
        
        String start = scanner.nextLine();
        while(scanner.hasNextLine())
        {
            line = scanner.nextLine();
            if(line.equals("BACK"))
            {
                session.add(index, session.get(index-back));
                back+=2;
            }
            else if(line.equals("FORWARD"))
            {
                session.add(index, session.get(index-2));
                back = 2;
            }
            else if(line.equals("RELOAD"))
            {
                session.add(index, session.get(index-1));
                back = 2;
            }
            else
            {
                String [] bits = line.split(" ");
                session.add(bits[bits.length-1]);
                back = 2;
            }
            index++;
        }
        System.out.println("Browser Session #1:");
        for(int i = 0; i < session.size(); i++)
        {
            System.out.println(session.get(i));
        }
    }
}
