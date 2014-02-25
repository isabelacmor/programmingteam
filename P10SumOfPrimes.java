import java.math.*;

public class P10SumOfPrimes
{
    public static void main (String [] args)   
    {
        int count = 0;
        BigInteger sum = BigInteger.valueOf(0);
        
        while(count != 2000000)
        {
            if(isPrime(count))
            {
                sum = sum.add(BigInteger.valueOf(count));
                System.out.println(count + " is prime");
                System.out.println("Current sum is " + sum);
            }            
            count++;
        }
        
        System.out.println("Count ends at " + count);
        System.out.println("The sum of all primes below two million is " + sum);
    }
    
    public static boolean isPrime(long num) {
        if(num == 2){return true;}
        else if(num == 1){return false;}
        else if (num % 2 == 0) {
            return false;
        }
        for (int n = 3; n <= Math.sqrt(num); n += 2) {
            if (num != n && num % n == 0) {
                return false;
            }
        }
        return true;
    }


}
