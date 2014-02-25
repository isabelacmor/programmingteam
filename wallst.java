import java.util.*;
import java.io.*;

public class wallst
{
	public static void main(String [] args)throws IOException
	{
		Scanner in = new Scanner(new File("wallst.in"));
		ArrayList <Integer> lengths = new ArrayList();
		ArrayList <Integer> widths = new ArrayList();
		ArrayList <Integer> allNums = new ArrayList();
		
		int runs = in.nextInt();
		String blank = in.nextLine();
		int set = 1;
		int lots;
		
		while(runs != 0)
		{
			lots = in.nextInt();
			if(lots == 2)
			{
				int chooseLot1;
				int chooseLot2;
				int d1l1 = in.nextInt();
				int d2l1 = in.nextInt();
				int d1l2 = in.nextInt();
				int d2l2 = in.nextInt();
				if(d1l1 > d2l1){ chooseLot1 = d2l1;}
				else{chooseLot1 = d1l1;}
				if(d2l1 < d2l2){ chooseLot2 = d2l2;}
				else{chooseLot2 = d1l2;}
				
				System.out.println("LOT1 is " + chooseLot1);
				System.out.println("LOT2 is " + chooseLot2);
			
				int mult = chooseLot2*chooseLot1;
			
				System.out.println("The minimum cost for lot #" + set + " is $" + (100*mult) + ".");
			}
			else
			{
				//adding all values to a single ArrayList, the immediately splitting lengths and widths into separate respective ArrayLists
				for(int i = 0; i < lots*2; i++)
				{
					allNums.add(in.nextInt());
					if(i%2==0)
					{
						lengths.add(allNums.get(i));
					}
					else
					{
						widths.add(allNums.get(i));
					}
				}
				
				//find smallest length in first ArrayList
				int tempOne, tempTwo;
				int pTO, pTT;
				for(int i = 0; i <lengths.size()-1; i++)
				{
					if(lengths.get(i) > lengths.get(i+1))
					{
						tempOne = lengths.get(i);
						tempTwo = lengths.get(i+1);
						lengths.remove(i);
						lengths.add(i+1, tempOne);
						
						pTO = widths.get(i);
						pTT = widths.get(i+1);
						widths.remove(i);
						widths.add(i+1, pTO);
					}
				}
				System.out.println(lengths + " : " + widths);	
				System.out.println("The minimum cost for lot #" + set + " is $" + (100*lengths.get(0)*widths.get(0)));
			}			
					
			//refreshing ArrayLists and decrementing cases
			allNums = new ArrayList();
			lengths = new ArrayList();
			widths = new ArrayList();
			set++;
			runs--;
		}
		
	}
}