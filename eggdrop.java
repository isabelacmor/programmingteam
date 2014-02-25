import java.io.*;
import java.util.*;
/**
 * Write a description of class eggdrop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class eggdrop
{
    public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2010\\eggdrop.in");  
        Scanner scanner = new Scanner(file);
        int numTimes = scanner.nextInt();
        double maxV, maxH;
        int maxHint;
        for(int i = 0; i <= numTimes+1; i++)
        {
            if(scanner.hasNextInt())
            {
                maxV = scanner.nextInt();
                System.out.println("Maximum Velocity: " + maxV);
                maxH = ((maxV/9.8)*(maxV/9.8))*4.9;
                maxHint = (int)maxH;
                System.out.println("Egg Drop#" + i+1 + ": The maximum height is " + maxHint + " meter(s).");
            }
        }
    }
}
