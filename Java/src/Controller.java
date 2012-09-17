import models.LinearRegressionModel;
import data.DataRecord;
import data.DataSet;


public class Controller {
	public static void main(String[] args) {
		DataSet data = new DataSet("data.csv");
		LinearRegressionModel model = new LinearRegressionModel(data);
		
		System.out.println("Testing model");

		System.out.println("Test 1: 35 / " + model.query(new DataRecord(new double[] {10.0, 15.0} )));
		System.out.println("Test 2: 164.21 / " + model.query(new DataRecord(new double[] {41.305, 81.60} )));
	}
}
