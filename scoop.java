import java.io.*;
import java.util.*;
/**
 * Write a description of class scoop here.
 * 
 * @author Isabella 
 * @date 4/30/2012
 * @purpose prep for UCF HSPT 2012
 */
public class scoop
{
    public static void main (String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2008\\scoop.in");
        Scanner scanner = new Scanner(file);
        
        int times = scanner.nextInt();
        String empty = scanner.nextLine();
        int counter = 1;
        String [] order;
        int scoop;
        int total = 1;
        while(times != 0)
        {
            total = 1;            
            order = scanner.nextLine().split(" ");
            scoop = order.length;
            for(int i = 0; i < scoop-1; i++)
            {
                if(order[i].equals("Double"))
                {
                    total *= 2;
                }
                else if(order[i].equals("Triple"))
                {
                    total *= 3;
                }
                else if(order[i].equals("Quadruple"))
                {
                    total *= 4;
                }
                else{}
            }
            System.out.println("Order #" + counter + ": " + total);
            counter++;
            times--;
        }
    }
}
