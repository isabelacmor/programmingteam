import java.io.*;
import java.util.*;
/**
 * Write a description of class nihongo here.
 * 
 * @author Isabella Moreira
 * @date 5/03/12
 * @purpose prep for UCF HSPT 2012
 * @time < 10 mins
 */
public class nihongo
{
    public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2001\\nihongo.in");
        Scanner scanner = new Scanner(file);
        
        String sent = scanner.nextLine();
        String [] words;
        int [] indexOfSpaces;
        
        while(!sent.equals("yame"))
        {
            //System.out.println(sent);
            
            words = sent.split(" ");
            
            if(words[words.length-2].equals("desu"))
            {
                System.out.println("Hai, " + words[words.length-3] + " " + words[words.length-2]);
            }
            else if(words[words.length-2].contains("desu") || !words[words.length-2].equals("desu"))
            {
                System.out.println("Hai, " + words[words.length-2]);
            }
            else
            {
                System.out.println("YOU SHOULDN'T BE IN THIS ELSE STATEMENT");    
            }
            
            sent = scanner.nextLine();
        }
    }
}
