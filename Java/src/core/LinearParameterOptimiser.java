/**
 * Linear Parameter Optimiser
 * Optimises a set of parameters based on a training data set
 */
package core;

import data.DataRecord;
import data.DataSet;

public class LinearParameterOptimiser {
	private DataSet data;
	private double[] parameters;
	
	public LinearParameterOptimiser(DataSet d, double[] p) {
		data = d;
		parameters = p;
	}
	
	// TODO: Write optimise method that makes use of runGradientDescent
	
	private void runGradientDescent(int learningRate) {
		// Adjust each parameter simultaneously
		double[] newParams = new double[parameters.length];
		for(int i = 0; i < parameters.length; i++) {
			newParams[i] = parameters[i] - (learningRate * computeCurrentCostDerivative(i));
		}
		this.parameters = newParams;
	}
	
	private double computeCurrentCost() {
		// Cost is half the average squared error over the entire training set
		double cost = 0.0;
		int dataSetSize = data.getSize();
		
		for(int i = 0; i < dataSetSize; i++) {
			DataRecord currentRecord = data.get(i);
			
			Parameterisation p = new Parameterisation(currentRecord, parameters);
			cost += Math.pow(p.compute() - currentRecord.getResult(), 2);
		}
		cost = cost / (2 * dataSetSize);
		return cost;
	}
	
	private double computeCurrentCostDerivative(int feature) {
		double deriv = 0.0;
		int dataSetSize = data.getSize();
		
		for(int i = 0; i < dataSetSize; i++) {
			DataRecord currentRecord = data.get(i);
			
			Parameterisation p = new Parameterisation(currentRecord, parameters);
			deriv += (p.compute() - currentRecord.getResult()) * currentRecord.getFeature(feature);
		}
		deriv = deriv / dataSetSize;
		return deriv;
	}
}
