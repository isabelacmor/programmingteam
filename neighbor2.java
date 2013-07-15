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
 * find largest. then find next largest where index != previousI
 */
public class neighbor2
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("neighbor.in"));
        
        int numTimes = in.nextInt();
        int caseNums = 1;
        int houseNum;
        int evenHouseNum = 0;
        int oddHouseNum = 0;
        int numHouses;
        int evenSum = 0;
        int oddSum = 0;
        
        while(numTimes != 0)
        {            
            numHouses = in.nextInt();
            int [] evenHouses = new int[numHouses];
            int [] oddHouses = new int[numHouses];
                        
            for(int i = 0; i < numHouses; i++)
            {
                if(i%2 == 0)
                {
                    evenHouses[evenHouseNum] = in.nextInt();
                    evenHouseNum++;
                }
                else
                {
                    oddHouses[oddHouseNum] = in.nextInt();
                    oddHouseNum++;
                }
            }
            for(int i = 0; i < numHouses/2; i++)
            {
                evenSum += evenHouses[i];
                oddSum += oddHouses[i];
            }
            
            if(oddSum > evenSum)
            {
                System.out.print("Case #" + caseNums + ": " + oddSum + " : ");
                
                houseNum = 1;
                for(int i = 0; i < oddHouses.length; i++)
                {
                    System.out.print(houseNum + " ");
                    houseNum+=2;
                }
            }
            else if(evenSum > oddSum || evenSum == oddSum)
            {
                System.out.print("Case #" + caseNums + ": " + evenSum + " : ");
                
                houseNum = 0;
                for(int i = 0; i < evenHouses.length; i++)
                {
                    System.out.print(houseNum + " ");
                    houseNum+=2;
                }
            }
            else
            {
                System.out.println("Oops, something went wrong.");
            }
            System.out.println();
            
            evenHouseNum = 0;
            oddHouseNum = 0;
            evenSum = 0;
            oddSum = 0;
            caseNums++;
            numTimes--;
        }
    }
}
