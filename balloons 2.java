import java.io.*;
import java.util.*;

public class balloons {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++){
			int N = in.nextInt();
			int X = in.nextInt();
			int Y = in.nextInt();
			
			boolean first = false;
			boolean last = false;
			
			int[] arr = new int[N];
			for(int j = 0; j < N; j++)
				arr[j] = in.nextInt();
			
			if(arr[0] == X) first = true;
			if(arr[N-1] == Y) last = true;
			
			if(!first && !last) System.out.println("OKAY");
			else if(!first) System.out.println("HARD");
			else if(!last) System.out.println("EASY");
			else System.out.println("BOTH");
		}
	}
}

/*
4
3 1 2
1 3 2
5 3 4
3 1 2 4 5
6 1 6
2 1 3 4 5 6
7 7 7
1 7 2 3 4 5 6
*/
