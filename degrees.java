import java.io.*;
import java.util.*;

public class degrees {
	public static int maxDegree;
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numPeople = in.nextInt();
		int numRelation = in.nextInt();
		int ctr = 1;
		
		while(numPeople != 0 && numRelation != 0){
			int[][] graph = new int[numPeople][numPeople];
			ArrayList<String> myPeople = new ArrayList();
			maxDegree = 0;
			
			initGraph(graph);
			for(int i = 0; i < numRelation; i++){
				String cur = in.next();
				String next = in.next();
				
				if(!myPeople.contains(cur)) myPeople.add(cur);
				if(!myPeople.contains(next)) myPeople.add(next);
				
				graph[myPeople.indexOf(cur)][myPeople.indexOf(next)] = 1;
				graph[myPeople.indexOf(next)][myPeople.indexOf(cur)] = 1;
			}
			
			//printGraph(graph, myPeople);
			floyds(graph);
			//printGraph(graph, myPeople);
			
			if(disconnected(graph)){//numRelation < numPeople){	//this condition is wrong
				System.out.println("Network " + ctr + ": DISCONNECTED");
			}
			else{
				System.out.println("Network " + ctr + ": " + maxDegree);
			}
			
			ctr++;
			numPeople = in.nextInt();
			numRelation = in.nextInt();
		}
	}
	
	public static int[][] initGraph(int[][] graph){
		for(int i = 0; i < graph.length; i++){
			for(int j = 0; j < graph.length; j++){
				if(i == j) graph[i][j] = 0;
				else graph[i][j] = 5;
			}
		}
		
		return graph;
	}
	
	public static void printGraph(int[][] graph, ArrayList<String> names){
		for(int i = 0; i < graph.length; i++){
			System.out.println(i + ": " + names.get(i));
		}
		
		for(int i = 0; i < graph.length; i++){
			System.out.print(i + ":\t");
			for(int j = 0; j < graph.length; j++){
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean disconnected(int[][] graph){
		for(int i = 0; i < graph.length; i++){
			for(int j = 0; j < graph.length; j++){
				//no connections to this point :(
				if(graph[i][j] == 5) return true;
			}
		}
		return false;
	}
	
	public static void floyds(int[][] graph){
		for(int k = 0; k < graph.length; k++){
			for(int i = 0; i < graph.length; i++){
				for(int j = 0; j < graph.length; j++){
					//System.out.println(i + " --> " + k + " --> " + j);
          			if(graph[i][k]+graph[k][j] < graph[i][j]){
          				//System.out.print("Route" );
          				//System.out.println(i + " --> " + k + " --> " + j + "\tcost: " + (graph[i][k]+graph[k][j]));
          				//System.out.println("is better than "+ i + " --> " + j + "\tcost: " + graph[i][j]);
          				graph[i][j] = graph[i][k]+graph[k][j];
          				
          				if(graph[i][k]+graph[k][j] > maxDegree) maxDegree = graph[i][k]+graph[k][j];
          			}
          			//System.out.println(i + " to " + j + ": " + graph[i][j]);
				}
			}
		}
	}
}

/*

4 4 
Ashok Kiyoshi Ursala Chun Ursala Kiyoshi 
Kiyoshi Chun 
4 2 
Ashok Chun Ursala Kiyoshi 
6 5 
Bubba Cooter Ashok Kiyoshi Ursala Chun 
Ursala Kiyoshi Kiyoshi Chun 
0 0

*/
