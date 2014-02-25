import java.io.*;
import java.util.*;
/**
 * Write a description of class kakuro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class kakuro
{
    public static void main (String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2006\\kakuro.in");
        Scanner scanner = new Scanner(file);
        
        int problems = Integer.parseInt(scanner.nextLine());
        int goal, first, second, third;
        String [] nums = new String[4];
        for(int i = 0; i < problems; i++)
        {
            nums = (scanner.nextLine()).split(" ");
            goal = Integer.parseInt(nums[0]);
            first = Integer.parseInt(nums[1]);
            second = Integer.parseInt(nums[2]);
            third = Integer.parseInt(nums[3]);
            if((first != second) && (first != third) && (third != second) && (first+second+third==goal))
            {
                System.out.println("Proper triplet");
            }
            else
            {
                System.out.println("Not a good triplet");
            }
        }
    }
}
