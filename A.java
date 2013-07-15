import java.util.Arrays;
import java.util.Scanner;


public class A 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int [] data = new int[10];
		int cases = sc.nextInt();
		int num = sc.nextInt();
		for(int i = 0; i<cases; i++)
		{
			for (int c = 0; c < 10; c++)
			{
				data[c] = sc.nextInt();
			}
			Arrays.sort(data);
			System.out.print(num + " ");
			System.out.print(data[7]);
			num = sc.nextInt();
			System.out.println();
			
		}
	}
}
