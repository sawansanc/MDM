package LevelOneAlgorithms;

import Utility.Algorithm;
import Utility.Record;

public class Voting implements Algorithm {
	public boolean run(Record foo, Record bar) {
//		double x = 0;
		return (new ExactMatch().run(foo, bar) || new fuzzyWuzzy().run(foo, bar) || new Soundex().run(foo, bar));
//		x += new Soundex().run(foo, bar) ? 1 : 0;
//		x += new SequenceMatcher().run(foo, bar) ? 1 : 0;
//		return FuzzySearch.tokenSortPartialRatio(foo, bar) > 55;
//		return x > 0;
	}
}
