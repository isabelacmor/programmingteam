import java.util.*;

/**
* Send stating num through the sequence.
* Make a list of all the numbers in the sequence.
* Find the length of the list.
* Compare with the current longest length.
* Keep if longer, toss if shorter.

* REPEAT
**/

public class P14LongestChain
{
   public static void main (String [] args)
   {
       int count = 1000000;
       int tempLen = 0;
       int tempStartingNum = 0;
       int len = 0;
       int startingNum = 0;
       while(count != 1)
       {
           len = seq(count);
           System.out.println("Current length: " + len + " at chain num: " + count);
           if(len > tempLen)
           { 
               tempLen = len;
               startingNum = count;
               System.out.println("We just assigned a new longest length of " + tempLen + " at a starting number of " + startingNum);
           }
           count--;
       }
       
       System.out.println("Longest chain is " + tempLen + " long and is produced by the number " + startingNum);
   }
   
   public static int seq (int n) //n is the starting number
   {
       List series = new ArrayList();
       
       while(n != 1 && n > 0)
       {
           if(n%2 == 0)
           {
               n /= 2;
               series.add(n);
           }
           else
           {
               n = (3*n) + 1;
               series.add(n);
           }
       }
       int length = series.size();
       series.clear();
       return length;
   }
}