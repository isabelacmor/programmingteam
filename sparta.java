import java.io.*;
import java.util.*;
/**
 * Write a description of class sparta here.
 * 
 * @author Isabella Moreira 
 * @date 4/30/12
 * @purpose prep for UCF HSPT 2012
 */
public class sparta
{
    public static void main (String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2008\\sparta.in");
        Scanner scanner = new Scanner(file);
        
        int times = scanner.nextInt();
        int yells = 0;
        int armySize = 0;
        int current = 1;
        String [] yellsCount;
        while(times != 0)
        {
            armySize = 0;
            System.out.println("Dispute " + current + ":");
            yells = scanner.nextInt();
            String blank = scanner.nextLine();
            for(int n = 0; n < yells; n++)
            {
                yellsCount = (scanner.nextLine()).split(" ");
                for(int a = 1; a < yellsCount.length; a+=2)
                {
                    armySize += Integer.parseInt(yellsCount[a]);
                }
            }
            System.out.println("Perians " + armySize + ", Spartan 300");
            System.out.println("This is SPARTA!");
            System.out.println();
            times--;
            current++;
        }
    }
}
