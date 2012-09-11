/**
 * DataAlignmentException
 * 
 * Thrown when data lengths mismatch. For example when trying to parameterise a 6-feature data record with a 5-parameter parameter list.
 */
package data;

@SuppressWarnings("serial")
public class DataAlignmentException extends Exception {
	
	private String errorMessage;
	
	public DataAlignmentException(String e) {
		errorMessage = e;
	}
	
	public String toString() {
		if(errorMessage != null) {
			return errorMessage;
		} else {
			return "DataAlignmentException";
		}
	}

}
