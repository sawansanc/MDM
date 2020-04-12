package LevelTwoAlgorithms;

import Utility.Weights;

public class Backpropagation {
	
	public Weights weights = new Weights();
	
	public void updateWeights(float fnameMatch, float lnameMatch, float addressMatch, float target) {
		weights.fname += weights.alpha * target * 0.5f * (float)Math.pow((double)(target - fnameMatch), 2);
		weights.lname += weights.alpha * target * 0.5f * (float)Math.pow((double)(target - lnameMatch), 2);
		weights.address += weights.alpha * target * 0.5f * (float)Math.pow((double)(target - addressMatch), 2);
	}
}
