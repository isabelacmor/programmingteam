import java.io.*;
import java.util.*;

public class search {
	
	public static int R, C;
	public static ArrayList<String> foundWords = new ArrayList();
	public static ArrayList<String> notFoundWords = new ArrayList();
	
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numWordsToFind = in.nextInt();
		int ctr = 1;
		
		while(numWordsToFind != 0){
			System.out.println("Puzzle number " + ctr + ":");
			
			ArrayList<String> wordSearch = new ArrayList();
			foundWords.clear();
			notFoundWords.clear();
			
			String blank = in.nextLine();
			
			for(int i = 0; i < numWordsToFind; i++){
				wordSearch.add(in.nextLine());
			}
			
			R = in.nextInt();
			C = in.nextInt();
			blank = in.nextLine();
			
			char [][] grid = new char[R][C];
			for(int i = 0; i < R; i++){
				String line = in.nextLine();
				for(int j = 0; j < C; j++){
					grid[i][j] = line.charAt(j);
				}
			}
			
			//loop through the words
			for(int i = 0; i < numWordsToFind; i++){
				//loop through the entire grid
				//System.out.println("Looking for: " + wordSearch.get(i) + "\n====================");
				outer:
				for(int m = 0; m < R; m++){
					for(int n = 0; n < C; n++){
						if(solve(grid, wordSearch.get(i), m, n)){
							//System.out.println("Found " + wordSearch.get(i));
							if(!foundWords.contains(wordSearch.get(i))) foundWords.add(wordSearch.get(i));
							break outer;
						}
					}
				}
			}
			
			//System.out.println("Found: " + foundWords);
			
			if(foundWords.size() == wordSearch.size()){
				System.out.println("ALL WORDS FOUND");
			}
			else{
				for(int i = 0; i < wordSearch.size(); i++){
					if(foundWords.contains(wordSearch.get(i))){}
					else System.out.println(wordSearch.get(i));
				}
			}
			
			System.out.println();
			
			ctr++;
			numWordsToFind = in.nextInt();
		}
	}
	
	public static boolean solve(char [][] grid, String find, int row, int col){
		String allRow, allCol, leftDiag, rightDiag;
		String revRow, revCol, revLeft, revRight;

		allRow = makeRow(grid, row);
		allCol = makeCol(grid, col);
		leftDiag = makeLeftDiag(grid, row, col);
		rightDiag = makeRightDiag(grid, row, col);
		
		revRow = new StringBuilder(allRow).reverse().toString();
		revCol = new StringBuilder(allCol).reverse().toString();
		revLeft = new StringBuilder(leftDiag).reverse().toString();
		revRight = new StringBuilder(rightDiag).reverse().toString();
		
		//System.out.println("\n\nCheck from cell: (" + row + ", " + col + ")");
		//System.out.println("allRow: " + allRow);
		//System.out.println("allCol: " + allCol);
		//System.out.println("leftDiag: " + leftDiag);
		//System.out.println("rightDiag: " + rightDiag);
		
		if(allRow.contains(find) || allCol.contains(find) || leftDiag.contains(find) || rightDiag.contains(find)) return true;
		if(revRow.contains(find) || revCol.contains(find) || revLeft.contains(find) || revRight.contains(find)) return true;
		return false;
	}
	
	public static String makeRow(char[][] grid, int row){
		String theRow = "";
		
		for(int i = 0; i < C; i++){
			theRow = theRow + grid[row][i];
		}
		
		return theRow;
	}
	
	public static String makeCol(char[][] grid, int col){
		String theCol = "";
		
		for(int i = 0; i < R; i++){
			theCol = theCol + grid[i][col];
		}
		
		return theCol;
	}
	
	public static String makeLeftDiag(char[][] grid, int row, int col){
		String theLeftDiag = "";
		
		int [] set = findStartingLeft(row, col);
		row = set[0]+1;
		col = set[1]+1;
		
		//System.out.println("Left diag starts at cell (" + row + ", " + col + ")");
		
		//until we hit row = R or col = C
		while(inBounds(row, col)){
			theLeftDiag = theLeftDiag + grid[row][col];
			row++;
			col++;
		}
		
		return theLeftDiag;
	}
	
	public static String makeRightDiag(char[][] grid, int row, int col){
		String theRightDiag = "";
		
		int [] set = findStartingRight(row, col);
		row = set[0]+1;
		col = set[1]-1;
		
		//System.out.println("Right diag starts at cell (" + row + ", " + col + ")");
		
		//until we hit row = 0 or col = 0
		while(inBounds(row, col)){
			theRightDiag = theRightDiag + grid[row][col];
			row++;
			col--;
		}
		
		return theRightDiag;
	}
	
	//returns the very top left on the diag
	public static int[] findStartingLeft(int row, int col){
		while(inBounds(row, col)){
			row--;
			col--;
		}
		
		int [] set = {row, col};
		
		return set;
	}
	
	//returns the very bottom right on the diag
	public static int[] findStartingRight(int row, int col){
		while(inBounds(row, col)){
			row--;
			col++;
		}
		
		int [] set = {row, col};
		
		return set;
	}
	
	public static boolean inBounds(int r, int c){
		if(r >= 0 && c >= 0 && r < R && c < C) return true;
		return false;
	}
	
	public static void printGrid(char [][] grid){
		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}