import java.io.*;
import java.util.*;

public class tiles {
	public static long [] dp = new long[505];
	public static int MOD = 10007;
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		solveDP();
		
		for(int i = 0; i < numCases; i++){
			int n = in.nextInt();
			
			System.out.println(dp[n]);
		}
	}
	
	public static void solveDP(){
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i < dp.length; i++){
			dp[i] =  dp[i-1] % MOD;
			dp[i] += dp[i-2] % MOD;
			dp[i] += dp[i-2] % MOD;
			
			dp[i] %= MOD;
		}
	}
}


/*

5
1
2
3
4
5


*/