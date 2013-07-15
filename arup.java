import java.io.*;
import java.util.*;

public class arup {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int numGames = in.nextInt();
		
		for(int j = 1; j <= numGames; j++){
			System.out.print("Game #" + j + ": ");
			
			int row = in.nextInt();
			int col = in.nextInt();
			String blank = in.nextLine();
			
			char [][] board = new char[row][col];
			for(int r = 0; r < row; r++){
				String line = in.nextLine();
				line = line.replaceAll(" ", "");
				//System.out.println(line);
				char [] chars = line.toCharArray();
				
				for(int c = 0; c < col; c++){
					board[r][c] = chars[c];
				}
			}
			
			boolean won = false;
			
			for(int i = 0; i < row; i++){
				if(checkRow(i, board, col)){
					if(board[i][0] == 'X'){
						System.out.println("Huzzah! X is victorious!");
						won = true;
						break;
					}
					else if(board[i][0] == 'O'){
						System.out.println("Success! O has conquered the board!");
						won = true;
						break;
					}
					else{}
				}
			}
			
			if(!won){
				for(int i = 0; i < col; i++){
					if(checkCol(i, board, row)){
						if(board[0][i] == 'X'){
							System.out.println("Huzzah! X is victorious!");
							won = true;
							break;
						}
						else if(board[0][i] == 'O'){
							System.out.println("Success! O has conquered the board!");
							won = true;
							break;
						}
						else{}
					}
				}
			}
			
			if(!won) System.out.println("Oh no! Neither of the players won!");
			
			
		}
	}
	
	public static boolean checkCol(int colNum, char [][] board, int r){
		for(int i = 0; i < r-1; i++){
			if(board[i][colNum] == board[i+1][colNum]) continue;
			else return false;
		}
		
		if(board[0][colNum] != '-') return true;
		return false;
	}
	
	public static boolean checkRow(int rowNum, char [][] board, int c){
		for(int i = 0; i < c-1; i++){
			if(board[rowNum][i] == board[rowNum][i+1]) continue;
			else return false;
		}
		
		if(board[rowNum][0] != '-') return true;
		return false;
	}
}
