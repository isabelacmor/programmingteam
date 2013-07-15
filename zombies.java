import java.io.*;
import java.util.*;
/**
 * Write a description of class zombies here.
 * 
 * @author Isabella Moreira
 * @date 9/12/2012
 */
public class zombies
{
    public static void main (String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        int numLevels = in.nextInt();
        int width, height, numZombies, numMoves;
        int counter = 1;
        int capturedZombies = 0;
        
        while(counter != numLevels+1)
        {
            int xcor = 1;
            int ycor = 1;
            
            width = in.nextInt();
            height = in.nextInt();
            
            numZombies = in.nextInt();            
            int [] zombiePosx = new int [numZombies];
            int [] zombiePosy = new int [numZombies];
            for(int i = 0; i < numZombies; i++)
            {
                zombiePosx[i] = in.nextInt();
                zombiePosy[i] = in.nextInt();
                //System.out.println("Zombie position " + i + " : " + zombiePosx[i] + "," + zombiePosy[i]);
            }

            numMoves = in.nextInt();
            String [] movesPos = new String [numMoves];
            String blank = in.nextLine();
            for(int i = 0; i < numMoves; i++)
            {
                movesPos[i] = in.nextLine();
                //System.out.println("Move position " + i + " : " + movesPos[i]);
            }
            //move positions are in form: even=x cor; odd=y cor
            
            if(numMoves == 0)
            {
                for(int j = 0; j < numZombies; j++)
                    {
                        //System.out.println("Checking her pos: " +  xcor + "," + ycor + " with zombie pos " + zombiePosx[j] + "," + zombiePosy[j]);
                        if(xcor == zombiePosx[j] && ycor == zombiePosy[j])
                        {
                            capturedZombies++;
                            zombiePosx[j] = 0;
                            zombiePosy[j] = 0;
                            //System.out.println("Matched and made equal zero.");
                        }
                        //System.out.println("No match; same nums");
                    }
            }
            else
            {
                
                //check starting point
                for(int j = 0; j < numZombies; j++)
                    {
                        //System.out.println("Checking her pos: " +  xcor + "," + ycor + " with zombie pos " + zombiePosx[j] + "," + zombiePosy[j]);
                        if(xcor == zombiePosx[j] && ycor == zombiePosy[j])
                        {
                            capturedZombies++;
                            zombiePosx[j] = 0;
                            zombiePosy[j] = 0;
                            //System.out.println("Matched and made equal zero. Current captured zombies equals " + capturedZombies);
                        }
                        //System.out.println("No match; same nums");
                    }
            for(int i = 0; i < numMoves; i++)
            {           
                  //calculate her new position
                if(movesPos[i].equals("N"))
                {
                    ycor++;
                }
                else if(movesPos[i].equals("S"))
                {
                    ycor--;
                }
                else if(movesPos[i].equals("E"))
                {
                    xcor++;
                }
                else if(movesPos[i].equals("W"))
                {
                    xcor--;
                }
                else{System.out.println("We have encountered an error!");}
                
                //see if Crystel's xcor and ycor are the same as any zombie's
                for(int j = 0; j < numZombies; j++)
                    {
                        //System.out.println("Checking her pos: " +  xcor + "," + ycor + " with zombie pos " + zombiePosx[j] + "," + zombiePosy[j]);
                        if(xcor == zombiePosx[j] && ycor == zombiePosy[j])
                        {
                            capturedZombies++;
                            zombiePosx[j] = 0;
                            zombiePosy[j] = 0;
                            //System.out.println("Matched and made equal zero. Current captured zombies equals " + capturedZombies);
                        }
                        //System.out.println("No match; same nums");
                    }
                //System.out.println("New pos: " + xcor + "," + ycor);
            }
        }
            
            System.out.println("Level " + counter + ": Crystel vanquished " + capturedZombies + " zombies.");
            
            capturedZombies = 0;
            counter++;
        }
    }
}