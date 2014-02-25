import java.io.*;
import java.util.*;

public class searchOld {
	
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
			
			for(int i = 0; i < numWordsToFind; i++){
				if(solve(grid, wordSearch.get(i))) foundWords.add(wordSearch.get(i));
				else notFoundWords.add(wordSearch.get(i));
			}
			
			//System.out.println("Found: " + foundWords);
			
			if(foundWords.size() == wordSearch.size()){
				System.out.println("ALL WORDS FOUND");
			}
			else{
				for(int i = 0; i < notFoundWords.size(); i++){
					System.out.println(notFoundWords.get(i));
				}
			}
			
			System.out.println();
			
			ctr++;
			numWordsToFind = in.nextInt();
		}
	}
	
	//can optimize all checks to return false if the number of cells left is less than 
	//the number of letters we still need to make the word...but we'll worry about that later
	public static boolean solve(char [][] grid, String find){
		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				if(grid[i][j] == find.charAt(0)){
					//System.out.println("Found a match for word " + find + " with " + (grid[i][j]) + " on (" + i + ", " + j + ")");
					//System.out.println("\n\nrightRow\n");
					if(rightRow(grid, i, j+1, find, 1)) return true;// || leftRow(grid, i, j, find, 1);
					//System.out.println("\n\nleftRow\n");
					if(leftRow(grid, i, j-1, find, 1)) return true;
					//System.out.println("\n\ntopCol\n");
					if(topCol(grid, i-1, j, find, 1)) return true;
					//System.out.println("\n\nbottomCol\n");
					if(bottomCol(grid, i+1, j, find, 1)) return true;
					//System.out.println("\n\nupRight\n");
					if(upRight(grid, i-1, j+1, find, 1)) return true;
					//System.out.println("\n\ndownLeft\n");
					if(downLeft(grid, i+1, j-1, find, 1)) return true;
					//System.out.println("\n\ndownRight\n");
					if(downRight(grid, i+1, j+1, find, 1)) return true;
					//System.out.println("\n\nupLeft\n");
					if(upLeft(grid, i-1, j-1, find, 1)) return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean upRight(char [][] grid, int rowNum, int colNum, String find, int index){
		//System.out.println("colNum: " + colNum);
		
		//ran out of board space w/o finding word
		if(colNum >= C || colNum < 0 || rowNum >= R || rowNum < 0) return false;
		
		//found the entire word
		if(index >= find.length()-1) return true;
		
		//System.out.println("Our grid");
		//printGrid(grid);
		//System.out.println("Looking at (" + rowNum + ", " + colNum + ")");
		//System.out.println("Grid: " + grid[rowNum][colNum]);
		//System.out.println("Find: " + find.charAt(index));
		
		//this char matches, so keep searching to the right
		if(grid[rowNum][colNum] == find.charAt(index)) return upRight(grid, rowNum-1, colNum+1, find, index+1);
		
		return false;
	}
	
	public static boolean downLeft(char [][] grid, int rowNum, int colNum, String find, int index){
		//System.out.println("colNum: " + colNum);
		
		//ran out of board space w/o finding word
		if(colNum >= C || colNum < 0 || rowNum >= R || rowNum < 0) return false;
		
		//found the entire word
		if(index >= find.length()-1) return true;
		
		//System.out.println("Our grid");
		//printGrid(grid);
		//System.out.println("Looking at (" + rowNum + ", " + colNum + ")");
		//System.out.println("Grid: " + grid[rowNum][colNum]);
		//System.out.println("Find: " + find.charAt(index));
		
		//this char matches, so keep searching to the right
		if(grid[rowNum][colNum] == find.charAt(index)) return downLeft(grid, rowNum+1, colNum-1, find, index+1);
		
		return false;
	}
	
	public static boolean downRight(char [][] grid, int rowNum, int colNum, String find, int index){
		//System.out.println("colNum: " + colNum);
		
		//ran out of board space w/o finding word
		if(colNum >= C || colNum < 0 || rowNum >= R || rowNum < 0) return false;
		
		//found the entire word
		if(index >= find.length()-1) return true;
		
		//System.out.println("Our grid");
		//printGrid(grid);
		//System.out.println("Looking at (" + rowNum + ", " + colNum + ")");
		//System.out.println("Grid: " + grid[rowNum][colNum]);
		//System.out.println("Find: " + find.charAt(index));
		
		//this char matches, so keep searching to the right
		if(grid[rowNum][colNum] == find.charAt(index)) return downRight(grid, rowNum+1, colNum+1, find, index+1);
		
		return false;
	}
	
	public static boolean upLeft(char [][] grid, int rowNum, int colNum, String find, int index){
		//System.out.println("colNum: " + colNum);
		
		//ran out of board space w/o finding word
		if(colNum >= C || colNum < 0 || rowNum >= R || rowNum < 0) return false;
		
		//found the entire word
		if(index >= find.length()-1) return true;
		
		//System.out.println("Our grid");
		//printGrid(grid);
		//System.out.println("Looking at (" + rowNum + ", " + colNum + ")");
		//System.out.println("Grid: " + grid[rowNum][colNum]);
		//System.out.println("Find: " + find.charAt(index));
		
		//this char matches, so keep searching to the right
		if(grid[rowNum][colNum] == find.charAt(index)) return upLeft(grid, rowNum-1, colNum-1, find, index+1);
		
		return false;
	}
	
	public static boolean topCol(char [][] grid, int rowNum, int colNum, String find, int index){
		//System.out.println("colNum: " + colNum);
		//System.out.println("in topCol: " + colNum);
		//System.out.println("looking for: " + find);
		//ran out of board space w/o finding word
		if(colNum > C || colNum < 0 || rowNum > R || rowNum < 0) return false;
		
		//found the entire word
		if(index >= find.length()-1) return true;
		
		//System.out.println("Our grid");
		//printGrid(grid);
		//System.out.println("Looking at (" + rowNum + ", " + colNum + ")");
		//System.out.println("Grid: " + grid[rowNum][colNum]);
		//System.out.println("Find: " + find.charAt(index));
		
		//this char matches, so keep searching to the right
		if(grid[rowNum][colNum] == find.charAt(index)) return topCol(grid, rowNum-1, colNum, find, index+1);
		
		//System.out.println("FAILED " + find);
		return false;
	}
	
	public static boolean bottomCol(char [][] grid, int rowNum, int colNum, String find, int index){
		//System.out.println("in bottomCol: " + colNum);
		//System.out.println("looking for: " + find);
		//ran out of board space w/o finding word
		if(colNum >= C || colNum < 0 || rowNum >= R || rowNum < 0){
			//System.out.println("FAILED " + find);
			return false;
		}
		
		//found the entire word
		if(index >= find.length()-1) return true;
		
		//System.out.println("Our grid");
		//printGrid(grid);
		//System.out.println("Looking at (" + rowNum + ", " + colNum + ")");
		//System.out.println("Grid: " + grid[rowNum][colNum]);
		//System.out.println("Find: " + find.charAt(index));
		
		//this char matches, so keep searching to the right
		if(grid[rowNum][colNum] == find.charAt(index)) return bottomCol(grid, rowNum+1, colNum, find, index+1);
		
		//System.out.println("FAILED " + find);
		return false;
	}
	
	public static boolean rightRow(char [][] grid, int rowNum, int colNum, String find, int index){
		//System.out.println("colNum: " + colNum);
		//System.out.println("R: " + R + " C: " + C);
		//ran out of board space w/o finding word
		if(colNum >= C || colNum < 0 || rowNum >= R || rowNum < 0) return false;
		
		//found the entire word
		if(index >= find.length()-1) return true;
		
		//System.out.println("Our grid");
		//printGrid(grid);
		//System.out.println("Looking at (" + rowNum + ", " + colNum + ")");
		//System.out.println("Grid: " + grid[rowNum][colNum]);
		//System.out.println("Find: " + find.charAt(index));
		
		//this char matches, so keep searching to the right
		if(grid[rowNum][colNum] == find.charAt(index)){
			return rightRow(grid, rowNum, colNum+1, find, index+1);
		}
		
		return false;
	}
	
	public static boolean leftRow(char [][] grid, int rowNum, int colNum, String find, int index){
		//System.out.println("colNum: " + colNum);
		
		//ran out of board space w/o finding word
		if(colNum >= C || colNum < 0 || rowNum >= R || rowNum < 0) return false;
		
		//found the entire word
		if(index >= find.length()-1) return true;
			
		//this char matches, so keep searching to the right
		//System.out.println("Grid: " + grid[rowNum][colNum]);
		//System.out.println("Find: " + find.charAt(index));
		if(grid[rowNum][colNum] == find.charAt(index)) return leftRow(grid, rowNum, colNum-1, find, index+1);
		
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

/*

9
SKYWALKER
WATTO
HUTT
JABBA
DARTHVADER
JARJAR
JEDI
YODA
EWOK
9 9
AEIOUBCHR
JEDIODUFE
AAGHJTKLK
RQBPTNTML
JRSBTVWAA
AYZKAZYXW
RXOWVADOY
TWSRQPNMK
EDFGHJKLS
2
ADD
BAD
4 4
AADD
BBBB
CCCA
DDDD
3
HELLO
GOODBYE
NOTFOUND
5 10
NEXTLINEBA
UOYOLLEHCK
GOODBYEFOR
NOWWASTHIS
FUNFORYOUQ
1
AWKWARD
20 20
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAWKWARDAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAAAAAAA
1
A
1 2
AA
1
A
1 2
BB
0

 
*/
