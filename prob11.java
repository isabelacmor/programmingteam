package mercer2010;
// Arup Guha
// 12/16/2012
// Solution to 2010 Mercer Contest Problem Alien DNA(prob11)

import java.math.*;
import java.util.*;

public class prob11 {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);

		// Read in two input values.
		BigInteger n = new BigInteger(stdin.next());
		BigInteger m = new BigInteger(stdin.next());

		// Process each case.
		while (n.compareTo(BigInteger.ZERO) != 0) {

			// The key here is realizing that the answer to the query is Fibonacci numbers.
			// Secondly, we need a quick way to generate Fibonacci numbers. Since we are using mod,
			// the direct formula (with real numbers) is insufficient. But, we can set up a matrix
			// equation that has fibonacci numbers:

			// (1 1) ^ n = ( F(n+1) F(n)   )
			// (1 0)       ( F(n)   F(n-1) ), this can be verified via induction.

			// We need F(n+2), so let's just add one to n and return mat[0][0].
			n = n.add(BigInteger.ONE);

			// Set up our matrix as shown above.
			BigInteger[][] base = new BigInteger[2][2];
			base[0][0] = BigInteger.ONE;
			base[0][1] = BigInteger.ONE;
			base[1][0] = BigInteger.ONE;
			base[1][1] = BigInteger.ZERO;

			// The key is fast matrix exponentiation.
			mat myMatrix = new mat(base, m);
			mat ans = myMatrix.exp(n);
			System.out.println(ans.m[0][0]);

			// Get the next case.
			n = new BigInteger(stdin.next());
			m = new BigInteger(stdin.next());

		}
	}

}

class mat {

	public BigInteger[][] m;
	public int size;
	public BigInteger modulus;

	// Matrix object with mod value.
	public mat(BigInteger[][] matrix, BigInteger modVal) {
		m = matrix;
		size = matrix.length;
		modulus = modVal;
	}

	// Does a modular matrix multiply.
	public mat multiply(mat other) {

		BigInteger[][] ans = new BigInteger[size][size];

		// Regular matrix multiply algorithm.
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {

				BigInteger tmp = new BigInteger("0");
				for (int k=0; k<size; k++)
					tmp = (tmp.add(this.m[i][k].multiply(other.m[k][j]))).mod(modulus);

				ans[i][j] = tmp;
			}
		}

		return new mat(ans, modulus);
	}

	// Run fast exponentiation.
	public mat exp(BigInteger power) {

		BigInteger two = new BigInteger("2");

		// This base case is sufficient.
		if (power.equals(BigInteger.ONE))
			return this;

		// This is where we get our savings.
		if (power.mod(two).equals(BigInteger.ZERO)) {
			mat mySqrt = exp(power.divide(two));
			return mySqrt.multiply(mySqrt);
		}

		// Regular recursive case.
		mat tmp = exp(power.subtract(BigInteger.ONE));
		return this.multiply(tmp);
	}
}