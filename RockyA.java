import java.io.*;
import java.util.*;

public class RockyA {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numPages = in.nextInt();
		
		while(numPages != 0)
		{
			ArrayList<Integer> indv = new ArrayList();
			
			String line = in.next();
			line = line.replaceAll(",", " ");
			String [] lineA = line.split(" ");
			
			for(int i = 0; i < lineA.length; i++)
			{
				//range
				if(lineA[i].contains("-"))
				{
					String [] newSplit = lineA[i].split("-");
					if(Integer.parseInt(newSplit[0]) > Integer.parseInt(newSplit[1])){}
					else
					{
						for(int j = Integer.parseInt(newSplit[0]); j <= Integer.parseInt(newSplit[1]); j++)
						{
							if(!indv.contains(j) && j <= numPages) indv.add(j);
						}
					}
				}
				//single number
				else
				{
					if(indv.contains(lineA[i])){}
					else if(Integer.parseInt(lineA[i]) <= numPages) indv.add(Integer.parseInt(lineA[i]));
				}
			}
			
			Set setPages = new LinkedHashSet(indv);
			indv.clear();
			indv.addAll(setPages);
			
			System.out.println(indv.size());
			
			numPages = in.nextInt();
		}
	}
}
