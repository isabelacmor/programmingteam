import java.io.*;
import java.util.*;

public class e
{
	public static PrintStream out = new PrintStream(System.out);
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args)
	{
		int sets = in.nextInt();
		for(int set = 1; set <= sets; set++)
		{
			out.print(in.nextInt() + " ");
			String num = in.next();
			
			int len = num.length();
			int[] input = new int[len];
			int index = -1;
			for(int i = 0; i < len; i++)
			{
				input[i] = num.charAt(i) - '0';
			}
			for(int i = len - 2; i >= 0; i--)
			{
				if(input[i] < input[i+1])
				{
					index = i;
					break;
				}
			}
			
			if(index == -1)
			{
				out.println("BIGGEST");
			}
			else
			{
				int mindex = -1;
				int min = 10;
				for(int i = index + 1; i < len; i++)
				{
					if(input[i] > input[index])
					{
						if(input[i] < min)
						{
							mindex = i;
							min = input[i];
						}
					}
				}
				
				int[] output = new int[len];
				for(int i = 0; i < index; i++)
				{
					output[i] = input[i];
				}
				output[index] = min;
				
				//int[] temp = new int[len - (index + 1)];
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for(int i = index; i < len; i++)
				{
					if(i == mindex)
					{
						continue;
					}
					temp.add(input[i]);
				}
				Collections.sort(temp);
				for(int i = 0; i < len - (index + 1); i++)
				{
					output[i + (index + 1)] = temp.get(i);
				}
				for(int i = 0; i < len; i++)
				{
					out.print(output[i]);
				}
				out.println();
			}
		}
	}
}











