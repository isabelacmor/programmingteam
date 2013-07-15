import java.io.*;
import java.util.*;

public class minesweeper {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(new File("minesweeper.in"));
		
		int row = in.nextInt();
		int col = in.nextInt();
		
		while(row != 0 && col != 0)
		{
			String [][] board = new String[row][col];
			
			//set up board
			for(int i = 0; i < row; i++)
			{
				String line = in.next();
				for(int j = 0; j < col; j++)
				{
					board[i][j] = line.substring(j, j+1);
					//System.out.print(board[i][j]);
					//System.out.println(i + " " + j);
				}
			}
			
			//count number of adjacent *'s (bombs)
			int [][] bombCount = new int[row][col];
			//start at 1 so we can check adjacent
			for(int i = 0; i < row; i++)
			{
				for(int j = 0; j < col; j++)
				{
					if(board[i][j].equals("*")) bombCount[i][j] = -99;
					else
					{
						if(i > 0 && j > 0 && board[i-1][j-1].equals("*")) bombCount[i][j]++;
						if(j > 0 && board[i][j-1].equals("*")) bombCount[i][j]++;
						if(j > 0 && i+1 < row && board[i+1][j-1].equals("*")) bombCount[i][j]++;
						
						if(i > 0 && board[i-1][j].equals("*")) bombCount[i][j]++;
						if(i+1 < row && board[i+1][j].equals("*")) bombCount[i][j]++;
						
						if(i > 0 && j+1 < col && board[i-1][j+1].equals("*")) bombCount[i][j]++;
						if(j+1 < col && board[i][j+1].equals("*")) bombCount[i][j]++;
						if(j+1 < col && i+1 < row && board[i+1][j+1].equals("*")) bombCount[i][j]++;
					}
				}
			}
			
			//print solution board
			for(int i = 0; i < row; i++)
			{
				for(int j = 0; j < col; j++)
				{
					if(bombCount[i][j] == -99){System.out.print("*");}
					else System.out.print(bombCount[i][j]);
				}
				System.out.println();
			}
			
			//get new vals
			row = in.nextInt();
			col = in.nextInt();
		}
	}
}