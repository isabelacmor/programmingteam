import java.io.*;
import java.util.*;

/**
 * Write a description of class bunnies here.
 * 
 * @author Isabella Moreira
 * @date 9/26/2012
 * @purpose: to determine whether or not the owner can reach his bunny, by determining if there is a clear path between Peter's location and his bunny's
 * 
 * @previousBugs: I cannot figure out how to make the adjacentX() method not set a square equal to X if it is adjacent diagonally
 * I have separated the nested loops in adjacentX() so that it checks only for xcors and then only for ycors, but it still returns a grid with those values changed.
 * I believe if this bug is worked out, the method that checks to see if C (the bunny) is horz or vert adjacent to an X will return c
 * 
 * @totalTimeDebugging: 1 hour (9/26); 20 mins (9/27)
 * @bugLocation: in floodFill if statements, adjacentX() has to take the corresponding x and y value used elsewhere (ex: x+i or y+j)
 */
public class bunnies
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        int numPens = in.nextInt();
        int height, width;
        while(numPens != 0)
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
            
            //FIND PETER (STARTING LOCATION)
            int x = 0, y = 0;
            for(int i = 0; i < height; i++)
            {
                for(int j = 0; j < width; j++)
                {
                    if(grid[i][j] == 'P')
                    {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }
            
            //FIND BUNNY (ENDING LOCATION)
            int xC = 0, yC = 0;
            for(int i = 0; i < height; i++)
            {
                for(int j = 0; j < width; j++)
                {
                    if(grid[i][j] == 'C')
                    {
                        xC = i;
                        yC = j;
                        break;
                    }
                }
            }
            
            //System.out.println(Arrays.deepToString(grid));
            //FILL COURSE WITH X's
            floodFill(grid, x, y, width, height);
            boolean reachBunny = hasX(grid, width, height, xC, yC);
            //System.out.println(Arrays.deepToString(grid));
            if(reachBunny == true){ System.out.println("yes"); }
            else{ System.out.println("no"); }
            
            numPens--;
        }
    }
    
    public static void floodFill(char[][]grid, int x, int y, int width, int height)
    {
        //MARK THIS SPOT AS VISITED
        grid[x][y] = 'X';
        
        //GO THROUGH EACH SQUARE THAT'S AN __ (underscore) AND ADJACENT TO ANOTHER X (either horizontally or vertically)
        for(int i = -1; i <= 2; i++)
        {
            if(inbounds(x+i, y, width, height) && adjacentX(grid, x+i, y, width, height) && (grid[x+i][y] == '_' || grid[x+i][y] == 'C'))
            {
                floodFill(grid, x+i, y, width, height);
            }
        }
        
        for(int j = -1; j <= 2; j++)
        {
            if(inbounds(x, y+j, width, height) && adjacentX(grid, x, y+j, width, height) && (grid[x][y+j] == '_' || grid[x][y+j] == 'C'))
            {
                floodFill(grid, x, y+j, width, height);
            }
        }
    }
    
    public static boolean inbounds(int x, int y, int width, int height)
    {
        return x >= 0 && x < height && y >= 0 && y < width;
    }
    
    public static boolean hasX(char[][]grid, int width, int height, int xC, int yC)
    {
        if(grid[xC][yC] == 'X'){ return true; }
        else{ return false; }
    }
    
    public static boolean adjacentX(char[][]grid, int x, int y, int width, int height)
    {
        //check spaces to the left and right, if valid
        for(int i = -1; i < 2; i++)
        {
            if(inbounds(x+i, y, width, height) && grid[x+i][y] == 'X')
            {
                return true;
            }
        }
        
        //check spaces above and below, if valid
        for(int j = -1; j < 2; j++)
        {
            if(inbounds(x, y+j, width, height) && grid[x][y+j] == 'X')
            {
                return true;
            }
        }
        return false;
    }
}