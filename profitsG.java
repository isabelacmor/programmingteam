import java.io.*;
import java.util.*;

public class profitsG {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numDays = in.nextInt();
		
		while(numDays != 0)
		{
			int [] nums = new int[numDays];
			//read in values
			for(int i = 0; i < numDays; i++)
			{
				nums[i] = in.nextInt();
			}
			
			calcSum2(numDays, nums);
						
			numDays = in.nextInt();
		}
	}
		
	public static void calcSum2(int numDays, int [] nums)
	{
		int maxSoFar = nums[0];
		int maxEndingHere = nums[0];
		for(int i = 1; i < numDays; i++)
		{
			maxEndingHere += nums[i];
			if(nums[i] > maxEndingHere) maxEndingHere = nums[i];
			if(maxEndingHere > maxSoFar) maxSoFar = maxEndingHere;
		}
		
		System.out.println(maxSoFar);
	}
}