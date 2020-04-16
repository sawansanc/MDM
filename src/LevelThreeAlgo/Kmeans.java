package LevelThreeAlgo;

import Utility.Algorithm;
import Utility.EuclideanDistance;
import Utility.Record;
import Utility.Weights;

public class Kmeans implements Algorithm {
	
	Weights weights;
	
	public Kmeans(Weights weights) {
		this.weights = weights;
	}
	
	public boolean run(Record foo, Record bar) {
		return new EuclideanDistance().getDistance(foo, bar, weights) < 3;
	}
}
