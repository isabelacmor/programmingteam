public class P1belowThousand
{
    public static void main (String [] args)
    {
        int counter = 999;
        int sum = 0;
        
        while(counter != 0)
        {
            if(counter%3 == 0 || counter%5 == 0)
            {
                sum += counter;
            }
            counter--;
        }
        
        System.out.println("The sum of all multiples of 3 or 5 below 1000 is " + sum);
    }
}
