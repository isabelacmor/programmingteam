import java.io.*;
import java.util.*;
/**
 * Write a description of class genetic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class genetic
{
    public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2001\\genetic.in");
        Scanner scanner = new Scanner(file);
        
        int cases = scanner.nextInt();
        int indexMutant;
        String empty, gene, newGene;
        
        while(cases != 0)
        {
            indexMutant = scanner.nextInt();
            empty = scanner.nextLine();
            gene = scanner.nextLine();
            
            if(gene.substring(indexMutant-1, indexMutant).equals("0") && indexMutant >= 2)
            {
                newGene = gene.substring(0, indexMutant-2) + "1" + gene.substring(indexMutant);
            }
            else if(gene.substring(indexMutant-1, indexMutant).equals("1") && indexMutant >= 2)
            {
                newGene = gene.substring(0, indexMutant-2) + "0" + gene.substring(indexMutant);
            }
            else if(gene.substring(indexMutant-1, indexMutant).equals("0") && indexMutant < 2)
            {
                newGene = gene.substring(0, indexMutant-1) + "1" + gene.substring(indexMutant);
            }
            else if(gene.substring(indexMutant-1, indexMutant).equals("1") && indexMutant < 2)
            {
                newGene = gene.substring(0, indexMutant-1) + "0" + gene.substring(indexMutant);
            }
            else
            {
                newGene = gene;
            }
            System.out.println(newGene + "\n");
            
            cases--;
        }
    }
}
