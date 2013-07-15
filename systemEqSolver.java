import java.io.*;
import java.util.*;

public class systemEqSolver {
	public static void main(String[] args) {

	      Scanner input = new Scanner(System.in);
	      
	      //Test numbers 9.0 4.0 3.0 -5.0 -6.0 -21.0
	      System.out.print("Enter a, b, c, d, e, f: ");
	      double a = input.nextDouble();
	      double b = input.nextDouble();
	      double c = input.nextDouble();
	      double d = input.nextDouble();
	      double e = input.nextDouble();
	      double f = input.nextDouble();

	      double determinant = (a * e) - (b * d);
	      if (determinant == 0) {
	         System.out.println("The equation has no solution");
	      } 
	      else {
	         double x = ((c * e) - (b * f)) / determinant;
	         double y = ((a * f) - (d * c)) / determinant;
	         System.out.println("x is " + x + " and " + "y is " + y);
	      }
	   }

	}