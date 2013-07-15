// Arup Guha
// 8/9/06
// Solution to 2006 UCF Programming Contest Problem: Tnine.
// This solution is not ideally what I'd want to write, but it was what
// I could put together given the part of the API I know. The ArrayList
// doesn't give me the option of doing a look-up based on a "key", so I
// have manually implemented it. It works, but I imagine there's a much
// cleaner solution that makes use of the API in a better way.

import java.util.*;
import java.io.*;

public class tnine {
	
	// A tnine object will store one T9 string, as well as a collection
	// of all the words that match to it.
	private String digits;
	private ArrayList<String> words;
	
	// We can use this to look up the corresponding number for each
	// letter.
	final static String[] nums = {"2","2","2","3","3","3","4","4","4",
	                            "5","5","5","6","6","6","7","7","7","7",
	                            "8","8","8","9","9","9","9"};
	
	// Basic constructor, it "seeds" the new T9 object with a new numeric
	// string and a single corresponding alphabetic string. To use this
	// object properly these two have to match.
	public tnine(String d, String w) {
		digits = d;
		words = new ArrayList<String>();
		words.add(w);
	}
	
	// This adds an extra word into a T9 object and associates that word
	// with the current object's T9 string.
	public void add(String w) {
		words.add(w);
	}
	
	public static void main(String[] args) throws IOException {
		
		// Store the dictionary here.
		ArrayList<tnine> dictionary = new ArrayList<tnine>();
		
		// Open the input file.
		Scanner fin = new Scanner(new File("tnine.in"));
		
		// Number of words in the dictionary.
		int size = fin.nextInt();
		
		// Read in each word.
		for (int i=0; i<size; i++) {
			
			// Read in the next word and calculate its numeric string.
			String word = fin.next();
			String textmap = getText(word);
			
			// See if we have that numeric string in our dictionary yet.
			int index = getIndex(dictionary, textmap);
			
			// If not, add a new object to our dictionary.
			if (index < 0)
				dictionary.add(new tnine(textmap, word));
				
			// If so, add the new word to the appropriate object.
			else
				dictionary.get(index).add(word);
				
			
		}
		
		int numcases = fin.nextInt();
		String garbage = fin.nextLine();
		
		// Loop through each case.
		for (int i=1; i<=numcases; i++) {
			
			// Set up the message in a StringTokenizer.
			StringTokenizer tok = new StringTokenizer(fin.nextLine());
			
			// answer will store the text message, if there is a unique one.
			String answer = "";
			
			// Stores the total possible number of messages.
			int total = 1;
			
			// Loop as long as there are more words in the text message.
			while (tok.hasMoreElements()) {
				
				// This is the next word in the text message.
				String number = tok.nextToken();
				
				// See if it's in the dictionary.
				int location = getIndex(dictionary, number);
				int numchoices=1;
				
				// Invalid message, break out of the loop.
				if (location < 0) {
					total = 0;
					break;
				}
				else
					// See how many times it's in the dictionary.
					numchoices = dictionary.get(location).words.size();
				
				// Could be a multiple message, for now just calculate how
				// many messages could fit this one up til this point.
				if (numchoices > 1) {
					total *= numchoices;
					
					/* Prints out each word if there is more than one that matches.
					System.out.print(numchoices+" ");
					for (int j=0; j<dictionary.get(location).words.size(); j++)
						System.out.print(dictionary.get(location).words.get(j)+" ");
					System.out.println();
					*/
					
				}
				
				// Only one choice for this word, so go ahead and calculate
				// the corresponding word.
				else {
					
					String realword = dictionary.get(location).words.get(0);
					if (answer.equals(""))
						answer = answer + realword;
					else
						answer = answer + " " + realword;
				}
			}
			
			System.out.print("Message #"+i+": ");
			
			if (total == 0)
				System.out.println("not a valid text");
			else if (total == 1)
				System.out.println(answer);
			else
				System.out.println("there are "+total+" possible messages");
			System.out.println();
		}
		
		fin.close();
		
		
	}
	
	public static String getText(String w) {
		String ans = "";
		for (int i=0; i<w.length(); i++)
			ans = ans + nums[w.charAt(i)-'a'];
		return ans;
	}
	
	public static int getIndex(ArrayList<tnine> dictionary, String textmap) {
		
		for (int i=0; i<dictionary.size(); i++)
			if (dictionary.get(i).digits.equals(textmap))
				return i;
		return -1;
	}
}