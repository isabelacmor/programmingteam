import java.io.*;
import java.util.*;

public class sokoban {
	
	public static char [][] grid;
	
	//[r][c]
	public static int [] workerPlace;
	
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		int r = in.nextInt();
		int c = in.nextInt();
		
		int ctr = 1;
		
		while(r != 0 && c != 0){
			grid = new char[r][c];
			String blank = in.nextLine();
			
			//read in grid
			for(int i = 0; i < r; i++){
				String line = in.nextLine();
				grid[i] = line.toCharArray();
			}
			
			workerPlace = findWorker();
			
			//read in directions
			char [] directions = in.nextLine().toCharArray();
			
			for(int i = 0; i < directions.length; i++){
				//System.out.println("\n\nMOVE: " + directions[i]);
				doMove(directions[i]);
				//printGrid(grid);
				if(isComplete()) break;
			}
			
			if(isComplete()){
				System.out.println("Game " + ctr + ": complete");
			}
			else System.out.println("Game " + ctr + ": incomplete");
			
			//print grid
			printGrid(grid);
			
			ctr++;
			r = in.nextInt();
			c = in.nextInt();
		}
	}
	
	public static void doMove(char move){
		if(move == 'U'){
			//is the worker touching the wall above?
			if(workerPlace[0] == 1){
				//can't move up
			}
			//there's at least one space above him...he can move up...
			//now let's check what's above him
			else{
				//if it's empty, he can move
				if(grid[workerPlace[0]-1][workerPlace[1]] == '.'){
					if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
						grid[workerPlace[0]][workerPlace[1]] = '.';
					}
					else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
						grid[workerPlace[0]][workerPlace[1]] = '+';
					}
					workerPlace[0]--;
					grid[workerPlace[0]][workerPlace[1]] = 'w';
				}
				//if it's a target, he can move...but he needs to become capital
				else if(grid[workerPlace[0]-1][workerPlace[1]] == '+'){
					if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
						grid[workerPlace[0]][workerPlace[1]] = '.';
					}
					else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
						grid[workerPlace[0]][workerPlace[1]] = '+';
					}
					workerPlace[0]--;
					grid[workerPlace[0]][workerPlace[1]] = 'W';
				}
				//there's two+ spaces above him, so we can move a box if present
				else if(workerPlace[0]-2 > 0){
					//there's a box (not on target)...let's move it
					if(grid[workerPlace[0]-1][workerPlace[1]] == 'b'){
						//check to see if there's a box or wall beyond it to the left
						if(grid[workerPlace[0]-2][workerPlace[1]] == 'b' || grid[workerPlace[0]-2][workerPlace[1]] == 'B' ||grid[workerPlace[0]-2][workerPlace[1]] == '#'){
							//can't move anything...
						}
						else{
							if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
								grid[workerPlace[0]][workerPlace[1]] = '.';
							}
							else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
								grid[workerPlace[0]][workerPlace[1]] = '+';
							}
							workerPlace[0]--;
							grid[workerPlace[0]][workerPlace[1]] = 'w';
							if(grid[workerPlace[0]-1][workerPlace[1]] == '.'){
								grid[workerPlace[0]-1][workerPlace[1]] = 'b';
							}
							else grid[workerPlace[0]-1][workerPlace[1]] = 'B';
						}
					}
					else if(grid[workerPlace[0]-1][workerPlace[1]] == 'B'){
						//check to see if there's a box or wall beyond it to the left
						if(grid[workerPlace[0]-2][workerPlace[1]] == 'b' || grid[workerPlace[0]-2][workerPlace[1]] == 'B' ||grid[workerPlace[0]-2][workerPlace[1]] == '#'){
							//can't move anything...
						}
						else{
							if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
								grid[workerPlace[0]][workerPlace[1]] = '.';
							}
							else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
								grid[workerPlace[0]][workerPlace[1]] = '+';
							}
							workerPlace[0]--;
							grid[workerPlace[0]][workerPlace[1]] = 'W';
							if(grid[workerPlace[0]-1][workerPlace[1]] == '.'){
								grid[workerPlace[0]-1][workerPlace[1]] = 'b';
							}
							else grid[workerPlace[0]-1][workerPlace[1]] = 'B';
						}
					}
				}
			}
		}
		else if(move == 'D'){
			//is the worker touching the wall below?
			if(workerPlace[0] == grid.length-2){
				//can't move down
			}
			//there's at least one space below him...he can move down...
			//now let's check what's below him
			else{
				//if it's empty, he can move
				if(grid[workerPlace[0]+1][workerPlace[1]] == '.'){
					if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
						grid[workerPlace[0]][workerPlace[1]] = '.';
					}
					else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
						grid[workerPlace[0]][workerPlace[1]] = '+';
					}
					workerPlace[0]++;
					grid[workerPlace[0]][workerPlace[1]] = 'w';
				}
				//if it's a target, he can move...but he needs to become capital
				else if(grid[workerPlace[0]+1][workerPlace[1]] == '+'){
					if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
						grid[workerPlace[0]][workerPlace[1]] = '.';
					}
					else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
						grid[workerPlace[0]][workerPlace[1]] = '+';
					}
					workerPlace[0]++;
					grid[workerPlace[0]][workerPlace[1]] = 'W';
				}
				//there's two+ spaces above him, so we can move a box if present
				else if(workerPlace[0]+2 < grid.length-1){
					//there's a box (not on target)...let's move it
					if(grid[workerPlace[0]+1][workerPlace[1]] == 'b'){
						//check to see if there's a box or wall beyond it to the left
						if(grid[workerPlace[0]+2][workerPlace[1]] == 'b' || grid[workerPlace[0]+2][workerPlace[1]] == 'B' ||grid[workerPlace[0]+2][workerPlace[1]] == '#'){
							//can't move anything...
						}
						else{
							if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
								grid[workerPlace[0]][workerPlace[1]] = '.';
							}
							else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
								grid[workerPlace[0]][workerPlace[1]] = '+';
							}
							workerPlace[0]++;
							grid[workerPlace[0]][workerPlace[1]] = 'w';
							if(grid[workerPlace[0]+1][workerPlace[1]] == '.'){
								grid[workerPlace[0]+1][workerPlace[1]] = 'b';
							}
							else grid[workerPlace[0]+1][workerPlace[1]] = 'B';
						}
					}
					else if(grid[workerPlace[0]+1][workerPlace[1]] == 'B'){
						//check to see if there's a box or wall beyond it to the left
						if(grid[workerPlace[0]+2][workerPlace[1]] == 'b' || grid[workerPlace[0]+2][workerPlace[1]] == 'B' ||grid[workerPlace[0]+2][workerPlace[1]] == '#'){
							//can't move anything...
						}
						else{
							if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
								grid[workerPlace[0]][workerPlace[1]] = '.';
							}
							else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
								grid[workerPlace[0]][workerPlace[1]] = '+';
							}
							workerPlace[0]++;
							grid[workerPlace[0]][workerPlace[1]] = 'W';
							if(grid[workerPlace[0]+1][workerPlace[1]] == '.'){
								grid[workerPlace[0]+1][workerPlace[1]] = 'b';
							}
							else grid[workerPlace[0]+1][workerPlace[1]] = 'B';
						}
					}
				}
			}
		}
		else if(move == 'L'){
			//is the worker touching the wall above?
			if(workerPlace[1] == 1){
				//can't move up
			}
			//there's at least one space above him...he can move up...
			//now let's check what's above him
			else{
				//if it's empty, he can move
				if(grid[workerPlace[0]][workerPlace[1]-1] == '.'){
					if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
						grid[workerPlace[0]][workerPlace[1]] = '.';
					}
					else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
						grid[workerPlace[0]][workerPlace[1]] = '+';
					}
					workerPlace[1]--;
					grid[workerPlace[0]][workerPlace[1]] = 'w';
				}
				//if it's a target, he can move...but he needs to become capital
				else if(grid[workerPlace[0]][workerPlace[1]-1] == '+'){
					if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
						grid[workerPlace[0]][workerPlace[1]] = '.';
					}
					else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
						grid[workerPlace[0]][workerPlace[1]] = '+';
					}
					workerPlace[1]--;
					grid[workerPlace[0]][workerPlace[1]] = 'W';
				}
				//there's two+ spaces above him, so we can move a box if present
				else if(workerPlace[1]-2 > 0){
					//there's a box (not on target)...let's move it
					if(grid[workerPlace[0]][workerPlace[1]-1] == 'b'){
						//check to see if there's a box or wall beyond it to the left
						if(grid[workerPlace[0]][workerPlace[1]-2] == 'b' || grid[workerPlace[0]][workerPlace[1]-2] == 'B' ||grid[workerPlace[0]][workerPlace[1]-2] == '#'){
							//can't move anything...
						}
						else{	
							if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
								grid[workerPlace[0]][workerPlace[1]] = '.';
							}
							else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
								grid[workerPlace[0]][workerPlace[1]] = '+';
							}
							workerPlace[1]--;
							grid[workerPlace[0]][workerPlace[1]] = 'w';
							if(grid[workerPlace[0]][workerPlace[1]-1] == '.'){
								grid[workerPlace[0]][workerPlace[1]-1] = 'b';
							}
							else grid[workerPlace[0]][workerPlace[1]-1] = 'B';
						}
					}
					else if(grid[workerPlace[0]][workerPlace[1]-1] == 'B'){
						if(grid[workerPlace[0]][workerPlace[1]-2] == 'b' || grid[workerPlace[0]][workerPlace[1]-2] == 'B' ||grid[workerPlace[0]][workerPlace[1]-2] == '#'){
							//can't move anything...
						}
						else{
							if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
								grid[workerPlace[0]][workerPlace[1]] = '.';
							}
							else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
								grid[workerPlace[0]][workerPlace[1]] = '+';
							}
							workerPlace[1]--;
							grid[workerPlace[0]][workerPlace[1]] = 'W';
							if(grid[workerPlace[0]][workerPlace[1]-1] == '.'){
								grid[workerPlace[0]][workerPlace[1]-1] = 'b';
							}
							else grid[workerPlace[0]][workerPlace[1]-1] = 'B';
						}
					}
				}
			}
		}
		else if(move == 'R'){
			//is the worker touching the wall to the right?
			if(workerPlace[1] == grid[0].length-1){
				//can't move right
				System.out.println("wall crash");
			}
			//there's at least one space below him...he can move down...
			//now let's check what's below him
			else{
				//if it's empty, he can move
				if(grid[workerPlace[0]][workerPlace[1]+1] == '.'){
					if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
						grid[workerPlace[0]][workerPlace[1]] = '.';
					}
					else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
						grid[workerPlace[0]][workerPlace[1]] = '+';
					}
					workerPlace[1]++;
					grid[workerPlace[0]][workerPlace[1]] = 'w';
				}
				//if it's a target, he can move...but he needs to become capital
				else if(grid[workerPlace[0]][workerPlace[1]+1] == '+'){
					if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
						grid[workerPlace[0]][workerPlace[1]] = '.';
					}
					else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
						grid[workerPlace[0]][workerPlace[1]] = '+';
					}
					workerPlace[1]++;
					grid[workerPlace[0]][workerPlace[1]] = 'W';
				}
				//there's two+ spaces above him, so we can move a box if present
				else if(workerPlace[1]+2 <= grid[0].length-1){
					//there's a box (not on target)...let's move it
					if(grid[workerPlace[0]][workerPlace[1]+1] == 'b'){
						if(grid[workerPlace[0]][workerPlace[1]+2] == 'b' || grid[workerPlace[0]][workerPlace[1]+2] == 'B' ||grid[workerPlace[0]][workerPlace[1]+2] == '#'){
							//can't move anything...
						}
						else{
							if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
								grid[workerPlace[0]][workerPlace[1]] = '.';
							}
							else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
								grid[workerPlace[0]][workerPlace[1]] = '+';
							}
							workerPlace[1]++;
							grid[workerPlace[0]][workerPlace[1]] = 'w';
							if(grid[workerPlace[0]][workerPlace[1]+1] == '.'){
								grid[workerPlace[0]][workerPlace[1]+1] = 'b';
							}
							else grid[workerPlace[0]][workerPlace[1]+1] = 'B';
						}
					}
					else if(grid[workerPlace[0]][workerPlace[1]+1] == 'B'){
						if(grid[workerPlace[0]][workerPlace[1]+2] == 'b' || grid[workerPlace[0]][workerPlace[1]+2] == 'B' ||grid[workerPlace[0]][workerPlace[1]+2] == '#'){
							//can't move anything...
						}
						else{
							if(grid[workerPlace[0]][workerPlace[1]] == 'w'){
								grid[workerPlace[0]][workerPlace[1]] = '.';
							}
							else if(grid[workerPlace[0]][workerPlace[1]] == 'W'){
								grid[workerPlace[0]][workerPlace[1]] = '+';
							}
							workerPlace[1]++;
							grid[workerPlace[0]][workerPlace[1]] = 'W';
							if(grid[workerPlace[0]][workerPlace[1]+1] == '.'){
								grid[workerPlace[0]][workerPlace[1]+1] = 'b';
							}
							else grid[workerPlace[0]][workerPlace[1]+1] = 'B';
						}
					}
				}
				else{
					//off grid
				}
			}
		}
		else{} //invalid move
	}
	
	public static boolean isComplete(){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == 'b'){
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static int[] findWorker(){
		int [] place = new int[2];
		
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == 'w' || grid[i][j] == 'W'){
					place[0] = i;
					place[1] = j;
				}
			}
		}
		
		return place;
	}
	
	public static void printGrid(char [][] grid){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}


/*

8 9
#########
#...#...#
#..bb.b.#
#...#w#.#
#...#b#.#
#...++++#
#...#..##
#########
ULRURDDDUULLDDD
6 7
#######
#..####
#.+.+.#
#.bb#w#
##....#
#######
DLLUDLULUURDRDDLUDRR
0 0

*/