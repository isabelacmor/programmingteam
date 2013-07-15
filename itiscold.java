import java.io.*;
import java.util.*;

public class itiscold {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++)
		{
			int numFans = in.nextInt();
			ArrayList<Integer> speed = new ArrayList();
			ArrayList<String> dir = new ArrayList();

			for(int j = 0; j < numFans; j++)
			{
				int curS = in.nextInt();
				speed.add(curS);
			}
			
			String blank = in.nextLine();
			for(int j = 0; j < numFans; j++)
			{
				String curD = in.next();
				dir.add(curD);
			}
			
			int totalSpeed = 0;
			for(int j = 0; j < numFans; j++)
			{
				if(dir.get(j).equals("T"))
				{
					totalSpeed += speed.get(j);
				}
			}
			
			int runningA = 0;
			for(int j = 0; j < numFans-2; j++)
			{
				if(dir.get(j).equals("A") && dir.get(j+1).equals("A"))
				{
					runningA += speed.get(j);
				}
				else if(dir.get(j).equals("A") && dir.get(j+1).equals("T"))
				{
					if(runningA <= totalSpeed) totalSpeed -= runningA;
					runningA = 0;
				}
			}
			
			System.out.println(totalSpeed);
		}
	}
}

/*


3
2
1 2
T T
2
3 5
A T
2
3 5
T A


*/