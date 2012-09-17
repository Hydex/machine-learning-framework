package core;

import data.DataSet;

public abstract class ParameterOptimiser {
	protected DataSet data;
	protected double[] parameters;
	
	public ParameterOptimiser(DataSet d, double[] p) {
		System.out.println("Parameter optimiser initialised");
		
		data = d;
		parameters = p;
	}
	
	public void optimise() {
		System.out.println("Commencing parameter optimisation routine");
		double learningRate = 1.0;
		int iteration = 1, convergence = 0;
		boolean optimised = false, firstErrorEncountered = false, messagePrinted = false;
		while(!optimised) {
			System.out.println("Gradient descent iteration " + iteration + ": Current cost is "
					+ computeCurrentCost() + ". Learning rate is " + learningRate);
			int status = iterate(learningRate); iteration++;
			if(status == 0) {
				firstErrorEncountered = true;
				learningRate = learningRate / 1.3;
				System.out.println("Aligning learning parameters, algorithm may run slow or incorrect during this time");
				messagePrinted = false; convergence = 0;
			} else if(status == 1) {
				convergence++;
				if(convergence >= 10) optimised = true;
			} else if(status == 2) {
				convergence = 0;
				if(firstErrorEncountered == false) {
					learningRate = learningRate * 1.3;
					System.out.println("Aligning learning parameters, algorithm may run slow or incorrect during this time");
					messagePrinted = false;
				} else {
					if(messagePrinted == false) {
						System.out.println("Learning parameters aligned");
						messagePrinted = true;
					}
				}
			}
		}
		// Finished optimising
		System.out.println("Parameter optimisation complete");
	}
	
	public double[] getParameters() {
		return parameters;
	}
	
	private int iterate(double learningRate) {
		// Record the current cost function
		double curCost = computeCurrentCost();
		// Run gradient descent
		runGradientDescent(learningRate);
		// Record the new cost function, if it's the same, the parameters are optimised
		double newCost = computeCurrentCost();
		
		if(newCost > curCost) return 0;
		else if(newCost == curCost) return 1;
		else return 2;
	}
	
	private void runGradientDescent(double learningRate) {
		// Adjust each parameter simultaneously
		double[] newParams = new double[parameters.length];
		for(int i = 0; i < parameters.length; i++) {
			newParams[i] = parameters[i] - (learningRate * computeCurrentCostDerivative(i));
		}
		this.parameters = newParams;
	}
	
	protected abstract double computeCurrentCost();
	protected abstract double computeCurrentCostDerivative(int feature);

}
