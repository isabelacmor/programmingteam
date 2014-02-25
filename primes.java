package mercer2010;
import java.io.*;
import java.util.*;

public class primes {

	public static long[] prime = new long[256], sum = new long[256];
	public static boolean[] isPrime = new boolean[256];

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		solve();

		int numCases = in.nextInt();
		for (int i = 0; i < numCases; i++)
			System.out.println(sum[in.nextInt()]);
	}

	public static void solve() {		
		int ctr = 0;
		int num = 2;
		
		while(ctr < 256){
			if(isPrime(num)){
				prime[ctr] = num;
				ctr++;
			}
			num++;
			
		}
			
		sum[0] = 2;
		sum[1] = 5;
		for(int i = 2; i < prime.length; i++){
			sum[i] = sum[i-1] + prime[i];
		}
	}
	
	public static boolean isPrime(int num){
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0) return false;
		
		return true;
	}
}

/*

3
0
5
7

*/