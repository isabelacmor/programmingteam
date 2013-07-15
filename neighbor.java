import java.io.*;
import java.util.*;

/**
 * Write a description of class neighbor here.
 * 
 * @author Isabella Moreira 
 * @date   9/12/2012
 * 
 * start check with 0 -> then check the largest number, then index start at
 * second num, loop
 * 
 * start check with 1 -> same as above
 * 
 * find largest. then find next largest where index != previousIndex-1 || previousIndex+1
 */
public class neighbor
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("neighbor.in"));
        
        int numTimes = in.nextInt();
        int caseNums = 1;
        int houseNum;
        int numHouses;
        int sum = 0;
        
        final int MAX_DONATION = 2000000;
        final int MIN_DONATION = 1;
        
        while(numTimes != 0)
        {            
            numHouses = in.nextInt();
            int [] allHouses = new int[numHouses];
            int [] usedHouses = new int[numHouses];
            int [] usedIndex = new int[numHouses];
            int [] bestIndex = new int[numHouses];
                     
            //assigning all houses to the array
            //their index value doesn't need to be stored
            //(it's already the index of the actual array)
            for(int i = 0; i < numHouses; i++)
            {
                allHouses[i] = in.nextInt();
                System.out.print(allHouses[i] + " ");
            }
            
            //find the FIRST absolute largest number
            //then break
            outerloop:
            for(int i = MAX_DONATION; i >= MIN_DONATION; i--)
            {
                for(int j = 0; j < allHouses.length; j++)
                {
                    //System.out.println("Checking " + allHouses[j] + " with " + i);
                    if(allHouses[j] == i)
                    {
                        usedHouses[0] = allHouses[j];
                        usedIndex[0] = j;
                        allHouses[j] = -1; //keeping the indexing intact, but making 
                        //sure this number isn't counted again (bc it's negative, it 
                        //will never be the largest)
                        break outerloop;
                    }
                }
                //System.out.println("DECREMENTING THE DONATION AMOUNT---------------------------------");
            }
            System.out.println("Largest num " + usedHouses[0] + " at index " + usedIndex[0]);
            
            //keep checking the rest of the numbers for the absolute largest
            //checking for the condition of the indexes
            int newI = 1;
            for(int i = MAX_DONATION; i >= MIN_DONATION; i--)
            {
                for(int j = 0; j < allHouses.length; j++)
                {
                    //System.out.println("Comparing " + allHouses[j] + " with " + i);
                    if(allHouses[j] == i)
                    {
                        //we need to put it in j+1 because j already has the largest
                        usedHouses[newI] = i;
                        usedIndex[newI] = j;
                        allHouses[j] = -1;
                        newI++;
                    }
                }
            }
            
            for(int i = 0; i < usedHouses.length; i++)
            {
                System.out.print(usedHouses[i] + " ");
            }
            
            /*
             * DON'T KNOW HOW TO DO:
             * 
             * As long as the indexes are more than one away from each other, add all the big
             * numbers first.
             * 
             * Then, as long as the indexes are more than one away from all the chosen numbers
             * that make up the sum, add the smaller numbers.
             * 
             * if(i > 0 && (usedIndex[i]-(usedIndex[i]-1)) != 1 && (usedIndex[i+1])-usedIndex[i] != 1)
             */
            
            sum = usedHouses[0];
            for(int i = 0; i < usedHouses.length; i++)
            {
                System.out.println("Ordered houses " + usedHouses[i] + " at index " + usedIndex[i]);
            }
            
            //look at largest.
            //if it's index - the index of all previous largest is > 1, we can add it
            boolean tf = true;
            for(int i = 0; i < usedHouses.length; i++)
            {
                for(int j = 0; j < usedHouses.length; j++)
                {
                    System.out.println("Comparing " + usedHouses[i] + " at index " + usedIndex[i] + " and " + usedHouses[j] + " at index " + usedIndex[j]);
                    if(usedIndex[i] != 0 && usedIndex[i]-1 != usedIndex[j] && usedIndex[i]+1 != usedIndex[j] && usedHouses[i] >= usedHouses[j])
                    {
                        tf = true;
                    }
                    else if(usedIndex[i] == 0 && usedIndex[i]+1 != usedIndex[j]+2 && usedHouses[i] >= usedHouses[j])
                    {
                        tf = true;
                    }
                    else{
                        tf = false;
                        break;
                    }
                }
                if(tf)
                {
                    sum+= usedHouses[i];
                    System.out.println("We've added " + usedHouses[i] + " at index " + usedIndex[i]);
                }
                else{System.out.println("N/A");}
                
                tf = true;
            }
            
            System.out.println("Sum: " + sum);
            System.out.println("MOVING TO A NEW CASE##############################################################");
            
            sum = 0;
            caseNums++;
            numTimes--;
        }
    }
}