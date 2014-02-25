import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	String from, to;
	int fno;
	
	public Edge(String f, String t, int n){
		from = f;
		to = t;
		fno = n;
	}
	
	public int compareTo(Edge o){
		return fno - o.fno;
	}
}

public class airways {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++){
			int numFlights = in.nextInt();
			
			//Stores all edges, so we can reference later
			ArrayList<Edge> adj = new ArrayList();
			
			//Stores our from --> list of all possible destinations, in order of flight #
			HashMap<String, PriorityQueue<Edge>> list = new HashMap();
			
			//Stores all possible cities
			HashSet<String> cities = new HashSet();
			
			//Stores the in-degree of each city
			HashMap<String, Integer> inDeg = new HashMap();
			
			//Read in all flights
			for(int j = 0; j < numFlights; j++){
				String from = in.next();
				String to = in.next();
				int num = in.nextInt();
				
				//Add this flight to our list of flights
				adj.add(new Edge(from, to, num));
				
				//Add the cities if we haven't seen it before
				if(!cities.contains(from)){
					cities.add(from);
					inDeg.put(from, 0);
					list.put(from, new PriorityQueue());
				}
				
				if(!cities.contains(to)){
					cities.add(to);
					inDeg.put(to, 0);
					list.put(to, new PriorityQueue());
				}
			}
			
			//Calculate each city's in-degree
			//Go through all edges
			for(Edge e : adj){
				//Add the destination to the from city's list of possible destinations
				list.get(e.from).add(e);
				//Remove the destination, meaning we've determined that this city cannot be first
				cities.remove(e.to);
				//Increment the in-degree of the destination
				inDeg.put(e.to, inDeg.get(e.to) + 1);
			}
			
			//Toposort
			PriorityQueue<Edge> Q = new PriorityQueue();
			
			//Add all cities with zero in-degree
			for(String s : cities)
				Q.addAll(list.get(s));
					
			//StringBuilder stores our running answer
			StringBuilder ans = new StringBuilder();
			
			//Process until our Q is empty
			while(!Q.isEmpty()){
				Edge e = Q.poll();
				
				//Decrement in-degree of destination from this flight
				inDeg.put(e.to, inDeg.get(e.to) - 1);
				
				//Add the source of this flight to the answer
				ans.append(e.fno).append(" ");
				
				//If the current destination has no more incoming flights, add all it's destinations to the Q
				if(inDeg.get(e.to) == 0) Q.addAll(list.get(e.to));
			}
			
			System.out.println(ans);
		}
	}
}

/*


2
7
TAMPA MIAMI 912
ORLANDO TAMPA 450
MIAMI ATLANTA 321
ATLANTA NEWYORK 942
ORLANDO ATLANTA 952
CHICAGO MIAMI 568
MIAMI ATLANTA 64
3
ATLANTA TAMPA 351
MIAMI NEWYORK 135
ORLANDO CHICAGO 531


*/