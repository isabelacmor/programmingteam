import java.io.*;
import java.util.*;

/**
 * Write a description of class zero here.
 * 
 * @author Isabella Moreira
 * @date 9/16/2012
 */
public class splash
{
    public static void main(String [] args) throws IOException
    {
       Scanner in = new Scanner(System.in); 
       int times = in.nextInt();
       int area;
       
       while(times != 0)
       {
           area = in.nextInt() * in.nextInt();
           System.out.println(area);
           
           times--;
       }
    }    
}