import java.io.*;
import java.util.*;
/**
 * Write a description of class chalice here.
 * 
 * @author Isabella Moreira
 * @version 4/30/12
 * @purpose prep for UCF HSPT 2012
 */
public class chalice
{
    public static void main (String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2008\\chalice.in");
        Scanner scanner = new Scanner(file);
        
        int trials = scanner.nextInt();
        int counter = 1;
        int weightAccused, numGeese;
        int totalWeightGeese = 0;
        int [] weightGeese;
        
        while(trials != 0)
        {
            System.out.print("Trial #" + counter + ": ");
            
            weightAccused = scanner.nextInt();
            numGeese = scanner.nextInt();
            weightGeese = new int[numGeese];
            totalWeightGeese = 0;
            
            //System.out.println("WEIGHT ACCUSED: " + weightAccused);
            //System.out.println("NUMBER OF GEESE: " + numGeese);
            
            for(int i = 0; i < numGeese; i++)
            {
                weightGeese[i] = scanner.nextInt();
                totalWeightGeese += weightGeese[i];
                //System.out.println("TOTAL GEESE WEIGHT: " + totalWeightGeese);
            }
            
            if(weightAccused <= totalWeightGeese)
            {
                System.out.println("SHE'S A WITCH! BURN HER!");
            }
            else
            {
                System.out.println("She's not a witch. BURN HER ANYWAY!");
            }
            
            counter++;
            trials--;
        }
    }
}
