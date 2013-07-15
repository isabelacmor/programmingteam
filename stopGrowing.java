import java.io.*;
import java.util.*;

public class stopGrowing {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++)
		{
			ArrayList<Integer> a = new ArrayList();
			ArrayList<Integer> b = new ArrayList();
			ArrayList<Integer> c = new ArrayList();
			ArrayList<Integer> d = new ArrayList();
			ArrayList<Integer> e = new ArrayList();
			ArrayList<Integer> sum = new ArrayList();
			
			a.add(in.nextInt());
			b.add(in.nextInt());
			c.add(in.nextInt());
			d.add(in.nextInt());
			e.add(in.nextInt());
			
			int m = in.nextInt();

			//calculating first two sums
			sum.add(a.get(0) + b.get(0) + c.get(0) + d.get(0) + e.get(0));
			a.add(a.get(0) + b.get(0));
			b.add(b.get(0) + c.get(0));
			c.add(c.get(0) + d.get(0));
			d.add(d.get(0) + e.get(0));
			e.add(e.get(0) + a.get(0));
			sum.add(a.get(1) + b.get(1) + c.get(1) + d.get(1) + e.get(1));
			
			int j = 1;
			int timesInWhile = 0;
			//while the sum is increasing and it's less than the target
			while(sum.get(j-1) < sum.get(j) && !(sum.get(j) >= m))
			{
				a.add(a.get(j) + b.get(j));
				b.add(b.get(j) + c.get(j));
				c.add(c.get(j) + d.get(j));
				d.add(d.get(j) + e.get(j));
				e.add(e.get(j) + a.get(j));
				sum.add(a.get(j+1) + b.get(j+1) + c.get(j+1) + d.get(j+1) + e.get(j+1));
				
				j++;
				timesInWhile++;
			}
			
			
			//System.out.println(a + " \n" + b + " \n" + c + " \n" + d + " \n" + e + " \n" + sum);
			if(sum.get(sum.size()-1) >= m && timesInWhile > 0) System.out.println("Case #" + (i+1) + ": " + j);
			else if(sum.get(sum.size()-1) >= m && timesInWhile == 0) System.out.println("Case #" + (i+1) + ": 0");
			else System.out.println("Case #" + (i+1) + ": -1");
		}
	}
}