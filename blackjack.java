import java.io.*;
import java.util.*;

/**
 * Write a description of class lotto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class blackjack
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        String draw = in.nextLine();
        String [] drawString;
        int [] drawNum;
        ArrayList <Integer> playerHand = new ArrayList();
        ArrayList <Integer> dealerHand = new ArrayList();
        
        while(!draw.equals("JOKER"))
        {
            drawString = draw.split("");
            drawNum = new int[drawString.length];
            
            for(int i = 0; i < drawString.length; i++)
            {
                if(!drawString[i].equals("Q") && !drawString[i].equals("J") && !drawString[i].equals("K") && !drawString[i].equals("A"))
                {
                    drawNum[i] = Integer.parseInt(drawString[i]);
                }
                else if(drawString[i].equals("Q") || drawString[i].equals("K") || !drawString[i].equals("J"))
                {
                    drawNum[i] = 10;
                }
            }
            
            draw = in.nextLine();
        }
    }
}