import java.io.*;
import java.util.*;

public class gDIV2 {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int rc = in.nextInt();
		
		while(rc!=0)
		{
			String [][] board = new String[rc][rc];
			String blank = in.nextLine();
			
			//build board
			for(int i = 0; i < rc; i++)
			{
				String curLine = in.nextLine();
				for(int j = 0; j < rc; j++)
				{
					board[i][j] = curLine.substring(j, j+1);
				}
			}
			
			//check rows
			int total = 0, totali = 0;
			for(int i = 0; i < rc; i++)
			{
				total = 0;
				totali = 0;
				for(int j = 0; j < rc; j++)
				{
					if(board[i][j].equals("X")) total++;
					else if(board[i][j].equals("."))
					{
						totali++;
						if(total > 0)
						{
							System.out.print(total + " ");
							total = 0;
						}
						if(totali == rc)
						{
							System.out.print("0 ");
							break;
						}
					}
				}
				if(total > 0)
					System.out.println(total + " ");
				else System.out.println();
			}
			
			//check columns
			for(int i = 0; i < rc; i++)
			{
				total = 0;
				totali = 0;
				for(int j = 0; j < rc; j++)
				{
					if(board[j][i].equals("X")) total++;
					else if(board[j][i].equals("."))
					{
						totali++;
						//print the current consecutive sum of X's
						//before setting to zero
						if(total > 0)
						{
							System.out.print(total + " ");
							total = 0;
						}
						//triggered if the entire row or column (whichever we're checking atm)
						//is entirely made up of dots. If that's the case, there's no need
						//to keep checking, so we can just print a 0 and break
						if(totali == rc)
						{
							System.out.print("0 ");
							break;
						}
					}
				}
				//the last thing printed for this row, so we can use
				//println
				if(total > 0)
					System.out.println(total + " ");
				else System.out.println();
			}
			
			rc = in.nextInt();
		}
	}
}