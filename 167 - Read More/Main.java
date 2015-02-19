import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * CodeEval - Read More
 * 
 * 
 * @author Vicky
 *
 */



public class Main {

	/**
	 * This program traverses through each line of an input file and if the 
	 * string in the line is >55 characters, it is reduced to a "... <Read More>"
	 * string. If the length is <=55 character, then the line is printed without any changes. 
	 * 
	 * 
	 * @param args Path String containing the path of the file to read 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = getFileContents(args[0]);
		
		
		String input;
		while((input = in.readLine()) != null){
			
			if(input.length()>55){
				input = createReadMoreString(input);				
			} 
			
			System.out.println(input);
		}
	}


	/**
	 * The worker method for creating the Read More string.
	 * 
	 * This method first concatenates the string
	 * 		if the string contains spaces
	 * 			build back all of the string, except for the last word.
	 * 
	 * 		else if the string doesn't contain spaces
	 * 			proceed with the remaining substring
	 * 
	 * 	from here, append "... <Read More>" to the string and return the newly built string.
	 * 			
	 * 
	 * @param input String to be shortened
	 * @return String The newly formatted string
	 * 
	 */

	private static String createReadMoreString(String input) {
		input = input.substring(0, 40);
		
		StringBuilder s = new StringBuilder();
		
		if(input.contains(" ")){
			String[] substrings = input.split(" ",-1);	//Need limit to validate empty end to the array when applicable
			
			for(int i = 0; i<substrings.length-1; i++){
				s.append(substrings[i]);
				if(i<substrings.length-2) s.append(" ");
			}
			
		} else s.append(input);
		
		
		s.append("... <Read More>");
		input = s.toString();
		return input;
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
	
