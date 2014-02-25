import java.io.*;
import java.util.*;
/**
 * Write a description of class seating here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class seating
{
     public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2002\\seating.in");
        Scanner scanner = new Scanner(file);
        
        int times = scanner.nextInt();
        int count = 1;
        int people, drivers, peopleCombo, total;

        while(times != 0)
        {
            people = 0;
            drivers = 0;
            peopleCombo = 1;
            total = 1;
            
            people = scanner.nextInt();
            drivers = scanner.nextInt();
            
            for(int i = 1; i < people; i++)
            {
                peopleCombo *= i;
            }
            total = peopleCombo*drivers;
            
            System.out.println("Data set #" + count + ": " + total + " combination(s) possible.");
           
            count++;
            times--;
        }
    }
}
