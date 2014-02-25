import java.awt.geom.Line2D;
import java.io.*;
import java.util.*;

class PointCor{
	int x, y;
	
	PointCor(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
}

public class vacation {
	public static double totalCost = Double.MAX_VALUE;
	
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 1; i <= numCases; i++){
			System.out.println("Vacation #" + i + ":");
			totalCost = Double.MAX_VALUE;
			
			int numRides = in.nextInt();
			int numBlock = in.nextInt();
			PointCor [] points = new PointCor[numRides];
			PointCor [] block  = new PointCor[numBlock];
			
			for(int j = 0; j < numRides; j++){
				points[j] = new PointCor(in.nextInt(), in.nextInt());
			}
			
			for(int j = 0; j < numBlock; j++){
				block[j] = new PointCor(in.nextInt(), in.nextInt());
			}
			
			boolean[] used = new boolean[numRides];
			int [] perm = new int[numRides];
			permute(0, used, perm, numRides, block, points);
			
			//add the time cost of the rides
			if(totalCost == Double.MAX_VALUE) System.out.print("Jimmy should plan this vacation a different day.");
			else{
				totalCost += numRides * 120;
				System.out.printf("Jimmy can finish all of the rides in %.3f seconds.", totalCost);
			}
			
			System.out.println("\n");
		}
	}
	
	public static void permute(int p, boolean[] used, int[] perm, int N, PointCor[] block, PointCor[] points){
		if(p == N){
			if(validPath(perm, block)){
				//System.out.println("CAN VISIT: ");
				//printPerm(perm);
				double hereCost = calcCost(perm, points);
				//System.out.println("Path cost: " + hereCost);
				if(hereCost < totalCost) totalCost = hereCost;
			}
			else{
				//System.out.println("==>>>>>>BLOCKED<<<<<<==");
			}
		}
		
		for(int i = 0; i < N; i++){
			if(!used[i]){
				used[i] = true;
				perm[p] = i;
				permute(p+1, used, perm, N, block, points);
				used[i] = false;
			}
		}
	}
	
	public static double calcCost(int[] perm, PointCor[] points){
		double total = 0;
		total += distance(new PointCor(0, 0), points[perm[0]]);
		
		for(int i = 0; i < perm.length-1; i++){
			total += distance(points[perm[i]], points[perm[i+1]]);
		}
		
		return total;
	}
	
	//true if we can complete this entire path (ie: nothing blocked)
	public static boolean validPath(int[] perm, PointCor[] block){
		for(int i = 0; i < perm.length-1; i++){
			//if any point is blocked, the entire path is invalid
			//+1 on perms because indexed from 0-n but rides are from 1-n
			if(blockedP((perm[i]+1), (perm[i+1]+1), block)){
				//System.out.println("=========BLOCKED PATH=========");
				//printPerm(perm);
				return false;
			}
		}
		
		return true;
	}
	
	//true if any blocked point lies on the line from a to b
	public static boolean blockedP(int x, int y, PointCor[] block){
		for(int i = 0; i < block.length; i++){
			if((block[i].x == x && block[i].y == y) || (block[i].x == y && block[i].y == x))
					return true;
		}
		
		return false;
	}
	
	public static boolean intersect(PointCor a, PointCor c, PointCor b){
		return new Line2D.Float(a.x, a.y, b.x, b.y).ptLineDist(c.x, c.y) <= 0.01;
	}
	
	public static double distance(PointCor a, PointCor b){
	    return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
	}

	public static boolean isBetween(PointCor a, PointCor c, PointCor b){
	    return distance(a,c) + distance(c,b) == distance(a,b);
	}
	
	public static void printPerm(int [] perm, PointCor[] points){
		for(int i = 0; i < perm.length; i++){
			System.out.print(points[perm[i]] + " --> ");
		}
		
		System.out.println();
	}
	
	public static void printPerm(int [] perm){
		for(int i = 0; i < perm.length; i++){
			System.out.print((perm[i]+1) + " --> ");
		}
		
		System.out.println();
	}
}

/*


3
4 0
0 2
2 2
2 4
4 4
5 4
10 10
12 35
64 60
3 7
100 857
1 2
1 3
1 4
1 5
5 2
0 5
0 10
0 20
0 50
0 25
3 4
1 2


*/
