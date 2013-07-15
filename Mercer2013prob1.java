import java.util.*;
import java.io.*;

public class Mercer2013prob1 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for(int i = 0; i < cases; i++)
		{
			
			int goal = sc.nextInt();
			if(prime(goal)== true)
			{
				System.out.println(goal + ": " + "impossible");
				
			}
			
			//ArrayList<Integer> used = new ArrayList();
			
			int sum = 1;
			int start = 1;
			int add = 3;
			
			while(start < (goal/2)+1)
			{
				//System.out.println("start: " + start);
					sum += add;
					//System.out.println("here 2\t sum: "+sum+" goal: "+goal);
					//System.out.println("We are adding " + add);
					//System.out.println("the current sum is " + sum);
					if(sum == goal)
					{
						System.out.println(goal + ": " + "[" + start + ", " + add + "]");
						sum -= start;
						start += 2;
						add = start+2;
						sum = start;
						//System.out.println("our new start is " +  start);
						//System.out.println("our new add is   " +  add);
						//System.out.println("our new sum is   " +  sum);
						//break;
					}
					else if(sum > goal)
					{
						//System.out.println("too big");
						sum = 0;
						start += 2;
						add = start+2;
						//System.out.println("our new start is " +  start);
						
					}
					else if(sum < goal) add +=2; 
					
			}

		}
			
		}
	
	public static boolean prime(int goal)
	{
		for(int j = 2; j*j <= goal; j++)
		{
			if(goal%j == 0 && goal!= j)
			{
				return false;
			}
		}
		return true;
		
	}
}


/*

3
7
35
400

*/



