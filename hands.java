import java.io.*;
import java.util.*;
/**
 * Write a description of class hands here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hands
{
    public static void main (String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2008\\hands.in");
        Scanner scanner = new Scanner(file);
        
        int times = scanner.nextInt();
        int [] first = new int [3];
        int [] second = new int [3];
        int count = 1;
        while(times != 0)
        {
            first[0] = scanner.nextInt();
            first[1] = scanner.nextInt();
            first[2] = scanner.nextInt();
            second[0] = scanner.nextInt();
            second[1] = scanner.nextInt();
            second[2] = scanner.nextInt();
            Arrays.sort(first);
            Arrays.sort(second);
            System.out.println("Pair #" + count + " of hands requires a clock face at least " + (first[2]+second[2]) + " meters wide.");
            count++;
            times--;
        }
    }
}
