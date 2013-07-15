import java.io.*;
import java.util.*;

public class sinko {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 1; i <= numCases; i++)
		{
			ArrayList<Integer> toS = new ArrayList();
			int h = in.nextInt();
			int b = in.nextInt();
			int s = in.nextInt();
			
			toS.add(h);
			toS.add(s);
			toS.add(b);
			Collections.sort(toS);
			
			double semiP = (h+b+s)/2;
			double area = Math.sqrt(semiP*(semiP-h)*(semiP-b)*(semiP-s));
			
			double height = area*(0.5*toS.get(2));
			
			if(height < 0)
			{
				System.out.println("Ali is sunk!");
			}
			else System.out.println("Proceed");
		}
	}
}
