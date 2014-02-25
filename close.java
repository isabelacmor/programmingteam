import java.io.*;
import java.util.*;

/**
 * Write a description of class close here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class close
{
    public static final int calsPerFat = 9;
    public static final int calsPerCarbs = 4;
    public static final int calsPerProt = 4;
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("close.in"));
        
        double numCal = in.nextInt();
        double numFat = in.nextInt();
        double numCarbs = in.nextInt();
        double numProt = in.nextInt();
        
        double trueCals;
        
        int maxCounter = 999999999;
        
        while(numCal != 0 && numFat !=0 && numCarbs != 0 && numProt != 0)
        {
            trueCals = 0;
            trueCals = numFat*calsPerFat + numCarbs*calsPerCarbs + numProt*calsPerProt;
            
            //while they're not equal
            while((int)trueCals != (int)numCal)
            {
                if(trueCals > numCal){ trueCals = tryLow(trueCals, numCal, numFat, numCarbs, numProt); }
                else if(trueCals < numCal){ trueCals = tryHigh(trueCals, numCal, numFat, numCarbs, numProt); }
                
                maxCounter--;
            }
            if(maxCounter >= 0){ System.out.println("yes"); }
            else{ System.out.println("no"); }
            
            //get next vals
            numCal = in.nextInt();
            numFat = in.nextInt();
            numCarbs = in.nextInt();
            numProt = in.nextInt();
        }
    }
    public static double tryHigh (double trueCals, double numCal, double numFat, double numCarbs, double numProt)
    {
        numFat -= 0.1;
        numCarbs -= 0.1;
        numProt -= 0.1;
        trueCals = (numFat*calsPerFat + numCarbs*calsPerCarbs + numProt*calsPerProt);
        return trueCals;
    }
    public static double tryLow (double trueCals, double numCal, double numFat, double numCarbs, double numProt)
    {
        numFat += 0.1;
        numCarbs += 0.1;
        numProt += 0.1;
        trueCals = (numFat*calsPerFat + numCarbs*calsPerCarbs + numProt*calsPerProt);
        return trueCals;
    }
}