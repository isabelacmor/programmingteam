import java.io.*;
import java.util.*;

public class eDIV2 {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int numApts = in.nextInt();
		int widthRoom = in.nextInt();
		int lengthRoom = in.nextInt();
		int heightRoom = in.nextInt();
		int area = in.nextInt();
		int numWD = in.nextInt();
		
		while(!(numApts == 0 && widthRoom == 0 && lengthRoom == 0 && heightRoom == 0 && area == 0 && numWD == 0))
		{
			double surfaceArea = 2*widthRoom*heightRoom + 2*heightRoom*lengthRoom + widthRoom*lengthRoom;
			
			for(int i = 0; i < numWD; i++)
			{
				int widthWD = in.nextInt();
				int heightWD = in.nextInt();
				surfaceArea -= widthWD*heightWD;
			}
			
			surfaceArea *= numApts;
			
			double cansNeeded = surfaceArea/area;
			float ans = (float)(Math.ceil(cansNeeded));
					
			System.out.println((int)ans);
		
			
			
			numApts = in.nextInt();
			widthRoom = in.nextInt();
			lengthRoom = in.nextInt();
			heightRoom = in.nextInt();
			area = in.nextInt();
			numWD = in.nextInt();
		}
	}
}