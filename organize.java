import java.util.*;
import java.io.*;

public class organize
{
    public static void main (String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
       
        final int diaCD = 120;
        final int thickCD = 2;
        int [] dimensions = new int[3];
        dimensions[0] = in.nextInt();
        dimensions[1] = in.nextInt();
        dimensions[2] = in.nextInt();
        int numCD = in.nextInt();
        int count = 1;
       
        int thickTotal;
        boolean truth = false;

        while(dimensions[0] != 0 && dimensions[1] != 0 && dimensions[2] != 0 && numCD != 0)
        {
            //System.out.println("Current vals " + dimensions[0] + ", " + dimensions[1] + ", " + dimensions[2] + ", " + numCD);
            thickTotal = numCD * thickCD;
            Arrays.sort(dimensions);
            
            firstIf:
            if(dimensions[0] >= diaCD)
            {
                truth = true;
                dimensions[0] = -1;
                //System.out.println("Check out in first req");
            }
            else if(dimensions[1] >= diaCD)
            {
                truth = true;
                dimensions[1] = -1;         
                //System.out.println("Check out in first req");
            }
            else if(dimensions[2] >= diaCD)
            {
                truth = true;
                dimensions[2] = -1;
                //System.out.println("Check out in first req");
            }
            else
            {
                truth = false;
                //System.out.println("Box " + count + ": Stack of " + numCD + " discs does not fit.");
                //break firstIf;
            }
            //System.out.println(truth);
            //System.out.println("Entering second if");
            secondIf:
            if(truth == true)
            {
                if(dimensions[0] >= diaCD)
                {
                    truth = true;
                    dimensions[0] = -1;
                    //System.out.println("Check out in second req");
                }
                else if(dimensions[1] >= diaCD)
                {
                    truth = true;
                    dimensions[1] = -1;  
                    //System.out.println("Check out in second req");
                }
                else if(dimensions[2] >= diaCD)
                {
                    truth = true;
                    dimensions[2] = -1;
                    //System.out.println("Check out in second req");
                }
                else
                {
                    truth = false;
                    //System.out.println("Box " + count + ": Stack of " + numCD + " discs does not fit.");
                    //break secondIf;
                }
            }
            if(truth == true)
            {
                if(dimensions[0] >= thickTotal)
                {
                    System.out.println("Box " + count + ": Stack of " + numCD + " discs fits!"); 
                }
                else if(dimensions[1] >= thickTotal)
                {
                    System.out.println("Box " + count + ": Stack of " + numCD + " discs fits!"); 
                }
                else if(dimensions[2] >= thickTotal)
                {
                    System.out.println("Box " + count + ": Stack of " + numCD + " discs fits!"); 
                }
                else{System.out.println("Box " + count + ": Stack of " + numCD + " discs does not fit."); }
                }
            else{System.out.println("Box " + count + ": Stack of " + numCD + " discs does not fit."); }
            
            dimensions[0] = in.nextInt();
            dimensions[1] = in.nextInt();
            dimensions[2] = in.nextInt();
            numCD = in.nextInt();
            //System.out.println("Current vals " + dimensions[0] + ", " + dimensions[1] + ", " + dimensions[2] + ", " + numCD);
            count++;
         }
    }
}