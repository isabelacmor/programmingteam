import java.util.*;
import java.io.*;
public class isogram
{
    public static void main(String [] args) throws IOException
    {
        Scanner input = new Scanner(new File("isogram.in"));
        
        int counter = input.nextInt();
        String blank = input.nextLine();
        String word;
        
        //looping through the list of words
        while(counter!=0)
        {
            word = input.nextLine();
            System.out.println("Current Word: " + word);
            //checkWord(word);
            System.out.println("True or false? " + checkWord(word) + "\n");
            counter--;
        }
    }
    
    public static boolean checkWord(String word)
    {
       ArrayList <String> letters = new ArrayList();
       ArrayList <Integer> times = new ArrayList();
       int wordLen = word.length();
       int tempTime = 0;
       int indexWord;
       int countLetter = 1;
       
       //looping through the length of the word to check every individual character
       for(int i = 0; i < wordLen; i++)
       {
           //if the ArrayList of letters does NOT already contain the letter we are currently analyzing
           if(!(letters.contains(word.substring(i, i+1))))
           {
               //we add the letter to the end of the ArrayList letters, then set the letter count equal to 1 in the corresponding index of the ArrayList times
               letters.add(word.substring(i, i+1));
               times.add(countLetter);
               
               //These are just debugging statements
               //System.out.println("NEW LETTER IS BEING ADDED: " + letters.get(letters.indexOf(word.substring(i, i+1))) + "\n CURRENT TIMES: " + times.get(letters.indexOf(word.substring(i, i+1))));
               //System.out.println("THE CURRENT ARRAYS ARE: " + letters + " " + times);
           }
           //if the ArrayList of letters already contains the letter we are analyzing
           else
           {
               //we get the index of the letter in ArrayList (for convenience)
               indexWord = letters.indexOf(word.substring(i, i+1));
               //we make the current count of that letter equal tempTime so we can increment it
               tempTime = times.get(indexWord);
               //we add the increment of the current times of appearance into the corresponding index of the placement of said letter
               times.add(indexWord, tempTime+1);
               //we then remove the old times (located after the new index) from the ArrayList
               times.remove(indexWord+1);
               
               //These are just debugging statements
               //System.out.println("THIS LETTER HAS ALREADY BEEN FOUND. WE ARE CHANGING THE COUNT FROM: " + tempTime + " TO: " + times.get(indexWord));
               //System.out.println("THE CURRENT ARRAYS ARE: " + letters + " " + times);
           }
       }
            
       int count = 0;
       boolean equals = false;
       //checking to see if all the values in the ArrayList times equal 2
       while(count != times.size())
       {
           if(times.get(count) == 2)
           {
               equals = true;
           }
           else
           {
               return false;
           }
           count++;
       }

       return equals;
    }
}
