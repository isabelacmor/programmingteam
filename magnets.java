import java.io.*;
import java.util.*;

public class magnets {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		String line = in.nextLine();
		
		while(!line.equals("END")){
			if(noDup(line)) System.out.println(line);
			
			line = in.nextLine();
		}
	}
	
	public static boolean noDup(String line){
		int [] freq = new int[26];
		
		for(int i = 0; i < line.length(); i++){
			//System.out.println((int)line.charAt(i) - 65);
			
			if(line.charAt(i) != ' ') freq[(int)line.charAt(i) - 65]++;
			
			if(line.charAt(i) != ' ' && freq[(int)line.charAt(i) - 65] > 1) return false;
		}
		
		return true;
	}
}

/*

I LOVE YOU
I LOVE MUSTARD
HAPPY BIRTHDAY
GLAD U BORN
SMILE
IMAGINE
WHATS UP DOC
HAVE A NICE DAY
END

*/