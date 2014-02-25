import java.io.*;
import java.util.*;
import java.math.*;

public class kissing {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++){
			int R = in.nextInt();
			int N = in.nextInt();
			
			double theta = Math.PI / N;
			double littleR = (R * Math.sin(theta)) / (Math.sin(theta) + 1);
			
			double areaLittleCircle = Math.PI * littleR * littleR;
			double areaBigCircle = Math.PI * R * R;
			double areaAllLittle = N * areaLittleCircle;
			
			double areaInnerTriangle = Math.cos(theta) * littleR * (R - littleR);
			double areaSector = ((Math.PI - 2 * theta)/2) * littleR * littleR;
			
			double areaBlue = (areaInnerTriangle - areaSector) * N;
			double areaGreen = areaBigCircle - areaAllLittle - areaBlue;
			
			System.out.printf("%.4f %.4f\n", areaBlue, areaGreen);
		}
	}
}

/*

8
8 4
1 5
5 4
9 5
5 5
6 4
8 4
2 4 
 
*/
