import java.io.*;
import java.util.*;
/**
 * Write a description of class tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tower
{
    public static void main (String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2008\\tower.in");
        Scanner scanner = new Scanner(file);
        
        int times = scanner.nextInt();
        double degs = 0;
        double rads = 0;
        double dist = 0;
        int count = 1;
        while(times != 0)
        {
            dist = scanner.nextDouble();
            rads = Math.acos(dist/56);
            degs = Math.toDegrees(rads);
            System.out.print("Target #" + count + ": ");
            System.out.printf("%.1f", degs);
            System.out.println(" degrees");
            count++;
            times--;
        }
    }
}
