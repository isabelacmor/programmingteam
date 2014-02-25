import java.io.*;
import java.util.*;

public class SudokuSolver {
	public static int MAX_SUB_NUM = 3;
	public static int MAX_IND_SUB = 3;
	
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(new File("puzzle.in"));
		int[][] grid = new int[MAX_SUB_NUM*MAX_IND_SUB][MAX_SUB_NUM*MAX_IND_SUB];
		
		//read in puzzle from file
		for(int i = 0; i < MAX_SUB_NUM*MAX_IND_SUB; i++){
			for(int j = 0; j < MAX_SUB_NUM*MAX_IND_SUB; j++){
				grid[i][j] = in.nextInt();
			}
		}
		
		printGrid(grid);
		
		solve(grid, 1, 0, 0);
		
		printGrid(grid);
		
	}
	
	public static void solve(int[][] grid, int val, int i, int j){
		int ctr = 1;
		
		for(int r = i; r < MAX_SUB_NUM*MAX_IND_SUB; r++){
			for(int c = j; c < MAX_SUB_NUM*MAX_IND_SUB; c++){
				if(validPos(grid, ctr, r, c)) solve(grid, ctr, r, c);
			}
			ctr++;
		}
	}
	
	//Returns true if grid[i][j] is a valid position for val (no collisions)
	public static boolean validPos(int[][] grid, int val, int i, int j){
		//check row
		for(int c = 0; c < MAX_SUB_NUM*MAX_IND_SUB; c++){
			if(grid[i][c] == val) return false;
		}
		
		//check col
		for(int r = 0; r < MAX_SUB_NUM*MAX_IND_SUB; r++){
			if(grid[r][j] == val) return false;
		}
		
		//check subcell
		int cellX, cellY;
		if(i < 3) cellX = 0;
		else if(i < 6) cellX = 1;
		else cellX = 2;
		
		if(j < 3) cellY = 0;
		else if(j < 6) cellY = 1;
		else cellY = 2;
		
		for(int r = 0+cellX; r < 3+cellX; r++){
			for(int c = 0+cellY; c < 3+cellY; c++){
				if(grid[r][c] == val) return false;
			}
		}
		
		return true;
	}
	
	public static void printGrid(int[][] grid){
		for(int i = 0; i < MAX_SUB_NUM*MAX_IND_SUB; i++){
			for(int j = 0; j < MAX_SUB_NUM*MAX_IND_SUB; j++){
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
