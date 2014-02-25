import java.io.*;
import java.util.*;

public class sticker {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		String line = in.nextLine();
		for(int i = 0; i < numCases; i++){
			line = in.nextLine();
			
			System.out.println(solve(line));
		}
	}
	
	public static long solve(String line){
		int start = -1, next = -1;
		long total = 1;
		
		for(int i = 0; i < line.length(); i++){
			if(line.charAt(i) != '?'){
				next = findNext(line, i+1);
				if(next != -1){
					if(line.charAt(i) != line.charAt(next)){
						total = (total * (next-i)) % 1000000007;
					}
				}
			}
		}
		
		return total;
	}
	
	public static int findNext(String line, int start){
		for(int i = start; i < line.length(); i++){
			if(line.charAt(i) != '?'){
				return i;
			}
		}
		
		return -1;
	}
}
