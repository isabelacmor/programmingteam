import java.util.List;
import java.util.ArrayList;

class Vertex{
	private int vertexNo; //vertex number, starting from 0
	private boolean visited;
	private Object data = null; //can store any data associate with this vertes
	
	public Vertex(int vertexNo, Object data){
		this.vertexNo = vertexNo;
		this.visited = false;
		this.data = data;
	}
	public Vertex(int vertexNo){
		this(vertexNo, null);
	}
	
	public void visit(){
		this.visited = true;
	}
	public boolean isVisited(){
		return this.visited;
	}
	public int getVertexNo(){
		return this.vertexNo;
	}
	public Object getData(){
		return this.data;
	}
}

class Graph {
	private final int DEFAULT_EDGE_COST = 1;
	private Vertex[] vertices = null; //list of all vertices in the graph
	private int totalVertices = 0; //keeps count of vertices
	private int[][] adjMatrix = null; //keeps the edges of the graph using adjacency matrix
	private int[] adjacentVertCount = null; //keeps count of adjacent vertices for each vertex
	
    public Graph(int maxVertices) {
    	this.vertices = new Vertex[maxVertices]; //initialize vertices array
    	this.adjMatrix = new int[maxVertices][maxVertices]; //initialize adjacency matrix
    	this.adjacentVertCount = new int[maxVertices]; //initialize adjacent vertices count
    	for(int i=0; i<maxVertices; i++){
    		this.adjacentVertCount[i] = 0; //set adjacent vertex count to 0 initially
    		for(int j=0; j<maxVertices; j++){
    			this.adjMatrix[i][j] = -1; //set adjacency list to -1 initially
    		}
    	}
    }
    
    public Graph(){
    	//default Max amount of vertices: 100 [0-99]
    	this(100);
    }
    
    //add a new vertex with vertexNo and data
    public void addVertex(int vertexNo, Object data){
    	this.vertices[vertexNo] = new Vertex(vertexNo, data);
    	this.totalVertices++;
    }
    
    //add a new vertex with vertexNo only
    public void addVertex(int vertexNo){
    	this.addVertex(vertexNo, null);
    }
    
    //add a uni-directional edge with cost
    public void addEdge(int fromVertexNo, int toVertexNo, int cost){
    	this.adjMatrix[fromVertexNo][toVertexNo] = cost;
    	this.adjacentVertCount[fromVertexNo]++;
    }
    
    //add a uni-directional edge with cost
    public void addEdge(Vertex fromVertex, Vertex toVertex, int cost){
    	this.addEdge(fromVertex.getVertexNo(), toVertex.getVertexNo(), cost);
    }
    
    //add a uni-directional edge
    public void addEdge(int fromVertexNo, int toVertexNo){
    	this.addEdge(fromVertexNo, toVertexNo, this.DEFAULT_EDGE_COST);
    }
    
    //add a uni-directional edge
    public void addEdge(Vertex fromVertex, Vertex toVertex){
    	this.addEdge(fromVertex.getVertexNo(), toVertex.getVertexNo());
    }
    
    //add a bi-directional edge with cost
    public void addBidirectionalEdge(int vertex1, int vertex2, int cost){
    	this.addEdge(vertex1, vertex2, cost);
    	this.addEdge(vertex2, vertex1, cost);
    }
    
    //add a bi-directional edge with cost
    public void addBidirectionalEdge(Vertex v1, Vertex v2, int cost){
    	this.addBidirectionalEdge(v1.getVertexNo(), v2.getVertexNo(), cost);
    }
    
    //add a bi-directional edge
    public void addBidirectionalEdge(int vertex1, int vertex2){
    	this.addBidirectionalEdge(vertex1, vertex2, this.DEFAULT_EDGE_COST);
    }
    
    //add a bi-directional edge
    public void addBidirectionalEdge(Vertex v1, Vertex v2){
    	this.addBidirectionalEdge(v1.getVertexNo(), v2.getVertexNo());
    }
    
    //get the total vertices count in the graph
    public int getTotalNumberOfVertices(){
    	return this.totalVertices;
    }
    
    ///mark a vertex as visited
    public void visitVertex(int vertexNo){
    	this.vertices[vertexNo].visit();
    }
    
