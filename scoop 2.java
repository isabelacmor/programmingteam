import java.io.*;
import java.util.*;

/**
 * Write a description of class scoop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class scoop
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        int numOrders = in.nextInt();
        int count = 1;
        String blank, order;
        int baseScoops;
        blank = in.nextLine();
        
        while(numOrders != 0)
        {
            baseScoops = 1;
            order = in.nextLine();
            String [] orderSplit = order.split(" ");
            
            for(int i = 0; i < orderSplit.length; i++)
            {
                if(orderSplit[i].equals("Double")){ baseScoops*=2; }
                else if(orderSplit[i].equals("Triple")){ baseScoops*=3;}
                else if(orderSplit[i].equals("Quadruple")){ baseScoops*=4;}
                else{}
            }
            
            if(numOrders == 1)
            {
                System.out.print("Order #" + count + ": " + baseScoops);
            }
            else{System.out.println("Order #" + count + ": " + baseScoops);}
            
            numOrders--;
            count++;
        }
    }
}
