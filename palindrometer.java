import java.io.*;
import java.util.*;

public class palindrometer {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(new File("palindrometer.in"));
		
		int count = 0;
		String curLine = in.next();
		String whileLine = curLine;
		String finalLine = "";
		int lenLine = curLine.length();
		
		//while it's not the end of input
		while(!whileLine.equals("0"))
		{
			count = 0;
			curLine = whileLine;
			lenLine = curLine.length();
			boolean tf = isPal(curLine);
			//while it's still not a palindrome
			while(!tf)
			{
				int curNum = Integer.parseInt(curLine);
				curNum++;
				for(int i = 0; i < lenLine-String.valueOf(curNum).length(); i++)
				{
					finalLine += "0";
				}
				
				finalLine += curNum;
				count++;
				tf = isPal(finalLine);
				curLine = String.valueOf(curNum);
				finalLine = "";
			}
		
			System.out.println(count);
			whileLine = in.next();
		}
		
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