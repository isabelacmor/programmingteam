import java.io.*;
import java.util.*;

public class test021613 {
	public static class Triangle
	{
		LineSeg a, b, c;
		double x, y, z;
		
		Triangle(LineSeg a, LineSeg b, LineSeg c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		Triangle(double a, double b, double c)
		{
			x = a;
			y = b;
			z = c;
		}
		
		public static double calcArea(Triangle o)
		{
			double semiP = (LineSeg.calcLen(o.a) + LineSeg.calcLen(o.b) + LineSeg.calcLen(o.c))/2.0;
			double area = Math.sqrt(semiP*(semiP-LineSeg.calcLen(o.a))*(semiP-LineSeg.calcLen(o.b))*(semiP-LineSeg.calcLen(o.c)));
			return area;
		}
		
		public static double calcAreaLen(Triangle o)
		{
			double semiP = (o.x + o.y + o.z)/2.0;
			double area = Math.sqrt(semiP*(semiP-o.x)*(semiP-o.y)*(semiP-o.z));
			return area;
		}
		
		public static boolean isValid(Triangle o)
		{
			if((LineSeg.calcLen(o.a) >= LineSeg.calcLen(o.b) + LineSeg.calcLen(o.c)) || (LineSeg.calcLen(o.b) >= LineSeg.calcLen(o.a) + LineSeg.calcLen(o.c)) || (LineSeg.calcLen(o.c) >= LineSeg.calcLen(o.b) + LineSeg.calcLen(o.a)))
				return false;
			return true;
		}
		
		public static boolean isValidLen(Triangle o)
		{
			if(o.x >= o.y + o.z || o.y >= o.x + o.z || o.z >= o.y + o.x)
				return false;
			return true;
		}
		
	}
	
	public static class Point
	{
		int x, y;
		
		Point(int mX, int mY)
		{
			x = mX;
			y = mY;
		}
		
		//inclusive points
		public static boolean isPointInsideRectangle(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY, int pX, int pY)
		{
			return pX >= topLeftX && pX < bottomRightX && pY >= topLeftY && pY < bottomRightX; 
		}
	}
	public static class LineSeg
	{
		Point start, end;
		double len, slope;
		
		LineSeg(Point a, Point b)
		{
			start = a;
			end = b;
		}
		
		public static double calcLen(LineSeg o)
		{
			double len = Math.sqrt(Math.pow((o.start.x - o.end.x), 2) + Math.pow((o.start.y - o.end.y), 2));
			o.len = len;
			return len;
		}
		
		public static double calcLen(Point a, Point b)
		{
			double len = Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
			return len;
		}
		
		public static double calcSlope(LineSeg o)
		{
			if(o.start.x - o.end.x == 0) return -1; //no slope
			double slope = ((1.0)*o.start.y - o.end.y)/(o.start.x - o.end.x);
			o.slope = slope;
			return slope;
		}
		
		public static boolean isBetween(LineSeg o, Point a)
		{
			return calcLen(o.start, a) + calcLen(a, o.end) == calcLen(o.start, o.end);
		}
		
		public static boolean isBetween(int a, int b, int c)
		{
			return b > a ? c >= a && c <= b : c >= b && c <= a;
		}
		
		public static Point midpoint(LineSeg o)
		{
			return new Point((o.start.x+o.end.x)/2, (o.start.y+o.end.y)/2);
		}
		
		public static boolean isOn(LineSeg o, Point a)
		{
			return (o.start.x <= a.x || o.end.x <= a.x) && (a.x <= o.start.x || a.x <= o.end.x) && (o.start.y <= a.y || o.end.y <= a.y) && (a.y <= o.start.y || a.y <= o.end.y);
		}
		
		public static int sameSide(LineSeg o, LineSeg n)
		{
			int same = 0;
			double dx = (double)o.end.x-o.start.x;
			double dy = (double)o.end.y-o.start.y;
			double dx1 = (double)n.start.x-o.start.x;
			double dy1 = (double)n.start.y-o.start.y;
			double dx2 = (double)n.end.x-o.end.x;
			double dy2 = (double)n.end.y-o.end.y;
			
			double c1 = dx * dy1 - dy * dx1;
		    double c2 = dx * dy2 - dy * dx2;

		    if (c1 != 0 && c2 != 0)
		      same = c1 < 0 != c2 < 0 ? -1 : 1;
		    else if (dx == 0 && dx1 == 0 && dx2 == 0)
		      same = !isBetween (o.start.y, o.end.y, n.start.y) && !isBetween (o.start.y, o.end.y, n.end.y) ? 1 : 0;
		    else if (dy == 0 && dy1 == 0 && dy2 == 0)
		      same = !isBetween (o.start.x, o.end.x, n.start.x) && !isBetween (o.start.x, o.end.x, n.end.x) ? 1 : 0;

		    return same;
			
		}
		
		public static boolean intersect(LineSeg o, LineSeg n)
		{
			int s1 = sameSide(o, n);
			int s2 = sameSide(n, o);
			
			return s1 <= 0 && s2 <= 0;
		}
	}
	
	public static void main(String [] args)
	{
		LineSeg line = new LineSeg(new Point(-4, -10), new Point(0, 2));
		double len = LineSeg.calcLen(line);
		double slope = LineSeg.calcSlope(line);
		System.out.printf("(%d, %d) and (%d, %d)\ndistance btwn = %f\nslope = %f\n(%d, %d) in btwn = ", 1, 1, 5, 5, len, slope, 2, 1);
		System.out.println(LineSeg.isBetween(line, new Point(2, 1)));
		Point mid = LineSeg.midpoint(line);
		System.out.printf("midpoint is (%d, %d)\n", mid.x, mid.y);
		
		LineSeg line2 = new LineSeg(new Point(-4, -9), new Point(0, -1));
		System.out.printf("line (%d, %d) to (%d, %d) intersect? ", line2.start.x, line2.start.y, line2.end.x, line2.end.y);
		System.out.println(LineSeg.intersect(line, line2));
		
		Triangle tri = new Triangle(new LineSeg(new Point(0, 0), new Point(12, 0)), new LineSeg(new Point(24, 0), new Point(12, 26)), new LineSeg(new Point(12, 26), new Point(0, 0)));
		System.out.println("valid triangle? " + Triangle.isValid(tri) + "\narea: " + Triangle.calcArea(tri));
		
		Triangle tri2 = new Triangle(12.0, 14.0, 16.0);
		System.out.println("valid triangle? " + Triangle.isValidLen(tri2) + "\narea: " + Triangle.calcAreaLen(tri2));
		
		System.out.println("is point in rect? " + Point.isPointInsideRectangle(0, 0, 12, 12, 6, 6));
	}
}
