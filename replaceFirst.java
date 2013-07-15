import java.io.*;
import java.util.*;
/**
 * Write a description of class letters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class replaceFirst
{
    public static void main (String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2008\\letters.in");
        Scanner scanner = new Scanner(file);
        
        int words = scanner.nextInt();
        String word, newWord;
        String empty = scanner.nextLine();
        
        while(words != 0)
        {
            word = scanner.nextLine();
            newWord = word.replaceFirst("l", "w");
            System.out.println(newWord);
            words--;
        }
    }
}
