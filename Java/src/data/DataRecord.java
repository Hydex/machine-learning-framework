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
	
	public double getFeature(int pos) {
		if(pos < 0 || pos > data.length) {
			System.out.println("Error: Tried to access non-existant feature in data record.");
			System.exit(1);
			return 0.0;
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
