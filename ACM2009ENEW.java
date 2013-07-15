import java.io.*;
import java.util.*;

public class ACM2009ENEW {
	
	public static ArrayList<String> numAL;
	
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++)
		{
			int curCase = in.nextInt();
			//String blank = in.next();
			
			String num = in.next();
			String [] numA = num.split("");
			String [] numAns = num.split("");
			Arrays.sort(numA);
			
			numA = reverse(numA);
			
			numAL = new ArrayList(Arrays.asList(numAns));
			
			//already the largest permutation therefore, biggest next permutation
			if(strEq(numA, num)) System.out.println(curCase + " BIGGEST");
			else
			{
				System.out.print(curCase + " ");
				
				nextP(numAns);
				
				/*
				int indexSm = findSmallest(numAns);
				String valSwap = numAL.get(indexSm);
				
				//find where this should be placed
				int lastIndex = swap(indexSm, valSwap, numAL);
				
				//sort numAL from lastIndex to numAL.size()
				ArrayList<Integer> ending = extract(numAL, lastIndex);
				
				printAns(numAL, lastIndex, ending);
				*/
				System.out.println();
			}
		}
	}

	public static void nextP(String [] numAns)
	{
		int index = 0;
		for(int i = 1; i < numAns.length-1; i++)
		{
			if(Integer.parseInt(numAns[i]) < Integer.parseInt(numAns[i+1]))
			{
				index = i;
			}
		}
		
		int indexSwap = 0;
		for(int j = 1; j < numAns.length; j++)
		{
			if(Integer.parseInt(numAns[j]) > Integer.parseInt(numAns[index])) indexSwap = j;
		}
		
		String temp = numAns[index];
		numAns[index] = numAns[indexSwap];
		numAns[indexSwap] = temp;
		
		int [] numNew = new int[numAns.length-index-1];
		int addI = 0;
		
		for(int i = 0; i < numAns.length; i++)
		{
			if(i <= index) System.out.print(numAns[i] + "");
			else
			{
				numNew[addI] = Integer.parseInt(numAns[i]);
				addI++;
			}
		}
		
		Arrays.sort(numNew);
		//numNew = reverseInt(numNew);
		
		for(int i = 0; i < numNew.length; i++)
		{
			System.out.print(numNew[i] + "");
		}
		
	}
	
	public static boolean strEq(String [] one, String two)
	{
		for(int i = 0; i < one.length-1; i++)
		{
			if(one[i].equals(two.substring(i, i+1))){}
			else
			{
				return false;
			}
		}
			
		return true;
	}
	
	public static int[] reverseInt(int[] numNew) {
		for(int i = 0; i < numNew.length/2; i++)
		{
		    int temp = numNew[i];
		    numNew[i] = numNew[numNew.length - i - 1];
		    numNew[numNew.length - i - 1] = temp;
		}
		System.out.println("final reversed");
		
		return numNew;
    }
	
	public static String[] reverse(String[] numNew) {
		for(int i = 0; i < numNew.length/2; i++)
		{
		    String temp = numNew[i];
		    numNew[i] = numNew[numNew.length - i - 1];
		    numNew[numNew.length - i - 1] = temp;
		}
		
		return numNew;
    }
}
