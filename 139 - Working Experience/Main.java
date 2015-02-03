import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * CodeEval - Working Experience
 * 
 * 
 * @author Vicky
 *
 */



public class Main {

	/**
	 * Given a list of dates, this program outputs the number of years the person has worked.
	 * Each date is transformed into a unique number that represents that date:
	 *                 DateNumber = (Year-1990) + (Month as a number from 0 to 11)
	 * 1990 is the lower bounds for a possible year, making DateNumber = 0 when Year=1990 and Month=0
	 * 
	 * There are 372 valid months, the size of the boolean array. When the date is visited, the corresponding
	 * entry in the boolean is flipped to True and later tallied to find the number of unique months worked.
	 * 
	 * @param args Path String containing the path of the file to read 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = getFileContents(args[0]);
		
		
		String input;
		while((input = in.readLine()) != null){
			boolean[] worked = new boolean[372];
			String[] ranges = input.split(";");
			
			for(String range : ranges){
				String[] startEnd = range.split("-");
				
				int startDate = toInt(startEnd[0].trim());
				int endDate = toInt(startEnd[1].trim());
				
				for(int i = startDate; i<=endDate; i++){
					worked[i] = true;
				}
			}
					
			System.out.println(sumMonthsWorked(worked)/12);
				
		}
		

	}
	
	/**
	 * Simple method that loops through array and returns the number of unique months worked.
	 * 
	 * @param months
	 * @return Number of unique months worked
	 */
	private static int sumMonthsWorked(boolean[] months){
		int monthsWorked = 0;
		for(Boolean workedMonth : months){
			if(workedMonth) monthsWorked++;
		}
		return monthsWorked;
	}
	
	/**
	 * Method used to transform a String date to a corresponding integer from 0-371.
	 * 
	 * @param date String in the format of "Month Year" where "Month" is the first three characters 
	 *   of an American calendar month, with the first character capitalized.
	 * @return Date as represented by an integer from 0 to 371
	 * @throws IllegalArgumentException Year is out of bounds. 1990-2020 is the legal bounds. 
	 * 
	 */	
	private static int toInt(String date){
		int intMonth;
		int intYear;
		int intDate;
		String[] monthYear = date.split(" ");
				
		intMonth = Month.getMonth(monthYear[0]).ordinal();
		intYear = Integer.parseInt(monthYear[1])-1990;
		
		if(intYear < 0 || intYear > 30) throw new IllegalArgumentException("Illegal year range: "+intYear);
		
		
		intDate = intYear*12 + intMonth;
		
		
		return intDate;
	}
	
	/**
	 * Enum representing months and used to turn a string into a Month
	 * 
	 */
	private enum Month {
		JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;
		
		/**
		 * 
		 * @return Enum represented by the input string, if it exists
		 * @param month Expected string for each month
		 * @throws IllegalArgumentException when an invalid string date is passed to getMonth
		 * 
		 */
		public static Enum<Month> getMonth(String month){
			switch(month){
				case "Jan": return JAN;
				case "Feb": return FEB;
				case "Mar": return MAR;
				case "Apr": return APR;
				case "May": return MAY;
				case "Jun": return JUN;
				case "Jul": return JUL;
				case "Aug": return AUG;
				case "Sep": return SEP;
				case "Oct": return OCT;
				case "Nov": return NOV;
				case "Dec": return DEC;
				default:
					throw new IllegalArgumentException("Invalid month");
				
			}
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
	
