/**
 * Linear Parameter Optimiser
 * Optimises a set of parameters based on a training data set
 */
package core;

import data.DataRecord;
import data.DataSet;

public class LinearParameterOptimiser extends ParameterOptimiser {
	
	public LinearParameterOptimiser(DataSet d, double[] p) {
		super(d, p);
	}
	
	protected double computeCurrentCost() {
		// Cost is half the average squared error over the entire training set
		double cost = 0.0;
		int dataSetSize = data.getSize();
		
		for(int i = 0; i < dataSetSize; i++) {
			DataRecord currentRecord = data.get(i);
			
			cost += Math.pow(Hypothesis.computeLinearHypothesis(currentRecord, parameters) - currentRecord.getResult(), 2);
		}
		cost = cost / (2 * dataSetSize);
		return cost;
	}
	
	protected double computeCurrentCostDerivative(int feature) {
		double deriv = 0.0;
		int dataSetSize = data.getSize();
		
		for(int i = 0; i < dataSetSize; i++) {
			DataRecord currentRecord = data.get(i);
			
			deriv += (Hypothesis.computeLinearHypothesis(currentRecord, parameters) - currentRecord.getResult()) * currentRecord.getFeature(feature);
		}
		deriv = deriv / dataSetSize;
		return deriv;
	}
}
