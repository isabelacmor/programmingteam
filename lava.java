import java.io.*;
import java.util.*;

public class lava {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("/Users/isabella/Documents/ProgrammingTeam/workspace/Feb2Mercer4/src/test.in"));
		
		int numFloors = in.nextInt();
		for(int i = 1; i <= numFloors; i++)
		{
			int rows = in.nextInt();
			int cols = in.nextInt();
			
			char[][] grid = new char[rows][cols];
			
			//read grid
			for(int j = 0; j < rows; j++)
			{
				String line = in.next();
				grid[j] = line.toCharArray();
			}
			
			int count = 0;
			//find next T
			while(hasT(grid, rows, cols))
			{
				
				int x = 0, y = 0;
				boolean foundStart = false;
				for(int j = 0; j < rows; j++)
				{
					for(int k = 0; k < cols; k++)
					{
						if(grid[j][k] == 'T' && foundStart == false)
						{
							x = j;
							y = k;
							foundStart = true;
							break;
						}
					}
				}
				
				floodfill(grid, x, y, rows, cols);
				count++;
			}
			
			boolean solved = true;
			//very end, see if there are any more ~ in the grid
			for(int j = 0; j < rows; j++)
			{
				for(int k = 0; k < cols; k++)
				{
					if(grid[j][k] == '~')
					{
						solved = false;
						break;
					}
				}
			}
			
			if(solved) System.out.println("Floor #" + i + ": Only need to flush " + count + " toilet(s).");
			else System.out.println("Floor #" + i + ": Call a plumber!");
			
		}
	}
	
	public static boolean hasT(char [][] grid, int rows, int cols)
	{
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(grid[i][j] == 'T') return true;
			}
		}
		
		return false;
	}
	
	// Floodfills starting from spot (x,y) all of the contiguous
		// locations to s that have a d.
		public static void floodfill(char[][] grid, int x, int y, int rows, int cols) {
			
			// Mark this spot
			grid[x][y] = 'X';
			
			// Run through each adjacent square.	
			// Only fill it if it's inbounds and part of the course(d).
			if (inbounds(x+1,y, rows, cols) && (grid[x+1][y]=='~' || grid[x+1][y]=='T')) floodfill(grid,x+1,y, rows, cols);
			if (inbounds(x-1,y, rows, cols) && (grid[x-1][y]=='~' || grid[x-1][y]=='T')) floodfill(grid,x-1,y, rows, cols);
			if (inbounds(x,y+1, rows, cols) && (grid[x][y+1]=='~' || grid[x][y+1]=='T')) floodfill(grid,x,y+1, rows, cols);
			if (inbounds(x,y-1, rows, cols) && (grid[x][y-1]=='~' || grid[x][y-1]=='T')) floodfill(grid,x,y-1, rows, cols);
			
		}
		
		// Returns true iff x and y are valid 
		public static boolean inbounds(int x, int y, int rows, int cols) {
			return x >= 0 && x < rows && y >= 0 && y < cols;
		}

}
