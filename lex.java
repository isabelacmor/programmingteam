import java.io.*;
import java.util.*;

/**
 * Write a description of class bunnies here.
 * 
 * @author Isabella Moreira
 * @date 9/26/2012
 * @purpose: to determine the total area transformed from water to land by the crystal; where each cell represents 5 square miles
 */
public class lex
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        int numLandings = in.nextInt();
        int height, width;
        while(numLandings != 0)
        {
            height = in.nextInt();
            width = in.nextInt();
            String blank = in.nextLine();
            //System.out.println(height + " " + width);
            
            //first num = rows -> height
            char [][] grid = new char[height][width];
            
            //READ IN GRID
            for(int i = 0; i < height; i++)
            {
                String line = in.nextLine();
                grid[i] = line.toCharArray();
            }
            
            //FIND CRYSTAL (STARTING LOCATION)
            int x = 0, y = 0;
            for(int i = 0; i < height; i++)
            {
                for(int j = 0; j < width; j++)
                {
                    if(grid[i][j] == 'X')
                    {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }
                       
            //System.out.println(Arrays.deepToString(grid));
            //FILL COURSE WITH V's
            floodFill(grid, x, y, width, height);
            //System.out.println(Arrays.deepToString(grid));
            int count = 0;
            for(int i = 0; i < height; i++)
            {
                for(int j = 0; j < width; j++)
                {
                    if(grid[i][j] == 'V')
                    {
                        count++;
                    }
                }
            }
            System.out.println(count*5);
            
            numLandings--;
        }
    }
    
    public static void floodFill(char[][]grid, int x, int y, int width, int height)
    {
        //MARK THIS SPOT AS VISITED
        grid[x][y] = 'V';
        
        //GO THROUGH EACH SQUARE THAT'S A ~ AND ADJACENT TO ANOTHER V (either horizontally or vertically)
        for(int i = -1; i <= 2; i++)
        {
            if(inbounds(x+i, y, width, height) && adjacentX(grid, x+i, y, width, height) && grid[x+i][y] == '~')
            {
                floodFill(grid, x+i, y, width, height);
            }
        }
        
        for(int j = -1; j <= 2; j++)
        {
            if(inbounds(x, y+j, width, height) && adjacentX(grid, x, y+j, width, height) && grid[x][y+j] == '~')
            {
                floodFill(grid, x, y+j, width, height);
            }
        }
    }
    
    public static boolean inbounds(int x, int y, int width, int height)
    {
        return x >= 0 && x < height && y >= 0 && y < width;
    }
    
    public static boolean hasX(char[][]grid, int width, int height)
    {
//         if(grid[xC][yC] == 'X'){ return true; }
//         else{ return false; }
            return true;
    }
    
    public static boolean adjacentX(char[][]grid, int x, int y, int width, int height)
    {
        //check spaces to the left and right, if valid
        for(int i = -1; i < 2; i++)
        {
            if(inbounds(x+i, y, width, height) && grid[x+i][y] == 'V')
            {
                return true;
            }
        }
        
        //check spaces above and below, if valid
        for(int j = -1; j < 2; j++)
        {
            if(inbounds(x, y+j, width, height) && grid[x][y+j] == 'V')
            {
                return true;
            }
        }
        return false;
    }
}