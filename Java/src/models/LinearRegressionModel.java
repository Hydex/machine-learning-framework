/**
 * Linear Regression Model
 * This class represents a single linear regression case.
 */
package models;

import core.LinearParameterOptimiser;
import core.Hypothesis;
import data.DataRecord;
import data.DataSet;

public class LinearRegressionModel {

	private DataSet data;
	private double[] parameters;
	
	public LinearRegressionModel(DataSet d) {
		System.out.println("Creating linear regression model");
		
		data = d;
		
		// Initialise parameters to 0
		int numOfParams = d.get(0).getLength();
		parameters = new double[numOfParams];
		for(int i = 0; i < numOfParams; i++) {
			parameters[i] = 0.0;
		}
		
		this.learn();
	}
	
	public double query(DataRecord r) {
		r.normaliseMean(data.getFeatureMeans());
		r.normaliseMax(data.getFeatureMaximums());
		return Hypothesis.computeLinearHypothesis(r, parameters);
	}
	
	private void learn() {
		System.out.println("Beginning model learning process with supplied data");
		
		// Optimise parameters
		LinearParameterOptimiser parOpt = new LinearParameterOptimiser(data, parameters);
		parOpt.optimise();
		parameters = parOpt.getParameters();
	}
	
}
