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
	private double[] featureMaximums;
	private double[] featureMeans;
	
	public DataSet(String filename) {
		this.initialise(filename);
		this.scaleData();
	}
	
	public int getSize() {
		return records.size();
	}
	
	public void add(DataRecord r) {
		records.add(r);
		
		System.out.println("Added new data record (#" + this.getSize() + ")");
	}
	
	public double[] getFeatureMeans() {
		return featureMeans;
	}
	
	public double[] getFeatureMaximums() {
		return featureMaximums;
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
	
	private void initialise(String filename) {
		System.out.println("Data set initialised");
		records = new ArrayList<DataRecord>();
		try {
			this.loadDataFromFile(filename);
		} catch(IOException e) {
			System.out.println("Error loading data file");
		}
		featureMaximums = new double[records.get(0).getLength() - 1];
		featureMeans = new double[records.get(0).getLength() - 1];
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
	
	private void scaleData() {
		System.out.println("Beginning data normalisation");
		
		// Get the mean for each feature
		for(int i = 1; i < records.get(0).getLength(); i++) {
			// Find the mean of the feature
			double sum = 0.0;
			for(int j = 0; j < records.size(); j++) {
				sum += records.get(j).getFeature(i);
			}
			featureMeans[i-1] = sum / records.size();
		}
		// Normalise each record around the means
		for(int j = 0; j < records.size(); j++) {
			records.get(j).normaliseMean(featureMeans);
		}
		
		// Get the max for each feature
		for(int i = 1; i < records.get(0).getLength(); i++) {
			// Find the maximum
			for(int j = 0; j < records.size(); j++) {
				double absFeature = Math.abs(records.get(j).getFeature(i));
				if(absFeature > featureMaximums[i-1]) {
					featureMaximums[i-1] = absFeature;
				}
			}
		}
		// Divide each record by the max to get a range of -1 to 1
		for(int j = 0; j < records.size(); j++) {
			records.get(j).normaliseMax(featureMaximums);
		}
		
		System.out.println("Data normalised");
	}
}
