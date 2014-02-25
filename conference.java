import java.io.*;
import java.util.*;

public class conference {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();		
		for(int z = 0; z < numCases; z++){
			
			int numOffers = in.nextInt();
			int[] offers = new int[30]; 
			boolean[] booked = new boolean[30];
			long income = 0;
			
			for(int i = 0; i < numOffers; i++){
				int startDay = in.nextInt();
				int length = in.nextInt();
				//offer stores day by start day and corresponding length
				offers[startDay] = length;
			}
		
			for(int i = 0; i < 30; i++){
				if(!booked[i]){
					//it is always more profitable to book a shorter conference that starts
					//at an earlier date than a longer one at a later date
					for(int j = i; j < i + offers[i]; j++){
						booked[j] = true;
					}
				}
			}
	
			for(int i = 0; i < 30; i++){
				if(booked[i]){
					income += Math.pow(2, 29-i);
				}
			}
			
			System.out.println(income);
		}
	}
}