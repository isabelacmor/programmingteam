import java.math.*;

public class P48rootChain
{
    public static void main (String [] args)
    {
        BigInteger sum = BigInteger.valueOf(0);
        int nums = 1;
        
        while(nums != 1000)
        {
            sum = sum.add(BigInteger.valueOf(nums).pow(nums));
            //System.out.println("Current Sum: " + sum);
            nums++;
        }
        
        String stringSum = String.valueOf(sum);
        int len = stringSum.length();
        stringSum = stringSum.substring(len-10, len);
        System.out.println("The length of the sum of the series is " + len);
        System.out.println("The sum of the series is " + sum);
        System.out.println("The last ten digits of the sum of the series is " + stringSum);
    }
}
