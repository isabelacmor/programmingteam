import java.io.*;
import java.util.*;

/**
 * Write a description of class conversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class conversions
{
    public static final double KGtoLB = 2.2046;
    public static final double LBtoKG = 0.4536;
    public static final double LItoGAL = 0.2642;
    public static final double GALtoLI = 3.7854;
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        int numCases = in.nextInt();
        int counter = 1;
        while(numCases != 0)
        {
            double value = in.nextDouble();
            String unit = in.next();
            String newUnit = "";
            
            if(unit.equals("kg"))
            {
                value *= KGtoLB;
                newUnit = "lb";
            }
            else if(unit.equals("lb"))
            {
                value *= LBtoKG;
                newUnit = "kg";
            }
            else if(unit.equals("l"))
            {
                value *= LItoGAL;
                newUnit = "g";
            }
            else if(unit.equals("g"))
            {
                value *= GALtoLI;
                newUnit = "l";
            }
            
            System.out.printf("%d %.4f %s\n", counter, value, newUnit);
            
            numCases--;
            counter++;
        }
    }
}