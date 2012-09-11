/**
 * DataRecord
 * Represents a single data record in the system
 * 0th feature returned automtically as 1
 */
package data;

public class DataRecord {
	private double[] data;
	private double result;
	
	public DataRecord(double[] d, double r) {
		data = d;
		result = r;
	}
	
	public int getLength() {
		return data.length + 1;
	}
	
	public double getFeature(int pos) throws DataAlignmentException {
		if(pos < 0 || pos > data.length) {
			throw new DataAlignmentException("DataAlignmentException: Tried to access non-existant feature in data record.");
		} else if(pos == 0) {
			return 1;
		} else {
			return data[pos-1];
		}
	}
	
	public double getResult() {
		return result;
	}
}
