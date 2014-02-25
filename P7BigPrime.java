public class P7BigPrime
{
    public static void main (String [] args)   
    {
        int count = 0;
        int currentNum = 0;
        
        while(count != 10001)
        {
            currentNum++;
            if(isPrime(currentNum))
            {
                count++;
                System.out.println(currentNum + " is prime");
            }            
        }
        
        System.out.println("Current count ends at " + count);
        System.out.println("The 10,001st prime number is " + currentNum);
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
