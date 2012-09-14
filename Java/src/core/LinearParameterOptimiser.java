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
		System.out.println("Linear parameter optimiser initialised");
		
		data = d;
		parameters = p;
	}
	
	public void optimise(double learningRate) {
		System.out.println("Commencing parameter optimisation routine");
		boolean optimised = false;
		int iteration = 0;
		while(!optimised) {
			// Record the current cost function
			double curCost = computeCurrentCost();
			// Run gradient descent
			runGradientDescent(learningRate);
			// Record the new cost function, if it's the same, the parameters are optimised
			double newCost = computeCurrentCost();
			if(newCost == curCost) optimised = true;
			
			iteration++;
			System.out.println("Completed gradient descent iteration " + iteration + ". Current cost is " + newCost);
		}
		// Finished optimising
		System.out.println("Parameter optimisation complete");
	}
	
	public double[] getParameters() {
		return parameters;
	}
	
	private void runGradientDescent(double learningRate) {
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
