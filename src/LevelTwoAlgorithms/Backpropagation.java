package LevelTwoAlgorithms;

import Utility.Weights;

public class Backpropagation {
	
	Weights weights;
	
	void updateWeights(float fnameMatch, float lnameMatch, float addressMatch, float target) {
		weights.fname += weights.alpha * target * 0.5 * Math.pow((double)(target = fnameMatch), 2);
		weights.lname += weights.alpha * target * 0.5 * Math.pow((double)(target = lnameMatch), 2);
		weights.address += weights.alpha * target * 0.5 * Math.pow((double)(target = addressMatch), 2);
	}
}
