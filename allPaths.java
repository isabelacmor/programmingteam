import java.util.*;

public class allPaths {

    private static Map<Integer, LinkedHashSet<Integer>> map = new HashMap<Integer, LinkedHashSet<Integer>>();
    private int startNode;
    private int numLinks;

    public allPaths(int startNode, int numLinks) {
        super();
        this.startNode = startNode;
        this.numLinks = numLinks;
    }

    public void addEdge(int source, int destiny) {
        LinkedHashSet<Integer> adjacente = map.get(source);
        if(adjacente==null) {
            adjacente = new LinkedHashSet<Integer>();
            map.put(source, adjacente);
        }
        adjacente.add(destiny);
    }

    public void addLink(int source, int destiny) {
        addEdge(source, destiny);
        addEdge(destiny, source);
    }

    public LinkedList<Integer> adjacentNodes(int last) {
        LinkedHashSet<Integer> adjacente = map.get(last);
        System.out.println("adjacentes:" + adjacente);
        if(adjacente==null) {
            return new LinkedList<Integer>();
        }
        return new LinkedList<Integer>(adjacente);
    }


public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int numVertices = input.nextInt();
    int numLinks = input.nextInt();
    int startNode = input.nextInt();
    int endNode = startNode;

    allPaths mapa = new allPaths(startNode, numLinks);

    for(int i = 0; i<numLinks; i++){
        mapa.addLink(input.nextInt(), input.nextInt());
    }

    List<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    List<Integer> visited = new ArrayList<Integer>();
    visited.add(startNode);
    Integer currentNode = 0;

    Iterator it = map.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pairs = (Map.Entry)it.next();
        currentNode = (Integer) pairs.getKey(); 
        //System.out.println("Current Node:" + currentNode);
        mapa.findAllPaths(mapa, visited, paths, currentNode);

    }
}

private void findAllPaths(allPaths mapa, List<Integer> visited,
        List<ArrayList<Integer>> paths, Integer currentNode) {

    if (currentNode.equals(startNode)) { 
        paths.add(new ArrayList<Integer>(visited));

        LinkedList<Integer> nodes = mapa.adjacentNodes(currentNode); 
        //System.out.println("visited:" + visited);

        for (Integer node : nodes) {
            //System.out.println("nodes:" + nodes);
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(visited);
            temp.add(node);          
            findAllPaths(mapa, temp, paths, node);
        }

    }

    else {
        LinkedList<Integer> nodes = mapa.adjacentNodes(currentNode);  
        System.out.println("currentNode:" + currentNode);
        //System.out.println("nodes:" + nodes);
        for (Integer node : nodes) {            
            if (visited.contains(node)) {
                continue;
            } 
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(visited);
            System.out.println("visited:" + visited);
            temp.add(node);          
            findAllPaths(mapa, temp, paths, node);
        }
    }

} 

}