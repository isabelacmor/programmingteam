import java.io.*;
import java.util.*;
/**
 * Write a description of class playlist here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playlist
{
    public static void main (String [] args) throws IOException
    {
        File file = new File("C:\\Users\\Isabella\\Downloads\\solutionsData2002\\playlist.in");
        Scanner scanner = new Scanner(file);
        
        int times = scanner.nextInt();
        int numToPlay, totalSongs;
        String [] songs;
        String [] temp;
        String [] newSongs;
        String num;
        String empty;
        int count = 1;
        
        while(times != 0)
        {
            numToPlay = scanner.nextInt();
            totalSongs = scanner.nextInt();
            empty = scanner.nextLine();
           
            songs = new String [totalSongs];
            newSongs = new String [totalSongs];
            
            for(int i = 0; i < songs.length; i++)
            {
                songs[i] = scanner.nextLine();
                //System.out.println("SONGS: " + songs[i]);
            }
            for(int n = 0; n < songs.length; n++)
            {
                temp = songs[n].split(" ");
                num = temp[1] + " ";
                
                //System.out.println("TEMP: " + temp[0]);
                //System.out.println("NUM: " + num);
                
                newSongs[n] = num + temp[0];
                
                //System.out.println("NEW SONGS: " + newSongs[n]);
            }
            
            Arrays.sort(newSongs);
            for(int i = 0; i < newSongs.length; i++)
            {
                System.out.println("NEW SORTED SONGS: " + newSongs[i]);
            }
            
            int indexSongs = newSongs.length-1;
            System.out.println("Case #" + count + ":");
            
            String [] finalTemp;
            
            while(numToPlay != 0)
            {
                finalTemp = newSongs[indexSongs].split(" ");
                System.out.println(finalTemp[1]);
                indexSongs--;
                numToPlay--;
            }
            System.out.println();
            
            count++;
            times--;
        }
    }
}
