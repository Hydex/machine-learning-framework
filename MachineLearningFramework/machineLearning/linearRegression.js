/*	Compute a linear hypothesis 
	x = the function input (a single vector) 
	p = the hypothesis parameters (a single vector of the same length as x) */
function linRegComputeHypothesis(x, p) {
	var ans = 0;
	for(var ft in x) {
		ans += x[ft] * p[ft];
	}
	return ans;
}

/*	Compute a linear regression cost function
	x = the set of training examples
	y = the set of training answers
	p = the hypothesis parameters */
function linRegComputeCostFunction(x, y, p) {
	var ans = 0;
	for(var n in x) {
		ans += Math.pow(linRegComputeHypothesis(x[n], p) - y[n], 2);
	}
	ans /= (2 * x.length);
	return ans;
}

/*	Runs a single iteration of gradient descent for linear regression
	x = the set of training examples
	y = the set of training answers
	p = the initial hypothesis parameters
	a = the learning rate
	returns the revised hypothesis parameters */
function linRegGradientDescentIteration(x, y, p, a) {
	var newp = new Array();
	for(var i in p) {
		ans = 0;
		for(var n in x) {
			ans += (linRegComputeHypothesis(x[n], p) - y[n]) * x[n][i];
		}
		ans *= a;
		ans /= x.length;
		ans = p[i] - ans;
		newp[i] = ans;
	}
	return newp;
}

/*	Runs a full cycle of gradient descent for linear regression for rep repetitions or until convergence
	x, y, p and a are as above
	rep is the number of repetitions
	returns the revised hypothesis parameters */
function linRegRunGradientDescent(x, y, p, a, rep) {
	var prevp = 0;
	var prevcf = 0;
	var cf = 1;
	var iteration = 1;
	
	// Normalisation
	normOffsets = linRegCenterFeatures(x);
	normScaleFactors = linRegScaleFeatures(x);

	while((iteration <= rep || rep == 0) && cf != prevcf) {
		prevcf = cf; cf = linRegComputeCostFunction(x,y,p);
		console.log("it: " + iteration + ". cc: " + cf + ". Current parameters are: " + p);
		prevp = p; p = linRegGradientDescentIteration(x, y, p, a);
		
		if(cf == prevcf) { console.log("Gradient descent has converged."); }
		iteration++;
	}
	return [p, normOffsets, normScaleFactors];
}

/*	Automatically center the features in a training set for linear regression
	Returns the offsets */
function linRegCenterFeatures(x) {
	var offsets = new Array(x[0].length);
	offsets[0] = 0;
	for(var i = 1; i < x[0].length; i++) {
		var sum = 0; for(var j = 0; j < x.length; j++) { sum += x[j][i]; } // get the sum
		offsets[i] = sum / x.length;
		for(var j = 0; j < x.length; j++) { x[j][i] = x[j][i] - offsets[i]; }
	}
	return offsets;
}

/* Automatically scale the features in a training set for lear regression
	Returns the scale factors */
function linRegScaleFeatures(x) {
	var scaleFactors = new Array(x[0].length);
	scaleFactors[0] = 1;
	for(var i = 1; i < x[0].length; i++) {
		var max = 0; for(var j = 0; j < x.length; j++) { if(Math.abs(x[j][i]) > max) { max = Math.abs(x[j][i]); } } // get the max
		scaleFactors[i] = max;
		for(var j = 0; j < x.length; j++) { x[j][i] = x[j][i] / scaleFactors[i]; }
	}
	return scaleFactors;
}

/* Normalise a single input */
function linRegNormaliseInput(x, o, p) {
	for(var i = 1; i < x.length; i++) {
		x[i] = (x[i] - o[i]) / p[i];
	}
	return x;
}