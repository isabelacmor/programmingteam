package mercer2010;
import java.io.*;
import java.util.*;

class SB implements Comparable<SB>{
	public String city;
	public int exit;
	public double dist;
	
	public SB(String line){
		String [] sep = line.split(",");
		city = sep[0];
		exit = Integer.valueOf(sep[1]);
		dist = Double.valueOf(sep[2]);
	}
	
	public int compareTo(SB s){
		if(this.exit > s.exit) return 1;
		else if(this.exit < s.exit) return -1;
		else{
			if(this.dist > s.dist) return 1;
			else if(this.dist < s.dist) return -1;
			else return 0;
		}
	}
	
	public String toString(){
		return city + ", Exit " + exit; 
	}
}
public class starbucks {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		ArrayList<SB> sb = new ArrayList();
		while(true){
			String line = in.nextLine().trim();
			if(line.equals("END"))
				break;
			sb.add(new SB(line));
		}
		
		Collections.sort(sb);
		
		for(SB s : sb)
			if(s.dist <= 2.0) System.out.println(s);
	}
}

/*

Epps Bridge Road,40,1.5 
Tiger Blvd,25,4.2 
Main Street,25,1.0 
Your Street,25,50 
Green Street,150,4 
END 


*/
