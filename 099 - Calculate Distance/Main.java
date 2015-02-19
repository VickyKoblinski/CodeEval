import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * CodeEval - Calculate Distance
 * 
 * 
 * @author Vicky
 *
 */



public class Main {

	/**
	 * Given two points, find the distance. 
	 *		The formula for finding the distance between two points (p1 and p2) is
	 *				a^2 + b^2 = c^2
	 *		where
	 *				a = change in x
	 *				b = change in y
	 *				c = distance between p1 and p2
	 *		Solving for c we get
	 *				c = sqrt(a^2+b^2)
	 *		or
	 *				c = sqrt((x1-x2)^2+(y1-y2)^2)
	 *
	 *	Our input file contains 2 points on each line. This program first parses out all the non-numbers 
	 * (except for '-') and then we have an array that contains { x1, y1, x2, y2 } in that order. From
	 * here, we can simply substitue these values into our formula to get the distance.
	 * 
	 * @param args Path String containing the path of the file to read 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = getFileContents(args[0]);
		
		
		String input;
		while((input = in.readLine()) != null){

			input = input.replaceAll("\\(|\\)|,", "");
			
			
			String[] points = input.split(" ");
			
			int[] p1 = 	{	Integer.parseInt(points[0]),
							Integer.parseInt(points[1])
						};
			int[] p2 =	{	Integer.parseInt(points[2]),
							Integer.parseInt(points[3])
			};
			
	
			//a^2+b^2=c^2
			
			int a = Math.abs(p1[0]-p2[0]);
			int b = Math.abs(p1[1]-p2[1]);
			
			int c = (int)Math.sqrt(a*a+b*b);
			
			System.out.println(c);
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
	
