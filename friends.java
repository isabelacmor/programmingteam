import java.io.*;
import java.util.*;

/**
 * Write a description of class friends here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class friends
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("friends.in"));
        int numNetworks = in.nextInt();
        int numRegistered;
        
        while(numNetworks != 0)
        {
            //number of registered users
            numRegistered = in.nextInt();
            String blank = in.nextLine();
            
            //arraylist of usernames
            ArrayList <String> regNames = new ArrayList();
            for(int i = 0; i < numRegistered; i++)
            {
                regNames.add(in.next());
            }

            boolean[][]G = new boolean[numRegistered][numRegistered];
            int numConnections = in.nextInt();
            //we need to permanently keep the number of connections,
            //so the while loop below must use an alternately sorted value
            int tempNumConnections = numConnections;
            blank = in.nextLine();
            //THESE ARE THE CONNECTIONS BETWEEN PEOPLE, USED TO LATER SET UP GRID
            String [][] connections = new String[numConnections][2]; //connections exist between only a pair of people
            int x = 0;
            int y = 0;
            String name1, name2;
            while(tempNumConnections != 0)
            {
                name1 = in.next();
                name2 = in.next();
                connections[x][y] = name1;
                connections[x][y+1] = name2;
                System.out.println("Connection between " + connections[x][y] + " and " + connections[x][y+1]);
                x++;
                tempNumConnections--;
            }
            
            //SETTING UP GRID
            int yy = 0;
            for(int i = 0; i < numConnections; i++)
            {
                name1 = connections[i][yy];
                name2 = connections[i][yy+1];
                G[regNames.indexOf(name1)][regNames.indexOf(name2)] = G[regNames.indexOf(name2)][regNames.indexOf(name1)] = true;
                System.out.println("G[" + regNames.indexOf(name1) + "][" + regNames.indexOf(name2) + "] is true");
            }
            boolean [] V = new boolean[numRegistered];
            //int myDirectFriends = DFS(regNames.indexOf("You"), V, numRegistered, G));

            int numCompetitors = in.nextInt();
            blank = in.nextLine();
            int [] otherDirectFriends = new int[numCompetitors];
            for(int i = 0; i < numCompetitors; i++)
            {
                String name = in.next();
                otherDirectFriends[i] = DFS(regNames.indexOf(name), V, numRegistered, G, 0);
            }
            
            DFS(numRegistered, G);
            System.out.println("Running YOU coolness");
            DFS(regNames.indexOf("You"), V, numRegistered, G);
            System.out.println("Running ARUP coolness");
            DFS(regNames.indexOf("Arup"), V, numRegistered, G);
            System.out.println("Running CHRIS coolness");
            DFS(regNames.indexOf("Chris"), V, numRegistered, G);
            
            //System.out.println(myDirectFriends);
            //System.out.println(DFS(regNames.indexOf("Arup"), V, numRegistered, G));
            //System.out.println(DFS(regNames.indexOf("Chris"), V, numRegistered, G));
            
            /*map
            *You Arup Jason Ali Glenn Chris
            *  0    1     2   3     4     5
            *
            *   _____
            *  |     |
            *  4--3--5     1
            *  | /
            *  |/
            *  0---2
            * 
            */            
            numNetworks--;
        }
    }
    public static void DFS(int vertices, boolean [][] G)
    {
        boolean [] V = new boolean[vertices];
        int numComp  = 0;
        
        for(int i = 0; i < vertices; i++)
        {
            if(!V[i])
            {
                numComp++;
                DFS(i, V, vertices, G);
            }
        }
        System.out.println("Done with DFS; found " + numComp + " components");
    }
    public static int DFS(int at, boolean [] V, int vertices, boolean [][] G, int count)
    {
        V[at] = true;
        count++;
        for(int i = 0; i < vertices; i++)
        {
            if(G[at][i] && !V[i])
            {
                count+=DFS(i, V, vertices, G, 0);
            }
        }
        return count;
    }
    public static void DFS(int at, boolean [] V, int vertices, boolean [][] G)
    {
        V[at] = true;
        for(int i = 0; i < vertices; i++)
        {
            if(G[at][i] && !V[i])
            {
                System.out.println("Going to node " + i);
                DFS(i, V, vertices, G);
            }
        }
        System.out.println("Done processing node " + at);
    }
}