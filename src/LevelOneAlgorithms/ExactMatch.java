package LevelOneAlgorithms;

import Utility.Algorithm;
import Utility.Record;

public class ExactMatch implements Algorithm {
	public boolean run(Record foo, Record bar) {
		
		return foo.fetch("fname").trim().toLowerCase().equals(bar.fetch("fname").trim().toLowerCase()) && foo.fetch("lname").trim().toLowerCase().equals(bar.fetch("lname").trim().toLowerCase()) && foo.fetch("address").trim().toLowerCase().equals(bar.fetch("address").trim().toLowerCase());
	}
}
