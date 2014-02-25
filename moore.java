import java.io.*;
import java.util.*;

public class moore {
	public static int YEARS = 0; 
	public static double BASE = Math.pow(0.5, 1/1.5);
	
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++){
			YEARS = in.nextInt();
			
			//negative reciprocal
			double factor = -1.0/YEARS;
			factor /= Math.log(BASE);
			
			//derivative and log stuff
			double x = Math.log(factor) / Math.log(BASE);
			
			if(x >= 0) System.out.printf("%.6f\n", calcMoore(x));
			else System.out.printf("%.6f\n", (double)YEARS);
			
			
			//System.out.printf("%.6f\n", ternarySearch(0, YEARS));
			
		}
	}
	
	//BLACKBOXED
	//Y --> the given start year (from input)
	//x --> the year you're testing
	public static double calcMoore(double x){
		return x + (YEARS / (Math.pow(2, (x / 1.5))));
	}
	
	
	public static double ternarySearch(int low, int high){
		
		double highest = high;
		double lowest = low;
		
		System.out.println("High: " + high + "\nLow : " + low);
		
		double difference = highest - lowest;
		
		while(difference > 1e-9){
			System.out.println("\nLowest : " + lowest);
			System.out.println("Highest: " + highest);
			
            //Split the graph "U" into thirds and initialize the two times
            double lowTime = low + (difference / 3);
            double highTime = high - (difference / 3);
            
            //Put the two times into the function
            double time1 = calcMoore(lowTime);
            double time2 = calcMoore(highTime);
            
            //If the first time is lower than the second time, update the highest to the second time
            if(time1 < time2){
                highest = highTime;
            }
            //If the first time is greater than the second time, update the lowest to the first time
            else{
                lowest = lowTime;
            }
            
            //Update the difference 
            difference = highest - lowest;
		}
		
		return (highest+lowest)/2.0;
		
	}
}


/*


7
14
3
47
123
1
5000000
1000000000


*/