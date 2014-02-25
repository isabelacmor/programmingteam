import java.io.*;
import java.util.*;
import java.lang.*;

public class RockyParenthesis {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine())
		{
			String line = in.nextLine();
			String [] lineA = line.split("");
			
			//can only remove () IF:
			//( --- next to a letter with a + to the right
			//) --- next to a letter with a + to the left
			
			int numRemoved = 0;
			
			for(int i = 0; i < lineA.length; i++)
			{
				if(i > 0 && lineA[i].equals("(") && lineA[i-1].equals("+")) 
				{
					lineA[i] = "";
					numRemoved++;
				}
				
				else if(i > 0 && lineA[i].equals("(") && isAlpha(lineA, i-1) && isAlpha(lineA, i+1)) 
						//&& isAlpha(lineA, i-1) && isAlpha(lineA, i+1))
				{
					
				}
				
				else if(lineA[i].equals("(") && isAlpha(lineA, i+2))
				{}
				else if(lineA[i].equals("(") && !isAlpha(lineA, i+2))
				{
					lineA[i] = "";
					numRemoved++;
				}
				else{}
			}
			
			for(int i = lineA.length-1; i >= 0; i--)
			{
				if(numRemoved > 0 && lineA[i].equals(")"))
				{
					lineA[i] = "";
					numRemoved--;
				}
				else {}
			}
			
			for(int i = 0; i < lineA.length; i++)
			{
				System.out.print(lineA[i]);
			}
			System.out.println();
		}
	}
	
	public static boolean isAlpha(String [] word, int index)
	{		
		ArrayList<String> alpha = new ArrayList();
		alpha.add("a");
		alpha.add("b");
		alpha.add("c");
		alpha.add("d");
		alpha.add("e");
		alpha.add("f");
		alpha.add("g");
		alpha.add("h");
		alpha.add("i");
		alpha.add("j");
		alpha.add("k");
		alpha.add("l");
		alpha.add("m");
		alpha.add("n");
		alpha.add("o");
		alpha.add("p");
		alpha.add("q");
		alpha.add("r");
		alpha.add("s");
		alpha.add("t");
		alpha.add("u");
		alpha.add("v");
		alpha.add("w");
		alpha.add("x");
		alpha.add("y");
		alpha.add("z");
		
		String letter = word[index];
		letter = letter.toLowerCase();

		if(alpha.contains(letter)) return true;
		return false;
	}
}