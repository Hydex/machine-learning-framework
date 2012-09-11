/**
 * Parameterisation
 * 
 * Represents a union between a single data record and a set of parameters
 * Also known as a linear parameterisation, or linear hypothesis
 */

package core;

import data.DataAlignmentException;

public class Parameterisation {
	int[] record;
	int[] parameters;
	
	public Parameterisation(int[] r, int[] p) throws DataAlignmentException {
		if(r.length != p.length) {
			throw new DataAlignmentException();
		} else {
			record = r;
			parameters = p;
		}
	}
	
	public int compute() {
		int sum = 0;
		for(int i = 0; i < record.length; i++) {
			sum += record[i] * parameters[i];
		}
		return sum;
	}
}
