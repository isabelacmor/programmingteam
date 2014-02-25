import java.io.*;
import java.util.*;

public class ACM2009A {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++)
		{
			int curCase = in.nextInt();
			ArrayList<Integer> nums = new ArrayList();
						
			for(int j = 0; j < 10; j++)
			{
				nums.add(in.nextInt());
			}
			
			Collections.sort(nums);
			
			System.out.println(curCase + " " + nums.get(nums.size()-3));
		}
	}
}