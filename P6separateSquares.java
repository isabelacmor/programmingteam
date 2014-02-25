import java.math.*;

public class P6separateSquares
{
    public static void main (String [] args)
    {
        BigInteger sumOfSquares = BigInteger.valueOf(0);
        BigInteger squareOfSums = BigInteger.valueOf(0);
        int count = 1;
        
        while(count != 101)
        {
            sumOfSquares = sumOfSquares.add(BigInteger.valueOf(count).pow(2));
            count++;
        }
        
        count = 1;
        while(count != 101)
        {
            squareOfSums = squareOfSums.add(BigInteger.valueOf(count));
            count++;
        }
        squareOfSums = squareOfSums.pow(2);
        BigInteger diff = squareOfSums.subtract(sumOfSquares);
        
        System.out.println("The difference between the sum of the squares and the square of the sums is " + (diff));
    }
}
