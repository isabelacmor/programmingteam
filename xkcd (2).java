import java.io.*;
import java.util.*;

/**
 * @(#)xkcd.java
 *
 *
 * @author 
 * @version 1.00 2012/10/8
 */


public class xkcd 
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
			used = new boolean[num];
			perm(0, num, totalSum, values, used, perm);
			
			num = in.nextInt();
    	}
    }
    
    public static void perm(int index, int num, int totalSum, int [] values, boolean [] used, int [] perm)
    {
    	//base case
    	if(index == num)
    	{
    		for(int i = 0; i < num; i++)
    		{
    			System.out.println(perm[i]);
    		}
    	}
    	
    	//recursive solution
    	for(int i = 0; i < num; i++)
    	{
    		if(!used[i] && values[i] <= totalSum)
    		{
    			perm[index] = values[i];
    			used[i] = true;
    			perm(index+1, num, totalSum, values, used, perm);
    			used[i] = false;
    			totalSum-=values[i];
    		}
    	}
    }
    
    //converts the arrangement of number permutations to its alpha representation
    //hardcoded
    public String numToString(int [] perm)
    {
    	return "";
    }
}