package LevelOneAlgorithms;

import me.xdrop.fuzzywuzzy.FuzzySearch;

public class Voting implements LevelOneAlgo {
	public boolean run(String foo, String bar) {
//		double x = 0;
		return (new ExactMatch().run(foo, bar) || FuzzySearch.tokenSortPartialRatio(foo, bar) > 55) || new Soundex().run(foo, bar);
//		x += new Soundex().run(foo, bar) ? 1 : 0;
//		x += new SequenceMatcher().run(foo, bar) ? 1 : 0;
//		return FuzzySearch.tokenSortPartialRatio(foo, bar) > 55;
//		return x > 0;
	}
}
