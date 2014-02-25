import java.io.*;
import java.util.*;
/**
 * Write a description of class diving here.
 * 
 * @author Isabella Moreira
 * @date 5/01/12
 * @purpose prep for UCF HSPT 2012
 * @time < 10 mins
 */
public class diving
{
    public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2002\\diving.in");
        Scanner scanner = new Scanner(file);
        
        int numDives = scanner.nextInt();
        int numFeet;
        int decMins, travelTime = 0;
        int airSupply = 60; //in minutes
        int timeBelow = 0;
        
        while(numDives != 0)
        {
            numFeet = scanner.nextInt();
            decMins = 0;
            travelTime = 0;
            airSupply = 60; //in minutes
            timeBelow = 0;
            //System.out.println("FEET: " + numFeet);
            if(numFeet >= 40)
            {
                decMins = (numFeet-30)/10;
            }
            airSupply -= decMins;
            travelTime = (numFeet/10)*2;
            timeBelow = airSupply - travelTime;
            if(timeBelow >= 0)
            {
                System.out.println(timeBelow + " minute(s) at " + numFeet + " feet");
            }
            else
            {
                System.out.println("0 minute(s) at " + numFeet + " feet");
            }
            
            numDives--;
        }
    }
}
