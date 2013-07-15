import java.io.*;
import java.util.*;

public class yuno {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("/Users/isabella/Documents/ProgrammingTeam/workspace/Feb2Mercer4/src/test.in"));
		
		int numCases = in.nextInt();
		String blank = in.nextLine();
		for(int i = 0; i < numCases; i++)
		{
			String obj = in.nextLine();
			String after = in.nextLine();
			
			obj = obj.toUpperCase();
			after = after.toUpperCase();
			
			System.out.println(obj + "...\nY U NO " + after + "?\n");
		}
	}
}
