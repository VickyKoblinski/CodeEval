import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * CodeEval - Roller Coaster
 * 
 * 
 * @author Vicky
 *
 */



public class Main {

	/**
	 * Takes input file and sends it to printRollerCoaster() line by line.
	 * 
	 * @param args Path String containing the path of the file to read 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = getFileContents(args[0]);
		
		
		String input;
		while((input = in.readLine()) != null){

			printRollerCoaster(input.toCharArray());
				
		}
	}



	/**
	 * Main work of the program. Each character is first evaluted to determine if it is a letter or not. 
	 * If it isn't a letter, print the character. If it is a letter, then print the upper or lower case version
	 * of that letter and switch the flag so that the opposite case will be printed when the next letter is found.
	 * 
	 * @param line Char array of a line of text from the input file. 
	 * 
	 */

	private static void printRollerCoaster(char[] line) {
		boolean toUpperCase = true;
		
		for(char c : line){
			if(Character.isLetter(c)){				
				System.out.print(toUpperCase ? Character.toUpperCase(c) : Character.toLowerCase(c)); //Print the correct casing

				toUpperCase = !toUpperCase;
				
			} else {
				System.out.print(c);
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
	
