import java.io.*;
import java.util.*;

public class aDIV2 {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numRounds = in.nextInt();
		
		for(int i = 0; i < numRounds; i++)
		{
			int p1Wins = 0;
			int p2Wins = 0;
			
			String p1Play, p2Play;
			
			int numPlays = in.nextInt();
			for(int j = 0; j < numPlays; j++)
			{
				p1Play = in.next();
				p2Play = in.next();
				
				if(p1Play.equals(p2Play)){} //no change in score
				else if(p1Play.equals("R") && p2Play.equals("S")) p1Wins++;
				else if(p1Play.equals("S") && p2Play.equals("P")) p1Wins++;
				else if(p1Play.equals("P") && p2Play.equals("R")) p1Wins++;
				else p2Wins++;
			}
			
			if(p1Wins > p2Wins) System.out.println("Player 1");
			else if(p2Wins > p1Wins) System.out.println("Player 2");
			else System.out.println("TIE");
		}
	}
}