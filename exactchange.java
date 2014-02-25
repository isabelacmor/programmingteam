import java.util.*;
import java.io.*;

public class exactchange {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 1; i <= numCases; i++){
			System.out.print("Item #" + i + ": ");
			
			int numDenom = in.nextInt();
			int[] denom = new int[numDenom];
			
			for(int j = 0; j < numDenom; j++){
				denom[j] = in.nextInt();
			}
			
			int target = in.nextInt();
			
			System.out.println(solve(denom, target) ? "YES" : "NO");
		}
	}
	
	public static boolean solve(int [] denom, int target){
		for(int i = 0; i < (1 << denom.length); i++){
			int mask = i;
			int sum = 0;
			
			for(int j = 0; j < denom.length; j++){
				if((mask & 1) == 1) sum += denom[j];
				mask = mask >> 1;
			}
			
			if(sum == target) return true;
		}
		
		return false;
	}
}

/*


3 
6
12 8 1 2 4 100 
28 
3 
1 2 3 
4 
6 
3 1 3 2 3 88 
91 


*/