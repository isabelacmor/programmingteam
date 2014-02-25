import java.io.*;
import java.util.*;

public class sum {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int C = in.nextInt();
		for(int i = 0; i < C; i++){
			int N = in.nextInt();
			int M = in.nextInt();
			
			int[][] ar = new int[N][M];
			for(int n = 0; n < N; n++)
				for(int m = 0; m < M; m++)
					ar[n][m] = in.nextInt();
			
			findMaxSum(ar);
		}
	}
	
	public static void findMaxSum(int M[][]){
	    int maxSum = Integer.MIN_VALUE;
	 
	    int sum = 0, start = 0, finish = 0;
	    int [] temp;
	 
	    // Set the left column
	    for (int left = 0; left < M[0].length; ++left){
	        temp = new int[M.length];
	 
	        // Set the right column for the left column set by outer loop
	        for (int right = left; right < M[0].length; ++right){
	            // Calculate sum between current left and right for every row 'i'
	            for (int i = 0; i < M.length; ++i)
	                temp[i] += M[i][right];
	 
	            // Find the maximum sum subarray in temp[]. The kadane() function
	            // also sets values of start and finish.  So 'sum' is sum of
	            // rectangle between (start, left) and (finish, right) which is the
	            //  maximum sum with boundary columns strictly as left and right.
	            sum = kadane(temp, start, finish, M.length);
	 
	            // Compare sum with maximum sum so far. If sum is more, then update
	            // maxSum and other output values
	            if (sum > maxSum)
	            {
	                maxSum = sum;
	            }
	        }
	    }
	 
	    // Print final values
	    System.out.println(maxSum + " from " + start + ", " + finish);
	}
	
	public static int kadane(int[] arr, int start, int finish, int n){
	    // initialize sum, maxSum and
	    int sum = 0, maxSum = Integer.MIN_VALUE;
	 
	    // Just some initial value to check for all negative values case
	    boolean pos = false;
	 
	    // local variable
	    int local_start = 0;
	 
	    for (int i = 0; i < n; ++i){
	        sum += arr[i];
	        if (sum < 0){
	            sum = 0;
	            local_start = i+1;
	        }
	        else if (sum > maxSum){
	            maxSum = sum;
	            start = local_start;
	            pos = true;
	        }
	    }
	 
	     // There is at-least one non-negative number
	    if (pos)
	        return maxSum;
	 
	    // Special Case: When all numbers in arr[] are negative
	    maxSum = arr[0];
	    start = finish = 0;
	 
	    // Find the maximum element in array
	    for (int i = 1; i < n; i++)
	    {
	        if (arr[i] > maxSum){
	            maxSum = arr[i];
	            start = finish = i;
	        }
	    }
	    return maxSum;
	}
}

/*

2
3 3
-4 -2 -1
-3 2 3
1 4 5
3 4
-6 -5 -4 -3
-5 -4 -3 -2
-4 -3 2 -1

*/