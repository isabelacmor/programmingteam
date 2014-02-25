import java.io.*;
import java.util.*;

public class robot {

	public static int curX, curY;
	public static int[] L, R, U, D;

	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		String line = in.nextLine();
		
		for(int i = 0; i < numCases; i++){
			int[] ans = {0, 0, 0, 0};
					
			curX = 0;
			curY = 0;
			line = in.nextLine();
			
			ans = solve(line, ans);
			
			System.out.println("ANSWER:\n");
			for(int j = 0; j < ans.length; j++){
				System.out.print(ans[j] + " ");
			}
		}
	}
	
	public static int[] solve(String line, int[] cur){
		if(line.length() == 0) return cur;
		
		System.out.println("\n\nSolving " + line);
		
		if(line.charAt(0) == 'U'){
			curY++;
			cur[1]++;
			cur[3]++;
			return solve(line.substring(1), cur);
		}
		else if(line.charAt(0) == 'D'){
			curY--;
			cur[1]--;
			cur[3]--;
			return solve(line.substring(1), cur);
		}
		else if(line.charAt(0) == 'L'){
			curX--;
			cur[0]--;
			cur[2]--;
			return solve(line.substring(1), cur);
		}
		else if(line.charAt(0) == 'R'){
			curX++;
			cur[0]++;
			cur[2]++;
			return solve(line.substring(1), cur);
		}
		else{
			L = solve("L" + line.substring(1), cur);
			System.out.println("L array");
			printArr(L);
			R = solve("R" + line.substring(1), cur);
			System.out.println("R array");
			printArr(R);
			U = solve("U" + line.substring(1), cur);
			System.out.println("U array");
			printArr(U);
			D = solve("D" + line.substring(1), cur);
			System.out.println("D array");
			printArr(D);
			
			System.out.println("Updating extremes\n================\n");
			System.out.println("L array");
			printArr(L);
			System.out.println("R array");
			printArr(R);
			System.out.println("U array");
			printArr(U);
			System.out.println("D array");
			printArr(D);
			
			for(int i = 0; i < L.length; i+=2){
				L[i] = Math.min(Math.min(Math.min(L[i], R[i]), U[i]), D[i]);
			}
			
			for(int i = 1; i < L.length; i+=2){
				L[i] = Math.max(Math.max(Math.max(L[i], R[i]), U[i]), D[i]);
			}
			
			//return updateExtremes(L, R, U, D);
			
			printArr(L);
			return L;
		}
	}
	
	public static void printArr(int[] ar){
		for(int n: ar) System.out.print(n + " ");
	}
	
	public static int[] updateExtremes(int[] L, int[] R, int[] U, int[] D){
		System.out.println("Updating extremes\n================\n");
		System.out.println("L array");
		printArr(L);
		System.out.println("R array");
		printArr(R);
		System.out.println("U array");
		printArr(U);
		System.out.println("D array");
		printArr(D);
		
		for(int i = 0; i < L.length; i+=2){
			L[i] = Math.min(Math.min(Math.min(L[i], R[i]), U[i]), D[i]);
		}
		
		for(int i = 1; i < L.length; i+=2){
			L[i] = Math.max(Math.max(Math.max(L[i], R[i]), U[i]), D[i]);
		}
		
		return L;
	}
}

/*

3
RUL?R?D
????????
RRRUU

*/