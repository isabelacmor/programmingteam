import java.io.*;
import java.util.*;

/**
 * Write a description of class dance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dance
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        String [] danceMovesAr;
        ArrayList <String> danceMoves = new ArrayList();
        boolean [] rules; //false = rule not broken
        
        while(in.hasNextLine())
        {
            rules = new boolean [] {false, false, false, false, false};
            String line = in.nextLine().toLowerCase();
            danceMovesAr = line.split(" ");
            Collections.addAll(danceMoves, danceMovesAr);
            int aLSize = danceMoves.size();
            
            if(danceMoves.get(0).equalsIgnoreCase("jiggle"))
            {
               rules[3] = true;
            }
            if(aLSize > 3 && danceMoves.get(aLSize-3).equalsIgnoreCase("clap") && danceMoves.get(aLSize-2).equalsIgnoreCase("stomp") && danceMoves.get(aLSize-1).equalsIgnoreCase("clap"))
            {
                
            }
            else{ rules[1] = true; }
            if(!danceMoves.contains("dip")){ rules[4] = true; }
            if(danceMoves.contains("twirl") && !danceMoves.contains("hop")){ rules[2] = true; }
            
            //checking for jiggle or twirl with dip
            for(int i = 0; i < aLSize; i++)
            {
                if(!danceMoves.get(i).equals("dip")) {}
                //if dip is in the end and doesn't have a jiggle (a twirl here would be impossible)
                else if(i == aLSize-1 && aLSize > 1 && danceMoves.get(i).equals("dip") && !((danceMoves.get(i-1).equals("jiggle") || danceMoves.get(i-2).equals("jiggle"))))
                {
                    rules[0] = true;
                    danceMoves.set(i, "DIP");
                }
                //if dip is second to last and doesn't have a twirl or jiggle
                else if(i == aLSize-2 && danceMoves.get(i).equals("dip") && !((danceMoves.get(i-1).equals("jiggle") || danceMoves.get(i-2).equals("jiggle") || danceMoves.get(i+1).equals("twirl"))))
                {
                    rules[0] = true;
                    danceMoves.set(i, "DIP");
                }
                else if(i == 0 && aLSize > 1 && danceMoves.get(i).equals("dip") && (danceMoves.get(i+1).equals("twirl") || danceMoves.get(i+2).equals("twirl"))){}
                //i ==1 so we're not out of bounds //and we're okay
                else if(i == 1 && danceMoves.get(i).equals("dip") && (danceMoves.get(i-1).equals("jiggle") || danceMoves.get(i+1).equals("twirl") || danceMoves.get(i+2).equals("twirl"))) {}
                else if(i >= 2 && danceMoves.get(i).equals("dip") && (danceMoves.get(i-1).equals("jiggle") || danceMoves.get(i-2).equals("jiggle") || danceMoves.get(i+1).equals("twirl") || danceMoves.get(i+2).equals("twirl"))) {} //any i >= 2 is in bounds for this test //and we're okay
                else
                {
                    rules[0] = true;
                    danceMoves.set(i, "DIP");
                }
            }
            
            //all printing           
            System.out.print("form");
            if(rules[0] == false && rules[1] == false && rules[2] == false && rules[3] == false && rules[4] == false)
            {
                System.out.print(" ok: ");
            }
            
            int countBroken = 0;
            for(int i = 0; i < rules.length; i++)
            {
                if(rules[i] == true){ countBroken++; }
            }          
            
            int counterPos = 0;
            if(countBroken == 1)
            {
                for(int i = 0; i < rules.length; i++)
                {
                    if(rules[i] == true)
                    {
                        System.out.print(" error " + (i+1) + ": ");
                        break;
                    }
                }
            }
            else if(countBroken != 0)
            {
                System.out.print(" errors ");
                while(countBroken != 0)
                {
                    if(rules[counterPos] == true && countBroken != 1 && countBroken != 2) //so we know when to print "and"
                    {
                        System.out.print((counterPos+1) + ", ");
                        countBroken--;
                    }
                    else if(rules[counterPos] == true && countBroken == 2)
                    {
                        System.out.print(counterPos+1);
                        countBroken--;
                    }
                    else if(rules[counterPos] == true && countBroken == 1)
                    {
                        System.out.print(" and " + (counterPos+1) + ": ");
                        countBroken--;
                    }
                
                    counterPos++;
                }
            }
            
            //print the actual dance moves
            for(int i = 0; i < aLSize-1; i++)
            {
                System.out.print(danceMoves.get(i) + " ");
            }
            System.out.println(danceMoves.get(aLSize-1));
            
            danceMoves = new ArrayList();
        }
    }
}