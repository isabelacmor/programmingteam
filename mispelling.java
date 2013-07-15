import java.io.*;
import java.util.*;

/**
 * Write a description of class mispelling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mispelling
{
   public static void main(String [] args) throws IOException
   {
       Scanner in = new Scanner(System.in);
       
       int numWords = in.nextInt();
       int counter = 1;
       
       while(numWords != 0)
       {
           int indexR = in.nextInt();
           String [] wordAr = in.next().split("");
           ArrayList <String> word = new ArrayList(Arrays.asList(wordAr));
           
           word.remove(indexR);
           
           System.out.print(counter + " ");
           for(int i = 0; i < word.size(); i++)
           {
               System.out.print(word.get(i));
           }
           System.out.println();
           
           numWords--;
           counter++;
       }
   }
}