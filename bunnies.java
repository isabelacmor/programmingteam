import java.io.*;
import java.util.*;

public class bunnies {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++){
			int r = in.nextInt();
			int c = in.nextInt();
			String blank = in.nextLine();
			
			char [][] board = new char[r][c];
			
			for(int j = 0; j < r; j++){
				String line = in.nextLine();
				board[j] = line.toCharArray();
			}

			//start from all feeders
			for (int j=0; j<r; j++) {
				for (int k=0; k<c; k++) {
					if (board[j][k] == '+') {
						floodfill(board, j, k, r, c);
					}
				}
			}
			
			//find if P or C is still on board
			boolean tf = true;
			for (int j=0; j<r; j++) {
				for (int k=0; k<c; k++) {
					if(board[j][k] == 'P' || board[j][k] == 'C'){
						tf = false;
						break;
					}
				}
			}
			
			if(tf) System.out.println("yes");
			else System.out.println("no");
		}
	}
	
	public static void floodfill(char[][] grid, int x, int y, int r, int c) {
		//mark this spot
		grid[x][y] = 'X';
		
		//check cardinals
		if(x-1 >= 0 && x-1 < r && (grid[x-1][y] == '_' || grid[x-1][y] == 'P' || grid[x-1][y] == 'C')){
			floodfill(grid ,x-1, y, r, c);
		}
		if(x+1 >= 0 && x+1 < r && (grid[x+1][y] == '_' || grid[x+1][y] == 'P' || grid[x+1][y] == 'C')){
			floodfill(grid, x+1, y, r, c);
		}
		if(y-1 >= 0 && y-1 < c && (grid[x][y-1] == '_' || grid[x][y-1] == 'P' || grid[x][y-1] == 'C')){
			floodfill(grid,x,y-1, r, c);
		}
		if(y+1 >= 0 && y+1 < c && (grid[x][y+1] == '_' || grid[x][y+1] == 'P' || grid[x][y+1] == 'C')){
			floodfill(grid,x,y+1, r, c);
		}
	}
}
