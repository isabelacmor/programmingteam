import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class ACM2009E2 {
	static ArrayList<String> perms = new ArrayList();
	
	public static void main(String[] args) throws Exception {
	    
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++)
		{
			int curCase = in.nextInt();
			//BigInteger start = BigInteger.valueOf(in.nextInt());
			String start = in.next();
			
			String str = start + "";
		    StringBuffer strBuf = new StringBuffer(str);
		    doPerm(strBuf, str.length());
		    
		    System.out.println(curCase + " ");
		    System.out.println(perms);
		    
		    Collections.sort(perms);
		    
		    int indexOriginal = perms.indexOf(String.valueOf(start));
		    System.out.println("index: " + indexOriginal);
		    		    
		    if(indexOriginal == perms.size()-1)
		    {
		    	System.out.println("BIGGEST");
		    }
		    else
		    {
		    	System.out.println(perms.get(indexOriginal+1));
		    }
		}


	}

	private static void doPerm(StringBuffer str, int index){
	    if(index == 0)
	        perms.add(str.toString());            
	    else { //recursively solve this by placing all other chars at current first pos
	        doPerm(str, index-1);
	        int currPos = str.length()-index;
	        for (int i = currPos+1; i < str.length(); i++) {//start swapping all other chars with current first char
	            swap(str,currPos, i);
	            doPerm(str, index-1);
	            swap(str,i, currPos);//restore back my string buffer
	        }
	    }
	}

	private  static void swap(StringBuffer str, int pos1, int pos2){
	    char t1 = str.charAt(pos1);
	    str.setCharAt(pos1, str.charAt(pos2));
	    str.setCharAt(pos2, t1);
	} 
}
