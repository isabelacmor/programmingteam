import java.util.*;
import java.io.*;
import java.awt.*;

public class lineIntersection {
	static boolean getLineLineIntersection(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4)
	{
		if (x1 == x2 && y1 == y2)
			return false;

		double intersectionX = det(det(x1, y1, x2, y2), x1 - x2,
				det(x3, y3, x4, y4), x3 - x4)/
				det(x1 - x2, y1 - y2, x3 - x4, y3 - y4);
		double intersectionY = det(det(x1, y1, x2, y2), y1 - y2,
				det(x3, y3, x4, y4), y3 - y4)/
				det(x1 - x2, y1 - y2, x3 - x4, y3 - y4);

		System.out.println(intersectionX + " "  + intersectionY);	
		
		return true;
	}

	static double det(double a, double b, double c, double d)
	{
		return a * d - b * c;
	}
	
	public static void main(String [] args)
	{
		getLineLineIntersection(15, 10, 50, 25, 35, 5, 30, 30);
	}
}
