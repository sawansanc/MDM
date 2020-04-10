package erApp;

import java.util.ArrayList;
import java.util.Collections;
import LevelOneAlgorithms.*;
import LevelTwo.LevelTwo;
import Utility.*;

import java.util.HashSet;
//import java.util.Scanner;
import java.util.Set;

public class LevelOne {
	 
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Record>> groupedRecords = new ArrayList<ArrayList<Record>>();
		ArrayList<Record> in = new ArrayList<Record>();
		//reads CSV into groupedRecords
		new FileIO("D:\\maruti\\dataset.csv", in);
		groupedRecords.add(in);
		PrintRecords.print(groupedRecords);
		
//		Scanner read = new Scanner(System.in);
//		int user_input;
		
		groupedRecords = driver(groupedRecords, new Voting());
		
		new LevelTwo(groupedRecords);
//		PrintRecords.print(groupedRecords);
		
//		do {
//			System.out.println("1: Soundex, 2: SequenceMatcher, 3: Levenshtein, 4: ExactMatch, 5: Print Result");
//			user_input = read.nextInt();
//			switch(user_input) {
//			case 1: groupedRecords = driver(groupedRecords, new Soundex()); break;
//			case 2: groupedRecords = driver(groupedRecords, new SequenceMatcher()); break;
//			case 3: groupedRecords = driver(groupedRecords, new Levenshtein()); break;
//			case 4: groupedRecords = driver(groupedRecords, new ExactMatch()); break;
//			case 5: print(groupedRecords); break;
//			default: read.close(); break;
//			}
//		}
//		while(user_input < 6);
	}
	
	
	//this method writes all the indexes of matching entries with the first entry of records into a set
	static void matchingRecords(ArrayList<Record> records, Set<Integer> set, int curr, int next, LevelOneAlgo algo) {
		if(next < records.size() && curr < records.size()) {
			set.add(curr);
			if(!set.contains(next))
				if(algo.run(records.get(curr).fetch("fname"), records.get(next).fetch("fname")) && 
						algo.run(records.get(curr).fetch("lname"), records.get(next).fetch("lname")) && 
						algo.run(records.get(curr).fetch("address"), records.get(next).fetch("address"))) {
					set.add(next);
					matchingRecords(records, set, next, 0, algo);
				}
			matchingRecords(records, set, curr, next + 1, algo);	
		}
	}
	
//	returns new value for groupedRecords after applying algorithm by using matchingRecords
	static ArrayList<ArrayList<Record>> driver(ArrayList<ArrayList<Record>> groupedRecords, LevelOneAlgo algo) {
		Set<Integer> set = new HashSet<Integer>();
		ArrayList<ArrayList<Record>> out = new ArrayList<ArrayList<Record>>();
		for(ArrayList<Record> records : groupedRecords)	{
			ArrayList<Record> refinedRecords;
			while(records.size() > 0) {
				refinedRecords = new ArrayList<Record>();
				if(records.size() > 1)
					matchingRecords(records, set, 0, 1, algo);
				else
					set.add(0);
				while(!set.isEmpty()) {
					int x = Collections.max(set);
					refinedRecords.add(records.get(x));
					records.remove(x);
					set.remove(x);
				}
				out.add(refinedRecords);
				set.clear();
			}
		}
		return out;
	}
}