    //gets if a vertex is visited
    public boolean isVisited(int vertexNo){
    	return this.vertices[vertexNo].isVisited();
    }
    
    //get a vertex from a vertexNo
    public Vertex getVertex(int vertexNo){
    	return this.vertices[vertexNo];
    }
    
    //gets a vertex data from vertexNo
    public Object getVertexData(int vertexNo){
    	return this.vertices[vertexNo].getData();
    }
    
    //get adjacent vertex numbers for a given vertexNo
    public int[] getAdjacentVertexNumbers(int vertexNo){
    	int[] ret = new int[this.adjacentVertCount[vertexNo]];
    	int index = 0;
    	
    	for(int i=0; i<this.adjMatrix[vertexNo].length; i++){
    		if(this.adjMatrix[vertexNo][i] >= 0){
    			ret[index++] = i;
    		}
    	}
    	
    	return ret;
    }
    
    //get adjacent vertex numbers for a given vertex
    public int[] getAdjacentVertexNumbers(Vertex vert){
    	return this.getAdjacentVertexNumbers(vert.getVertexNo());
    }
    
    //get adjacent vertices for a given vertexNo
    public Vertex[] getAdjacentVertices(int vertexNo){
    	Vertex[] ret = new Vertex[this.adjacentVertCount[vertexNo]];
    	int index = 0;
    	
    	for(int i=0; i<this.adjMatrix[vertexNo].length; i++){
    		if(this.adjMatrix[vertexNo][i] >= 0){
    			ret[index++] = this.vertices[i];
    		}
    	}
    	
    	return ret;
    }
    
    //get adjacent vertices for a given vertex
    public Vertex[] getAdjacentVertices(Vertex vert){
    	return this.getAdjacentVertices(vert.getVertexNo());
    }
    
    //gets the edge/path cost from adjacency list for two given vertexNo
    public int getEdgeCost(int fromVertNo, int toVertNo){
    	return this.adjMatrix[fromVertNo][toVertNo];
    }
    
    //gets the edge/path cost from adjacency list for two given vertices
    public int getEdgeCost(Vertex fromVert, Vertex toVert){
    	return this.getEdgeCost(fromVert.getVertexNo(), toVert.getVertexNo());
    }
    
    //gets all vertices
    public Vertex[] getVertices(){
    	return this.vertices;
    }
    
    //returns all the edges of the graph
    //needed for edge traversing algorithms
    public Edge[] getAllEdges(){
    	int totalEdges = 0;
    	for(int i=0; i<this.adjacentVertCount.length; i++){
    		totalEdges += this.adjacentVertCount[i];
    	}
    	
    	Edge[] edges = new Edge[totalEdges];
    	int index = 0;
    	for(int i=0; i<this.vertices.length; i++){
    		for(int j=0; j<this.vertices.length; j++){
    			if(this.adjMatrix[i][j] >= 0){
    				edges[index++] = new Edge(this.vertices[i], this.vertices[j], this.adjMatrix[i][j]);
    			}
    		}
    	}
    	
    	return edges;
    }
    
    public Edge[] getAllBidirectionalEdges(){
    	int totalEdges = 0;
    	for(int i=0; i<this.adjacentVertCount.length; i++){
    		totalEdges += this.adjacentVertCount[i];
    	}
    	totalEdges /= 2;
    	
    	Edge[] edges = new Edge[totalEdges];
    	int index = 0;
    	for(int i=0; i<this.vertices.length; i++){
    		for(int j=i+1; j<this.vertices.length; j++){
    			if(this.adjMatrix[i][j] >= 0){
    				edges[index++] = new Edge(this.vertices[i], this.vertices[j], this.adjMatrix[i][j]);
    			}
    		}
    	}
    	
    	return edges;
    }
}

//edge class is needed for Kruskal's algorithm
class Edge{
	private Vertex fromVertex=null, toVertex=null;
	private int weight;
	public Edge(Vertex from, Vertex to, int weight){
		this.fromVertex = from;
		this.toVertex = to;
		this.weight = weight;
	}
	
	public Vertex getFrom(){
		return this.fromVertex;
	}
	public Vertex getTo(){
		return this.toVertex;
	}
	public int getWeight(){
		return this.weight;
	}
}

