import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * CodeEval - Without Repetitions
 * 
 * 
 * @author Vicky
 *
 */



public class Main {

	/**
	 * This program removes repeated characters. ("Ii willl see you" becomes "Ii wil se you")
	 * 
	 * This simple program traverses a string and keeps track of the last character it's seen. If
	 * the next character is equal to the last, then we continue until we find a new character. 
	 * 
	 * When a new character is found, it is printed and the pointer changes to reference this new
	 * character for the next iteration. 
	 * 
	 * @param args Path String containing the path of the file to read 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = getFileContents(args[0]);
		
		
		String input;
		while((input = in.readLine()) != null){
			
			char last = '\0'; //"empty" character

			for(char c : input.toCharArray()){
				if(c != last){
					System.out.print(c);
					last = c;
				}
			}
			
			System.out.println();
		}
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
	
