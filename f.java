import java.util.*;
import java.io.*;


public class f {

	public static Planets[] planets;
	public static int[][] connected;
	
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		int numPlanets = stdin.nextInt();
		
		while(numPlanets != 0){
			planets = new Planets[numPlanets];
			connected = new int[numPlanets][numPlanets];
			for(int i = 0; i < connected.length; i++){
				Arrays.fill(connected[i], 0);
			}
			
			for(int i = 0; i < numPlanets; i++){
				planets[i] = new Planets(stdin.nextInt(), stdin.nextInt(), stdin.nextInt(), stdin.nextInt());
				if(i != 0){
					connected[connector(planets, i)][i] = 1;
					connected[i][connector(planets, i)] = 1;
				}
			}
			
			int[] maxDistances = new int[numPlanets];
			for(int i = 0; i < planets.length; i++){
				maxDistances[i] = bf(i);
			}
			
			//System.out.println("all max: " + Arrays.toString(maxDistances));
			
			ArrayList<Planets> valid = new ArrayList();
			int min = maxDistances[0];
			for(int m = 0; m < maxDistances.length; m++){
				if(maxDistances[m] < min) min = maxDistances[m];
			}
			
			for(int m = 0; m < maxDistances.length; m++){
				if(maxDistances[m] == min) valid.add(planets[m]);
			}
			
			Collections.sort(valid);
			for(Planets v : valid){
				System.out.print(v.ID + " ");
			}
			System.out.println();
			
			numPlanets = stdin.nextInt();
		}

	}
	
	public static int bf(int src){
		int[] dist = new int[planets.length];
		
		for(int i = 0; i < planets.length; i++){
			if(i == src) dist[i] = 0;
			else dist[i] = 20000;
		}
		
		//System.out.println("from " + src + ": " + Arrays.toString(dist));
		
		for(int i = 0; i < planets.length; i++){
			for(int j = 0; j < planets.length; j++){
				for(int k = 0; k < planets.length; k++){
					if(connected[j][k] == 1){
						if(dist[j] + connected[j][k] < dist[k]){
							dist[k] = dist[j] + connected[j][k];
						}
					}
				}
			}
		}
		
		Arrays.sort(dist);
		//System.out.println(src + ": " + Arrays.toString(dist));
		return dist[dist.length-1];
	}
	
	public static int djikstras(int source){
		Point[] distanceD = new Point[planets.length];
		
		Arrays.fill(distanceD, new Point(Integer.MAX_VALUE, source));
		
		distanceD[source].distance = 0;
		
		for(int i = 0; i < planets.length; i++){
			int vertex = 0;
			int bestSeen = Integer.MAX_VALUE;
			
			for(int j = 0; j < planets.length; j++){
				if(!distanceD[j].visited && distanceD[j].distance < bestSeen){
					bestSeen = distanceD[j].distance;
					vertex = j;
				}
			}
			
			distanceD[vertex].visited = true;
			
			for(int j = 0; j < planets.length; j++){
				if(distanceD[vertex].distance+connected[vertex][j] < distanceD[j].distance){
					distanceD[j].distance = distanceD[vertex].distance+ connected[vertex][j];
					distanceD[j].previous = vertex;
				}
			}
		}
		
		Arrays.sort(distanceD);
		for(int i = 0; i < distanceD.length; i++){
			System.out.println(distanceD[i].distance);
		}
		
		return distanceD[distanceD.length-1].distance;
	}

	public static int connector(Planets[] p, int index){
		int best = 0;
		double distance = -1;
		
		for(int k = 0; k < index; k++){
			double tempD = Math.sqrt(Math.pow(p[k].x-p[index].x, 2) + Math.pow(p[k].y-p[index].y, 2) + Math.pow(p[k].z-p[index].z, 2));
			if(tempD < distance || distance == -1){
				best = k;
				distance = tempD;
			}
		}
		
		return best;
	}
}
class Point implements Comparable<Point>{
	public int distance;
	public int previous;
	public boolean visited;
	
	public Point(int d, int p){
		distance = d;
		previous = p;
		visited = false;
	}

	@Override
	public int compareTo(Point p) {
		return distance - p.distance;
	}
	
	
}

class Planets implements Comparable<Planets>{
	int ID;
	double x;
	double y;
	double z;
	
	public Planets(int id, int a, int b, int c){
		ID = id;
		x = a;
		y = b;
		z = c;
	}

	@Override
	public int compareTo(Planets o) {
		return this.ID - o.ID;
	}
}

/*

5
1 0 0 0
2 0 0 1
3 0 0 2
4 0 0 3
5 0 0 4
5
1 0 0 0 
2 1 1 0
3 3 2 0 
4 2 1 0
5 3 0 0
10
21 71 76 4
97 32 5 69
70 33 19 35
3 79 81 8
31 91 17 67
52 31 48 75
48 90 14 4
41 73 2 21
83 74 41 69
26 32 30 24
0
*/