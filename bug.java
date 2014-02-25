import java.io.*;
import java.util.*;

public class bug {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int C = in.nextInt();
		for(int c = 0; c < C; c++){
			int N = in.nextInt();
			int X = in.nextInt();
			int Y = in.nextInt();
			
			solve(N, X, Y);
		}
	}
	
	public static void solve(int N, int X, int Y){
		//only one number in the array
		if(N == 1){
			if(Y == 1) System.out.print(lower(X));
			else System.out.print(X);
		}
		else{
			//perfect answer
			if(Y == 2){
				//the number we want is already included in the range from 1-N
				if(X < N){
					for(int i = 1; i <= N; i++)
						System.out.print(i + " ");
				}
				//the number is outside the range, we print it separately
				else{
					for(int i = 1; i < N; i++)
						System.out.print(i + " ");
					System.out.print(X);
				}
			}
			//exclude X from the answer
			else{
				//the number we want is in the range from 1-N
				if(X <= N){
					int print = 1;
					int done = 0;
					while(done < N){
						if(print == X) print++;
						else{
							System.out.print(print + " ");
							print++;
							done++;
						}
						
					}
				}
				//we don't have to worry about excluding it
				else{
					for(int i = 1; i <= N; i++)
						System.out.print(i + " ");
				}
			}
		}
			
		System.out.println();
	}
	
	//returns lowest number != to X
	public static int lower(int X){
		if(X == 1) return 2;
		else return 1;
	}
}

/*

20
3 3 1
4 7 2
1 1 1
1 1 2
1 100 1
1 100 2
99 1 1
99 1 2
99 100 1
99 100 2
2 1 1
2 1 2
2 2 1
2 2 2
2 22 1
2 22 2
36 75 2

*/
