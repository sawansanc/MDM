package LevelOneAlgorithms;

public class ExactMatch implements LevelOneAlgo {
	public boolean run(String foo, String bar) {
		return foo.trim().toLowerCase().equals(bar.trim().toLowerCase());
	}
}
