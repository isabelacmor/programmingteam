import java.io.*;
import java.util.*;

class Person{
	char name;
	ArrayList<Character> people = new ArrayList();
	ArrayList<Character> pref = new ArrayList();
	
	Person(char n){
		name = n;
	}
	
	public void addPerson(char n, char p){
		people.add(n);
		pref.add(p);
	}
	
	public char getPrefPerson(char n){
		int index = people.indexOf(n);
		if(index != -1) return pref.get(index);
		else return '-';
	}
	
	public void printPerson(){
		System.out.println(name + "\n=====");
		for(int i = 0; i < people.size(); i++){
			System.out.println(pref.get(i) + ": " + people.get(i));
		}
	}
}

public class toga {
	public static int totalScore;
	
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numProc = in.nextInt();
		int ctr = 1;
		
		while(numProc != 0){
			totalScore = 0;
			int maxScore = 0;
			
			int numPairs = numProc/2;
			ArrayList<Person> setGirls = new ArrayList();
			ArrayList<Person> setGuys = new ArrayList();
			
			String blank = in.nextLine();
			
			//get guest list
			for(int i = 0; i < numProc; i++){
				String line = in.nextLine();
				
				char name = line.charAt(0);
				char pref = line.charAt(1);
				char match = line.charAt(2);
				
				//lowercase
				if(name >= 97){
					//person doesn't exist in our list yet...so add him
					if(getIndexPerson(name, setGuys) == -1){
						setGuys.add(new Person(name));
					}
					//add his match
					setGuys.get(getIndexPerson(name, setGuys)).addPerson(match, pref);
					
				}
				//uppercase
				else{
					//person doesn't exist in our list yet...so add her
					if(getIndexPerson(name, setGirls) == -1){
						setGirls.add(new Person(name));
					}
					//add her match
					setGirls.get(getIndexPerson(name, setGirls)).addPerson(match, pref);
				}
			}
			
			//System.out.println("List of guys\n");
			//printList(setGuys);
			//System.out.println("List of girls\n");
			//printList(setGirls);
			
			boolean[] used = new boolean[setGuys.size()];
			int [] perm = new int[setGuys.size()];
			for(int i = 0; i < setGuys.size(); i++){
				perm[i] = i;
			}
			
			//permute the list of guys
			//keep list of girls static
			//now calculate the total happiness for each permutation (perm will be MfMf...Mf)
			//so just do calcScore(p.get(i), p.get(i+1))
			permute(0, used, perm, setGuys.size(), setGirls, setGuys);
			
			System.out.println("Party " + ctr + " has a maximum happiness quotient of " + totalScore);
			
			ctr++;
			numProc = in.nextInt();
		}
	}
	
	public static int calcScore(Person m, Person f){
		char getScoreM = m.getPrefPerson(f.name);
		char getScoreF = f.getPrefPerson(m.name);
		
		if(getScoreM == '-' || getScoreF == '-') return 0;
		
		if(getScoreM == 'L' && getScoreF == 'L') return 4;
		else if((getScoreM == 'T' && (getScoreF == 'T' || getScoreF == 'L')) || (getScoreF == 'T' && (getScoreM == 'T' || getScoreM == 'L'))) return 3;
		else if(getScoreF == 'T') return 2;
		else return 1;
	}
	
	public static void permute(int p, boolean[] used, int[] perm, int N, ArrayList<Person> girls, ArrayList<Person> guys){
		
		if(p == N){
			//calculate the score of this perm
			int [] girlsOrder = new int[girls.size()];
			for(int i = 0; i < girls.size(); i++){
				girlsOrder[i] = i;
			}
			
			//System.out.println("This perm: \n\n");
			//printPerm(girls, guys, perm, girlsOrder);
			
			//guysOrder = perm
			//System.out.println("perm.length: " + perm.length + "\ngirlsOrder.length: " + girlsOrder.length);
			
			int tempScore = 0;
			int smaller = perm.length;
			if(girls.size() < smaller) smaller = girls.size();
				
			for(int i = 0; i < smaller; i++){
				//System.out.println("guys: " + perm[i] + "\ngirls: " + girlsOrder[i]);
				tempScore += calcScore(guys.get(perm[i]), girls.get(girlsOrder[i]));
			}
			
			if(tempScore > totalScore) totalScore = tempScore;
		}
		
		for(int i = 0; i < N; i++){
			if(!used[i]){
				used[i] = true;
				perm[p] = i;
				permute(p+1, used, perm, N, girls, guys);
				used[i] = false;
			}
		}
	}
	
	public static void printPerm(ArrayList<Person> girls, ArrayList<Person> guys, int [] perm, int [] girlOrder){
		System.out.println("perm.length: " + perm.length);
		//System.out.println("perm[0]: " + perm[0]);
		//System.out.println("perm[1]: " + perm[1]);
		
		for(int i = 0; i < perm.length; i++){
			System.out.println(guys.get(perm[i]).name + " paired with " + girls.get(girlOrder[i]).name);
			System.out.print(perm[i] + ", ");
		}
	}
	
	public static void printList(ArrayList<Person> list){
		for(int i = 0; i < list.size(); i++){
			list.get(i).printPerson();
		}
	}
	
	public static int getIndexPerson(char name, ArrayList<Person> list){
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).name == name) return i;
		}
		
		return -1;
	}
}

/*

12
fLJ
fLM
fTC
bTJ
gTM
JLf
MTf
JTb
MLb
MTg
CTf
CLb
4
ATa
ATb
aTA
bTA
6
ALa
CLa
CLb
aTA
aLC
bTC
0


*/
