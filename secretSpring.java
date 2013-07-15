import java.io.*;
import java.util.*;

/**
 * Write a description of class secretSpring here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class secretSpring
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("secretSpring.in"));
        
        int numTrips = in.nextInt();
        int count = 1;
        int countSpring = 0;
        int countWinter = 0;
        String blank = in.nextLine();
        while(count != numTrips+1)
        {
            String visit = in.nextLine();
            String [] letters = new String[visit.length()];
            letters = visit.split("");
            
            for(int i = 0; i < letters.length-1; i++)
            {
                if(letters[i].equals("S") && letters[i+1].equals("S"))
                {
                    countSpring++;
                }
                else if(letters[i].equals("S") && !letters[i+1].equals("S"))
                {
                    countWinter++;
                }
            }
            System.out.println("Case " + count + ": " + countSpring + " / " + countWinter);
            
            count++;
            countSpring = 0;
            countWinter = 0;
        }
    }
}