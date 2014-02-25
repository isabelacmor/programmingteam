import java.io.*;
import java.util.*;

public class knitting {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numStitchesFirst = in.nextInt();
		int totalRows = in.nextInt();
		int rowsRepeat = in.nextInt();
		
		while(numStitchesFirst != 0 && totalRows !=0 && rowsRepeat != 0)
		{
			int totalSum = 0;
			int [] pattern = new int[rowsRepeat];
			for(int i = 0; i < rowsRepeat; i++)
			{
				pattern[i] = in.nextInt();
			}
			
			int curStitches = numStitchesFirst;
			totalSum+=curStitches;
			
			//System.out.println("totalSum: " + totalSum);
			
			//minimum case
			if(pattern.length == 1)
			{
				for(int i = 1; i < totalRows; i++)
				{
					curStitches+= pattern[0];
					totalSum+=curStitches;
					//System.out.println("curStitches: " + curStitches +  " totalSum: " + totalSum);
				}
			}
			else
			{
				int patIndex = 0;
				for(int i = 1; i < totalRows; i++)
				{
					if(patIndex < pattern.length)
					{
					}
					else
					{
						patIndex = 0; //reset the index for the pattern
						//System.out.println("reset patIndex");
					}
					curStitches+= pattern[patIndex];
					totalSum+=curStitches;
					patIndex++;
					//System.out.println("curStitches: " + curStitches +  " totalSum: " + totalSum + " patIndex: " + patIndex);
				}
			}
				
			System.out.println(totalSum);
			
			//get next vals
			numStitchesFirst = in.nextInt();
			totalRows = in.nextInt();
			rowsRepeat = in.nextInt();
		}
	}
}
