import java.io.*;
import java.util.*;


public class c {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 1; i <= numCases; i++){
			int caseN = in.nextInt();
			
			System.out.print(i + " ");
			
			int numBalls = in.nextInt();
			int numFloors = in.nextInt();
			
			int[][] memo = new int[numFloors+1][numBalls+1];
			
			for(int j = 0; j <= numFloors; j++) Arrays.fill(memo[j], -1);
			
			System.out.println(solve(memo, numFloors, numBalls));
		}
	}
	
	public static int solve(int[][] memo, int numFloors, int numBalls){
		if(numFloors < 1) return 0;
		if(numBalls == 1) return numFloors;
		if(memo[numFloors][numBalls] != -1) return memo[numFloors][numBalls];
			
		int min = 1001;
		for(int i = 1; i <= numFloors; i++){
			//solve the top half and bottom half of the building
			//and add one since we're dropping a single ball to get to this step
			int val = 1 + Math.max(solve(memo, i-1, numBalls-1), solve(memo, numFloors-i, numBalls));
			
			if(val < min) min = val;
		}
		
		return memo[numFloors][numBalls] = min;
	}
}

/*

4
1 2 10
2 2 100
3 2 300
4 25 900


*/
