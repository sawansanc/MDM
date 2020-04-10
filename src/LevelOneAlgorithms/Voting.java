package LevelOneAlgorithms;

import me.xdrop.fuzzywuzzy.FuzzySearch;

public class Voting implements LevelOneAlgo {
	public boolean run(String foo, String bar) {
//		double x = 0;
//		x += new Levenshtein().run(foo, bar) ? 1 : 0;
//		x += new Soundex().run(foo, bar) ? 1 : 0;
//		x += new SequenceMatcher().run(foo, bar) ? 1 : 0;
		return FuzzySearch.tokenSortPartialRatio(foo, bar) > 55;
	}
}
