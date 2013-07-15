import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class points {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++)
		{
			int numPoints = in.nextInt();
			int [] x = new int[numPoints];
			int [] y = new int[numPoints];
			
			for(int j = 0; j < numPoints; j++)
			{
				int tx = in.nextInt();
				int ty = in.nextInt();
				
				x[j] = tx;
				y[j] = ty;
			}
			
			Polygon poly = new Polygon(x, y, numPoints);
			
			int pX = in.nextInt();
			int pY = in.nextInt();
			
			if(onBound(x, y, pX, pY)) System.out.println("BOUNDARY");
			//only interior
			else if(poly.contains(pX, pY)) System.out.println("INTERIOR");
			//could be exterior or boundary
			else
			{
				/*if(onBound(x, y, pX, pY)) System.out.println("BOUNDARY");
				else*/ System.out.println("EXTERIOR");
			}
		}
	}
	
	public static boolean onBound(int [] x, int [] y, int pX, int pY)
	{
		for(int i = 0; i < x.length-1; i++)
		{
			if(Line2D.ptSegDist(x[i], y[i], x[i+1], y[i+1], pX, pY) == 0) return true;
		}
		if(Line2D.ptSegDist(x[0], y[0], x[x.length-1], y[x.length-1], pX, pY) == 0) return true;
		else return false;
	}
}

/*

used test data from: http://topcoder.bgcoder.com/print.php?id=550
passed all cases

 */
