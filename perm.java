import java.io.*;
import java.util.*;

public class perm {
	
	static int count;
	static ArrayList<Integer> countAL;
	
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		String [] options;
		
		for(int i = 0; i < numCases; i++)
		{
			countAL = new ArrayList();
			count = 0;
			int numOptions = in.nextInt();
			options = new String[numOptions];
			
			//read in the options for permutations
			for(int j = 0; j < numOptions; j++)
			{
				options[j] = in.next();
			}
			
			//permute
			String [] perms = new String[numOptions * (numOptions-1)];
			boolean [] used = new boolean[numOptions];
			permute(0, used, perms, options, numOptions);
			System.out.println("Case #" + (i+1) + ": " + countAL.get(countAL.size()-1));
		}
	}
	
	public static ArrayList permute(int index, boolean [] used, String [] perms, String [] options, int numOptions)
	{
		String word = "";
		if(index == 2) //where 2 is the length of combinations you can take (eg: for x, y, z; only permuations combining 2 options will count - xy, yz, xz - NOT xyz, yzx, etc)
		{
			for(int i = 0; i < 2; i++) //print to the same length
			{
				word+=perms[i];
			}
			if(isPal(word)) count++;
			countAL.add(count);
			//System.out.println("Count: " + count);
		}
		
		for(int k = 0; k < numOptions; k++)
		{
			if(!used[k])
			{
				perms[index] = options[k];
				used[k] = true;
				permute(index+1, used, perms, options, numOptions);
				used[k] = false;
			}
		}
		return countAL;
	}
	
	//checks if String is a palindrome
	public static boolean isPal(String input)
	{
		boolean isPalindrome = false;
		int left = 0;
		int right = input.length()-1;

		while(left<right&&left!=right)
		{
			if(input.charAt(left) != input.charAt(right))
			{
				isPalindrome = false;
				break;
			}
			else
			{
				isPalindrome = true;
			}
			left++;
			right--;
		}
		return isPalindrome;
	}
}