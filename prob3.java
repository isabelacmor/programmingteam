import java.io.*;
import java.util.*;

public class prob3 {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("C:\\Users\\Isabella\\Downloads\\MercerSpringContest2010DataFiles\\MercerSpringContestDataFiles\\stats.in"));
		
		
		List<String> words = new ArrayList();
		
		/*
		while(in.hasNextLine())
		{
			String line = in.nextLine();
			String [] word = line.split(" ");
			for(int i = 0; i < word.length; i++)
			{
				words.add(word[i]);
			}
		}
		*/
		
		while(in.hasNext())
		{
			String word = in.next();
			word = word.toLowerCase();
			word = word.replaceAll(",", "");
			word = word.replaceAll("\\.", "");
			word = word.replaceAll("\\?", "");
			word = word.replaceAll("!", "");
			word = word.replaceAll(";", "");
			word = word.replaceAll(":", "");
			word = word.replaceAll("-", "");
			word = word.replaceAll("@", "");
			word = word.replaceAll("#", "");
			word = word.replaceAll("$", "");
			word = word.replaceAll("%", "");
			word = word.replaceAll("^", "");
			word = word.replaceAll("&", "");
			word = word.replaceAll("\\*", "");
			word = word.replaceAll("\\(", "");
			word = word.replaceAll("\\)", "");
			word = word.replaceAll("1", "");
			word = word.replaceAll("2", "");
			word = word.replaceAll("3", "");
			word = word.replaceAll("4", "");
			word = word.replaceAll("5", "");
			word = word.replaceAll("6", "");
			word = word.replaceAll("7", "");
			word = word.replaceAll("8", "");
			word = word.replaceAll("9", "");
			word = word.replaceAll("0", "");
			words.add(word);
		}
		
		Collections.sort(words);
				
		//print median
		if(words.size() % 2 == 0)
		{
			System.out.println("My median=[" + words.get((words.size()/2)-1) + "," + words.get((words.size()/2)) + "]");
		}
		else
			System.out.println("My median=[" + words.get(words.size()/2) + "]");
				
		//calculate mode
		calcMode(words);
	}
	
	public static void calcMode(List<String> words)
	{		
		ArrayList<String> wordCheck = new ArrayList();
		ArrayList<Integer> wordFreq = new ArrayList();
		ArrayList<String> wordMode = new ArrayList();
		
		for(int i = 0; i < words.size(); i++)
		{
			if(!(wordCheck.contains(words.get(i))))
			{
				wordCheck.add(words.get(i));
				wordFreq.add(1);
			}
			else
			{
				int index = wordCheck.indexOf(words.get(i));
				int val = wordFreq.get(index);
				wordFreq.set(index, val+1);
			}
		}
		
		//find biggest repetition
		int curBig = 0;
		for(int i = 0; i < wordFreq.size(); i++)
		{
			if(wordFreq.get(i) > curBig)
			{
				curBig = wordFreq.get(i);
			}
		}
		
		//add all words repeated that many times
		for(int i = 0; i < wordFreq.size(); i++)
		{
			if(wordFreq.get(i) == curBig)
			{
				wordMode.add(wordCheck.get(i));
			}
		}
		
		//print
		System.out.print("My mode=[");
		if(wordMode.size() == 1)
			System.out.print(wordMode.get(0) + "(" + curBig + ")]");
		else
		{
			for(int i = 0; i < wordMode.size()-1; i++)
			{
				System.out.print(wordMode.get(i) + "(" + curBig + "),");
			}
			System.out.print(wordMode.get(wordMode.size()) + "(" + curBig + ")]");
		}
	}
}