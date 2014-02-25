import java.util.*;
import java.io.*;
import java.math.*;

public class comboDP {
	final public static long MOD = 1000000000000000000L;
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		BigInteger MOD2 = BigInteger.valueOf(MOD);
		
		for(int i = 0; i < numCases; i++)
		{
			int n = in.nextInt();
			int k = in.nextInt();
			
			System.out.println(pascal(n, k).remainder(MOD2));
		}
	}
	public static BigInteger pascal(int n, int k)
	{
		//our Pascal Triangle
		BigInteger pascalTri[][] = new BigInteger[n+1][n+1];
		
		//fill in all the first and last spots with 1
		for(int i = 0; i < n+1; i++)
		{
			pascalTri[i][0] = new BigInteger("1");
			pascalTri[i][i] = new BigInteger("1");
		}
		
		//row 2 is where the calculations start because row 0 and 1 are just 1's
		for(int i = 2; i < n+1; i++)
		{
			//j starts at 1 because the first number in the row is always 1
			for(int j = 1; j < i; j++)
			{
				pascalTri[i][j] = pascalTri[i-1][j].add(pascalTri[i-1][j-1]);
			}
		}
		
		return pascalTri[n][k];
	}
}