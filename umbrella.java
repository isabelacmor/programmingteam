import java.io.*;
import java.util.*;

public class umbrella {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 1; i <= numCases; i++)
		{
			int numRods = in.nextInt();
			int [] rods = new int[numRods];
			for(int j = 0; j < numRods; j++)
			{
				rods[j] = in.nextInt();
			}
			
			boolean cont = true;
			double maxArea = 0.0;
		    while (cont) {
		        double area = printPerm(rods, numRods);
		        cont = nextPerm(rods, numRods);
		        if(area > maxArea) maxArea = area;
		    }
			
			System.out.printf("Umbrella #%d: %.3f", i, maxArea);
		}
	}
	
	public static double printPerm(int perm[], int length) {

	    //area = 1/2 bc sin a
		double angle = 360.0 / length;
		double area = 0.0;
		
		angle = angle*3.1415/180;
		
		//System.out.println("angle: " + Math.sin(angle));
		
		for(int i = 0; i < length-1; i++)
		{
			//System.out.println("sides: " + perm[i]*perm[i+1] + " using " + perm[i] + " and " + perm[i+1]);
			area += 0.5 * perm[i]*perm[i+1] * Math.sin(angle);
			//System.out.println("current area " + area);
		}
		//System.out.println("sides: " + perm[0]*perm[perm.length-1] + " using " + perm[0] + " and " + perm[perm.length-1]);
		area += 0.5 * perm[0]*perm[perm.length-1]*Math.sin(angle);
		//System.out.println("current area " + area);
		
		//System.out.println(area);
		
		return area;
	}
	
	public static boolean nextPerm(int perm[], int length) {

	    // Find the spot that needs to change.
	    int i = length-1;
	    while (i>0 && perm[i] <= perm[i-1]) i--;
	    i--; // Advance to the location that needs to be swapped.

	    // 0 indicates that it failed.
	    if (i == -1) return false;

	    // Find the spot with which to swap index i.
	    int j=length-1;
	    while (j>i && perm[j]<=perm[i]) j--;

	    // Swap it.
	    int temp = perm[i];
	    perm[i] = perm[j];
	    perm[j] = temp;

	   // reverse from index i+1 to length-1.
	   int k,m;
	   for (k=i+1,m=length-1; k<m; k++,m--) {
	       temp = perm[k];
	       perm[k] = perm[m];
	       perm[m] = temp;
	    }

	    // Indicates success.
	    return true;
	}
}
