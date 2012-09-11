/**
 * DataAlignmentException
 * 
 * Thrown when data lengths mismatch. For example when trying to parameterise a 6-feature data record with a 5-parameter parameter list.
 */
package data;

@SuppressWarnings("serial")
public class DataAlignmentException extends Exception {
	
	public String toString() {
		return "Error: Data Alignment Exception";
	}

}
