import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * For each string of integers in the input file, print 1 if the 
 * string is self describing or 0 if it is not.
 * 
 * 1) Cycle through the list of numbers
 * 1.1) For each number, cycle through the digits
 * 1.1.1) For each digit, tally how often that digit occurs in a new string at the same index location as the number itself
 * 1.2) Check if the original number is the same as the newly created number. If true, print 1. If false, print 0.
 * 
 * @author Vicky
 *
 */



public class run {

	/**
	 * 
	 * Main method to evalute if a number is self describing. Prints 1 if true and 0 if false. 
	 * 
	 * @param args Path String containing the path of the file to read 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = getFileContents(args[0]);
		
		String input;
		while((input = in.readLine()) != null){
			
			System.out.println(isSelfDescribing(input.toCharArray()));		
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
	
	

	/**
	 * Creates an identical-length array and cycles through the original number. Each time a number is 
	 * visited, it is then marked in the second array. After the first array is exhausted, cycle through 
	 * it and compare it to the new array. Return 1 if they're identical or 0 if they aren't.
	 * 
	 * @param inputChar Character array containing the integers to be tested.
	 * @return 1 if the string is self describing or 0 if it is not.
	 */
	private static int isSelfDescribing(char[] inputChar){
		int length = inputChar.length;
		int[] output = new int[length];
			
		for(int i = 0; i<length; i++){
			int input = Character.getNumericValue(inputChar[i]);
			
			if(input>length-1) return 0; //End early if the input number is greater than the overall length of the string.
			output[input]++;
		}
		
		for(int i = 0; i<length; i++){
			int input = Character.getNumericValue(inputChar[i]);
			if(input != output[i]) return 0;
		}
		return 1;
		
	}

	
}


