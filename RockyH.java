import java.io.*;
import java.util.*;

public class RockyH {
	
	//letter
	public static final int LETTER_MIN_LEN = 125;
	public static final int LETTER_MAX_LEN = 290;
	
	public static final int LETTER_MIN_HEI = 90;
	public static final int LETTER_MAX_HEI = 155;
	
	public static final double LETTER_MIN_THI = 0.25;
	public static final double LETTER_MAX_THI = 7.00;
	
	//package
	public static final int PACK_MIN_LEN = LETTER_MAX_LEN;
	public static final int PACK_MAX_LEN = 380;
	
	public static final int PACK_MIN_HEI = LETTER_MAX_HEI;
	public static final int PACK_MAX_HEI = 300;
	
	public static final double PACK_MIN_THI = LETTER_MAX_THI;
	public static final double PACK_MAX_THI = 50;
	
	//parcel
	public static final int PARC_MIN_LEN = PACK_MAX_LEN;
		
	public static final int PARC_MIN_HEI = PACK_MAX_HEI;
		
	public static final double PARC_MIN_THI = PACK_MAX_THI;
	
	
	//main
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		double one = in.nextDouble();
		double two = in.nextDouble();
		double three = in.nextDouble();
		
		while(one != 0 && two != 0 && three != 0)
		{
			ArrayList<Double> dim = new ArrayList();
			dim.add(one);
			dim.add(two);
			dim.add(three);
			
			//stores in order:
			//thickness?, height?, length
			Collections.sort(dim);
			
			//not mailable
			if(dim.get(0) < LETTER_MIN_THI || dim.get(1) < LETTER_MIN_HEI || dim.get(2) < LETTER_MIN_LEN)
				System.out.println("not mailable");

			//minimum requirements
			else if(dim.get(2) >= LETTER_MIN_LEN)
			{
				//considering letter length
				//0 as thickness
				//1 as height
				if(dim.get(2) < LETTER_MAX_LEN)
				{
					if(dim.get(0) < LETTER_MAX_THI && dim.get(0) >= LETTER_MIN_THI && dim.get(1) < LETTER_MAX_HEI && dim.get(1) >= LETTER_MIN_HEI)
					{
						System.out.println("letter");
					}
					else if(dim.get(1) < LETTER_MAX_THI && dim.get(1) >= LETTER_MIN_THI && dim.get(0) < LETTER_MAX_HEI && dim.get(0) >= LETTER_MIN_HEI)
					{
						System.out.println("letter");
					}
				}
				//packet max - only thing that makes it a packet vs a letter
				else if((dim.get(0) > LETTER_MIN_THI && dim.get(0) < PACK_MAX_THI) || (dim.get(0) > LETTER_MIN_HEI && dim.get(0) < PACK_MAX_HEI) || (dim.get(1) > LETTER_MIN_THI && dim.get(1) < PACK_MAX_THI) || (dim.get(1) > LETTER_MIN_HEI && dim.get(1) < PACK_MAX_HEI) || (dim.get(2) > LETTER_MIN_LEN && dim.get(2) < PACK_MAX_LEN))
				{
					System.out.println("packet");
				}

			}
		
			
			one = in.nextDouble();
			two = in.nextDouble();
			three = in.nextDouble();
		}
	}
}