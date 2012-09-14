import models.LinearRegressionModel;
import data.DataRecord;
import data.DataSet;


public class Controller {
	public static void main(String[] args) {
		DataSet data = new DataSet("data.csv");
		LinearRegressionModel model = new LinearRegressionModel(data);
		
		System.out.println("Testing model");
		
		// TODO Debug why this isn't working
		double[] testData = {10.0};
		System.out.println("Test 1: 20 / " + model.query(new DataRecord(testData)));
		testData[0] = 41.305;
		System.out.println("Test 2: 82.61 / " + model.query(new DataRecord(testData)));
	}
}
