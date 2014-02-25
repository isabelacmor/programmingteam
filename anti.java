import java.io.*;
import java.util.*;

public class anti {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("/Users/isabella/Documents/ProgrammingTeam/workspace/Feb2Mercer4/src/test.in"));
		
		int numGames = in.nextInt();
		for(int i = 1; i <= numGames; i++)
		{
			System.out.print("Game #" + i + ": ");
			
			int numWords = in.nextInt();
			int numAllowed = in.nextInt();
			
			String blank = in.nextLine();
			String phrase = in.nextLine();
			phrase = phrase.replaceAll(" ", "");
			phrase = phrase.toUpperCase();
			
			int numUnique = findU(phrase);
			int notInAns = 26 - numUnique;
			
			if(notInAns < numAllowed) System.out.print("Impossible to lose\n\n");
			else System.out.print("Trolling succeeded\n\n");
		}
	}
	
	public static int findU(String phrase)
	{
		int [] freq = new int[26];
		for(int i = 0; i < 26; i++)
		{
			freq[i] = 0;
		}
		
		for(int i = 0; i < phrase.length(); i++)
		{
			freq[letterVal(phrase.substring(i, i+1))]++;
		}
		
		int count = 0;
		for(int i = 0; i < 26; i++)
		{
			if(freq[i] > 0) count++;
		}
		
		return count;
	}
	
	public static int letterVal(String letter)
	{
		return letter.charAt(0) - 1 - 64;
	}
}
