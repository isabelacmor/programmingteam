import java.io.*;
import java.util.*;

public class countseq {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		String blank = in.nextLine();
		
		for(int i = 0; i < numCases; i++){
			String line = in.nextLine();
			String find = in.nextLine();
			
			System.out.println(solve(line, find));
		}
	}
	
	public static long solve(String line, String find){
		long[][] grid = new long[line.length()+1][find.length()+1];
		
		//we're not quite sure if we can use this letter from the pattern yet (is it even in our line?)
		for(int i = 0; i < find.length()+1; i++){
			grid[0][i] = 0;
		}
		//we can definitely use any letter from our line
		for(int i = 0; i < line.length()+1; i++){
			grid[i][0] = 1;
		}
		
		//run through the DP table
		for(int i = 1; i < line.length()+1; i++){
			for(int j = 1; j < find.length()+1; j++){
				if(line.charAt(i-1) == find.charAt(j-1)){
					grid[i][j] = grid[i-1][j] + grid[i-1][j-1];
				}
				else{
					grid[i][j] = grid[i-1][j];
				}
			}
		}
		
		//return the bottom-right cell
		return grid[grid.length-1][grid[0].length-1];
	}
}

/*

2
engineering
nine
sallysellsseashells
sell

*/