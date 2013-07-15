import java.io.*;
import java.util.*;

/**
 * @name Isabella Moreira
 * @date 10/8/2012
**/

public class xkcd2
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("xkcd.in"));
        int totalSum = 42;
        int num = in.nextInt();
        int [] values = {2, 3, 4, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 22, 23, 24, 26};
        int [] perm;
        boolean [] used;
        
        while(num != 42)
        {
            perm = new int[num];
            used = new boolean[values.length];
            System.out.println("XKCD-like name(s) of length: "+num);
            
            /*** Needed to make boolean to check to see if any solutions existed... ***/
            if (!perm(0, num, totalSum, values, used, perm))
            	System.out.println("Mostly Harmless");

            num = in.nextInt();
        }
        System.out.println("The answer to life, the universe and everything!");
    }
    
    public static boolean perm(int index, int num, int totalSum, int [] values, boolean [] used, int [] perm)
    {
    	
    	
    	
        //base case
        if(index == num && totalSum == 0)
        {
			numToString(perm, num);
			return true;
			
        }
        
        if (index >= num) return false; /*** Prevent array out of bounds ***/
        
        //recursive solution
        boolean ans = false;
        /*** Generate in forward order, so list is alpha... ***/
        for(int i = 0; i < values.length; i++)
        {
        	// So we don't try values in a different ordering.
        	if (index > 0 && index < num-1 && values[i] > perm[index-1])
        		continue;
        	if (index == num-1 && values[i] < perm[index-1])
        		continue;
        	if (num > 2 && index == num-1 && values[i] > perm[index-2])
        		continue;
        		
            if(!used[i] && values[i] <= totalSum)
            {
                perm[index] = values[i];
                used[i] = true;
                totalSum-=values[i];
                /*** Don't call recursion if you don't need to... ***/
                /*** You have to add the || ans instead of ans || because of short-circuiting... ***/
                if (totalSum >= 0)
                	ans = perm(index+1, num, totalSum, values, used, perm) || ans;
                totalSum+= values[i]; /*** NEED THIS ***/
                used[i] = false;
            }
        }
        return ans;
    }
    
    //converts the arrangement of number permutations to its alpha representation
    //hardcoded
    //not sure why this method isn't working, but the logic works for in the above method
    public static void numToString(int [] perm, int num)
    {            

		/*** This is how you do this. ***/
        for(int i = 0; i <num; i++)
        {
            System.out.print((char)(perm[i]-1+'a'));
        }
        System.out.println();
    }
}