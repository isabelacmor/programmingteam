import java.io.*;
import java.util.*;

public class probAdecisionbits {
	public static void main (String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		String blank = in.nextLine();
		for(int i = 0; i < numCases; i++)
		{
			String line = in.nextLine();
			String[] lineA = line.split("");
			
			//System.out.println(lineA[(lineA.length/2)-1]+ " " + lineA[lineA.length/2]);
			if(lineA[(lineA.length/2)].equals(lineA[lineA.length/2+1])) System.out.println("Do-it");
			else System.out.println("Do-it-Not");
		}
	}
}
