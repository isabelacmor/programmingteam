import java.io.*;
import java.util.*;

public class stock {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numDays = in.nextInt();
		int numLow = in.nextInt();
		int numHigh = in.nextInt();
		
		int count = 1;
		
		while(numDays != 0 && numLow != 0 && numHigh != 0)
		{
			System.out.println("Case " + count);
			
			int [] originalOrder = new int[numDays];
			
			//read in stock prices
			for(int i = 0; i < numDays; i++)
			{
				originalOrder[i] = in.nextInt();
			}
			
			//System.out.println(quickSelect(originalOrder, 0, numDays-1, numHigh));
			System.out.println(runQuickSelect(originalOrder, 2));
			
			//update
			System.out.println();
			numDays = in.nextInt();
			numLow = in.nextInt();
			numHigh = in.nextInt();
			count++;
		}
	}
}
