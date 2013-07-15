import java.io.*;
import java.util.*;

public class fDIV2new {
	public static void main(String [] args)
	{
		//Scanner in = new Scanner(new File("C:\\Users\\Isabella\\workspace\\JavaProjects\\src\\fDIV2SOL.in"));
				Scanner in = new Scanner(System.in);
				
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
					check = ""; //we start checking from the first letter in the first word
					
					for(int i = 0; i < left.length() && i < right.length(); i++)
					{
						//for cases where we've checked all the letters of the first word, meaning its smaller than the second
						if(left.length()-1 == i)
						{
							System.out.println(left);
							break;
						}
						
						//if the letters aren't the same
						if(left.charAt(i)!=right.charAt(i))
						{
							//we add the entire left string we've checked so far and then the next alphabetical letter
							check = left.substring(0, i) + (char)(left.charAt(i)+1);
							
							//now if we get to this point and the halfway point and the second word are the same
							if(right.equals(check))
							{
								//we start at the next index to find another letter to add to split the words
								int end = i+1;
								
								//now we need to check for the end case of Z...so we need to see where the last Z is if there is one in the first word
								//while the next index is less than the left and the left is currently Z
								while(end < left.length()-1 && left.charAt(end) == 'Z')
								{
									//go to the next position
									end++;
								}
								
								//if the entire end of left is Z, we just print out the left word, 
								//meaning there is no other word we could possibly make to split the two words in half
								if(end == left.length()-1)
								{
									System.out.println(left);
									break;
								}
								
								//else if there is another letter other than Z in the left word, we can add extra letters, 
								//so we add everything we've checked so far, and then the next alphabetical letter
								check = left.substring(0, end) + (char)(left.charAt(end)+1);
								System.out.println(check);
								break;
							}

							//if none of this happens, we have a normal word that's enough to split the two
							else
							{
								System.out.println(check);
								break;
							}
						}
					}			
					numNames = in.nextInt();
				}
	}
}