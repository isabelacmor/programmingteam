import java.io.*;
import java.util.*;

/**
 * Write a description of class chalice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class chalice
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        int numTrials = in.nextInt();
        int count = 1;
        int witchWeight, flockWeight, numGeese;
        
        while(numTrials != 0)
        {
            witchWeight = in.nextInt();
            numGeese = in.nextInt();
            flockWeight = 0;
            
            for(int i = 0; i < numGeese; i++)
            {
                flockWeight += in.nextInt();
            }
            
            if(witchWeight <= flockWeight)
            {
                System.out.println("Trial #" + count + ": SHE'S A WITCH! BURN HER!");
            }
            else
            {
                System.out.println("Trial #" + count + ": She's not a witch. BURN HER ANYWAY!");
            }
            
            count++;
            numTrials--;
        }
    }
}
