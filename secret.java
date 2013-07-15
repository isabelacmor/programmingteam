import java.io.*;
import java.util.*;
/**
 * Write a description of class secret here.
 * 
 * @author Isabella Moreira 
 * @date 5/01/12
 * @purpose prep for UCF HSPT 2012
 * @time < 20 mins
 */
public class secret
{
    public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2002\\secret.in");
        Scanner scanner = new Scanner(file);
        
        int times = scanner.nextInt();
        int lines, wordsIndex;
        String sentence, empty;
        String [] sepSent;
        
        while(times != 0)
        {
            lines = scanner.nextInt();
            wordsIndex = scanner.nextInt() - 1;
            empty = scanner.nextLine();            
            
            //System.out.println("LINES: " + lines);
            //System.out.println("WORDSINDEX: " + wordsIndex);
            
            for(int i = 0; i < lines; i++)
            {
                sentence = scanner.nextLine();
                //System.out.println("SENTENCE: " + sentence);
                sepSent = sentence.split(" ");
                //System.out.print("LENGTH: " + sepSent.length);
                
                if(sepSent.length == 0 || sepSent.length == 1)
                {
                    System.out.print("STOP ");
                }
                else if(wordsIndex < sepSent.length)
                {
                    System.out.print(sepSent[wordsIndex] + " ");
                }
                else
                {
                    System.out.print("STOP ");
                }
            }
            System.out.println();            
            times--;
        }
    }
}
