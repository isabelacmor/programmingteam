import java.io.*;
import java.util.*;

class Statement{
	public int author, subject;
	public char type;
	
	public Statement(int a, int s, char t){
		author = a;
		subject = s;
		type = t;
	}
	
	public String toString(){
		return author + " " + subject + " " + type;
	}
}

public class logotron {
	public static Statement[] statements;
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int nC = 1; nC <= numCases; nC++){
			int numBots = in.nextInt();
			int numState = in.nextInt();
			
			statements = new Statement[numState];
			for(int i = 0; i < numState; i++)
				statements[i] = new Statement(in.nextInt(), in.nextInt(), in.next().charAt(0));
			
			System.out.print("Case #" + nC + ": ");
			combinations(numBots);
		}
	}
	
	public static void combinations(int n){
		int ctr = 0;
		char[] combo = new char[n];
		
		for (int i=0; i < (1 << n); i++) {
			combo = new char[n];
			Arrays.fill(combo, 'C');
			
	        for (int j=0; j < n; j++){	        	
	            if( (i & (1 << j)) != 0 )	//in set
	                combo[j] = 'T';
	        }
	        
	       if(isValid(combo)) ctr++;
	    }
		
		System.out.println(ctr);
	}
	
	public static boolean isValid(char[] combo){
		for(int i = 0; i < statements.length; i++){
			if((combo[statements[i].author-1] == 'T') && (combo[statements[i].subject-1] != statements[i].type)) return false;
			else if((combo[statements[i].author-1] == 'C') && (combo[statements[i].subject-1] == statements[i].type)) return false;
		}
		
		return true;
	}

}

/*

3
3 2
1 2 T
2 3 C
4 2
1 2 T
2 3 C
2 0


*/