import java.io.*;
import java.util.*;

public class viveLaDifference {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		
		//loop through all cases
		while(a != 0 && b != 0 && c != 0 && d != 0)
		{
			
			int newA = a, newB = b, newC = c, newD = d;
			int tempA = newA, tempB = newB, tempC = newC, tempD = newD;
			int rounds = 0;
			
			while(!(newA == newB && newB == newC && newC == newD && newD == newA))
			{
				newA = Math.abs(tempA-tempB);
				newB = Math.abs(tempB-tempC);
				newC = Math.abs(tempC-tempD);
				newD = Math.abs(tempD-tempA);
				
				tempA = newA;
				tempB = newB;
				tempC = newC;
				tempD = newD;
				
				rounds++;
			}
			
			System.out.println(rounds);
			
			//new case
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			d = in.nextInt();
		}
	}
}