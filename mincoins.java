import java.util.*;
import java.io.*;
import java.math.*;

public class mincoins {
	
	final public static long MOD = 1000000000L;
	
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		//go through all cases
		for(int i = 0; i < numCases; i++)
		{
			int numNeed = in.nextInt();
			int numCoins = in.nextInt();
			
			//add all the coins available
			int [] pocket = new int [numCoins];
			for(int j = 0; j < numCoins; j++)
			{
				pocket[j] = in.nextInt();
			}
			
			/* Minimum coins needed to make change
			int minNeeded = minChange(pocket, numNeed);
			if(minNeeded != Integer.MAX_VALUE-1)
				System.out.println(minNeeded);
			else
				System.out.println("-1");
			*/
			
			/* Maximum ways to make change */
			System.out.println(maxWays(numNeed, pocket));
		}
	}
	
	public static long maxWays(int n, int [] pocket)
	{
		//our table of results
		//the indices represent the total we need
		long [] results = new long[n+1];
		
		//this is the base case: there's only one way to make change for 0 coins
		results[0] = 1;
		
		//we can try to use all the coins
		for(int i = 0; i < pocket.length; i++)
		{
			//find all the ways to make change for the least currency to the target number so we can build up our answer
			for(int j = pocket[i]; j <= n; j++)
			{
				//the result for (ex) 21 is the result of 21 minus the current currency we're using
				results[j] += results[j-pocket[i]];
			}
		}
		
		return results[n];
	}
	
	public static int minChange(int [] pocket, int numNeed)
	{
		//we define our 2D table to hold the number to make change for and the denominations available in our pocket
		int m = pocket.length+1;
		int n = numNeed+1;
		int inf = Integer.MAX_VALUE-1;
		int actualAmount;
		int [][] table = new int[m][n];
		
		//trying to make change for a target of 0 cents is always 0
		//in this case we use MAX_VAL because later when we're adding subsequent values, we need to take the minimum
		//and we never want to take extra coins if we're at 0
		for(int i = 1; i < n; i++)
		{
			table[0][i] = inf;
		}
		
		//go through all the rows and columns, starting with needing 1 coin (since we precomputed 0)
		for(int i = 1; i < m; i++)
		{
			for(int curAmount = 1; curAmount < n; curAmount++)
			{
				//we are able to make this transaction (and possibly have money left over that we need to make change for)
				if(curAmount - pocket[i-1] >= 0)
					actualAmount = table[i][curAmount-pocket[i-1]];
				//this transaction isn't possible
				else
					actualAmount = inf;
				table[i][curAmount] = Math.min(table[i-1][curAmount], 1+actualAmount);
			}
		}
		
		return table[pocket.length][numNeed];
	}
}