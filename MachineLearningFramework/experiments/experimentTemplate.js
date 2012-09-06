/*
	Experiment Template

	Matrix notation:
	[
		[88, 47, 32, 55, 18],
		[18, 33, 12, 96, 79],
		[ 6, 45, 44, 21, 68],
	]
	Access '33' via matrix[1][1] notation

	Vector notation:
	[
		88,
		47,
		32,
		55,
		18,
	]
	Access '55' via vector[3] notation
*/

/* x: Your training data, the first feature in each example should always be 1 */
var x = [
	[1, 2104],
	[1, 1416],
	[1, 1534],
	[1, 852],
]

/* y: The correct answers for your training data */
var y = [
	5129,
	4416,
	4264,
	1352,
]

/* m: The number of training examples */
var m = x.length;

/* p: The parameters of the hypothesis */
var p = [
	3000,
	1,
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

