import java.io.*;
import java.util.*;

/**
 * This program solves any given sudoku puzzle (if solveable), or alerts the user if there is no solution.
 * 
 * @author Isabella Moreira
 * @date 10/6/2012
 * @notes Did quite a bit of Googling to find some help for this problem, as I wasn't sure the specifics of implementing the backtracking technique
 *        After having followed some given steps, I was able to understand the process; I just need more practice to be able to write these kinds of problems from scratch
 */
public class sudoku2
{
    public static void main(String [] args) throws IOException
    {
       Scanner in = new Scanner(new File("sudoku.in")); 
       //this is our 9x9 game board
       int [][] board = new int [9][9];
       
       int boardCount = 1;
       int numBoards = in.nextInt();
       while(numBoards != 0)
       {
           board = setupBoard(board, in); //sets up the sudoku board based on file contents
           System.out.println("Test case " + boardCount + ":\n"); //always printed
           if(solve(0, 0, board)) //solve returns true if the board is solvable
           {
              printBoard(board);
              System.out.println("\n");
           }
           else
           {
               System.out.println("No solution possible.\n\n");
           }
           
           boardCount++;
           numBoards--;
       }
    }    
    public static int[][] setupBoard(int [][] board, Scanner in)
    {
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                board[i][j] = in.nextInt();
            }
        }
        return board;
    }
    public static void printBoard(int [][] board)
    {
       for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
               
                System.out.print(board[i][j] + " ");
                
            }
            System.out.println();
        } 
    }
    public static boolean solve(int i, int j, int [][] board)
    {
        if (i == 9) //we must be at the last row...
        {
            i = 0; //i get reset here so that we can solve for the next row if needed
            if ((j+=1) == 9) //...and the last column
            //for the board to be solved
            {
                return true;
            }
        }
        if (board[i][j] != 0)  //skip cells that have already been filled (we don't need to resolve for these unless we run into an error later on)
        {
            return solve(i+1, j, board);
        }

        //we have to go through the numbers 1-9 inclusive to see if they are possible solutions to the problem
        for(int k = 1; k <= 9; k++) 
        {
            if(validity(i, j, k, board)) //if it's in the game board
            {
                board[i][j] = k; //we set this cell equal to k and try to solve from there
                //this may or may not be the solution; we don't currently know
                if(solve(i+1, j, board)) //now we try to solve the next cells
                {
                    return true;
                }
            }
        }
        board[i][j] = 0; //reset to 0 when backtracking so we can resolve with a different number
        return false; //returns this if it doesn't return true on line 89 (this board is unsolveable)
    }
    public static boolean validity(int i, int j, int k, int [][] board)
    {
        for (int m = 0; m < 9; m++)  //checking validity of the row
        {
            if (k == board[m][j]) //if the number we're trying to use in already in this row
            //then it's not a valid play
            {
                return false;
            }
        }

        for (int m = 0; m < 9; m++) //checking validity of the column
        {
            if (k == board[i][m]) //if the number we're trying to use in already in this column
            //then it's not a valid play
            {
                return false;
            }
        }

        int begBoxRow = (i / 3)*3; //beginning coordinates of 3x3 box's row
        int begBoxColumn = (j / 3)*3; //beginning coordinates of 3x3 box's column
        for (int m = 0; m < 3; m++) //checking validity of the 3x3 box; first the row
        {
            for (int n = 0; n < 3; n++) //then the column
            {
                if (k == board[begBoxRow+m][begBoxColumn+n]) //if the number we're trying to use is anywhere in this box already, it's an invalid move
                {
                    return false;
                }
            }
        }
        
        return true; //k could possibly be a solution for the current cell because
        //1. it doesn't already appear in the cell's row
        //2. it doesn't already appear in the cell's column
        //3. it doesn't already appear in the cell's 3x3 box
    }
}