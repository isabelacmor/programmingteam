import java.io.*;
import java.util.*;

public class username {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numNames = in.nextInt();
		int maxLen = in.nextInt();
		int ctr = 0;
		
		while(numNames!=0 && maxLen!=0)
		{
			ctr++;
			//read and process each name
			//store for each reference
			String blank = in.nextLine();
			ArrayList<String> usernameDB = new ArrayList();
			for(int i = 0; i < numNames; i++)
			{
				String fullName = in.nextLine();
				String [] nameA = fullName.split(" ");
				
				String first = nameA[0];
				String last = nameA[nameA.length-1];
				
				first = first.toLowerCase();
				first = first.replaceAll("'", "");
				first = first.replaceAll("-", "");
				
				last = last.toLowerCase();
				last = last.replaceAll("'", "");
				last = last.replaceAll("-", "");
				
				usernameDB.add(createName(first, last, usernameDB, maxLen));
			}
			
			System.out.println("Case " + ctr);
			for(int i = 0; i < usernameDB.size(); i++)
			{
				System.out.println(usernameDB.get(i));
			}
			
			numNames = in.nextInt();
			maxLen = in.nextInt();
		}
	}
	
	public static String createName(String first, String last, ArrayList<String> db, int max)
	{
		String temp = first.charAt(0) + "" + last;
		if(max >= temp.length());
		else temp = temp.substring(0, max);
		
		if(!db.contains(temp)) return temp;
		else
		{
			//check if we have temp.substring(0, temp.length()-1) plus numbers 1-9
			int largest = 1;
			for(int i = 1; i < 10; i++)
			{
				String newTemp;
				int lenTemp = temp.length();
				if(max >= temp.length()+1)
				{
					newTemp = temp.substring(0, temp.length()) + "" + i;
				}
				else
				{
					newTemp = temp.substring(0, (temp.length()-(1-(max-temp.length())))) + "" + i;
				}
				if(db.contains(newTemp)) continue;
				else return newTemp;
			}
			//if we get here, we need to check the same for 10-99
			for(int i = 10; i < 100; i++)
			{
				String newTemp;
				if(max >= temp.length()+2)
				{
					newTemp = temp.substring(0, temp.length()) + "" + i;
				}
				else
				{
					newTemp = temp.substring(0, (temp.length()-(2-(max-temp.length())))) + "" + i;
				}
				if(db.contains(newTemp)) continue;
				else return newTemp;
			}
		}
		
		return "";
	}
}
