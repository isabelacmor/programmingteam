import java.io.*;
import java.util.*;
public class e {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		String cmd;
		int cowID, revertIndex;
		ArrayList <ArrayList<Integer>> time = new ArrayList();
		ArrayList <Integer> timeIndex = new ArrayList();
		ArrayList <Integer> cows = new ArrayList();
		
		for(int i = 0; i < numCases; i++)
		{
			//System.out.println("INDEX: " + (i));
						
			//String blank = in.next();
			cmd = in.next();
			
			//System.out.println(cmd);
			
			if(cmd.equals("a"))
			{
				//System.out.println("adding");
				cowID = in.nextInt();
				cows.add(cowID);
			}
			else if(cmd.equals("s"))
			{
				//System.out.println("removing");
				if(cows.size() > 0) cows.remove(cows.size()-1);
				else
				{
					//System.out.println("-1");
					//break;
				}
			}
			
			else if(cmd.equals("t"))
			{
				revertIndex = in.nextInt();
				cows = new ArrayList<Integer>();
				revert(cows, time, revertIndex);
			}
			else{} //should never go here
			
			
			//System.out.println(cmd + " " + cowID);
			
			//System.out.println("COWS: " + cows);
			//System.out.println("COW SIZE: " + cows.size());
			
			ArrayList<Integer> newTime = new ArrayList(cows);			
			time.add(newTime);
			//System.out.println("timeAL" + time);
			
			if(cows.size() == 0) System.out.println("-1");
			if(cows.size() > 0) System.out.println(cows.get(cows.size()-1));
			//else System.out.println("-1");
		}
	}

	public static void revert(ArrayList <Integer> cows, ArrayList <ArrayList<Integer>> time, int revertIndex)
	{
		//System.out.println(" time:    " + ((time.get(revertIndex-2)).toString()));
		ArrayList<Integer> newTime = new ArrayList(time.get(revertIndex-2));
		for(int i = 0; i < newTime.size(); i++)
		{
			cows.add(newTime.get(i));
		}
		
		
		
	}
}