package mercer2010;
import java.io.*;
import java.util.*;

public class beadsEasy {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		String blank = in.nextLine();
		for(int i = 1; i <= numCases; i++){			
			StringBuilder sb1 = new StringBuilder(in.nextLine().trim());
			StringBuilder sb2 = new StringBuilder(in.nextLine().trim());
			sb1.append(sb1);
		
			//System.out.println(sb1.toString() + " -- " + sb2.toString());
			System.out.println("Case #" + i + ": " + (((sb1.toString().contains(sb2) || sb1.toString().contains(sb2.reverse())) && sb1.toString().length() == 2*sb2.toString().length()) ? "YES" : "NO"));
		}
	}
}

/*

4 
lana 
nala 
abcdefg 
efgabcd 
abcdefg 
bagfedc 
abcdefg 
opqrstu 


*/