import java.util.*;
import java.io.*;

/**
 * Write a description of class schedule here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class schedule
{
     public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2002\\schedule.in");
        Scanner scanner = new Scanner(file);
        
        int rooms = scanner.nextInt();
        String name;
        String empty = scanner.nextLine();
        int meetings;
        int [] times;
        
        while(rooms != 0)
        {
            name = scanner.nextLine();
            System.out.println("NAME: " + name);
            meetings = scanner.nextInt();
            System.out.println("# MEETINGS: " + meetings);
            times = new int [meetings*2];
            
            for(int i = 0; i < times.length; i++)
            {
                times[i] = scanner.nextInt();
                System.out.println("TIMES : " + times[i]);
            }
            for(int j = 1; j < times.length; j+=2)
            {
                if( times[j] <= times[j+2] )
                {
                    System.out.print("CONFLICTS AT " + times[j+2] + "-" + times[j]);
                }
                else
                {
                    System.out.println("SCHEDULE OK!");
                }
            }
            
            rooms--;            
        }
    }
}
