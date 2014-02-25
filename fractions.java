import java.io.*;
import java.util.*;

public class fractions {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		long num = in.nextLong();
		long den = in.nextLong();
		
		while(num!=0 && den!=0)
		{
			solve(num, den);
			num = in.nextLong();
			den = in.nextLong();
		}
	}
	
	public static void solve(long num, long den)
	{
		//numerator will be bigger than zero while we still don't have an answer
		while(num > 0)
		{
			//c is the ratio for simplifying the fractions or making them have a common denominator
			long c, denom = (den + num - 1) / num;
			//denom becomes the ceiling of the denominator/numerator
			while(true)
			{
				//find the common denominator
				c = gcd(num*denom-den, den*denom);
				//fulfills the one million condition
				if(den*denom/c < 1000000) break;
				//the next denominator will never be equal to or smaller than the previous
				denom++;
			}
			System.out.print(denom + " ");
			//substract from the original fraction (without all the common denom conversion)
			num = (num*denom - den)/c;
			den = den*denom/c;
		}
		System.out.println();
	}
	
	public static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}
}
