package LevelTwoAlgorithms;

import Utility.Weights;

public class GradientDescent {
	
	public Weights weights = new Weights();
	
	public void updateWeights(float fnameMatch, float lnameMatch, float addressMatch, float target, int sample) {
		weights.fname += weights.alpha * target * (float)(1 / sample) * (float)Math.pow((double)(target - (weights.fname + fnameMatch) / 2), 2);
		weights.lname += weights.alpha * target * (float)(1 / sample) * (float)Math.pow((double)(target - (weights.lname + lnameMatch) / 2), 2);
		weights.address += weights.alpha * target * (float)(1 / sample) * (float)Math.pow((double)(target - (weights.address + addressMatch) / 2), 2);
	}
}