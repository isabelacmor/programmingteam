import java.io.*;
import java.util.*;


/**
 * Write a description of class bfs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bfs
{
    public static void main (String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("bfs.in"));
        
        int numBoards = in.nextInt();
        String [][] board = new String [3][3];
        while(numBoards != 0)
        {         
            for(int i = 0; i < 3; i++) //read in three rows
            {
                for(int j = 0; j < 3; j++) //read in three columns for each row
                {
                    board[i][j] = in.next();
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            
            //make sure we're not starting with a solved board
            if(checkState(board) == true){ System.out.println("0"); }
            
            numBoards--;
        }
    }
    public static boolean checkState(String [][] board)
    {
        boolean correctPos = true;
        
        for(int i = 0; i < 3; i++) //read in three rows
        {
            for(int j = 0; j < 3; j++) //read in three columns for each row
            {
                if(correctPos == true && board[i][j].equals(Integer.toString(j+i)))
                {
                    correctPos = true;
                }
                else
                {
                    correctPos = false;
                    break;
                }
            }
        }
        
        return correctPos;
    }
}