package Utility;

import me.xdrop.fuzzywuzzy.FuzzySearch;

public class EuclideanDistance {
	
	private double distance(String foo, String bar) {
		return 1.0f - (float)FuzzySearch.tokenSetPartialRatio(foo, bar)/100.0f;
	}
	
	private double abs(double x) {
		return x < 0 ? -x : x;
	}
	
	public double getDistance(Record foo, Record bar, Weights weights) {
		return Math.pow(abs(weights.fname * distance(foo.fetch("fname"), bar.fetch("fname")) + weights.lname * distance(foo.fetch("lname"), bar.fetch("lname")) + weights.address * distance(foo.fetch("address"), bar.fetch("address"))), 0.5);
	}
}
