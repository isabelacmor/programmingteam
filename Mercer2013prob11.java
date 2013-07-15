import java.io.File;
import java.util.*;
import java.io.*;


public class Mercer2013prob11 
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner (new File("/Users/isabella/Documents/ProgrammingTeam/workspace/Feb2Mercer4/bin/tester.in"));
		String check;
		if(sc.hasNext())
			check = sc.nextLine();
		else
			check = "stupid";
		int lineNum = 1;
		while(sc.hasNext())
		{
			String printed = " ";
			if(check.length() > 40)
			{
				printed = check.substring(0, 40);
			}
			else
				printed = check; 
			
			
			int count = 0;
			if(check.contains("SPS"))
					count++;
			if (check.contains("GAD"))
				count++;
			if (check.contains("GABA"))
					count++;
			if (check.contains("GLRA1"))
				count++;
			
			if(count >=2)
				System.out.println(lineNum + ": " + printed);
			
			String checka = check.toLowerCase(); 
			
			
			if(checka.contains("stiff person syndrome") || (checka.contains("moersch-woltman condition")))
			{
				System.out.println(lineNum + ": " + printed);
				
			}			
			
			check = sc.nextLine();
			lineNum++;
		}
	}

}

/* 
Sadly, Dr. Plaut, the Maryville coach will not be at the contest.
She is suffering from Stiff Person Syndrome (SPS).
Perhaps it should be known as Stiff Woman's Syndrom since 2/3 of the people
with SPS are female.  But SPS affecting just 1 in 1,000,000, it's hard to know.
GAD antibodies have been linked to SPS.
But gad antibodies only appear in 60% of SPS cases.
*/