import java.io.*;
import java.util.*;

class Ship{
	public double x, y, r;
	
	public Ship(double x, double y, double r){
		this.x = x;
		this.y = y;
		this.r = r;
	}
}

public class crashandgo {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numShips = in.nextInt();
		
		//loop through all scenarios
		while(numShips != 0){
			//list of all ships on this planet
			ArrayDeque<Ship> list = new ArrayDeque<Ship>();
			
			//get all ships from input
			for(int j = 0; j < numShips; j++){
				Ship current = new Ship(in.nextInt(), in.nextInt(), in.nextInt());
				
				//let's try to merge everyone we've seen so far
				while(true){
					int numSeen = list.size();
					
					//find out what ships are reachable from the current ship
					ArrayDeque<Ship> neighbors = new ArrayDeque<Ship>();
					
					for(int i = 0; i < numSeen; i++){
						Ship check = list.removeFirst();
						
						double distanceSquared = Math.pow(current.x - check.x, 2) + Math.pow(current.y - check.y, 2);
						double maxRange = Math.max(check.r, current.r);
						
						//we can reach this ship, let's add it to our neighbors list
						//we don't put it back in the list, cause we'll add in a different merge to the main list
						if(Math.pow(maxRange, 2) >= distanceSquared){
							neighbors.addLast(check);
						}
						//we can't reach this ship, let's just add it back to the main list
						else{
							list.addLast(check);
						}
					}
					
					//now go through all the neighbors for this ship and merge
					if(neighbors.isEmpty()) break;
					
					//add the current ship for comparison since we're wiping data
					neighbors.add(current);
					current = new Ship(0, 0, 0);
					
					//find the average of all the neighbors
					for(Ship s : neighbors){
						current.x += s.x;
						current.y += s.y;
						current.r += Math.pow(s.r, 2);
					}
					
					current.x /= neighbors.size();
					current.y /= neighbors.size();
					current.r = Math.sqrt(current.r);
				}
				
				//now add the merged ship to the main list
				list.addLast(current);
			}
			//this is the answer
			System.out.println(list.size());
			
			numShips = in.nextInt();
		}
	}
}

/*

5
100 100 30
130 80 30
80 60 30
120 150 30
90 80 30
6
100 100 50
145 125 10
60 140 15
160 145 20
130 135 25
80 80 30
0

*/
