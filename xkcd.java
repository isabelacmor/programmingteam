import java.io.*;
import java.util.*;

/**
 * @name Isabella Moreira
 * @date 10/8/2012
**/

public class xkcd 
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("xkcd.in"));
        int totalSum = 42;
        int num = in.nextInt();
        int [] values = {2, 3, 4, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 22, 23, 24, 26};
        int [] perm;
        boolean [] used;
        
        while(num != 42)
        {
            perm = new int[num];
            used = new boolean[values.length];
            perm(0, num, totalSum, values, used, perm);
            //numToString(perm, num);
            System.out.println("-----------");
            num = in.nextInt();
        }
    }
    
    public static void perm(int index, int num, int totalSum, int [] values, boolean [] used, int [] perm)
    {
        //base case
        if(index == num)
        {
            for(int i = num-1; i >= 0; i--)
            {
                //System.out.println("Looking at " + perm[i]);
                if(perm[i] == 2){ System.out.print("b"); }
                else if(perm[i] == 3){ System.out.print("c");}
                else if(perm[i] == 4){ System.out.print("d");}
                else if(perm[i] == 6){ System.out.print("f");}
                else if(perm[i] == 7){ System.out.print("g");}
                else if(perm[i] == 8){ System.out.print("h");}
                else if(perm[i] == 10){ System.out.print("j");}
                else if(perm[i] == 11){ System.out.print("k");}
                else if(perm[i] == 12){ System.out.print("l");}
                else if(perm[i] == 13){ System.out.print("m");}
                else if(perm[i] == 14){ System.out.print("n");}
                else if(perm[i] == 16){ System.out.print("p");}
                else if(perm[i] == 17){ System.out.print("q");}
                else if(perm[i] == 18){ System.out.print("r");}
                else if(perm[i] == 19){ System.out.print("s");}
                else if(perm[i] == 20){ System.out.print("t");}
                else if(perm[i] == 22){ System.out.print("v");}
                else if(perm[i] == 23){ System.out.print("w");}
                else if(perm[i] == 24){ System.out.print("x");}
                else if(perm[i] == 26){ System.out.print("z");}
                else{ System.out.print("#"); }
            }
        }
        
        //recursive solution
        for(int i = values.length-1; i > num; i--)
        {
            if(!used[i] && values[i] <= totalSum)
            {
                perm[index] = values[i];
                used[i] = true;
                totalSum-=values[i];
                perm(index+1, num, totalSum, values, used, perm);
                used[i] = false;
            }
        }
    }
    
    //converts the arrangement of number permutations to its alpha representation
    //hardcoded
    //not sure why this method isn't working, but the logic works for in the above method
    public static void numToString(int [] perm, int num)
    {            
        for(int i = 0; i < num; i++)
        {
            System.out.println("Looking at " + perm[i]);
            if(perm[i] == 2){ System.out.print("b"); }
            else if(perm[i] == 3){ System.out.print("c");}
            else if(perm[i] == 4){ System.out.print("d");}
            else if(perm[i] == 6){ System.out.print("f");}
            else if(perm[i] == 7){ System.out.print("g");}
            else if(perm[i] == 8){ System.out.print("h");}
            else if(perm[i] == 10){ System.out.print("j");}
            else if(perm[i] == 11){ System.out.print("k");}
            else if(perm[i] == 12){ System.out.print("l");}
            else if(perm[i] == 13){ System.out.print("m");}
            else if(perm[i] == 14){ System.out.print("n");}
            else if(perm[i] == 16){ System.out.print("p");}
            else if(perm[i] == 17){ System.out.print("q");}
            else if(perm[i] == 18){ System.out.print("r");}
            else if(perm[i] == 19){ System.out.print("s");}
            else if(perm[i] == 20){ System.out.print("t");}
            else if(perm[i] == 22){ System.out.print("v");}
            else if(perm[i] == 23){ System.out.print("w");}
            else if(perm[i] == 24){ System.out.print("x");}
            else if(perm[i] == 26){ System.out.print("z");}
            else{ System.out.print("#"); }
        }
    }
}