import java.io.*;
import java.util.*;

public class passwords {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++)
		{
			int numItems = in.nextInt();
			int toGet = in.nextInt();
			
			String [] items = new String[numItems];
			String blank = in.nextLine();
			
			for(int j = 0; j < numItems; j++)
			{
				items[j] = in.nextLine();
			}
			
			
		}
	}
}
