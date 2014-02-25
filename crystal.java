import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * Write a description of class crystal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class crystal
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("crystal.in"));
        
        int numC = in.nextInt();
        int count = 1;
        double f1, f2, a, t, b, c;
        
        while(numC != 0)
        {
            f1 = in.nextDouble();
            f2 = in.nextDouble();
            a = in.nextDouble();
            b = in.nextDouble();
            c = in.nextDouble();
            
            t = a*f1*f2*Math.log((b*c*Math.E*((c*(b*f2*f1-f1+f2))/a*f1*f2)*Math.log(Math.E))/a)-b*c*f1*f2*Math.log(Math.E)+c*f1*Math.log(Math.E)-c*f2*Math.log(Math.E);
            System.out.println("Crystal #" + count + ": " + t);
            
            numC--;
            count++;
        }
    }
}
