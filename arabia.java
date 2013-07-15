import java.io.*;
import java.util.*;

/**
 * Write a description of class arabia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class arabia
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("arabia.in"));
        
        int numDepots = in.nextInt();
        int numAttacks = in.nextInt();
        int [] depVal, perm;
        boolean [] used;
        int originalVal;
        
        while(numDepots != 0 && numAttacks != 0)
        {
            depVal = new int [numDepots];
            int N = depVal.length;
            perm = new int [N/2];
            used = new boolean [N];
            
            for(int i = 0; i < depVal.length; i++)
            {
                depVal[i] = in.nextInt();
            }            
            permute(0, perm, N, used, depVal);
            
            numDepots = in.nextInt();
            numAttacks = in.nextInt();
        }
    }
    public static int [] permute(int ind, int [] perm, int N, boolean [] used, int [] depVal)
    {
        if(ind == N/2)
        {
            for(int k = 0; k < N/2; k++)
            {
                System.out.printf("%d", perm[k]);
            }
            System.out.println();
            return perm;
        }
        else
        {            
            for(int i = 0; i < N; i++)
            {
                if(!used[i])
                {
                    perm[ind] = depVal[i];
                    used[i] = true;
                    permute(ind+1, perm, N, used, depVal);
                    used[i] = false;
                }
            }
        }
        return null;
    }
}