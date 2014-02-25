package mercer2010;
import java.io.*;
import java.util.*;
import java.math.*;

class Matrix{
	public BigInteger[][] m;
	public int len;
	public BigInteger mod;

	public Matrix(BigInteger[][] matrix, BigInteger mv) {
		m = matrix;
		len = matrix.length;
		mod = mv;
	}
	
	//fast expo for f(n)
	public Matrix expo(BigInteger n){
		BigInteger TWO = new BigInteger("2");
		
		//base case
		if(n.equals(BigInteger.ONE)) return this;
		
		//fast expo
		if(n.mod(TWO).equals(BigInteger.ZERO)){
			Matrix sqrt = expo(n.divide(TWO));
			return sqrt.times(sqrt);
		}
		
		Matrix tmp = expo(n.subtract(BigInteger.ONE));
		return this.times(tmp);
	}
	
	//multiply two matrices as normal
	public Matrix times(Matrix other) {
		BigInteger[][] ans = new BigInteger[len][len];
		for (int i=0; i<len; i++) {
			for (int j=0; j<len; j++) {

				BigInteger tmp = new BigInteger("0");
				for (int k=0; k<len; k++)
					tmp = (tmp.add(this.m[i][k].multiply(other.m[k][j]))).mod(mod);

				ans[i][j] = tmp;
			}
		}

		return new Matrix(ans, mod);
	}
}

public class dna {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		BigInteger n = new BigInteger(in.next());
		BigInteger m = new BigInteger(in.next());
		
		//answer is the fib number n+2 mod m
		while(true){
			if(n.compareTo(BigInteger.ZERO) == 0) break;
			
			n = n.add(BigInteger.ONE);
			
			//matrix
			// (1 1) ^ n = ( F(n+1) F(n)   )
			// (1 0)	   ( F(n)   F(n-1) )
			BigInteger[][] bases = new BigInteger[2][2];
			bases[0][0] = BigInteger.ONE;
			bases[1][0] = BigInteger.ONE;
			bases[0][1] = BigInteger.ONE;
			bases[1][1] = BigInteger.ZERO;
			
			//make matrix for fast expo
			Matrix matrix = new Matrix(bases, m);
			//run fast expo
			Matrix res = matrix.expo(n);
			
			System.out.println(res.m[0][0]);
			
			n = new BigInteger(in.next());
			m = new BigInteger(in.next());
		}
	}
}

/*

1 10 
2 10 
5 10 
6 8 
0 0 

*/
