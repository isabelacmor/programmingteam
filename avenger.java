import java.io.*;
import java.util.*;
/**
 * Write a description of class avenger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class avenger
{
    public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2001\\avenger.in");
        Scanner scanner = new Scanner(file);
        
        int galsAvailable = 100;
        int sqftRoom;
        int possibleRooms = 0;
        int possibleSqft = 5000;
        int numRooms = scanner.nextInt();
        int totalSqft = 0;
        
        while(numRooms != 0)
        {
            sqftRoom = scanner.nextInt();
            
            if(sqftRoom <= possibleSqft && totalSqft <= possibleSqft)
            {
                possibleRooms++;
            }
            numRooms--;
        }
        System.out.println(possibleRooms);
        //System.out.println(numRooms);
    }
}
