import java.io.*;
import java.util.*;

/**
 * Write a description of class sorting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class letters
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);

        int numWords = in.nextInt();
        String blank = in.nextLine();
        
        while(numWords != 0)
        {
            String word = in.nextLine();
            word = word.replaceAll("l", "w");
            System.out.println(word);
            numWords--;
        }
    }
}