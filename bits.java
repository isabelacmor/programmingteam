import java.io.*;
import java.util.*;

/**
 * Write a description of class bits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bits
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("bits.in"));
        
        //first set of info
        int a = in.nextInt();
        int b, c, s, ans;
        int i = 0;
        //to store the results
        ArrayList <Integer> decimal = new ArrayList();
        ArrayList <String> binary = new ArrayList();
        while(a != 0)
        {
            //pull in rest of variables
            b = in.nextInt();
            c = in.nextInt();
            s = in.nextInt();
            
            //the first answer is s
            decimal.add(s);
            //calculate the next answer
            ans = (a*decimal.get(i)+b)%c;
            //as long as we haven't gotten the same answer before
            //(which would lead to an infinite loop)
            while(!decimal.contains(ans))
            {
                //add that answer
                decimal.add(ans);
                //increase the variable used for calculating the answer
                i++;
                //calculate the new answer
                ans = (a*decimal.get(i)+b)%c;
            }
            
            System.out.println(decimal);
            
            //change decimals to binaries
            for(int j = 0; j < decimal.size(); j++)
            {
                binary.add(String.format("%016d\n", Integer.parseInt(Integer.toBinaryString(decimal.get(j)))));
            }
            
            String result = "";
            boolean same = true;
            String cur = "";
            String lookingAt = "";
            
            System.out.println(binary.size());
            
            //go through all chars in the binary
            for(int k = 0; k < 16; k++)
            {
                //compare all binaries
                lookingAt = binary.get(0).substring(k, k+1);
                same = true;
                for(int m = 0; m < binary.size()-1; m++)
                {
                    if(lookingAt.equals(binary.get(m+1).substring(k, k+1)) && same == true)
                    {
                        same = true;
                        cur = binary.get(m).substring(k, k+1);
                    }
                    else
                    {
                        same = false;
                        cur = "?";
                        break;
                    }
                }
                result+=cur;
            }
            
            System.out.println(" " + binary);
            System.out.println(result);
            
            //get new values after checking for errors
            if(in.hasNext())
                a = in.nextInt();
            else
                break;
        }        
    }
}