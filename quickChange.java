import java.io.*;
import java.util.*;

public class quickChange {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 1; i <= numCases; i++)
		{
			System.out.print(i + " ");
			
			int [] change = {0, 0, 0, 0}; //Q, D, N, P
			int toMake = in.nextInt();
			
			change = makeChange(change, toMake);
			printChange(change);
		}
	}
	
	public static int[] makeChange(int [] change, int toMake){
		if(toMake >= 25){
			change[0]++;
			return makeChange(change, toMake-25);
		}
		else if(toMake >= 10){
			change[1]++;
			return makeChange(change, toMake-10);
		}
		else if(toMake >= 5){
			change[2]++;
			return makeChange(change, toMake-5);
		}
		else if(toMake > 0){
			change[3]++;
			return makeChange(change, toMake-1);
		}
		else return change;
	}
	
	public static void printChange(int [] change){
		System.out.println(change[0] + " QUARTER(S), " + change[1] + " DIME(S), " + change[2] + " NICKEL(S), " + change[3] + " PENNY(S)");
	}
}
