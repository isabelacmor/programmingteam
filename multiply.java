
/* Grade School Multiplication, MCPC 2011 Problem A, Java solution by Andy Harrington */
import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class multiply {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        
        int x = in.nextInt();	//first number to multiply
        int probNum = 1;
        
        while (x > 0) {
            System.out.println("Problem " + probNum);
            
            long y = in.nextInt();	//second number to multiply
            
            String ans = "" + x*y;
            int n = ans.length();
            
            String fstr = "%"+n+"s%n";  
            System.out.format(fstr, x);
            System.out.format(fstr, y);
            System.out.println(rep('-', n));
            
            int len = n, lines = 0, zeroes = 0; 
            
            while (y > 0) {
                long dig = y % 10;	//the single end digit
                //zero
                if (dig == 0){
                    zeroes++;
                }
                //digit
                else {
                    System.out.format("%"+len+"s" , x*dig);
                    System.out.println(rep('0', zeroes));
                    zeroes= 0;
                    lines++;
                }
                len--;
                y /= 10;
            }

            //don't want duplicate separator for a one-line solution
            if (lines > 1) {
                System.out.println(rep('-', n));
                System.out.println(ans);
            }
            
            probNum++;
            x = in.nextInt();
        }
    }
    
    public static String rep(char ch, int n) {
        String separator = "";
        for (int i = n; i > 0; i--)
            separator += ch;
        return separator;
    }
}

/*

432 5678
200001 90040
246 70
0 0

*/