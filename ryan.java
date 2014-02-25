import java.io.*;
import java.util.*;
/**
 * Write a description of class xkcd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ryan
{
    public static void main(String [] args) throws IOException{
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2010\\ryan.in");  
        Scanner scanner = new Scanner(file);
        int numTimes = scanner.nextInt();
        int numDone = 0;
        System.out.println(numTimes);
        for(int i = 0; i <= numTimes+1; i++)
        {
            if(scanner.hasNextLine())
            {
                String phrase = scanner.nextLine();
                System.out.println(phrase);
                if(phrase.equals("Greeks! Go home!"))
                {
                    numDone++;
                }
            }            
        }
        
        System.out.println("You've done: " + numDone);
        
        if(numDone >= numTimes)
        {
            System.out.println("You're done. Now don't do it again.");
        }
        else
        {
            System.out.println("You have " + (numTimes - numDone) + " left to go.");
        }
        
    }
}
