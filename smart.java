import java.io.*;
import java.util.*;
/**
 * Write a description of class smart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class smart
{
    public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2009\\smart.in");
        Scanner scanner = new Scanner(file);
        
        int numThrows = Integer.parseInt(scanner.nextLine());
        int target, real;
        String [] nums = new String [2];
        for(int i = 0; i < numThrows; i++)
        {
            nums = (scanner.nextLine()).split(" ");
            target = Integer.parseInt(nums[0]);
            real = Integer.parseInt(nums[1]);
            if(target == real)
            {
                System.out.println("The Old Knife-Hits-the-Target Trick");
            }
            else
            {
                System.out.println("Missed it by THAT much");
            }
        }
    }
}
