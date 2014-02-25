import java.io.*;
import java.util.*;

public class eligibility {
	public static class Data
	{
		String name;
		int numYears;
		ArrayList<Integer> yearsComp = new ArrayList();;
		
		public Data(String n, int curYear)
		{
			name = n;
			numYears = 1;
			yearsComp.add(curYear);
		}
		
		public void addYear(int curYear)
		{
			yearsComp.add(curYear);
			numYears++;
		}
		
		public boolean containsYear(int curYear, int index)
		{
			for(int i = 0; i < yearsComp.size(); i++)
			{
				if(yearsComp.get(i) == curYear) return true;
			}
			
			return false;
		}
	}
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 1; i <= numCases; i++)
		{
			System.out.println("Case #" + i + ":");
			int numNames = in.nextInt();
			
			ArrayList<Data> contestants = new ArrayList();
			String blank = in.nextLine();
			
			for(int j = 0; j < numNames; j++)
			{
				String line = in.nextLine();
				String curName = line.substring(0, line.length()-4);
				int curYear = Integer.parseInt(line.replaceAll("\\D", ""));
				int index = getIndex(contestants, curName);
				
				if(index == -1)
				{
					contestants.add(new Data(curName, curYear));
				}
				else
				{
					if(contestants.get(index).containsYear(curYear, index)){}
					else contestants.get(index).addYear(curYear);
				}
			}
			
			ArrayList<String> finNames = new ArrayList();
			for(int j = 0; j < contestants.size(); j++)
			{
				if(contestants.get(j).numYears < 5) finNames.add(contestants.get(j).name);
			}
			
			Collections.sort(finNames);
			for(int j = 0; j < finNames.size(); j++)
			{
				System.out.println(finNames.get(j));
			}
			
		}
	}
	
	public static int getIndex(ArrayList<Data> cont, String curName)
	{
		for(int i = 0; i < cont.size(); i++)
		{
			if(cont.get(i).name.equals(curName)) return i;
		}
		
		return -1;
	}
}

/*

1
6
ahmed 2010
ahmed 2011
ahmed 2009
ahmed 2008
ahmed 2005
mohamed 2001

*/
