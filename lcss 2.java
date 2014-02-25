import java.util.*;
import java.io.*;

public class lcss {
	public static void main(String [] args){
		String s1 = "BACBAD";
		String s2 = "ABAZDC";
		
		String lcssVal = solveLCSS(s1, s2);
		
		System.out.println("LCSS: " + new StringBuilder(lcssVal).reverse().toString());
	}
	
	public static String solveLCSS(String s1, String s2){
		int[][] grid = new int[s1.length()+1][s2.length()+1];
		
		//fill null rows with 0
		for(int i = 0; i < s1.length(); i++){
			grid[i][0] = 0;
		}
		
		//fill null cols with 0
		for(int i = 0; i < s2.length(); i++){
			grid[0][i] = 0;
		}
		
		for(int i = 1; i <= s1.length(); i++){
			for(int j = 1; j <= s2.length(); j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					grid[i][j] = grid[i-1][j-1]+1;
				}
				else{
					grid[i][j] = Math.max(grid[i][j-1], grid[i-1][j]);
				}
			}
		}
		
		System.out.println("LCSS length of (" + s1 + ", " + s2 + "): " + grid[s1.length()][s2.length()]);
		
		return buildLCSS(grid, s1);
	}
	
	public static String buildLCSS(int[][] grid, String s1){
		String revLCSS = "";
		
		int r = grid.length-1;
		int c = grid[0].length-1;
		
		while(r > 0 && c > 0){			
			if(grid[r-1][c] == grid[r][c]){
				r--;
			}
			else if(grid[r][c-1] == grid[r][c]){
				c--;
			}
			else if(grid[r-1][c] < grid[r][c] && grid[r][c-1] < grid[r][c]){
				revLCSS = revLCSS + s1.charAt(r-1);	//need to subtract 1 because of extra null row/col in grid
				r--;
				c--;
			}
		}
		
		return revLCSS;
	}
	
	public static void printGrid(int[][] grid){
		for(int i = 1; i < grid.length; i++){
			for(int j = 1; j < grid[0].length; j++){
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("\n");
	}
}
