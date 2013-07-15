import java.io.*;
import java.util.*;

public class unitpyramid {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		//precompute total cubes needed for each unit pyramid
		//go up until first biggest
		//if numCubes < n^2 (biggest base, which is the index squared), then we know we have an incomplete base
		//I'll store the number of cubes on each level in an AL
		
		//total cubes needed for an nxn cube
		int [] total = new int[1500];
		total[0] = 0;
		total[1] = 1;
		for(int i = 2; i < 1500; i++)
		{
			total[i] = total[i-1] + i*i;
		}
		
		//perfect squares
		int [] power = new int[1500];
		for(int i = 0; i < 1500; i++)
		{
			power[i] = i*i;
		}
		
		ArrayList<Integer> powerAL = new ArrayList(Arrays.asList(power));
		
		int numCases = in.nextInt();
		while(numCases != 0)
		{
			int numCubes = in.nextInt();
			//bases of unit pyramid
			ArrayList <Integer> bases = new ArrayList();
			
			int startInd = itSearch(total, numCubes);
			int startOrg = startInd;
			//System.out.println("Start index: " + startInd + " \tpower: " + power[startInd]);
			int availCubes = numCubes;
			while(availCubes > 0)
			{
				//System.out.println("we have " + availCubes + " cubes left");
				if(availCubes >= power[startInd])
				{
					//System.out.println("used part: " + power[startInd]);
					bases.add(power[startInd]);
					availCubes -= power[startInd];
					startInd--;
					//System.out.println("we now have " + availCubes + " left");
				}
				else
				{
					//System.out.println("used all");
					bases.add(availCubes);
					availCubes = 0;
				}
			}
			
			//System.out.println(bases);
			
			int sa = 0;
			//System.out.println("adding the top and bottom of base size: " + bases.get(0) + " = " +  bases.get(0)*2);
			//add the top and bottom
			sa += bases.get(0)*2;
			//add the wrap arounds
			for(int i = 0; i < bases.size()-1; i++)
			{	
				//System.out.println("startOrg: " + (startOrg) + " ---- " + power[startOrg]);
					//System.out.println("full row of base size " + bases.get(i) + " ; adding: " + startOrg*4);
					sa += startOrg*4;
					startOrg--;
				/*
				//wrap around...
				//if we have at least one row
				System.out.println("startOrg: " + (startOrg-i));
				if(bases.get(i) >= power[startOrg+i])
				{
					System.out.println("adding the wrap around of base size: " + bases.get(i) + " = " +  bases.get(i));
					sa += bases.get(i);// + Math.ceil(bases.get(i) / power[startOrg+i]);
				}
				//if we don't have at least one row
				else
				{
					System.out.println("adding the N/S of base size : " + bases.get(i) + " = " + (float)Math.ceil(bases.get(i)/(double)power[startOrg-i]));
					sa += ((float)Math.ceil(bases.get(i)/(double)power[startOrg-i]))*2;
					System.out.println("adding the E/W of base size : " + bases.get(i) + " = " + (bases.get(i) - Math.ceil(bases.get(i)/(double)power[startOrg-i])));
					sa += (bases.get(i) - Math.ceil(bases.get(i)/(double)power[startOrg-i]))*2;
				}*/
				//System.out.println("total SA so far is: " + sa);
				
			}
			
			//System.out.println("startOrg: " + (startOrg));
			//if this is a complete level
			if(bases.get(bases.size()-1) == power[startOrg])
			{
				//System.out.println("complete level: " + (sa+startOrg*4));
				sa += startOrg*4;
			}
			//else if we have at least one row
			else if(bases.get(bases.size()-1) >= startOrg)
			{
				double rows = Math.ceil(bases.get(bases.size()-1) / (double)startOrg);
				//System.out.println("adding the wrap around of base size: " + bases.get(bases.size()-1) + " = " + rows + " cols: " + startOrg*2);
				sa += rows*2 + startOrg*2;
			}
			//if we don't have at least one row
			//never comes here?
			else
			{
				//System.out.println("adding the N/S of base size : " + bases.get(bases.size()-1) + " = " + bases.get(bases.size()-1));
				//System.out.println("adding the E/W of base size : " + bases.get(bases.size()-1) + " = " + 2);
				sa += bases.get(bases.size()-1)*2 + 2;
			}
			System.out.println(sa);
			
			numCases--;
		}
	}
	
	public static int itSearch(int [] total, int numCubes)
	{
		int max = 0;
		for(int i = 0; i < total.length; i++)
		{
			if(total[i] < numCubes) max = i;
			else if(total[i] == numCubes) return max = i;
			else return max = i;
		}
		return max;
	}
}
