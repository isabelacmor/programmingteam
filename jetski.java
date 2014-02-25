import java.io.*;
import java.util.*;
/**
 * Write a description of class jetski here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class jetski
{
    public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2006\\jetski.in");
        Scanner scanner = new Scanner(file);
        
        int days = scanner.nextInt();
        double mph, mins, miles;
        int day = 1;
        double area;
        while(scanner.hasNextInt())
        {
            mph = scanner.nextInt();
            mins = scanner.nextInt();
            miles = (mph/60) * mins;
            area = (3.1415926535898 * (double)(miles*miles))/2;
            System.out.print("Day " + day + ": ");
            System.out.printf("%.2f", area);
            System.out.println();
            day++;
        }
    }
}
