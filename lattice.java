package mercer2010;
import java.io.*;
import java.util.*;

class Point{
	public int x, y;
	
	public Point(int x, int y){
		this.x = x; this.y = y;
	}
	
	public int numLattice(Point p){
		int diffX = Math.abs(this.x - p.x);
		int diffY = Math.abs(this.y - p.y);
		
		return gcd(diffX, diffY) - 1;
	}
	
	public int gcd(int a, int b){
		return b == 0 ? a : gcd(b, a%b);
	}
}

public class lattice {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		Point[] pts = new Point[3];
		for(int i = 0; i < 3; i++)
			pts[i] = new Point(in.nextInt(), in.nextInt());
		
		while(!allZero(pts)){
			//get area
			int area = area(pts);
			
			//get num boundary points (starts with 3 vertices)
			int boundPts = 3;
			for(int i = 0; i < 3; i++)
				boundPts += pts[i].numLattice(pts[(i+1)%3]);
			
			//Pick's Thm: A = B/2 + I - 1
			System.out.println((area-boundPts+2)/2);
			
			//get next triangle
			for(int i = 0; i < 3; i++)
				pts[i] = new Point(in.nextInt(), in.nextInt());
		}
	}
	
	public static int area(Point[] pts){
		int area = 0;
		for(int i = 0; i < 3; i++){
			area += pts[i].x * pts[(i+1)%3].y - pts[i].y * pts[(i+1)%3].x;
		}
		
		return Math.abs(area);
	}
	
	public static boolean allZero(Point[] pts){
		for(int i = 0; i < 3; i++){
			if(pts[i].x == 0 && pts[i].y == 0) continue;
			else return false;
		}
		
		return true;
	}
}

/*

0 0 1 0 0 1 
0 0 5 0 0 5 
0 0 0 0 0 0 

*/
