import java.io.*;
import java.util.*;

public class bullets {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++){
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			
			double distance = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
			
			System.out.println("Bullet shot from (" + x1 + ", " + y1 + ").");
			System.out.println("Bullet should hit CardinalBot at (" + x2 + ", " + y2 + ").");
			System.out.println("Distance to target: " + distance + ".");
			
			if(distance > 13) System.out.println("The bullet explodes.\n");
			else System.out.println("The bullet hits its target.\n");
		}
	}
}
