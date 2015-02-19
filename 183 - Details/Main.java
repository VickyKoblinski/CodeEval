import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * CodeEval - Detail
 * 
 * 
 * @author Vicky
 *
 */



public class Main {	


	/**
	 * This program reads in each line from the input file and
	 * determines how many spaces the Y's can get closer to the X's
	 * assuming the Y's cannot break form and that the '.'s are 
	 * empty spaces. 
	 * 
	 * The number of spaces that it can move is printed before moving 
	 * to the next case. 
	 * 
	 * 
	 * @param args Path String containing the path of the file to read 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {		
		BufferedReader in = getFileContents(args[0]);
	
		String input;
		while((input = in.readLine()) != null){
			System.out.println(findMoves(input));
			
			
		}
	}






	/**
	 * The worker function. This function uses the logic that, because all X's and Y's are together
	 * and not floating, all we need to do is find the minimum number of spaces along the rows
	 * to determine if and how much the puzzle can move.
	 * 
	 * To do this, the number of spaces ( represented by '.'s) are counted
	 * in each row, and the minimum is then returned to be printed.
	 * 
	 * 
	 * @param input String containing the board layout
	 * @return number of moves that can be made
	 */

	private static int findMoves(String input) {
		String[] lines = input.split(",");
		
		int minDots = Integer.MAX_VALUE; //Initializes the minDots with the maximum integer value
		
		for(String line : lines){
			int dots = 0;
			
			for(char c : line.toCharArray()) //loop through string to count all '.'s
				if(c == '.') dots++;
			
			if(dots<minDots) minDots = dots; //Determine running minimum. 
			
			if(minDots == 0) return 0; //end early
		}
		
		return minDots;
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

