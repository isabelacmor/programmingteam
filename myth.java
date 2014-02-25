import java.io.*;
import java.util.*;

public class myth {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numIDs = in.nextInt();
		while(numIDs != 0)
		{
			ArrayList<Boolean> finalOver = new ArrayList();
			int [] vals = new int[4];
			for(int i = 0; i < numIDs; i++)
			{
				int num = in.nextInt();
				vals[0] = num%10;
				num /=10;
				vals[1] = num%10;
				num /= 10;
				vals[2] = num%10;
				num /= 10;
				vals[3] = num%10;
			    
			    //System.out.println();
				
			    
				ArrayList<Boolean> overall = solve(vals);
			    
			    //System.out.println(overall);
			    
			    if(overall.contains(true)) finalOver.add(true);
			    else finalOver.add(false);
			}
			
			if(finalOver.contains(false)) System.out.println("BUSTED");
			else System.out.println("TRUE");
			
			
			
			numIDs = in.nextInt();
		}
		//while != 0
		////permute all numbers
		////return boolean -> reached 10 -> if false && false = false...if true && false = true
		////add to AL, if all true, TRUE, else BUSTED
	}
	
	public static ArrayList solve(int vals[])
	{
		ArrayList<Boolean> overall = new ArrayList();
		boolean current = true;
		boolean brokeOut = false;
		
		Arrays.sort(vals);
		
		boolean cont = true;
	    while (cont) {
	        overall.add(printPerm(vals, vals.length));
	        cont = nextPerm(vals, vals.length);
	    }
	    
	    return overall;
	}
	
	
	
	public static boolean printPerm(int perm[], int length) {

		/*System.out.println("CURRENT PERM: ");
	    for(int i = 0; i < length; i++)
	    {
	    	System.out.println(perm[i]);
	    }*/
	    if(perm[2] == 0) return false;
		int total = perm[0] * perm[1] / perm[2] + perm[3] - perm[0];
		if(total == 10) return true;
		else return false;
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
