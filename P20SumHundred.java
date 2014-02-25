import java.math.*;
import java.util.*;

public class P20SumHundred
{
    public static void main (String [] args)
    {
        int count = 0;
        BigInteger mult = BigInteger.valueOf(1);
        int sum = 0;
        
        while(count != 100)
        {
            count++;
            mult = mult.multiply(BigInteger.valueOf(count));
        }
        
        String multS = String.valueOf(mult);
        System.out.println("100! equals " + multS);
        
        for(int i = 0; i < multS.length()-1; i++)
        {
            sum += Integer.parseInt(multS.substring(i, i+1));
        }
        
        System.out.println("The sum of the digits in 100! is " + sum);
    }
}
