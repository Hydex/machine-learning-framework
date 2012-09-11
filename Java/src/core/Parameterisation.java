/**
 * Parameterisation
 * 
 * Represents a union between a single data record and a set of parameters
 * Also known as a linear parameterisation, or linear hypothesis
 */
package core;

import data.DataAlignmentException;
import data.DataRecord;

public class Parameterisation {
	private DataRecord record;
	private double[] parameters;
	
	public Parameterisation(DataRecord r, double[] p) throws DataAlignmentException {
		if(r.getLength() != p.length) {
			throw new DataAlignmentException("DataAlignmentException: Number of parameters not aligned with number of features in data record.");
		} else {
			record = r;
			parameters = p;
		}
	}
	
	public double compute() throws DataAlignmentException {
		double sum = 0;
		for(int i = 0; i < record.getLength(); i++) {
			sum += record.getFeature(i) * parameters[i];
		}
		return sum;
	}
}
