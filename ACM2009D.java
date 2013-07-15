import java.io.*;
import java.util.*;

public class ACM2009D {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("C:\\Users\\Isabella\\workspace\\JavaProjects\\src\\test.in"));
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++)
		{
			int curCase = in.nextInt();
			int totalNums = in.nextInt();
			
			ArrayList<Integer> terms = new ArrayList();
			ArrayList<Integer> medians = new ArrayList();
			int nums = 0;
			
			System.out.println(curCase + " " + (totalNums/2+1));
			
			for(int j = 0; j < totalNums; j++)
			{
				terms.add(in.nextInt());
				Collections.sort(terms);
				
				if(j % 2 == 0)
				{
					//max 10 terms per line
					nums %= 11;
					if(nums == 10)
					{
						nums = 0;
						System.out.print("\n");
					}
					
					//if the nums didn't print a line, it's going here
					if(nums != 0) System.out.print(" ");
					//keeps track of number of terms on the line so far
					nums++;
					//this will always be the median
					System.out.print(terms.get(j/2));
				}
			}
			
			System.out.println();
			//medians.add(terms.get(terms.size()/2));
			//System.out.println(medians);
		}
	}
}