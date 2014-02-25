package mercer2010;
import java.io.*;
import java.util.*;

public class grocery {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 1; i <= numCases; i++){
			int numItems = in.nextInt();
			
			int total = 0;
			for(int j = 0; j < numItems; j++){
				int id = in.nextInt();
				if(id == 1) total += in.nextInt() * in.nextInt();
				else if(id == 2 || id == 3) total += in.nextInt();
			}
			
			System.out.println("Day " + i + ": $" + total + ".");
		}
	}
}

/*

3 
2 
1 4 5 
2 6 
1 
3 -7 
0 


*/