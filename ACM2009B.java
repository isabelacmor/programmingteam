import java.io.*;
import java.util.*;

public class ACM2009B {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++)
		{
			int curCase = in.nextInt();
			int numTerms = in.nextInt();
			
			//read in terms
			int [] terms = new int[numTerms];
			for(int j = 0; j < numTerms; j++)
			{
				terms[j] = in.nextInt();
			}
			
			//this is the greatest subset total
			int total = calcTotal(terms);
			//this is the minimum subset total
			int ans = 0;
			
			//loop through all the terms while j is less than the number of terms
			//and the sum is less than half the total (we could possibly make two subsets each equal to half the total, never more)
			for(int j = 0, sumFirst = 0; (j < numTerms) && (sumFirst <= total/2); j++)
			{
				//the running sum
				//this will always be the minimum possible check 
				//since we move through the array in order from left to right
				sumFirst += terms[j];
				//if sumFirst is factor of total
				if(total % sumFirst == 0)
				{
					//we see if this will yield an equal subset throughout the set
					if(remainingSum(sumFirst, j+1, terms))
					{
						ans = sumFirst;
						break;
					}
				}
				//else you can't divide the set into this individual total
				//we need to add another number and see what happens
				else {}
			}
			
			if(ans > 0)	System.out.println(curCase + " " + ans);
			else System.out.println(curCase + " " + total);
			
		}
	}
	
	public static boolean remainingSum(int sumFirst, int start, int [] terms)
	{
		//remaining sum
		int remSum = 0;
		
		//loop from everything after the current term
		for(int i = start; i < terms.length; i++)
		{
			//add this to the remaining sum total
			remSum += terms[i];
			//if the remaining sum is more than the current sum
			//we can try to add another number
			if(remSum > sumFirst) return false;
			//if they're equal, we just start over counting at the next index because we've found a matching subset
			else if(remSum == sumFirst) remSum = 0;
		}
		//if we end up with another empty remaining sum, our first solution was never a possibility
		if(remSum != 0) return false;
		//or else, this is finally the feasible minimum answer
		return true;
	}
	
	public static int calcTotal(int [] terms)
	{
		int total = 0;
		for(int i = 0; i < terms.length; i++)
		{
			total += terms[i];
		}
		
		return total;
	}
}
