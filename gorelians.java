import java.io.*;
import java.util.*;

/**
 * Write a description of class gorelians here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gorelians
{
    class point
    {
        public Integer distance;
        public boolean chosen;
        public int last;
        
        public point(int d, int source)
        {
            distance = new Integer(d);
            last = source;
            chosen = false;
        }
    }
    final static int MAXINT = 100000000;
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(new File("gorelians.in"));
        
        int height = in.nextInt();
        int width = in.nextInt();
        while(height != 0 && width != 0)
        {
            int [][] adj = new int[height][width];
                     
            height = in.nextInt();
            width = in.nextInt();
        }
    }
}