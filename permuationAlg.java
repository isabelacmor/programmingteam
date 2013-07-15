
/**
 * Write a description of class permuationAlg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class permuationAlg
{
   public static void main(String [] args)
   {
       int [] values = {1, 2, 3, 4, 5, 6};
       int len = values.length;
       int [] perm = new int[len];
       boolean [] used = new boolean[len];
       int totalSum = 10;
       
       permute(0, values, len, perm, used, totalSum);
   }
   
   public static void permute(int ind, int [] values, int len, int [] perm, boolean [] used, int totalSum)
   {
       if(ind == len)
       {
           for(int k = 0; k < len; k++)
           {
               System.out.print(perm[k]);
           }
           System.out.println();
       }
       
       for(int i = 0; i < len; i++)
       {
           if(!used[i] && values[i] <= totalSum)
           {
               perm[ind] = values[i];
               System.out.print(perm[ind]);
               used[i] = true;
               totalSum-=values[i];
               permute(ind+1, values, len, perm, used, totalSum);
               //totalSum = 10;
               used[i] = false;
           }
       }
       //System.out.println();
   }
}