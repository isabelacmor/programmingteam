import java.io.*;
import java.util.*;

/**
 * Write a description of class balloons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class balloons2
{
    public static void main (String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        int teams = -1; 
        int balloonsA, balloonsB; 
        
        int distTotal = 0;
        int temp;
       
        //store these in an array, sort them by the difference of the distance, then find total
        //from least to greatest       
      
       while(teams != 0)
       {
           teams = in.nextInt();
           balloonsA = in.nextInt();
           balloonsB = in.nextInt();
           
           /*** Exit without processing this case ***/
           if (teams == 0)
               break;
               
           /*** MOVE THIS HERE SO YOUR ARRAY SIZES ARE CORRECT ***/
           int [] bestDist = new int[teams];
           int [] neededBals = new int[teams];
           int [] distAs = new int [2*teams];
           int [] distBs = new int [2*teams];
           
           for(int i = 0; i < teams; i++)
           {
               neededBals[i] = in.nextInt();
               distAs[i] = in.nextInt();
               distBs[i] = in.nextInt();
               bestDist[i] = Math.abs(distAs[i]-distBs[i]);
           }  
           int times = teams*2;
           int temp2;
           while(times != 0)
           {
               for(int i = 0; i < teams-1; i++)
               {
                   if(bestDist[i] > bestDist[i+1]){}
                   else
                   {
                       //sorting distances
                       temp = bestDist[i];
                       bestDist[i] = bestDist[i+1];
                       bestDist[i+1] = temp;
                       
                       //rearraning balloons according to distance swap
                       temp = neededBals[i];
                       neededBals[i] = neededBals[i+1];
                       neededBals[i+1] = temp;
                       
                       //rearranging individual distances according to total distance swap
                       temp = distAs[i];
                       temp2 = distBs[i];
                       distAs[i] = distAs[i+1];
                       distBs[i] = distBs[i+1];
                       distAs[i+1] = temp;
                       distBs[i+1] = temp2;
                   }
               }
               times--;
           }
           
           for(int k = 0; k < teams; k++)
           {
               while(neededBals[k] != 0)
               {
                   if(distAs[k] > distBs[k] && balloonsB > 0) //when B is closer
                   {
                       distTotal+=distBs[k];
                       balloonsB--;
                   }
                   else if(distBs[k] > distAs[k] && balloonsA > 0) //when A is closer
                   {
                       distTotal+=distAs[k];
                       balloonsA--;
                   }
                   else if(balloonsB <= 0) //no more balloonsB
                   {
                       distTotal+=distAs[k];
                       balloonsA--;
                   }
                   else if(balloonsA <= 0) //no more balloonsA
                   {
                       distTotal+=distBs[k];
                       balloonsB--;
                   }
                   else if(distAs[k] == distBs[k] && balloonsA > 0)
                   {
                       distTotal+=distAs[k];
                       balloonsA--;
                   }
                   else if(distAs[k] == distBs[k] && balloonsA <= 0)
                   {
                       distTotal+=distBs[k];
                       balloonsB--;
                   }
                   else
                   {
                    System.out.println("Your distAs is: " + distAs[k] + "...distBs is: " + distBs[k] + "...your balloonsA is: " + balloonsA  + "...your balloonsB is: " + balloonsB + "...We can't add anything");
                   }
                   neededBals[k]--;
               }
           }
           
           System.out.println(distTotal);
           distTotal = 0;    
       }
    }
}