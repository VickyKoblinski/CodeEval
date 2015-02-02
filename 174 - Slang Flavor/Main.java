import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * CodeEval - Slang Flavor
 * 
 * 
 * @author Vicky
 *
 */



public class Main {

	/**
	 * 
	 * Main method that does the "work". The method sifts through each character of the file and
	 * evaluates if it is one of the trigger punctuation. If it is not a trigger punctuation, then
	 * the current character is simply printed as-is. If it is a trigger punctuation then method
	 * determines if this is an even instance or an odd instance. If odd, then nothing special happens
	 * and the character is printed. If it is even, then the character is not printed and
	 * instead the next slang phrase in the queue is printed and placed in the back of the queue. 
	 * 
	 * 
	 * 
	 * @param args Path String containing the path of the file to read 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Queue<String> nextSlang = initializeQueue();	//Queue of slang phrases
		
		BufferedReader in = getFileContents(args[0]);
		
		boolean isEvenPunctuation = true;				//Must start as true because the value is flipped upon first inspection
		
		String input;
		while((input = in.readLine()) != null){
			for(Character c : input.toCharArray()){
				switch(c){								//Easily expendable to new trigger characters
					case '.':
					case '!':
					case '?':
						isEvenPunctuation = !isEvenPunctuation;

						if(isEvenPunctuation){
							System.out.print(nextSlang.peek());
							nextSlang.add(nextSlang.poll());
							break;
						} 					
					default:
						System.out.print(c);
						break;						
				}
							
			}
			System.out.println();	
				
		}
	}
	
	
	/**
	 * Simply initializes the queue of slang phrases. Open to easily add new phrases or rearranging order.
	 * 
	 * @return Queue<String> of slang phrases
	 */
	private static Queue<String> initializeQueue(){
		Queue<String> slang = new ArrayDeque<String>();
		slang.add(", yeah!");
		slang.add(", this is crazy, I tell ya.");
		slang.add(", can U believe this?");
		slang.add(", eh?");
		slang.add(", aw yea.");
		slang.add(", yo.");
		slang.add("? No way!");
		slang.add(". Awesome!");
		return slang;
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
	
