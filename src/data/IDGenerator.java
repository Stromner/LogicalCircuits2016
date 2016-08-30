package data;
/**
 * Generate unique IDs for the classes {@link TwoInputBlock} and {@link Cable}.
 * 
 * @author David Strömner
 */

public class IDGenerator {
	private static int idNum = 0;
	static int getId(){
		int temp = idNum;
		idNum++;
		return temp;
	}
}
