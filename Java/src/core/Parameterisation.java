/**
 * Parameterisation
 * 
 * Represents a union between a single data record and a set of parameters
 * Also known as a linear parameterisation, or linear hypothesis
 */
package core;

import data.DataRecord;

public class Parameterisation {
	private DataRecord record;
	private double[] parameters;
	
	public Parameterisation(DataRecord r, double[] p) {
		if(r.getLength() != p.length) {
			System.out.println("Error: Number of parameters not aligned with number of features in data record.");
		} else {
			record = r;
			parameters = p;
		}
	}
	
	public double compute() {
		double sum = 0;
		for(int i = 0; i < record.getLength(); i++) {
			sum += record.getFeature(i) * parameters[i];
		}
		return sum;
	}
}
