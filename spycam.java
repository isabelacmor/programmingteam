import java.io.*;
import java.util.*;

public class spycam {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		ArrayList <String> lettersUsed = new ArrayList();
		ArrayList <String> uncovered = new ArrayList();
		
		int row, col;
		row = in.nextInt();
		col = in.nextInt();
		while(row != 0 && col != 0)
		{
			//creating the desktop
			String [][] desk = new String[row][col];
			//reading in the papers
			for(int i = 0; i < row; i++)
			{
				for(int j = 0; j < col; j++)
				{
					desk[i][j] = in.next();
					//adding the letters into an AL so we know up to what we have to check
					if(!desk[i][j].equals(".") && !lettersUsed.contains(desk[i][j]))
					{
						lettersUsed.add(desk[i][j]);
					}
				}
			}
			
			//checking each individual sheet
			for(int i = 0; i < lettersUsed.size(); i++)
			{
				if(!uncovered(lettersUsed.get(index), desk, row, col))
				{
					//if the paper is not uncovered, we do nothing
				}
				else
				{
					//we add this letter to the AL of uncovered papers
					uncovered.add(lettersUsed.get(i));
				}
			}
			
			row = in.nextInt();
			col = in.nextInt();
		}
	}
	
	public static boolean uncovered(String letter, String [][] desk, int row, int col)
	{
		//check each cell that is the current LETTER
		//if the current cell (and the cell two the right, left, top, or bottom) is the current LETTER
		//but the cell one to the same direction is not, then return false and break;
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				//if letter = A
				//ACA = false
				if(j+1 < row && desk[i][j].equals(letter) && desk[i][j+2].equals(letter) && !desk[i][j+1].equals(letter)) return false;
			}
		}
	}
}