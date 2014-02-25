import java.io.*;
import java.util.*;

public class robo {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		String line = in.nextLine();
		
		for(int i = 0; i < N; i++){
			line = in.nextLine();
		
			solve(line);
		}
	}
	
	public static void solve(String line){		
		int x = 0, y = 0, q = 0;
		
		for(int i = 0; i < line.length(); i++){
			if(line.charAt(i) == '?') q++;
			else if(line.charAt(i) == 'L') x--;
			else if(line.charAt(i) == 'R') x++;
			else if(line.charAt(i) == 'U') y++;
			else y--;
		}
		
		System.out.println((x-q) + " " + (y-q) + " " + (x+q) + " " + (y+q));
	}
}

/*

3
RUL?R?D
????????
RRRUU

*/