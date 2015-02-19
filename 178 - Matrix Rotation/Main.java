import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * CodeEval - Matrix Rotation
 * 
 * 
 * @author Vicky
 *
 */



public class Main {

	/**
	 * Takes input file and breaks the contents down into easier to work with data structures. 
	 * 
	 * @param args Path String containing the path of the file to read 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = getFileContents(args[0]);
		
		
		String input;
		while((input = in.readLine()) != null){

			String[] s = input.split(" ");
						
			printRotation(toMatrix(s));


										
		}
	}
	
	
	/**
	 * This method takes a single-dimensional array of values and transforms it into a square matrix.
	 * 
	 * @param s single-dimensional array of the matrix
	 * @return char[][] Matrix
	 * @throws IllegalArgumentException String cannot create a square matrix. 
	 * 
	 */
	private static char[][] toMatrix(String[] s){
		double num = Math.sqrt(s.length);
		
		if((int)num != num){
			throw new IllegalArgumentException("Not a square matrix.");
		}
		
		int n = (int)num;
		char[][] matrix = new char[n][n];
		
		for(int i = 0; i<n; i++){
			for(int j=0; j<n; j++){
				matrix[i][j] = s[i*n+j].charAt(0);
			}
		}
		
		return matrix;
	}
	


	/**
	 * Cycles through the matrix in such a way to print the desired rotated matrix result.
	 * 
	 * Goes through each column of the array in ascending order and in each column prints the row in decending order.
	 * 
	 * example: Instead of matrix[row 0][column 0] printing first, matrix[row matrix.size-1][column 0] followed by
	 * 					   matrix[row 0][column 1]				   matrix[row matrix.size-2][column 0]
	 * 
	 * @param m Matrix to rotate
	 * 
	 */
	private static void printRotation(char[][] m){
		
		for(int i = 0; i<m.length; i++){
			
			for(int j = m.length-1; j>=0; j--){
				char print;

				print = m[j][i];
				
				System.out.print(print + " ");
			}
		}
		System.out.println();
		
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
	
