import java.io.*;
import java.util.*;

public class prob9 {
	public static void main(String [] args) throws IOException
	{
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("C:\\Users\\Isabella\\Desktop\\hard.in"));
		
		int numComps = in.nextInt();
		String blank = in.nextLine();
		
		for(int i = 1; i <= numComps; i++)
		{
			String first = in.nextLine();
			String second = in.nextLine();
			
			
			System.out.println("Processing:");
			if(first.length() > 6 && second.length() > 6)
			{
				for(int j = 0; j < 6; j++)
				{
					System.out.print(first.substring(j, j+1));
				}
				System.out.println();
				for(int j = 0; j < 6; j++)
				{
					System.out.print(second.substring(j, j+1));
				}
			}
			else
			{
				System.out.print(first + "\n" + second);
			}
			System.out.println();
			
			countLets(first, second);			
			
			String ans = compAL(first, second);
			
			System.out.println("Case #" + i + ": " + ans);
			
			System.out.println("---------");
		}
	}
	
	public static void countLets(String first, String second)
	{
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();          
		String s = first;
		for(int i = 0; i < s.length(); i++){
		   char c = s.charAt(i);
		   Integer val = map.get(new Character(c));
		   if(val != null){
		     map.put(c, new Integer(val + 1));
		   }else{
		     map.put(c,1);
		   }
		}
		
		System.out.println(map);
		map.clear();
		
		s = second;
		for(int i = 0; i < s.length(); i++){
			   char c = s.charAt(i);
			   Integer val = map.get(new Character(c));
			   if(val != null){
			     map.put(c, new Integer(val + 1));
			   }else{
			     map.put(c,1);
			   }
			}
		System.out.println(map);
	}
	
	public static String compAL(String first, String second)
	{
		String [] firstA = first.split("");
		String [] secondA = second.split("");
		
		List<String> firstAL = Arrays.asList(firstA);
		List<String> secondAL = Arrays.asList(secondA);
		
		Collections.sort(firstAL);
		Collections.sort(secondAL);
		
		if(firstAL.size()!=secondAL.size()) return "NO";
		//else
		for(int i = 0; i < firstAL.size(); i++)
		{
			if(firstAL.get(i).equals(secondAL.get(i)))
			{}
			else
				return "NO";
		}
		
		return "YES";
	}
}