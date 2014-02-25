import java.io.*;
import java.util.*;

/**
 * Write a description of class flag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class flag
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of stars for your design.");
        int numStars = in.nextInt();
        System.out.println("Enter the number of rows for your design.");
        int numRows = in.nextInt();
        int numTotal = 0;
        
        //calculating number of stars in each even and odd row
        int numInOdd = numStars/numRows;
        int numInEven = numInOdd+1;
        
        //seeing if the total stars that should be printed equals the total stars we need
        //this is the requirement for being a valid design
        for(int i = 0; i < numRows; i++)
        {
            if(i % 2 == 0)
            {
                numTotal += numInEven;
            }
            else
            {
                numTotal += numInOdd;
            }
        }
        
        //algorithm for printing the stars
        //if the row number is even (it always starts with even), prints out the number of stars even rows should contain
        //if it's odd, do the same for odd, starting with the opposite orientation
        if(numTotal == numStars)
        {
            for(int i = 0; i < numRows; i++)
            {
                if(i % 2 == 0)
                {
                    for(int j = 0; j < numInEven; j++)
                    {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                else
                {
                    for(int k = 0; k < numInOdd; k++)
                    {
                        System.out.print(" *");
                    } 
                    System.out.println();
                }
            }
        }
        else{ System.out.println("Sorry, no star design fits your specification."); }
        
    }
}
