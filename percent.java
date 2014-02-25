import java.io.*;
import java.util.*;

/**
 * Write a description of class percent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class percent
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        String transform = in.nextLine();
        while(!transform.equals("#"))
        {
            String result = transform.replaceAll("%", "%25");
            result = result.replaceAll("!", "%21");
            result = result.replaceAll(" ", "%20");
            result = result.replaceAll("\\*", "%2a");
            result = result.replaceAll("\\(", "%28");
            result = result.replaceAll("\\)", "%29");
            result = result.replaceAll("\\$", "%24");
           
            System.out.println(result);
            
            transform = in.nextLine();
        }
    }
}
