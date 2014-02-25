import java.util.*;
import java.io.*;

/**
 * Calculate cheapest cost for shipping package
 * 
 * @author Isabella Moreira 
 * @date 8/31/2012
 * 
 * NOTES: I realize this isn't the most effiecent way to solve the problem, but it's the best I could come up with that
 * would make sense to me and be easy for me to code.
 */
public class express
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("express.in"));
        
        int setNum = 1;
        
        while(in.hasNextLine())
        {
            //taking in variables from the file
            int range1, cost1, range2, cost2, range3, cost3, cost4;
            range1 = in.nextInt();
            cost1 = in.nextInt();
            range2 = in.nextInt();
            cost2 = in.nextInt();
            range3 = in.nextInt();
            cost3 = in.nextInt();
            cost4 = in.nextInt();
            
            int weight = in.nextInt();
            System.out.println("Set number " + setNum + ":");
            
            while(weight != 0)
            {
                int bestCost, currentCost, bestRange, addPounds;
                int [] possibleCost = new int [4];
                int [] weightIndex = {0, range1+1, range2+1, range3+1};
                          
                //Check what range the actual weight is in.
                //Find the lowest cost for the package in each range.
                //Find which cost is the lowest
                if(weight <= range1)
                {
                    possibleCost[0] = weight*cost1;
                    possibleCost[1] = (range1+1)*cost2;
                    possibleCost[2] = (range2+1)*cost3;
                    possibleCost[3] = (range3+1)*cost4;
                    
                    bestCost = possibleCost[0];
                    bestRange = 0;
                    for(int i = 0; i < 4; i++)
                    {
                        if(possibleCost[i] < bestCost)
                        {
                            bestCost = possibleCost[i];
                            bestRange = i;
                        }
                    }
                    addPounds = weightIndex[bestRange]-weight;
                    if(addPounds > 0)
                    {
                        System.out.println("Weight (" + weight + ") has the best price $" + bestCost + " (add " + addPounds  + " pounds)");
                    }
                    else
                    {
                        System.out.println("Weight (" + weight + ") has the best price $" + bestCost + " (add 0 pounds)");
                    }
                }
                
            
                else if(weight <= range2)
                {
                    possibleCost[0] = 999999999;
                    possibleCost[1] = weight*cost2;
                    possibleCost[2] = (range2+1)*cost3;
                    possibleCost[3] = (range3+1)*cost4;
                
                    bestCost = possibleCost[0];
                    bestRange = 0;
                    for(int i = 0; i < 4; i++)
                    {
                        if(possibleCost[i] < bestCost)
                        {
                            bestCost = possibleCost[i];
                            bestRange = i;
                        }
                    }
                    addPounds = weightIndex[bestRange]-weight;
                    if(addPounds > 0)
                    {   
                        System.out.println("Weight (" + weight + ") has the best price $" + bestCost + " (add " + addPounds  + " pounds)");
                    }
                    else
                    {
                        System.out.println("Weight (" + weight + ") has the best price $" + bestCost + " (add 0 pounds)");
                    }
                }
                else if(weight <= range3)
                {
                    possibleCost[0] = 999999999;
                    possibleCost[1] = 999999999;
                    possibleCost[2] = weight*cost3;
                    possibleCost[3] = (range3+1)*cost4;         
                    
                    bestCost = possibleCost[0];
                    bestRange = 0;
                    for(int i = 0; i < 4; i++)
                    {
                        if(possibleCost[i] < bestCost)
                        {
                            bestCost = possibleCost[i];
                            bestRange = i;
                        }
                    }
                    addPounds = weightIndex[bestRange]-weight;
                    if(addPounds > 0)
                    {
                        System.out.println("Weight (" + weight + ") has the best price $" + bestCost + " (add " + addPounds  + " pounds)");
                    }
                    else
                    {
                        System.out.println("Weight (" + weight + ") has the best price $" + bestCost + " (add 0 pounds)");
                    }
                }
                else
                {
                    bestCost = weight*cost4;
                    System.out.println("Weight (" + weight + ") has the best price $" + bestCost + " (add 0 pounds)");
                } 
                weight = in.nextInt();
            }
            System.out.println();
            setNum++;
        }
    }
}
