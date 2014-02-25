import java.io.*;
import java.util.*;

class set{
	public int value;
	public int distance;

	public set(int v, int d) {
		value = v;
		distance = d;
	}
}

public class calcGames {
	
	public static final int UPPER = 100;
	public static final int MAXANS= (int)1e9;
	
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++){
			int start = in.nextInt();
			System.out.println(start + ": " + solve(start));
		}
	}
	
	public static int solve(int start){
		int [] visited = new int[UPPER];
		for(int i = 0; i < UPPER; i++){
			visited[i] = -1;
		}
		
		LinkedList<set> Q = new LinkedList();
		Q.add(new set(start, 0));
		
		int numVisited = 0;
		int maxPress = 0;
		
		while(Q.size() > 0 && numVisited < UPPER-1){
			set s = Q.poll();
			
			if(s.value > 0 && s.value < UPPER && visited[s.value] == -1){
				visited[s.value] = s.distance;
				numVisited++;
				maxPress = s.distance;
			}
			
			//enqueue +1
			if(s.value+1 > 0 && s.value+1 < UPPER && visited[s.value+1] == -1){
				Q.add(new set(s.value+1, s.distance+1));
			}
			else if(s.value+1 > 0 && s.value+1 < MAXANS){
				Q.add(new set(s.value+1, s.distance+1));
			}
			
			//enqueue *3
			if(s.value*3 > 0 && s.value*3 < UPPER && visited[s.value*3] == -1){
				Q.add(new set(s.value*3, s.distance+1));
			}
			else if(s.value*3 > 0 && s.value*3 < MAXANS){
				Q.add(new set(s.value*3, s.distance+1));
			}
			
			//enqueue /2
			if(s.value/2 > 0 && s.value/2 < UPPER && visited[s.value/2] == -1){
				Q.add(new set(s.value/2, s.distance+1));
			}
			else if(s.value/2 > 0 && s.value/2 < MAXANS){
				Q.add(new set(s.value/2, s.distance+1));
			}
		}
		
		
		return maxPress;
		
	}
}

/*

3
1
73
99

*/