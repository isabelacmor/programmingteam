import java.io.*;
import java.util.*;

public class path {
	public static int INF = Integer.MIN_VALUE;
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for(int t = 0; t < T; t++){
			int N = in.nextInt();
			int M = in.nextInt();
			int Q = in.nextInt();
			
			int[][] graph = new int[N+1][N+1];
			
			//negative edge means no path
			for(int i = 0; i < N; i++) Arrays.fill(graph[i], INF);
			
			for(int m = 0; m < M; m++){
				int X = in.nextInt();
				int Y = in.nextInt();
				int Z = in.nextInt();
				
				if(graph[X][Y] != INF) graph[X][Y] = Math.min(graph[X][Y], Z);
				else graph[X][Y] = Z;
			}
			
			for(int q = 0; q < Q; q++){
				int A = in.nextInt();
				int B = in.nextInt();
				int C = in.nextInt();
				
				//solve(graph, A, B, C);
			}
			
			System.out.println("Solving");
			solve(graph, 1, 4, 2);
			
			System.out.println("\n\n\nBFS");
			BFS(graph);
		}
	}
	
	public static void solve(int[][] graph, int A, int B, int C){
		BFS(graph, A, new boolean[graph.length+1], C);
	}
	
	//on adj matrix
	public static void BFS(int[][] graph){		
		int[][] graphCopy = Arrays.copyOf(graph, graph.length);
		boolean [] visited = new boolean[graph.length+1];
		int numComponents = 0;
			
		for(int i = 1; i < graph.length; i++){
			if(!visited[i]){
				numComponents++;
				System.out.println("Starting BFS from node " + i);
				BFS(graph, i, visited, Integer.MAX_VALUE);
			}
		}
	}
		
	public static void BFS(int[][] graph, int start, boolean [] visited, int maxDist){
		ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
		Q.add(start);
		visited[start] = true;
		int numMoves = 0;
		int added = 0;
		
		while(!Q.isEmpty() && numMoves < maxDist){
			int head = Q.remove();
			System.out.print((head) + " -> ");
			
			//check all adj nodes
			for(int i = 1; i < graph.length; i++){
				if(graph[head][i] != INF && !visited[i]){
					Q.add(i);
					visited[i] = true;
				}
			}
			numMoves++;
		}
	}
}

/*


1
8 9 3
1 2 1
2 3 2
3 4 3
4 5 12
5 8 7
1 6 8
6 4 9
1 7 5
7 4 4
1 4 2
1 4 3
1 4 1


*/
