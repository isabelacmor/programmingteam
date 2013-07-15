import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class ACM2009E {
	public static void main(String[] args) throws Exception {
	    
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++)
		{
			int curCase = in.nextInt();
			String start = in.next();
			BigInteger cur = new BigInteger(start);
			String current = String.valueOf(cur.add(BigInteger.valueOf(1)));
			
			while(start.length() == current.length() &&  !(strEq(start, current)))
			{				
				current = new BigInteger(current).add(BigInteger.ONE).toString();
			}
			
			if(String.valueOf(start).length() == String.valueOf(current).length()) System.out.println(curCase + " " + current);
			else System.out.println(curCase + " BIGGEST");
		}


	}
	
	public static boolean strEq(String start, String current)
	{
		String [] startA = start.split("");
		String [] currentA = current.split("");
		
		Arrays.sort(startA);
		Arrays.sort(currentA);
		
		return Arrays.equals(startA, currentA);
	}
}
