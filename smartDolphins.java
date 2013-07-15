import java.io.*;
import java.util.*;

public class smartDolphins {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 1; i <= numCases; i++)
		{
			int numPellets = in.nextInt();
			int [] pel = new int[numPellets];
			
			for(int j = 0; j < numPellets; j++)
			{
				pel[j] = in.nextInt();
			}
			
			int [] maxI = lis(pel);
			int [] pelRev = revArray(pel);
			int [] maxD = lis(pelRev);
			
			
			int curMax = 0;
			for(int j = 0; j < pel.length; j++)
			{
				int tempMax = 0;
				int maxLoc = j;
				int maxLocRev = pel.length-maxLoc-1;
				if(maxLocRev != 0) tempMax = maxI[maxLoc] + maxD[maxLocRev-1];
				else tempMax = maxI[maxLoc]; //special case where the apex is the very first or last pellet
				
				if(tempMax > curMax) curMax = tempMax;
			}
			
			/*int maxEaten;
			if(maxLocRev != 0) maxEaten = maxI[maxLoc] + maxD[maxLocRev-1];
			else maxEaten = maxI[maxLoc]; //special case where the apex is the very first or last pellet 
			*/
			
			System.out.println("Case " + i + ":\nDynamo ate " + curMax + " food pellet(s).");
		}
	}
	
	public static int[] lis(int [] a)
	{
		int [] dp = new int[a.length];
		dp[0] = 1;
		
		for(int i = 1; i < a.length; i++)
		{
			int max = 1;
			for(int j = 0; j < i; j++)
			{
				if(a[j] <= a[i] && (1+dp[j] > max))	max = 1 + dp[j];
			}
			
			dp[i] = max;
		}
		
		/*
		System.out.println("LIST: ");
		printArray(dp);
		System.out.println("\n--------------------------\n\n");
		*/
		
		return dp;
	}
	
	public static int maxArrayInd(int [] a)
	{		
		//find the overall max val
		int max = a[0];
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] > max)	max = a[i];
		}
		
		
		//find the first instance of max
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] == max)
			{
				//System.out.println("MAX of " + max + " at index " + i);
				return i;
			}
		}
		
		return -1;
	}
	
	public static int[] revArray(int [] a)
	{
		for(int i = 0; i < a.length/2; i++)
		{
			int temp = a[i];
			a[i] = a[a.length-i-1];
			a[a.length-i-1] = temp;
		}
		
		return a;
	}
	
	public static void printArray(int [] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " | ");
		}
	}
}

/*

OTHER (incorrect) APPROACH
Another incorrect approach one would think of when first reading this problem is a greedy approach.
This would be done by finding the largest number in the list and automatically marking that as the
apex, and then solving the LIS of the left and right subsets. In reality, the largest number in the
list is not necessarily the apex of the pellets eaten or even a pellet chosen by Dynamo.

SAMPLE DATA
2
5
12 11 13 12 11
6
10 20 30 20 40 20

MY DATA
1 10
20 11 12 30 31 32 50 20 60 3

This case would break a greedy algo.
1 8
20 60 1 2 3 4 5 10

*/
