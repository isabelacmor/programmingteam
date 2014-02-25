//0-1
//regular
//continuous

import java.util.*;

class Treasure {
	public int weight, value;

	public Treasure(int w, int v) {
		weight = w;
		value = v;
	}
}

public class knapsack {
	// 0-1 knapsack DP
	public static int[][] knapsackDP(Treasure[] t, int capacity) {
		int[][] dp = new int[t.length + 1][capacity + 1];

		// regardless of capacity, we don't have any treasures to take!
		for (int i = 0; i <= capacity; i++)
			dp[0][i] = 0;
		// regardless of treasure, we don't have any capacity!
		for (int i = 0; i <= t.length; i++)
			dp[i][0] = 0;

		for (int i = 1; i <= t.length; i++)
			for (int j = 1; j <= capacity; j++)
				// have enough capacity
				if (j >= t[i - 1].weight)
					// best between taking + lowering capacity and not taking +
					// keeping capacity
					dp[i][j] = Math.max(t[i - 1].value
							+ dp[i - 1][j - t[i - 1].weight], dp[i - 1][j]);
				// not enough capacity; can't take regardless
				else
					dp[i][j] = dp[i - 1][j];

		return dp;
	}

	public static int[] subset(int[][] dp, Treasure[] t) {
		int[] subset = new int[t.length];
		int numItems = 0;
		int i = dp.length - 1;
		for (int j = dp[0].length - 1; j >= 0 && i > 0; i--) {
			// If the item is in the optimal subset, add it and subtract its
			// weight
			// from the column we are checking.
			if (dp[i][j] != dp[i - 1][j]) {
				subset[numItems] = i;
				j -= t[i - 1].weight;
				numItems++;
			}
		}
		
		return subset;
		//return Arrays.copyOfRange(subset, 0, numItems);
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/*
	 * ======================================================== M_dp(W) = max
	 * value achieved by knapsack with capacity W
	 * ========================================================
	 */
	static int M_dp(Treasure[] t, int W) {
		int[] sol, mySol;
		int i, myFinalSol;

		int[] M; // Data structure to store results
		int C; // Index to run through M[]

		sol = new int[t.length];
		mySol = new int[t.length];

		M = new int[W + 1]; // Create array

		/*
		 * --------------------------- Base cases ---------------------------
		 */
		M[0] = 0;

		/*
		 * ============================================== The other values M[C]
		 * ==============================================
		 */
		for (C = 1; C <= W; C++) {
			/*
			 * --------------------------------------- Solve the appropriate
			 * smaller problems ---------------------------------------
			 */
			for (i = 0; i < t.length; i++) {
				if (C >= t[i].weight)
					sol[i] = M[C - t[i].weight]; // Knapsack capacity reduced by w[i]
											// because it has item i packed in
											// it already
				else
					sol[i] = 0; // Not enough space to pack item i
			}

			/*
			 * --------------------------------------------- Use the solutions
			 * to the smaller problems to solve original problem
			 * ---------------------------------------------
			 */
			for (i = 0; i < t.length; i++) {
				if (C >= t[i].weight)
					mySol[i] = sol[i] + t[i].value; // Value is increased by v[i]
												// because it has item i packed
												// in
												// it already
				else
					mySol[i] = 0; // Not enough space to pack item i
			}

			/* *************************
			 * Find the best (maximum)************************
			 */
			M[C] = mySol[0];
			for (i = 1; i < t.length; i++)
				if (mySol[i] > M[C])
					M[C] = mySol[i];
		}

		return M[W]; // Return best value for knapsack of cap = W
	}
/*
	public static void main(String[] args) {
		Treasure[] t = new Treasure[3];

		// w, v
		t[0] = new Treasure(1, 10); //
		t[1] = new Treasure(2, 5);
		t[2] = new Treasure(320, 1);

		printArr(knapsackDP(t, 320));
		printArr(subset(knapsackDP(t, 320), t));
	}
*/
	
	 public static void main(String[] args) {
	  
		 Treasure [] t = new Treasure[6];
		 t[0] = new Treasure(4, 6);
		 t[1] = new Treasure(2, 4);
		 t[2] = new Treasure(3, 5);
		 t[3] = new Treasure(1, 3);
		 t[4] = new Treasure(6, 9);
		 t[5] = new Treasure(4, 7);
		 
		 //take 6: cap left -> 6
		 //take 4: cap left -> 5
		 //take 3: cap left -> 2
		 //take 2: cap left -> 0
	  
	  int capacity = 10;
	  
	  int[][] solution = knapsackDP(t, capacity); 
	  int[] optimalSubset = getOptimalSubset(solution, t);
	  
	  printMatrix(solution, "Solution Matrix"); 
	  printArray(optimalSubset, "Optimal Subset");
	  
	  System.out.println(M_dp(t, capacity));
	  
	  //Treasure [] t = new Treasure[6];
	  
	  //w, v t[0] = new Treasure(4, 6); // t[1] = new Treasure(2, 4); t[2] =
	  //new Treasure(3, 5); t[3] = new Treasure(1, 3); t[4] = new Treasure(6, 9);
	  //curCap: 4, curVal: 9 t[5] = new Treasure(4, 7);
	  
	  //printArr(knapsackDP(t, 10));
	  
	  }
	 
	/**
	 * 
	 * Returns the solution matrix for the Knapsack problem associated with the
	 * given values, weights and knapsack capacity.
	 * 
	 * @param values
	 *            The values of the items.
	 * @param weights
	 *            The weights of the items.
	 * @param capacity
	 *            The capacity of the knapsack.
	 * 
	 */
	private static int[][] getSolutionMatrix(Treasure [] t,
			int capacity) {
		int[][] matrix = new int[t.length + 1][capacity + 1];
		for (int i = 1; i <= t.length; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (j - t[i - 1].weight >= 0) {
					matrix[i][j] = Math.max(matrix[i - 1][j], t[i - 1].value
							+ matrix[i - 1][j - t[i - 1].weight]);
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}
		return matrix;
	}

	/**
	 * 
	 * Returns the optimal subset of items that should be included in the
	 * knapsack given a completed solution matrix.
	 * 
	 * @param solutionMatrix
	 *            An N by W matrix, where N is the number of items and W is the
	 *            capacity of the knapsack.
	 * @param weights
	 *            An array of size N containing the weights of each of the
	 *            items.
	 * 
	 */
	private static int[] getOptimalSubset(int[][] solutionMatrix, Treasure [] t) {
		int[] subset = new int[t.length];
		int numItems = 0;
		int i = solutionMatrix.length - 1;
		for (int j = solutionMatrix[0].length - 1; j >= 0 && i > 0; i--) {
			// If the item is in the optimal subset, add it and subtract its
			// weight
			// from the column we are checking.
			if (solutionMatrix[i][j] != solutionMatrix[i - 1][j]) {
				subset[numItems] = i;
				j -= t[i - 1].weight;
				numItems++;
			}
		}
		return Arrays.copyOfRange(subset, 0, numItems);
	}

	/**
	 * Prints an array to the console, applying the given title.
	 */
	private static void printArray(int[] array, String title) {
		StringBuilder builder = new StringBuilder();
		builder.append("\n").append(title).append(":\n{");

		if (array.length != 0)
			builder.append(array[0]);

		for (int i = 1; i < array.length; i++) {
			builder.append(", ").append(array[i]);
		}

		builder.append("}");

		System.out.println(builder.toString());

	}

	/**
	 * Prints a matrix (2-dimensional array) to the console, applying the given
	 * title.
	 */
	private static void printMatrix(int[][] matrix, String title) {
		StringBuilder builder = new StringBuilder();
		builder.append(title).append(":\n");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				builder.append(matrix[i][j]).append("\t");
			}
			builder.append("\n");
		}
		System.out.print(builder.toString());
	}
}
