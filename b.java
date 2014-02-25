import java.io.*;
import java.util.*;

public class b {
	public class Tree
	{
		int supervisor;
		Tree left, right;
		public Tree(int S, Tree L, Tree R)
		{
			supervisor = S;
			left = L;
			right = R;
		}
	}
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++)
		{
			int numEmp = in.nextInt();
			int [] emp = new int[numEmp-1];
			emp[0] = -1;
			for(int j = 1; j < numEmp; j++)
			{
				emp[j] = in.nextInt();
			}
			
			for(int j = 1; j < numEmp; j++)
			{
				
			}
		}
	}
}
