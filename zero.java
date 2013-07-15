import java.io.*;
import java.util.*;

/**
 * Write a description of class zero here.
 * 
 * @author Isabella Moreira
 * @date 9/16/2012
 */
public class zero
{
    public static void main(String [] args) throws IOException
    {
       Scanner in = new Scanner(System.in); 
       int songVotes = in.nextInt();
       int vote;
       int count = 1;
       String blank, line;
       
       while(songVotes != 0)
       {
           blank = in.nextLine();
           line = in.nextLine();
           vote = 0;           
           for(int i = 0; i < songVotes; i++)
           {
               if(line.substring(i, i+1).equals("+"))
               {
                   vote++;
               }
               else
               {
                   vote--;
               }
           }           
           if(vote > 0){ System.out.println("Song " + count + ": Shreddin"); }
           else{ System.out.println("Song " + count + ": Guitar Zero"); }
           
           vote = 0;
           count++;
           songVotes = in.nextInt();
       }
    }
}