public class Kruskal {
	private Graph graph;
	private int[] sets; //represent set for vertices
	
    public Kruskal(Graph g) {
    	this.graph = g;
    	this.sets = new int[g.getTotalNumberOfVertices()];
    }
    
    private void makeSet(Vertex v){
    	this.sets[v.getVertexNo()] = v.getVertexNo(); //simply set the set name to each vertex no
    }
    
    private int findSet(Vertex v){
    	return this.sets[v.getVertexNo()]; //gets the set name/number of a vertex
    }
    
    private void union(Vertex u, Vertex v){
    	int findWhat, replaceWith;
    	
    	if(u.getVertexNo() < v.getVertexNo()){
    		findWhat = this.sets[v.getVertexNo()];
    		replaceWith = this.sets[u.getVertexNo()];
    	}
    	else{
    		findWhat = this.sets[u.getVertexNo()];
    		replaceWith = this.sets[v.getVertexNo()];
    	}
    	
    	//make both sets same
    	for(int i=0; i<this.sets.length; i++){
    		if(this.sets[i] == findWhat){
    			this.sets[i] = replaceWith;
    		}
    	}

    }
    
    private void sortEdges(Edge[] edges){
    	for(int i=0; i<edges.length-1; i++){
    		for(int j=i+1; j<edges.length; j++){
    			if(edges[i].getWeight() > edges[j].getWeight()){
    				Edge tmp = edges[i];
    				edges[i] = edges[j];
    				edges[j] = tmp;
    			}
    		}
    	}
    }
    
    //runs the main kruskal algorithm
    public List<Edge> getMSTEdges(){
    	//holds the MST edges
    	List<Edge> mstEdges = new ArrayList<Edge>();
    	
    	Vertex[] vertices = this.graph.getVertices();
    	for(int i=0; i<vertices.length; i++){
    		this.makeSet(vertices[i]);
    	}
    	
    	//get all bi-directional edges
    	Edge[] edges = this.graph.getAllBidirectionalEdges();
    	//sort the edges w.r.t their weights in non-decreasing order
    	this.sortEdges(edges);
    	
    	for(int i=0; i<edges.length; i++){
    		//for each each, in sorted order
    		Edge e = edges[i];    		
    		if(this.findSet(e.getFrom()) != this.findSet(e.getTo())){
    			//if the vertices it connects are not in the same set
    			//this edge is an MST edge
    			mstEdges.add(e);
    			//now, both vertices should have same set
    			this.union(e.getFrom(), e.getTo());
    		}
    	}
    	
    	return mstEdges;
    }
    
    //main method
    //test kruskal's algorithm
    public static void main (String[] args){
    	int maximumVertices = 9;
    	
    	Graph g = new Graph(maximumVertices);
    	for(int i=0; i<9; i++){
    		g.addVertex(i);
    	}
    	
    	//adding edges
    	g.addBidirectionalEdge(0, 1, 4);
    	g.addBidirectionalEdge(0, 7, 8);
    	g.addBidirectionalEdge(1, 7, 11);
    	g.addBidirectionalEdge(1, 2, 8);
    	g.addBidirectionalEdge(2, 3, 7);
    	g.addBidirectionalEdge(2, 5, 4);
    	g.addBidirectionalEdge(2, 8, 2);
    	g.addBidirectionalEdge(3, 4, 9);
    	g.addBidirectionalEdge(3, 5, 14);
    	g.addBidirectionalEdge(4, 5, 10);
    	g.addBidirectionalEdge(5, 6, 2);
    	g.addBidirectionalEdge(6, 7, 1);
    	g.addBidirectionalEdge(6, 8, 6);
    	g.addBidirectionalEdge(7, 8, 7);
    	
    	
    	Kruskal k = new Kruskal(g);
    	List<Edge> mst = k.getMSTEdges();
    	
    	System.out.println ("Minimum Spanning Tree Edges are:");
    	java.util.ListIterator it = mst.listIterator();
    	while(it.hasNext()){
    		Edge e = (Edge)it.next();
    		System.out.println ("v" + e.getFrom().getVertexNo() + " --- v" + e.getTo().getVertexNo());
    	}
	}
}