import java.io.*;
import java.util.*;

class Point{
	public int x, y;
	
	Point(int mX, int mY){
		x = mX;
		y = mY;
	}
	
	public String toString(){
		return ("(" + x + "," + y + ")");
	}
}

public class spiral {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++){
			int find = in.nextInt();
			
			Point p = solve(find);
			System.out.println(p);
		}
	}
	
	/*
	
		The trick is that the spiral is actually made of squares
		
		The format is that the value of the top right corner is
		the square of each next odd number. For example:
		
		-------------------...
		|               5^2|
		|   ------------   |
		|   |       3^2|   |
		|   |   -----  |   |
		|   |   |1^2|  |   |
		|   |   -----  |   |
		|   |          |   |
		|    ----------    |
		|                  |
		--------------------
	
	 */
	
	public static Point solve(int find){
		
		//base case of the center of the spiral
		if(find == 1) return new Point(0, 0);
		
		//this will be the highest number
		//add some tolerance because we'll most likely get an awkward decimal number
		int squareOdd = (int)(Math.sqrt(find)-1e-10);
		
		//guarantee it's odd
		if(squareOdd % 2 == 0) squareOdd--;
		
		//this will be the level square our number is in
		int overflow = (int)(find - Math.pow(squareOdd, 2) - 1);
		
		//this will be the side our number is on
		int level = overflow / (squareOdd + 1);
		int offY  = overflow - level*(squareOdd + 1); 
		
		//make the point
		
		//left
		if(level == 0){
			return new Point((-squareOdd/2 + offY), ((squareOdd + 1)/2));
		}
		//down
		else if(level == 1){
			return new Point((squareOdd+1)/2, (squareOdd+1)/2 - offY - 1);
		}
		//right
		else if(level == 2){
			return new Point((squareOdd+1)/2 - offY - 1, -(squareOdd+1) / 2);
		}
		//up
		else{
			return new Point(-(squareOdd+1)/2, -(squareOdd+1)/2 + offY + 1);
		}
	}
}

/*

 
7
2
3
7
17
24
830
765409
 
 
*/
