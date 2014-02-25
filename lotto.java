import java.io.*;
import java.util.*;

/**
 * Write a description of class lotto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lotto extends ArrayList
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        ArrayList <Integer> numsUsed = new ArrayList();
        
        int numTicks = in.nextInt();
        while(numTicks!= 0)
        {
            boolean covered = true;
            for(int i = 0; i < numTicks*6; i++)
            {
                numsUsed.add(in.nextInt());
            }
            
            Collections.sort(numsUsed);
                        
            for(int j = 1; j <= 49; j++)
            {
                if(numsUsed.contains(j) && covered == true)
                {
                    
                }
                else
                {
                   System.out.println("No"); 
                   covered = false;
                   break;
                }
            }
            
            if(covered == true)
            {
                System.out.println("Yes");
            }
            
            numsUsed = new ArrayList();
            numTicks = in.nextInt();
        }
    }
}