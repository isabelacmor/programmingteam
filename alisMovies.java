import java.io.*;
import java.util.*;

public class alisMovies {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCol = in.nextInt();
		for(int i = 1; i <= numCol; i++)
		{
			int numMovies = in.nextInt();
			ArrayList<String> movies = new ArrayList();
			
			for(int j = 0; j < numMovies; j++)
			{
				String line = in.nextLine();
				String [] lineA = line.split(" ");
				lineA = swapNum(lineA);
			}
		}
	}
}
