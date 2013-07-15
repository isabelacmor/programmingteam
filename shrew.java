import java.io.*;
import java.util.*;

/**
 * Write a description of class shrew here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shrew
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        //initializing storage
        ArrayList <String> male = new ArrayList();
        ArrayList <String> female = new ArrayList();
        ArrayList <String> maleGene = new ArrayList();
        ArrayList <String> femaleGene = new ArrayList();
        ArrayList <String> childGene = new ArrayList();
        ArrayList <String> normalChild = new ArrayList();
        
        //pre-filling information
        String type = in.next();
        int currentRead1, currentRead2, currentRead3, currentRead4;
        String readString;
        while(!type.equals("X"))
        {
            //System.out.println("type: " + type);
            readString = in.nextLine().substring(1);
            //System.out.println("reading in gene: " + readString);
            if(type.equals("M"))
            {
                maleGene.add(readString);
            }
            else if(type.equals("F"))
            {
                femaleGene.add(readString);
            }
            else if(type.equals("C"))
            {
                childGene.add(readString);
            }
            
            type = in.next();
        }
        
        //printing current storage
        //System.out.println("maleGene: " + maleGene + "\nfemaleGene: " + femaleGene + "\nchildGene: " + childGene);
        
        //calculating what a normal child's genes should be
        //NOTE: maleGene.size() and femaleGene.size() are equal and
        //childGene.size() is exactly half that of the parent's arraylist size combined
        String currentMale, currentFemale;
        for(int i = 0; i < maleGene.size(); i++)
        {
            currentMale = maleGene.get(i);
            currentFemale = femaleGene.get(i);
            normalChild.add("0000");
            for(int j = 0; j < 4; j++)
            {
                //System.out.println("Comparing " + currentMale.substring(j, j+1) + " and " + currentFemale.substring(j, j+1));
                if(currentMale.substring(j, j+1).equals("0") && currentFemale.substring(j, j+1).equals("0"))
                {
                    //normalChild.get(i).replace(normalChild.get(i).charAt(j), '0');
                    normalChild.set(i, (  normalChild.get(i).substring(0, j)+"0"+normalChild.get(i).substring(j+1)  ));
                    //System.out.println("first if");
                }
                else if(currentMale.substring(j, j+1).equals("1") || currentFemale.substring(j, j+1).equals("1"))
                {
                    //normalChild.get(i).replace(normalChild.get(i).charAt(j), '1');
                    normalChild.set(i, (  normalChild.get(i).substring(0, j)+"1"+normalChild.get(i).substring(j+1)  ));
                    //System.out.println("second if");
                }
            }
        }
        
        //System.out.println("normalChild: " + normalChild);
        
        //comparing differences in normal child vs real child
        int countDif = 0;
        for(int j = 0; j < childGene.size(); j++)
        {
            countDif = 0;
            for(int i = 0; i < 4; i++)
            {
                if(normalChild.get(j).substring(i, i+1).equals(childGene.get(j).substring(i, i+1)))
                {
                    
                }
                else{ countDif++; }
            }
            System.out.println("Child " + (j+1) + " has a minimum of " + countDif + " mutations.");
        }
    }
}