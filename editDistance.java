import java.io.*;
import java.util.*;

public class editDistance {
	public static void main(String [] args){
		System.out.println(editDistDP("ranger", "roger"));
	}
	
	public static int editDistDP(String w1, String w2){
		int[][] dp = new int[w1.length()+1][w2.length()+1];
		
		for(int i = 0; i <= w1.length(); i++)
			dp[i][0] = i;
		
		for(int i = 0; i <= w2.length(); i++)
			dp[0][i] = i;
		
		for(int i = 1; i <= w1.length(); i++)
			for(int j = 1; j <= w2.length(); j++){
				if(w1.charAt(i-1) == w2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
				else dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
			}
		
		return dp[w1.length()][w2.length()];
	}
}
