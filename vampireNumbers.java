import java.io.*;
import java.util.*;

public class vampireNumbers {
	public static void main(String [] args) throws IOException
	{		
		//find the factors, then order them (string -> array -> string)
		//and see if it's >= to the sorted number to check / original number
		//if true, it's a vamp.
		
		//generate first all vampire numbers under 1,000,000
		//store in ArrayList
		
		Scanner in = new Scanner(System.in);
		
		int compare = in.nextInt();		
		
		//METHOD ONE
		//precompute all vamp numbers >= 1,000,000
		
		ArrayList<Integer> vamps = new ArrayList();
		int count = 0;
		while(count < 1000256)
		{
			//System.out.println(count);
			if(isVamp(count)) { vamps.add(count); }
			
			count++;
		}
		
		//System.out.println(vamps);
		
		
		while(compare != 0)
		{
			/* METHOD TWO 
			while(!isVamp(compare))
			{
				compare++;
				//System.out.println(compare);
			}
			
			System.out.println(compare);
			*/
			
			//METHOD ONE - CONT
			
			for(int i = 0; i < vamps.size(); i++)
			{
				if(vamps.get(i) < compare){}
				else
				{
					System.out.println(vamps.get(i));
					break;
				}
			}
			
			
			compare = in.nextInt();
		}
	}

	public static boolean isVamp(int number)
	{
		String numS = signature("" + number);
		for(int i = 2; i < Math.sqrt(number); i++)
		{
			if((number%i) == 0)
			{
				String combo = signature("" + i + "" + (number/i));
				if(combo.length() == numS.length() && combo.equals(numS))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static String signature(String s)
	{
		char [] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}
}