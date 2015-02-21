import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
/**
 * CodeEval - Morse Code
 * 
 * 
 * @author Vicky
 *
 */



public class Main {	


	/**
	 * Parse the strings into expected form for characters, and then look up those 
	 * characters in the created index tree.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {		
		BufferedReader in = getFileContents(args[0]);
		final TreeMap<String,String> tm = buildMorseTree();
		
		
		String input;
		while((input = in.readLine()) != null){
			String[] words = input.split("  "); //morse code line to morse code words
			
			for(String word : words){
				System.out.printf("%s ",getMorseWord(tm,word));
			}
			
			System.out.println();
		}
	}


	/**
	 * Simply breaks the morse code words into morse code characters and then looks
	 * them up in the tree creating a word to return back.
	 * 
	 * @param tm
	 * @param word
	 * @return
	 */
	private static String getMorseWord(TreeMap<String,String> tm,String word){
		StringBuilder sb = new StringBuilder();
		
		for(String letter : word.split((" "))){
			sb.append(tm.get(letter));
		}
		
		return sb.toString();
	}


	
	
	/**
	 * Builds the lookup tree to make translating from Morse to character fast and simple.
	 * @return Red Black Morse Code translation tree
	 */

	private static TreeMap<String,String> buildMorseTree(){
		final TreeMap<String,String> mt = new TreeMap<String,String>();
		
		//from wikipedia.org/wiki/Morse_code
		mt.put(".-", "A");
		mt.put("-...", "B");
		mt.put("-.-.", "C");
		mt.put("-..", "D");
		mt.put(".", "E");
		mt.put("..-.", "F");
		mt.put("--.", "G");
		mt.put("....", "H");
		mt.put("..", "I");
		mt.put(".---", "J");
		mt.put("-.-", "K");
		mt.put(".-..", "L");
		
		mt.put("--", "M");
		mt.put("-.", "N");
		mt.put("---", "O");
		mt.put(".--.", "P");
		mt.put("--.-", "Q");
		mt.put(".-.", "R");
		mt.put("...", "S");
		mt.put("-", "T");
		mt.put("..-", "U");
		mt.put("...-", "V");
		mt.put(".--", "W");
		mt.put("-..-", "X");
		
		mt.put("-.--", "Y");
		mt.put("--..", "Z");
		mt.put(".----", "1");
		mt.put("..---", "2");
		mt.put("...--", "3");
		mt.put("....-", "4");
		mt.put(".....", "5");
		mt.put("-....", "6");
		mt.put("--...", "7");
		mt.put("---..", "8");
		mt.put("----.", "9");
		mt.put("-----", "0");
		
		return mt;
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

