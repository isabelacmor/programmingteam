//package mercer2013;
import java.io.*;
import java.util.*;

class Person implements Comparable<Person>{
	public int first, last, height;
	
	public Person(int F, int L, int H){
		first = F; last = L; height = H;
	}
	
	public String toString(){
		return "<" + first + "," + last + "," + height + ">";
	}

	@Override
	public int compareTo(Person p) {
		if(this.first < p.first) return -1;
		else if(this.first > p.first) return 1;
		else{
			if(this.last < p.last) return -1;
			else if(this.last > p.last) return 1;
			else{
				if(this.height < p.height) return -1;
				else if(this.height > p.height) return 1;
				else return 0;
			}
		}
	}
}

public class nameography {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int nc = 1; nc <= numCases; nc++){
			int numNames = in.nextInt();
			
			in.nextLine();
			ArrayList<Person> ppl = new ArrayList();
			for(int i = 0; i < numNames; i++){
				ppl.add(new Person(in.next().length(), in.next().length(), in.nextInt()));
				in.nextLine();
			}
			
			Collections.sort(ppl);
			
			for(int i = 0; i < ppl.size()-1; i++){
				for(int j = i+1; j < ppl.size()-1; j++){
					if(ppl.get(i).first == ppl.get(j).first && ppl.get(i).last == ppl.get(j).last){
						ppl.get(i).height += ppl.get(j).height;
						ppl.remove(j);
						j--;
					}
				}
			}
			
			System.out.print(nc + " " + (ppl.size() == numNames ? "yes" : "no") + " ");
			for(Person p : ppl) System.out.print(p + " ");
			System.out.println();
		}
	}
}


/*

2 
2 
John McCain 175 
Barack Obama 185 
3 
John McCain 175 
Barack Obama 185 
Mitt Romney 188 


*/