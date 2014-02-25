import java.util.Arrays;
import java.util.Scanner;


public class party 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int names = sc.nextInt();
		while (names!= 0)
		{
			//read in array of names
			String[] list = new String[names];
			for (int i = -0; i<names; i++)
			{
				list[i] = sc.next();
			}
			
			//sort names 
			Arrays.sort(list);
		
			//Isolate two middle elements of sorted array
			String first = list[names/2 - 1];
			String second = list[names/2];
			
			
			for(int a = 0; a < first.length() && a < second.length(); a++)
			{
				//FRED and FREDDIE Case
				if (a == first.length()-1)
				{
					System.out.println(first);
					break;
				}
				
				if(first.charAt(a)!=second.charAt(a))
				{
					String half = first.substring(0,a) + (char)(first.charAt(a) + 1); 
					
					//special case
					if(half.equals(second))
					{
						//start at half.length-1 OR second.length-1
						int x = a+1;
						while(x < first.length()-1 && first.charAt(x) == 'Z')
						{
							x++;
						}
						if (x == first.length()-1)
						{
							System.out.println(first);
							break;
						}
						half = first.substring(0,x) + (char)(first.charAt(x) + 1); 
						System.out.println(half);
						break;
					}
					//normal case
					else
					{
					System.out.println(half);
					break;
					}
					
				}
				
				
			}
			
			
			names = sc.nextInt();
		}
	}

}
