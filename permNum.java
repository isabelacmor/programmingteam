import java.io.*;
import java.util.*;

public class permNum {
	public static void main(String [] args)
	{
		int [] values = {1, 2, 3, 4};
		int N = values.length;
		boolean [] used = new boolean[N];
		int [] perm = new int[N];
		
		permute(0, perm, values, used, N);
	}
	
	public static void permute(int ind, int [] perm, int [] values, boolean [] used, int N)
	{
		if(ind == N)
		{
			for(int k = 0; k < N; k++)
			{
				System.out.println(perm[k]);
			}
			return;
		}
		
		for(int i = 0; i < N; i++)
		{
			if(!used[i])
			{
				perm[ind] = values[i];
				used[i] = true;
				permute(ind+1, perm, values, used, N);
				used[i] = false;
			}
		}
	}
}