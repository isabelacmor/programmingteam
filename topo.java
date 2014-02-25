import java.io.*;
import java.util.*;

/** adjacent elements **/
class AdjElement{
	public int data;
	
	public AdjElement(int d){
		data = d;
	}
	
	public String toString(){
		return data + "";
	}
}

class Graph{
	 public LinkedList<AdjElement>[] lists;
	 
	 public Graph(String fileName)throws IOException{
		Scanner in = new Scanner(new File(fileName));
		int numNodes = in.nextInt();
		lists = new LinkedList[numNodes];
		        
		for(int i = 0; i < numNodes; i++){
		    lists[i] = new LinkedList<AdjElement>();
		    
		    int numConnections = in.nextInt();
		    for(int j = 0; j < numConnections; j++){
		    	lists[i].addLast(new AdjElement(in.nextInt()));
		    }
		}
	 }
	 
	 public LinkedList<AdjElement> getAdjListOfNode(int i) {
	        return lists[i];
	 }
	 
	 public void printGraphAdj(){
		 for(int i = 0; i < lists.length; i++){
			 System.out.print((i+1) + ": ");
			 ListIterator<AdjElement> it = lists[i].listIterator();
			 while(it.hasNext()){
				 System.out.print(it.next() + " -> ");
			 }
			 System.out.println("X");
		 }
	 }
	 
	 public boolean adjListContains(int origin, int find){
		 
		 for(int i = 0; i < getAdjListOfNode(origin-1).size(); i++){
			if(getAdjListOfNode(origin-1).get(i).data == find) return true;
		 }
		 
		 return false;
	 }
}

public class topo {
	public static Graph g;
	
	public topo(String fileName) throws IOException{
		g = new Graph(fileName);
	}
	
	public static void main(String [] args) throws IOException{
		System.out.println((hasTopoPath("TopoSort.in") == true) ? "PASS" : "FAIL");
	}
	
public static boolean hasTopoPath(String fileName) throws IOException{
		
		//set up necessary vars
		Graph g = new Graph(fileName);
		int [] incomingNodes = new int[g.lists.length];
		ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
		ArrayList<Integer> topPath = new ArrayList<Integer>();
		int ctr = 0;
		
		for(int i = 0; i < g.lists.length; i++){
			//go through the entire adj list and calculate the number of times each value appears
			//this will be the number of incoming nodes
			for(int j = 0; j < g.lists[i].size(); j++){
				incomingNodes[g.lists[i].get(j).data-1]++;
			}
		}
		
		//any node without any incoming edges can be processed first
		for(int i = 0; i < incomingNodes.length; i++){
			if(incomingNodes[i] == 0){
				Q.add(i+1);
			}
		}
		
		//while we still have nodes to process
		while(!Q.isEmpty()){
			//process this node as one we can immediately visit
			int nodeCan = Q.remove();
			
			//add it to the path list
				topPath.add(nodeCan);
				System.out.println(nodeCan + " -> ");
				ctr++;
			
				for(int i = 0; i < g.lists[nodeCan-1].size(); i++){
					incomingNodes[g.lists[nodeCan-1].get(i).data-1]--;
					
					//add to the queue if possible
					if(incomingNodes[g.lists[nodeCan-1].get(i).data-1] == 0){
						Q.add(g.lists[nodeCan-1].get(i).data);
					}
				}
			
		}
		
		//we haven't visited the same number of nodes as contained in the graph
		return ctr == g.lists.length;
	}
	
	public static double hoursSpent(){
		return 1.5;
	}
	
	public static double difficultyRating(){
		 return 2.5;
	}
}
