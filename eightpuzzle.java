package mercer2010;
import java.io.*;
import java.util.*;

class eightpuzzle {

	public static Queue<String> q = new LinkedList<String>();    // Use of Queue Implemented using LinkedList for Storing All the Nodes in BFS.
	public static  Map<String,Integer> map = new HashMap<String, Integer>(); // HashMap is used to ignore repeated nodes
	public static boolean tf;
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        
        for(int i = 0; i < numCases; i++){        	
            String str = "";
            for(int j = 0; j < 3; j++)
            	str += (in.nextInt() + "" + in.nextInt() + "" + in.nextInt());
        
            //build up search space as we go, based on initial board case
            add(str, 0);

            //try all routes from this node
            while(q.peek()!= null){
                up(q.peek());     
                down(q.peek());                                     
                left(q.peek());                                     
                right(q.remove());                          
            }
	            
	        System.out.println(map.get(str)); //use this
        }
    }

    //add this board state and depth if we haven't already gotten here yet
    public static void add(String str,int n){
        if(!map.containsKey(str)){
                map.put(str,n);
                q.add(str);
        }
    }

    //move our String pieces up
    public static void up(String str){
        int a = str.indexOf("0");
        
        //can't be in the first row
        if(a>2){
        	String s = str.substring(0,a-3)+"0"+str.substring(a-2,a)+str.charAt(a-3)+str.substring(a+1);
            add(s,map.get(str)+1);
        }
    }
    
    //move our String pieces down
    public static void down(String str){
        int a = str.indexOf("0");
      
        //can't be in the last row
        if(a<6){
        	String s = str.substring(0,a)+str.substring(a+3,a+4)+str.substring(a+1,a+3)+"0"+str.substring(a+4);
            add(s,map.get(str)+1);
        }
    }
    
    //move our String pieces left
    public static void left(String str){
        int a = str.indexOf("0");
        
        //can't be in the left-most column
        if(a!=0 && a!=3 && a!=6){
        	String s = str.substring(0,a-1)+"0"+str.charAt(a-1)+str.substring(a+1);
            add(s,map.get(str)+1);
        }
    }
    
    //move our String pieces right
    public static void right(String str){
        int a = str.indexOf("0");
        
        //can't be in the right-most row
        if(a!=2 && a!=5 && a!=8){
                String s = str.substring(0,a)+str.charAt(a+1)+"0"+str.substring(a+2);
                add(s,map.get(str)+1);
        }
    }
}

/*

3 
1 2 3 
4 5 6 
7 8 0 
1 2 3 
7 0 4 
8 6 5 
4 2 6 
3 1 5 
7 0 8

*/