package LevelOneAlgorithms;

import Utility.Algorithm;
import Utility.Record;
import me.xdrop.fuzzywuzzy.FuzzySearch;

public class fuzzyWuzzy implements Algorithm {
	int matchRatio = 55;
	public boolean run(Record foo, Record bar) {
		return FuzzySearch.tokenSortPartialRatio(foo.fetch("fname"), bar.fetch("fname")) > matchRatio && FuzzySearch.tokenSortPartialRatio(foo.fetch("lname"), bar.fetch("lname")) > matchRatio && FuzzySearch.tokenSortPartialRatio(foo.fetch("address"), bar.fetch("address")) > matchRatio;
	}
}
