/**
 * Linear Regression Model
 * This class represents a single linear regression case.
 */
package models;

import data.DataSet;

public class LinearRegressionModel {

	private DataSet data;
	private double[] parameters;
	
	public LinearRegressionModel(DataSet d) {
		data = d;
		int numOfParams = d.get(0).getLength();
		// Initialise parameters to 0
		parameters = new double[numOfParams];
		for(int i = 0; i < numOfParams; i++) {
			parameters[i] = 0.0;
		}
	}
	
}
