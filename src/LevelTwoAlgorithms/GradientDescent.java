package LevelTwoAlgorithms;

import Utility.Weights;

public class GradientDescent {
	
	public Weights weights = new Weights();
	
	public void updateWeights(float fnameMatch, float lnameMatch, float addressMatch, float target, int sample) {
	        weights.fname += weights.alpha * target * (float)(1.0 /(float) sample) * Math.pow((double)(target - fnameMatch), 2);
	        weights.lname += weights.alpha * target * (float)(1.0 /(float) sample) * Math.pow((double)(target - lnameMatch), 2);
	        weights.address += weights.alpha * target * (float)(1.0 /(float) sample) * Math.pow((double)(target - addressMatch), 2);
	    }
}