import java.io.*;
import java.util.*;

public class pizza {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		int ctr = 1;
		
		while(numCases != 0){
			double costPerSqIn = -1;
			int diaMax = -1;
			double priMax = Double.MAX_VALUE;
			
			for(int i = 0; i < numCases; i++){
				int dia = in.nextInt();
				int pri = in.nextInt();
				
				costPerSqIn = (pri*100.0) / Math.pow((dia/2), 2)*Math.PI;
				
				if(costPerSqIn < priMax){
					priMax = costPerSqIn;
					diaMax = dia;
				}
			}
			
			System.out.println("Menu " + ctr + ": " + diaMax);
			
			ctr++;
			numCases = in.nextInt();
		}
	}
}


/*

3
5 2
10 6
12 8
3
5 2
10 5
12 8
4
1 1
24 33
13 11
6 11
0


*/
