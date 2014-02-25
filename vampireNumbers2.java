import java.io.*;
import java.util.*;

public class vampireNumbers2 {
	public static void main(String [] args) throws IOException
	{		
		//find the factors, then order them (string -> array -> string)
		//and see if it's >= to the sorted number to check / original number
		//if true, it's a vamp.
		
		//generate first all vampire numbers under 1,000,000
		//store in ArrayList
		
		Scanner in = new Scanner(System.in);
		
		int compare = in.nextInt();		
		
		ArrayList<Integer> vamps = new ArrayList();
		int count = 0;
		while(count < 1000000)
		{
			//System.out.println(count);
			if(isVamp(count)) { vamps.add(count); }
			
			count++;
		}
		
		System.out.println(vamps);
		
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
		for(int i = 2; i < number/2; i++)
		{
			String combo = signature("" + i + "" + (number/i));
			if((number%i) == 0 && (i+(number/i))%9 == 0 && combo.length() == numS.length() && combo.equals(numS))
			{
				return true;
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
	
	public static boolean equalTwo(String combo, String original)
	{
		String [] comboAR = new String [combo.length()];
		String [] originalAR = new String [original.length()];
		
		String newCombo = "";
		String newOriginal = "";
		
		for(int i = 0; i < combo.length(); i++)
		{
			comboAR[i] = combo.substring(i, i+1);
		}
		
		for(int i = 0; i < original.length(); i++)
		{
			originalAR[i] = original.substring(i, i+1);
		}
		
		Arrays.sort(comboAR);
		Arrays.sort(originalAR);
		
		for(int i = 0; i < comboAR.length; i++)
		{
			newCombo+=comboAR[i];
		}
		
		for(int i = 0; i < originalAR.length; i++)
		{
			newOriginal+=originalAR[i];
		}
		
		if(newOriginal.equals(newCombo)) return true;
		else return false;
	}
}