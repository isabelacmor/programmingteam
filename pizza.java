import java.io.*;
import java.util.*;
/**
 * Write a description of class pizza here.
 * 
 * @author Isabella Moreira
 * @version 4/30/12
 * @purpose prep for UCF HSPT 2012
 */
public class pizza
{
    public static void main (String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2008\\pizza.in");
        Scanner scanner = new Scanner(file);
        
        //A = pi*r^2
        //C = 2pi*r
        //R = C/2pi
        int pizzas = scanner.nextInt();
        int counter = 1;
        double circum, slices, eaten, radius, area, calsTotal, calsInOneSlice, calsInEaten; //peri equals circum (C=2pi*r)
        double twoPi = 6.2831853;
        
        while(pizzas != 0)
        {
            circum = scanner.nextInt();
            slices = scanner.nextInt();
            eaten = scanner.nextInt();
            
            radius = circum/(twoPi); //47.746482982126915785851485233135
            area = (Math.pow(radius, 2))*3.14159265;
            
            calsTotal = area * 10;
            calsInOneSlice = calsTotal/slices;
            calsInEaten = Math.ceil(calsInOneSlice*eaten);
            
            System.out.println("Perfectly Popular Pizza " + counter + ": Perry consumed " + (int)(calsInEaten) + " calories.");
            counter++;
            pizzas--;
        }
    }
}
