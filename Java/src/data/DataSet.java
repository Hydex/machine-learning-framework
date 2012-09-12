/**
 * DataSet
 * Holds a collection of data records
 */
package data;

import java.util.ArrayList;

public class DataSet {
	private ArrayList<DataRecord> records;
	
	public DataSet() {
		records = new ArrayList<DataRecord>();
	}
	
	public int getSize() {
		return records.size();
	}
	
	public void add(DataRecord r) {
		records.add(r);
	}
	public DataRecord get(int pos) {
		try {
			return records.get(pos);
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Error: Tried to access non-existant data record in data set.");
			System.exit(1);
			return null;
		}
	}
}
