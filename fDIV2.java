import java.io.*;
import java.util.*;

public class fDIV2 {
	public static void main(String [] args) throws IOException
	{
		//Scanner in = new Scanner(new File("C:\\Users\\Isabella\\workspace\\JavaProjects\\src\\fDIV2SOL.in"));
		Scanner in = new Scanner(System.in);
		
		ArrayList<String> alpha = new ArrayList();
		alpha.add("A");
		alpha.add("B");
		alpha.add("C");
		alpha.add("D");
		alpha.add("E");
		alpha.add("F");
		alpha.add("G");
		alpha.add("H");
		alpha.add("I");
		alpha.add("J");
		alpha.add("K");
		alpha.add("L");
		alpha.add("M");
		alpha.add("N");
		alpha.add("O");
		alpha.add("P");
		alpha.add("Q");
		alpha.add("R");
		alpha.add("S");
		alpha.add("T");
		alpha.add("U");
		alpha.add("V");
		alpha.add("W");
		alpha.add("X");
		alpha.add("Y");
		alpha.add("Z");		
		
		int numNames = in.nextInt();
		while(numNames != 0)
		{
			//read in all the names
			String [] names = new String[numNames];
			for(int i = 0; i < numNames; i++)
			{
				names[i] = in.next();
			}
			
			Arrays.sort(names);
			
			String check = "";
			String left = "";
			String right = "";
			
			left = names[numNames/2 - 1];
			right = names[numNames/2];
			check = left.substring(0, 1); //we start checking from the first letter in the first word
			
			int i = 1;
			//System.out.println("right: " + (alpha.indexOf(right.substring(0, 1))-1) + " left: " + alpha.indexOf(left.substring(0, 1)));
			
			//if the two names don't even start with the same letter
			//we just return the next letter after the first letter of the first word
			if(!right.substring(0, 1).equals(check))
			{
				if(left.length() > right.length())
					System.out.println(left);
				else if(right.length() == 1 || left.length() == 1)
					System.out.println(alpha.get(alpha.indexOf(check)));
				else
					System.out.println(alpha.get(alpha.indexOf(check)+1));
			}			
			else
			{
				while((right.compareTo(check) > 0 && left.compareTo(check) > 0) || (right.compareTo(check) < 0 && left.compareTo(check) < 0))
				{
					//shouldn't need to check for the right being longer since the array is already in alphabetical order, but just in case...
					if((left.length() >= right.length() && i < left.length()) || (left.length() < right.length() && i < right.length()))
					{
						if(i < left.length() && i < right.length() && left.substring(i, i+1).equals(right.substring(i, i+1)))
						{
							check = check + "" + left.substring(i, i+1);
						}
						else if(i < left.length() && left.length() > right.length())
						{
							if(i >= right.length())
							{
								if((alpha.indexOf(left.substring(i, i+1)) == 25)) //then we are at Z
										check = check + "" + alpha.get(alpha.indexOf(left.substring(i, i+1)));
								else
								{	
									check = check + "" + alpha.get(alpha.indexOf(left.substring(i, i+1))+1);//left.substring(i, i+1);
								}
							}
							else if(i < right.length()-1 && !(alpha.get(alpha.indexOf(left.substring(i, i+1))).equals(right.substring(i, i+1))))
								check = check + "" + alpha.get(alpha.indexOf(left.substring(i, i+1))+1);//left.substring(i, i+1);
							else
								check = check + "" + left.substring(i, i+1);
						}
						else
						{
							check = check + "" + alpha.get(alpha.indexOf(left.substring(i, i+1))+1);
						}
						i++;
					}
				}
				System.out.println(check);
				//System.out.println("this case went to else");
			}			
			numNames = in.nextInt();
		}
	}
}