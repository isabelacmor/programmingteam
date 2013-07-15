import java.io.*;
import java.util.*;

public class commonTwoCB {
	
	public static void main(String [] args) throws IOException
	{
		String [] a = {"a", "a", "b", "b", "c"};
		String [] b = {"a", "b", "b", "b", "c"};
		System.out.println(commonTwo(a, b));
	}

	public static int commonTwo(String[] a, String[] b) {
		  int countCommon = 0;
		  ArrayList<String> aAL = new ArrayList(Arrays.asList(a));
		  ArrayList<String> bAL = new ArrayList(Arrays.asList(b));
		  
		  if(aAL.size() < bAL.size())
		  {
		     for(int i = 0; i < bAL.size(); i++)
		     {
		        if(aAL.contains(bAL.get(i)))
		        {
		           countCommon++;
		           while(aAL.contains(bAL.get(i)))
		        	   aAL.remove(bAL.get(i));
		        }
		     }
		  }
		  else
		  {
		     for(int i = 0; i < aAL.size(); i++)
		     {
		        if(bAL.contains(aAL.get(i)))
		        {
		           countCommon++;
		           while(bAL.contains(aAL.get(i)))
		        	   bAL.remove(aAL.get(i));
		        }
		     }
		  }
		  return countCommon;
		}
}
