/**
 * DataSet
 * Holds a collection of data records
 */
package data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class DataSet {
	private ArrayList<DataRecord> records;
	
	public DataSet() {
		this.initialise();
	}
	public DataSet(String filename) {
		this.initialise();
		try {
			this.loadDataFromFile(filename);
		} catch(IOException e) {
			System.out.println("Error loading data file");
		}
	}
	
	public int getSize() {
		return records.size();
	}
	
	public void add(DataRecord r) {
		records.add(r);
		
		System.out.println("Added new data record (#" + this.getSize() + ")");
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
	
	private void initialise() {
		System.out.println("Data set initialised");
		records = new ArrayList<DataRecord>();
	}
	
	private void loadDataFromFile(String filename) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(filename));
		List<String[]> fileData = reader.readAll();
		for(String[] row : fileData) {
			// Pull the first item out as the result
			double a = Double.parseDouble(row[0]);
			// Pull the remaining items out as the data
			double[] d = new double[row.length-1];
			for(int i = 1; i < row.length; i++) {
				d[i-1] = Double.parseDouble(row[i]);
			}
			this.add(new DataRecord(d, a));
		}
	}
}
