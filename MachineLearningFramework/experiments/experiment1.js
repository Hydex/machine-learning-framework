/*
	Experiment 1 
	Testing the basic linear regression functions for accuracy.

	Objective: Discover patterns in "weather data" (fabricated for testing purposes)
	Training Data Template: [1, <dayOfTheWeek> (1...7), <season> (1...4)]
	Training Answer Template: <temperature> (celsius)
*/

/* x: Your training data, the first feature in each example should always be 1 */
var x = [
	[1, 1, 1],
	[1, 2, 1],
	[1, 3, 1],
	[1, 4, 1],
	[1, 5, 1],
	[1, 6, 1],
	[1, 7, 1],
	[1, 1, 2],
	[1, 2, 2],
	[1, 3, 2],
	[1, 4, 2],
	[1, 5, 2],
	[1, 6, 2],
	[1, 7, 2],
	[1, 1, 3],
	[1, 2, 3],
	[1, 3, 3],
	[1, 4, 3],
	[1, 5, 3],
	[1, 6, 3],
	[1, 7, 3],
	[1, 1, 4],
	[1, 2, 4],
	[1, 3, 4],
	[1, 4, 4],
	[1, 5, 4],
	[1, 6, 4],
	[1, 7, 4],
]

/* y: The correct answers for your training data */
var y = [
	42,
	40,
	38,
	36,
	34,
	32,
	30,
	36,
	34,
	32,
	30,
	28,
	26,
	24,
	20,
	18,
	16,
	14,
	12,
	10,
	8,
	26,
	24,
	22,
	20,
	18,
	16,
	14,
]

/* m: The number of training examples */
var m = x.length;

/* p: The parameters of the hypothesis */
var p = [
	0,
	0,
	0,
];

/* Data error check: The vectors x and y must have the same length */
if(m != y.length) console.log("Data Error: Training Data and training answers must be the same length." +
	"\nNumber of training examples: " + m +
	"\nNumber of training answers: " + y.length);

/* Data error check: xp must be a valid matrix multiplication */
if(x[0].length != p.length) console.log("Data Error: The number of hypothesis parameters specified is " +
	"not in line with the number of features in the training examples" +
	"\nNumber of hypothesis parameters: " + p.length +
	"\nNumber of features: " + x[0].length);

/* Run gradient descent on the training data, evaluate the cost function along the way */
var data = linRegRunGradientDescent(x, y, p, 0.08, 10000);
p = data[0];
var normOffsets = data[1];
var normScaleFactors = data[2];

/* Test the algorithm */
console.log(linRegNormaliseInput([1, 7, 3], normOffsets, normScaleFactors));
console.log(linRegComputeHypothesis(linRegNormaliseInput([1, 1, 4], normOffsets, normScaleFactors), p));
console.log(p);