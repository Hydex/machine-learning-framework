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
		return records.get(pos);
	}
}
