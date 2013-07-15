import java.io.*;
import java.util.*;

/**
 * Write a description of class confusion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class Pair
{
    public int value;
    public int height;
    
    public Pair(int v, int h)
    {
        value = v;
        height = h;
    }
}
public class shouting
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("shouting.in"));
        
        int numPeople = in.nextInt();
        //store everyone's x,y cor
        int [] xCors = new int[numPeople];
        int [] yCors = new int[numPeople];   
        double [] edges = new double[numPeople];
        
        //
        Pair[] parentList = new Pair[numPeople];
        for(int i = 0; i < numPeople; i++)
        {
            parentList[i] = new Pair(i, 0);
        }
        //
        
        for(int i = 0; i < numPeople; i++)
        {
            xCors[i] = in.nextInt();
        }        
        int ind = 0;
        for(int i = numPeople; i < numPeople*2; i++)
        {
            yCors[ind] = in.nextInt();
            ind++;
        }
        //print cor pairs
        for(int i = 0; i < numPeople; i++)
        {
            System.out.println(xCors[i] + ", " + yCors[i]);
        }
        //print distances
        for(int i = 0; i < numPeople-1; i++)
        {
            System.out.println(getDist(xCors, yCors, i));
        }
        
        //print parentList
//         for(int i = 0; i < numPeople-1; i++)
//         {
//             System.out.println(parentList[i].height + " " + parentList[i].value);
//         }
    }
    public static double [] buildEdges(double [] edges, int [] xCors, int [] yCors, int numPeople)
    {
        for(int i = 0; i < numPeople; i++)
        {
            edges[i] = getDist(xCors, yCors, i);
        }
        return edges;
    }
    public static double getDist(int [] xCors, int [] yCors, int i)
    {
        return Math.sqrt(Math.pow((xCors[i+1]-xCors[i]), 2)+Math.pow((yCors[i+1]-yCors[i]), 2));
    }
    public static int find(int value, Pair [] parentList)
    {
        while(parentList[value].value != value)
        {
            value = parentList[value].value;
        }
        return value;
    }
    public static void union(int indexA, int indexB, Pair [] parentList)
    {
        int rootA = find(indexA, parentList);
        int rootB = find(indexB, parentList);
        
        if(parentList[rootA].height < parentList[rootB].height)
        {
            parentList[rootA].value = rootB;
        }
        else
        {
            parentList[rootB].value = rootA;
            
            if(parentList[rootA].height == parentList[rootB].height)
                parentList[rootA].height++;
        }
    }
}