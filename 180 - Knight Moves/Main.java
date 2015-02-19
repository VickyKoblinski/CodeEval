import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * CodeEval - Knight Moves
 * 
 * 
 * @author Vicky
 *
 */



public class Main {	
	//Global variables for knight's position
	private static int row;
	private static int col;

	/**
	 * This program reads in each line from the input file as a location on an 8x8
	 * chess board which is character represented horizontally (a-h) and numbered 
	 * vertically (1-8).
	 * 
	 * The program takes the starting location as given by the input file and outputs
	 * all possible moves that the chess piece can make, assuming that it is a knight.
	 * 
	 * 
	 * @param args Path String containing the path of the file to read 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {		
		BufferedReader in = getFileContents(args[0]);
		/* Array of all knight's moves in, what will result in, alphabetical order. 
		 */
		final int[][] moves = 		{	{-2,-1}, {-2,1},
										{-1,-2}, {-1,2},
										{1,-2} , {1,2} ,
										{2,-1} , {2,1} };
				
		String input;
		while((input = in.readLine()) != null){
			//Saves the integer value of the characters
			row = input.charAt(0);
			col = input.charAt(1);
			
			
			// Prints each valid move		
			for(int[] m : moves){
				System.out.print(getChange(m[0],m[1]));
			}

			
			System.out.println();
			
		}
	}
	

	/**
	 * This method takes in two integers that represent where the chess piece will 
	 * try to move to. If the move passes the horizontal and vertical check, then 
	 * the string containing the location is returned.
	 * 
	 * @param rowChange Number of spaces to move to up (or down if rowChange is negative)
	 * @param colChange Number of spaces to move to the right (or left if colChange is negative)
	 * @return (string) 
	 */
	private static String getChange(int rowChange, int colChange){
		int currentRow = getNewRow(rowChange);
		int currentCol = getNewCol(colChange);
		if(!h(currentRow) || !v(currentCol)){
			return "";
		}		
		
		return  Character.toString((char)currentRow) + Character.toString((char)currentCol) + " ";
		
	}
	
	
	/**
	 * Simple methods for returning the potential new row and column location.
	 * @param i Number of moves
	 */
	private static int getNewRow(int i){
		return i+row;
	}
	private static int getNewCol(int i){
		return i+col;
	}
	

	/**
	 * Methods for checking if the horizontal and vertical changes exist on the board.
	 * @param i New potential location
	 */
	private static boolean h(int i){
		return isValid('a','h',i);
	}
	private static boolean v(int i){
		return isValid('1','8',i);
	}
	
	private static boolean isValid(int min, int max, int move){
		return move>=min && move<=max;		
	}
	

	
	
	/**
	 * Simple method for taking a file location of a readable document and returning a more approparate object for working with this file's contents.
	 * 
	 * @param path String containing the path of the file to read 
	 * @return BufferedReader to later be iterated over
	 * @throws FileNotFoundException
	*/
	private static BufferedReader getFileContents(String path) throws FileNotFoundException{
		File file = new File(path);
		return new BufferedReader(new FileReader(file));	
	}
	

}

