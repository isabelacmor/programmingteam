import java.io.*;
import java.util.*;

public class scrabble {
	public static class Sets implements Comparable<Sets>
	{
		String word;
		int score;
		
		Sets(String w, int s)
		{
			word = w;
			score = s;
		}

		public int compareTo(Sets o) {
			// TODO Auto-generated method stub
			if(this.score > o.score) return -1;
			else if(this.score < o.score) return 1;
			else if(this.score == o.score) return this.word.compareTo(o.word);
			else return 0;
		}
	}
	
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("/Users/isabella/Downloads/solutionsData2013Online/scrabble.in"));
		
		ArrayList<Sets> alpha = new ArrayList();
		alpha = setupA(alpha);
		
		int numDict = in.nextInt();
		ArrayList<String> dict = new ArrayList();
		for(int i = 0; i < numDict; i++)
		{
			dict.add(in.next());
		}
		
		ArrayList<Sets> dictScores = new ArrayList();
		dictScores = setupWords(dictScores, dict, alpha);
		
		Collections.sort(dictScores);
		
		int numRacks = in.nextInt();
		String blank = in.nextLine();
		for(int i = 1; i <= numRacks; i++)
		{
			String tiles = in.nextLine();
			String [] tilesA = tiles.split("");
			ArrayList<String> tilesAL = new ArrayList(Arrays.asList(tilesA));
			//System.out.println(tilesAL);
			
			
			System.out.print("Tile Rack #" + i + ": ");
			solve(dictScores, tilesAL);
			//solve2(dictScores, tilesAL);
			System.out.println();
			System.out.println();
		}
	}
	
	public static void solve2(ArrayList<Sets> dictScores, ArrayList<String> tilesAL)
	{
		int [] freqTiles = freqCalc(tilesAL);
		for(int i = 0; i < dictScores.size(); i++)
		{
			int [] freqWord = freqCalc(dictScores.get(i).word);
			if(freqEq(freqTiles, freqWord))
			{
				System.out.print("Playing " + dictScores.get(i).word + " earns " + dictScores.get(i).score + " points, the max possible.");
				break;
			}
		}
	}
	
	public static boolean freqEq(int [] f1, int [] f2)
	{
		//f1 is the tiles
		for(int i = 0; i < f1.length; i++)
		{
			if(f1[i] >= f2[i]) continue;
			else return false;
		}
		
		return true;
	}
	
	public static int[] freqCalc(String word)
	{
		int [] freq = new int [26];
		for(int i = 0; i < 26; i++)
		{
			freq[i] = 0;
		}
		
		for(int i = 0; i < word.length()-1; i++)
		{
			freq[letterVal(word.substring(i, i+1))]++;
		}
		
		return freq;
	}
	
	public static int[] freqCalc(ArrayList<String> word)
	{
		int [] freq = new int [26];
		for(int i = 0; i < 26; i++)
		{
			freq[i] = 0;
		}
		
		for(int i = 0; i < word.size(); i++)
		{
			if(word.get(i).equals("") || word.get(i).equals(null)){}
			else{int index = letterVal(word.get(i));
			int two = 2;
			freq[index]++;}
		}
		
		return freq;
	}
	
	public static void solve(ArrayList<Sets> dictScores, ArrayList<String> tilesAL)
	{
		ArrayList<String> copyTiles = new ArrayList();
		for(int i = 0; i < tilesAL.size(); i++)
		{
			copyTiles.add(tilesAL.get(i));
		}
		
		//System.out.println(copyTiles);
		
		boolean solved = true;
		int solvedInd = 0;
		for(int i = 0; i < dictScores.size(); i++)
		{
			solved = true;
			solvedInd = i;
			int lenReach = dictScores.get(i).word.length();
			int lenFound = 0;
			
			copyTiles = new ArrayList();
			for(int K = 0; K < tilesAL.size(); K++)
			{
				copyTiles.add(tilesAL.get(K));
			}
			
			for(int j = 0; j < dictScores.get(i).word.length(); j++)
			{
				if(copyTiles.contains(dictScores.get(i).word.substring(j, j+1)))
				{
					copyTiles.set(copyTiles.indexOf(dictScores.get(i).word.substring(j, j+1)), "#");
					//System.out.println(copyTiles + " for word " + dictScores.get(i).word);
					lenFound++;
				}
				else
				{
					solved = false;
					break;
				}
			}
			
			if(lenFound == lenReach)
			{
				//System.out.println("LEN equal at word " + dictScores.get(solvedInd).word);
				break;
			}
		}
		
		System.out.print("Playing " + dictScores.get(solvedInd).word + " earns " + dictScores.get(solvedInd).score + " points, the max possible.");
	}
	
	public static ArrayList setupA(ArrayList<Sets> alpha)
	{
		alpha.add(new Sets("A", 1));
		alpha.add(new Sets("B", 3));
		alpha.add(new Sets("C", 3));
		alpha.add(new Sets("D", 2));
		alpha.add(new Sets("E", 1));
		alpha.add(new Sets("F", 4));
		alpha.add(new Sets("G", 2));
		alpha.add(new Sets("H", 4));
		alpha.add(new Sets("I", 1));
		alpha.add(new Sets("J", 8));
		alpha.add(new Sets("K", 5));
		alpha.add(new Sets("L", 1));
		alpha.add(new Sets("M", 3));
		alpha.add(new Sets("N", 1));
		alpha.add(new Sets("O", 1));
		alpha.add(new Sets("P", 3));
		alpha.add(new Sets("Q", 10));
		alpha.add(new Sets("R", 1));
		alpha.add(new Sets("S", 1));
		alpha.add(new Sets("T", 1));
		alpha.add(new Sets("U", 1));
		alpha.add(new Sets("V", 4));
		alpha.add(new Sets("W", 4));
		alpha.add(new Sets("X", 8));
		alpha.add(new Sets("Y", 4));
		alpha.add(new Sets("Z", 10));
		
		return alpha;
	}
	
	public static int letterVal(String letter)
	{
		return letter.charAt(0) - 1 - 64;
	}
	
	public static ArrayList setupWords(ArrayList<Sets> dictScores, ArrayList<String> dict, ArrayList<Sets> alpha)
	{
		int score;
		for(int i = 0; i < dict.size(); i++)
		{
			score = 0;
			for(int j = 0; j < dict.get(i).length(); j++)
			{
				String letter = dict.get(i).substring(j, j+1);
				int alphaIndex = letterVal(letter);
				score += (alpha.get(alphaIndex).score);
			}
			dictScores.add(new Sets(dict.get(i), new Integer(score)));
		}
		
		return dictScores;
	}
	
	
}