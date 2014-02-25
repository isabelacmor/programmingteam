import java.io.*;
import java.util.*;

public class f {
	public static void main(String [] args) throws IOException{
	    Scanner in = new Scanner(System.in);
	    
	    int numCases = in.nextInt();
	    
	    for(int i = 1; i <= numCases; i++){
	    	int caseN = in.nextInt();
	    	int numDigits = in.nextInt();
	    	int numAdj = in.nextInt();
	    	
	    	//dp this based on number of digits, number of adjacent one's, and the ending bit
	    	int[][][] dp = new int[numDigits+1][numAdj+1][2];
	    	
	    	//set up base cases
	    	dp[0][0][0] = 0;
	    	dp[1][0][0] = 1;
	    	dp[1][0][1] = 1;
	    	dp[1][1][0] = 0;
	    	dp[1][1][1] = 0;
	    	
	    	//build up rest of cases
	    	for(int j = 2; j <= numDigits; j++){
	    		for(int k = 0; k <= numAdj; k++){
	    			//with zero as the last bit, it's whatever we can make of one shorter length ending in both zero and one
	    			dp[j][k][0] = dp[j-1][k][0] + dp[j-1][k][1];
	    			
	    			//with more than zero adjacent ones, it's whatever we can make with zero as the end of length one shorter
	    			//and length one shorter, one fewer adjacent ones, and ending in a one
	    			if(k > 0)
	    				dp[j][k][1] = dp[j-1][k][0] + dp[j-1][k-1][1];
	    			//if we don't need any adjacent ones, it's the same as whatever we had of one shorter length ending in zero
	    			else
	    				dp[j][k][1] = dp[j-1][k][0];
	    		}
	    	}
	    	
	    	System.out.println(i + " " + (dp[numDigits][numAdj][0] + dp[numDigits][numAdj][1]));
	    }
	}
}

/*

10
1 5 2
2 20 8
3 30 17
4 40 24
5 50 37
6 60 52
7 70 59
8 80 73
9 90 84
10 100 90

*/