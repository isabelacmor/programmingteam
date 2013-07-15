import java.io.*;
import java.util.*;

/**
 * Write a description of class sorting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ice
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        int numSessions = in.nextInt();
        int sCount = 1;
        int cCount = 1;
        int numBursts, numCubes, cubeCount;
        int indCube = 0;
        
        while(numSessions != 0)
        {
            numBursts = in.nextInt();
            cCount = 1;
            System.out.println("Session #" + sCount + ":");
            indCube = 0;
            while(numBursts != 0)
            {
                indCube += in.nextInt();
                if(indCube > 7)
                {
                    System.out.println("   Cup #" + cCount + ": " + (indCube - 7) + " cubes too many!"); 
                    indCube = 0;
                    cCount++;
                }
                else if(indCube == 7)
                {
                    System.out.println("   Cup #" + cCount + ": Perfect!");
                    indCube = 0;
                    cCount++;
                }
                else if(indCube < 7 && numBursts - 1 == 0)
                {
                    System.out.println("   Cup #" + cCount + ": Need " + (7 - indCube) + " more cubes!");
                }
                else{}
                numBursts--;
            }
            System.out.println();
            
            sCount++;
            numSessions--;
        }
    }
}
