import java.io.*;
import java.util.*;

public class test {
	public static class LineSeg
	{
		int x1, y1, x2, y2;
		double length;
		 	LineSeg(int mX1, int mY1, int mX2, int mY2)
		{
			x1 = mX1, y1 = mY1, x2 = mX2, y2 = mY2;
		}
		
		public static double calcLen()
		{
			double len = Math.sqrt(Math.pow((this.x2 - this.x1), 2) + Math.pow((this.y2 - this.y1), 2));
		}
	}
	
    public static void main( String[ ] args ) 
    {
        printCombinations( combinations( new String[ ] { "A", "B", "C" } ) );
        LineSeg line = new LineSeg();
    }
}