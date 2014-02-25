import java.io.*;
import java.util.*;

public class stock2 {
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
			
			ArrayList<Integer> originalOrder = new ArrayList();
			ArrayList<Integer> lowCopy = new ArrayList();
			ArrayList<Integer> highCopy = new ArrayList();
			int [] low = new int[numLow];
			int [] high = new int[numHigh];
			
			//read in stock prices
			for(int i = 0; i < numDays; i++)
			{
				originalOrder.add(in.nextInt());
			}
			
			for(int i = 0; i < numDays; i++)
			{
				lowCopy.add(originalOrder.get(i));
				highCopy.add(originalOrder.get(i));
			}
			
			for(int i = 0; i < numLow; i++)
			{
				int smallest = lowCopy.get(0);
				int index = 0;
				for(int j = 0; j < lowCopy.size(); j++)
				{
					if(lowCopy.get(j) < smallest)
					{
						smallest = lowCopy.get(j);
						index = j;
					}
				}
				lowCopy.remove(index);
				System.out.print((index+1+i) + " ");
			}
			System.out.println();
			for(int i = 0; i < numHigh; i++)
			{
				int largest = highCopy.get(0);
				int index = 0;
				for(int j = 0; j < highCopy.size(); j++)
				{
					if(highCopy.get(j) > largest)
					{
						largest = highCopy.get(j);
						index = j;
					}
				}
				highCopy.remove(index);
				System.out.print((index+1+i) + " ");
			}
			
			//update
			System.out.println();
			numDays = in.nextInt();
			numLow = in.nextInt();
			numHigh = in.nextInt();
			count++;
		}
	}
	
	public static int findInd(int num, int [] list)
	{
		for(int i = 0; i < list.length; i++)
		{
			if(list[i] == num) return i;
		}
		
		return -1;
	}
}
