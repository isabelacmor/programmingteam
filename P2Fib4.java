import java.math.*;

public class P2Fib4
{
    public static void main (String [] args)
    {
        int count = 1;
        int currentFib = 0;
        int sum = 0;
        
        while(currentFib < 4000000)
        {
            count++;
            currentFib = nextFib(count);
            
            if(currentFib%2 == 0){ sum += currentFib; }
            
            System.out.println("Current Fibonacci number is " + currentFib);
            //System.out.println("Current sum of Fib nums is  " + sum);
        }
        
        System.out.println("Total sum of Fib nums is " + sum);
    }
    
    public static int nextFib(int n)
    {
        if(n <= 2){ return 1; }
        else{ return nextFib(n-1) + nextFib(n-2); }
    }
}
