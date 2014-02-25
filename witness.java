import java.io.*;
import java.util.*;

/**
 * Write a description of class witness here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class witness
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        //read in forbidden words
        ArrayList <String> forbidden = new ArrayList();
        String word = in.nextLine();
        while(!word.equals("EndOfInput"))
        {
            while(!word.equals("EndOfList"))
            {
                forbidden.add(word.toLowerCase()); //directly making the forbidden words lowercase so we can properly check ignoring case later on
                word = in.nextLine();
            }
            //System.out.println("forbidden: " + forbidden);
            
            //read in message
            ArrayList <String> msg = new ArrayList();
            String messageFull = "";
            word = in.nextLine();        
            //adding to arraylist msg puts every line of the letter into an index
            while(!word.equals("EndOfMsg"))
            {
                if(word.length() == 0)
                {
                    messageFull += "\n";
                    msg.add("\n");
                }
                else
                {
                    messageFull += (word.trim() + " ");
                    messageFull.trim();
                    msg.add(word.trim() + " ");
                }
                word = in.nextLine();
            }
            //System.out.println("1: " + messageFull + "\n 2: " + msg);//msg is the AL containing the formatted sentence
            
            //split to sentences
            //remove forbidden words
            //print all sentences based on length of each line in the first arraylist
            String [] sentencesAr = messageFull.split("(?<=[.!?\n])"); //this messy split() is used to keep punctuation marks intact
            ArrayList <String> sentences = new ArrayList();
            for(int i = 0; i < sentencesAr.length; i++)
            {
                sentences.add(sentencesAr[i]);
            }
            //System.out.println("3: " + sentences);
            
            //see if sentence contains any forbidden word.
            //if so, get location of word and location of closest punct mark.
            //block out words to the left or right of punct mark accordingly.
            int numChange;
            String punctEnd;
            String replacement = "";
            String temp;
            for(int i = 0; i < sentences.size(); i++)
            {
                temp = sentences.get(i).toLowerCase(); //we're going to check against a temp string which contains the current sentence in lowercase
                for(int j = 0; j < forbidden.size(); j++)
                {
                    if(temp.contains(" " + forbidden.get(j)) || temp.contains( forbidden.get(j) + " "))
                    {
                        replacement = "";
                        //System.out.println("checking " + forbidden.get(j) + " in sentence " + sentences.get(i));
                        numChange = sentences.get(i).length()-1;
                        punctEnd = sentences.get(i).substring(numChange+1);
                        for(int m = 0; m < numChange; m++)
                        {
                            replacement+="@";
                        }
                        replacement+=punctEnd;
                        sentences.set(i, replacement);
                        //System.out.println("replaced by " + sentences.get(i));
                    }
                    else
                    {
                        //System.out.println(forbidden.get(j) + " not found in sentence " + sentences.get(i));
                    }
                }
                //System.out.println("\n");
            }
            
            //System.out.println("4: " + sentences);
            String sentencesFinal = "";
            
            for(int i = 0; i < sentences.size(); i++)
            {
                sentencesFinal+=sentences.get(i);
            }
            
            //PRINT THE SENTENCES
            //BASED ON THE LENGTH OF THE ORIGINAL LINE ARRAY
            //
            //MAKE THE REPLACED SENTENCED ARRAY INTO ONE STRING
            //PRINT FROM n through max CHARS IN ORIGINAL LINE ARRAY
            //ONCE MAX CHARS IN LINE IS REACHED, PRINT \n THEN CONTINUE
            int startPos = 0;
            int lenMsg = 0;
            int lenSingle;
            int sub = 0;
            int addi = 1;
            //System.out.println("\nsentencesFinal length: " + sentencesFinal.length() + "\n");
            //System.out.printf("%-80s", sentencesFinal);
            for(int i = 0; i < msg.size(); i++)
            {
                lenMsg += (msg.get(i).length()-1);
                lenSingle = (msg.get(i).length()-1);
                startPos = lenMsg-lenSingle;
                //System.out.print("i: " + i + " startPos: " + startPos + "\tlenMsg: " + lenMsg + "\tlenSingle: " + lenSingle + "\n");
//                 if(i == msg.size()-3)
//                 {
//                     System.out.println("skipper");
//                 }
                if(msg.get(i).equals("\n") || msg.get(i).equals("")|| msg.get(i).equals(" "))
                {
                    System.out.print("");
                }
                else if(msg.get(i).length() > 1 && i <= 2)
                {
                    System.out.println(sentencesFinal.substring(startPos, lenMsg+1));
                }
                else if(msg.get(i).length() > 1 && i > 2 && i < 6)// && i%2 == 0)
                {
                    System.out.println(sentencesFinal.substring(startPos+(i-(i-(i-1))), lenMsg+(i-(i-(i-1)))));
                }
                else if(i == 2)// && i%2 == 0)
                {
                    System.out.println(sentencesFinal.substring(startPos, lenMsg+2));
                }
                else if(i >= 6 && i != msg.size()-1)// && i%2 == 0)
                {
                    System.out.println(sentencesFinal.substring(startPos+(i-(i-(i-1)+addi)), lenMsg+(i-(i-(i-1)))-1));
                    addi++;
                }
                else if(i == msg.size()-1)
                {
                    System.out.println(sentencesFinal.substring(startPos+(i-(i-(i-1)))-(sentencesFinal.length()-lenMsg), lenMsg+(i-(i-(i-1)))-(sentencesFinal.length()-lenMsg)));
                }
                else
                {
                    System.out.print("skipped");
                    //lenMsg--;
                }
                
           }
           System.out.println("====");
           if(in.hasNext())
            {
                word = in.nextLine();
            }
        }
    }
}