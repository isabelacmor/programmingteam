import java.io.*;
import java.util.*;

public class robin {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++){
			int numTerms = in.nextInt();
			
			int [] x = new int[numTerms];
			int [] y = new int[numTerms];
			
			for(int j = 0; j < numTerms; j++){
				x[j] = in.nextInt();
				y[j] = in.nextInt();
			}
			
			//sort
			Arrays.sort(x);
			Arrays.sort(y);
			
			//find median
			int medX = x[x.length / 2];
			int medY = y[y.length / 2];
			
			//add distance
			int distance = 0;
			
			//x distances
			for(int j = 0; j < numTerms; j++){
				distance += Math.abs(medX - x[j]);
				distance += Math.abs(medY - y[j]);
			}
			
			System.out.println(distance);
			
		}
	}
}


/*

3
5
0 0
2 0
0 2
2 2
1 1
2
0 1000000
1000000 0
4
0 2
1 5
1 1
3 2


*/