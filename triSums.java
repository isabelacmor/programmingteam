import java.io.*;
import java.util.*;

public class triSums {
	public static long [] T = new long[1002];
	public static long [] S = new long[1002];
	
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		fillT();
		allSum();
		
		int numCases = in.nextInt();
		for(int i = 1; i <= numCases; i++){
			int nCalc = in.nextInt();
			System.out.println(i + " " + nCalc + " " + S[nCalc]);
		}
	}
	
	//precompute all T values
	public static void fillT(){
		
		T[0] = 0;
		for(int i = 1; i <= 1000; i++){
			T[i] = T[i-1] + i;
		}
	}
	
	//precomputer all sums
	public static void allSum(){
		
		S[0] = 0;
		for(int k = 1; k < 1001; k++){
			S[k] = S[k-1] + (k*T[k+1]);
		}
	}
}
