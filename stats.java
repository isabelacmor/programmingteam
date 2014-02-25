package mercer2010;
import java.io.*;
import java.util.*;

public class stats {
	public static void main(String [] args) throws IOException{
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("test.in"));
		
		String doc = "";
		while(in.hasNext()){
			doc = doc + " " + in.nextLine().trim();
		}
		doc = doc.toLowerCase();
		doc = doc.replaceAll("[^a-z ]", "");
		
		String [] words = doc.trim().split(" ");
		Arrays.sort(words);
		
		if(words.length % 2 == 0){
			System.out.println("My median=[" + words[words.length/2-1] + "," + words[words.length/2] + "]");
		}
		else{
			System.out.println("My median=[" + words[words.length/2] + "]");
		}
		
		printFreq(words);
		
	}
	
	public static void printFreq(String [] words){
		HashMap<String, Integer> hm = new HashMap();
		
		//count freqs
		for(String s : words){
			if(hm.containsKey(s)){
				int cur = hm.get(s);
				hm.put(s, cur+1);
			}
			else hm.put(s, 1);
		}
		
		//find largest
		int maxFreq = -1;
		for (Integer vals : hm.values()) {
		    maxFreq = Math.max(maxFreq, vals);
		}
		
		//add largest to list
		ArrayList<String> valid = new ArrayList();
		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
		    if(entry.getValue() == maxFreq) valid.add(entry.getKey());
		}
		
		Collections.sort(valid);
		
		System.out.print("My mode=[");
		for(int i = 0; i < valid.size()-1; i++){
			System.out.print(valid.get(i) + "(" + maxFreq + "),");
		}
		
		System.out.print(valid.get(valid.size()-1) + "(" + maxFreq + ")]");
	}
}


/*

When April with his sweet showers has 
pierced the drought of March to the root, 
and bathed every vein in such moisture 
as has power to bring forth the flower 


*/