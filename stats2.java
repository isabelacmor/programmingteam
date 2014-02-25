package mercer2010;
import java.io.*;
import java.util.*;

class li implements Comparable<li>{
	public String word;
	public int freq;
	
	public li(String w){
		word = w;
		freq = 1;
	}

	public int compareTo(li o) {
		if(this.freq != o.freq) return o.freq - this.freq;
		else return this.word.compareTo(o.word);
	}
	
	public boolean equals(String o) {
		return this.word.equals(o);
	}
	
	public String toString(){
		return word + " : " + freq;
	}
}

public class stats2 {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("test.in"));
		
		ArrayList<String> words = new ArrayList();
		ArrayList<li> norep = new ArrayList();
		
		while(in.hasNext()){
			String word = in.next();
			words.add(word.toLowerCase().trim().replaceAll("[^a-z]", ""));
			update(norep, words.get(words.size()-1));
		}
		
		Collections.sort(words);
		Collections.sort(norep);
		
		//print median
		if(words.size()%2 == 1)
			System.out.println("My median=["+words.get(words.size()/2)+"]");
		else
			System.out.println("My median=["+words.get(words.size()/2-1)+","+words.get(words.size()/2)+"]");
		
		//print mode
		System.out.print("My mode=[");
		int i = 0;
		int best = norep.get(0).freq;
		while(i < norep.size() && norep.get(i).freq == best){
			if(i > 0) System.out.print(",");
			System.out.print(norep.get(i).word + "(" + best + ")");
			i++;		
		}
		
		System.out.println("]");
	}
	
	public static void update(ArrayList<li> norep, String s){
		boolean tf = false;
		
		for(li item : norep){
			if(item.word.equals(s)){
				item.freq++;
				tf = true;
				break;
			}
		}
		
		if(!tf) norep.add(new li(s));
	}
}
