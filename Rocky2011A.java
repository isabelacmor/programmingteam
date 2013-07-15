import java.io.*;
import java.util.*;

public class Rocky2011A {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numTerms = in.nextInt();
		int caseCounter = 1;
		
		while(numTerms != 0)
		{
			int [] terms = new int[numTerms];
			for(int i = 0; i < numTerms; i++)
			{
				terms[i] = in.nextInt();
			}
			
			int numIter = 0;
			
			while(!same(terms) && numIter < 1000)
			{
				terms = update(terms);
				numIter++;
			}
			
			if(same(terms)) System.out.println("Case " + caseCounter + ": " + numIter + " iterations");
			else System.out.println("Case " + caseCounter + ": not attained");
			
			numTerms = in.nextInt();
			caseCounter++;
		}
	}
	
	public static boolean same(int [] terms)
	{
		int val = terms[0];
		for(int i = 0; i < terms.length; i++)
		{
			if(terms[i] != val)
			{
				return false;
			}
		}
		return true;
	}
	
	public static int[] update(int [] terms)
	{
		int tempFirst = terms[0];
		//all but last term
		for(int i = 0; i < terms.length-1; i++)
		{
			terms[i] = Math.abs(terms[i] - terms[i+1]);
		}
		terms[terms.length-1] = Math.abs(terms[terms.length-1] - tempFirst);
		
		return terms;
	}
}