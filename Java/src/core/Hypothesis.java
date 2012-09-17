/**
 * Hypothesis
 * 
 * Contains methods to compute a range of hypothesis
 */
package core;

import data.DataRecord;

public class Hypothesis {
	
	public static double computeLinearHypothesis(DataRecord record, double[] parameters) {
		double sum = 0;
		for(int i = 0; i < record.getLength(); i++) {
			sum += record.getFeature(i) * parameters[i];
		}
		return sum;
	}
	
	public static double computeLogisticHypothesis(DataRecord record, double[] parameters) {
		double linearHypothesis = computeLinearHypothesis(record, parameters);
		return 1 / (1 + Math.pow(Math.E, -linearHypothesis));
	}
}
