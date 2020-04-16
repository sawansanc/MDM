package LevelTwo;

import Utility.*;
import me.xdrop.fuzzywuzzy.FuzzySearch;

import java.util.*;

import LevelTwoAlgorithms.GradientDescent;

public class LevelTwo {
	
	GradientDescent gradientDescentAlgo = new GradientDescent();
	Random random = new Random();
	
	public LevelTwo(ArrayList<ArrayList<Record>> groupedRecords) {
		PrintRecords.print(groupedRecords);
		randomGroups(groupedRecords, 4);
		System.out.println(gradientDescentAlgo.weights);
	}
	
	public Weights getWeights() {
		return gradientDescentAlgo.weights;
	}
	
	public void randomGroups(ArrayList<ArrayList<Record>> groupedRecords, int sample){
		ArrayList<ArrayList<Record>> randomGroups = new ArrayList<ArrayList<Record>>();
		
		Set<Integer> randomIndices = new HashSet<Integer>();
		while (randomIndices.size() < sample) {
			int randomIndex = random.nextInt(groupedRecords.size());
			if(groupedRecords.get(randomIndex).size() > 1)
				randomIndices.add(randomIndex);
		}
		
		for(int x : randomIndices) {
			randomGroups.add(groupedRecords.get(x));
		}
		
		randomRecords(randomGroups, sample);
	}
	
	public void randomRecords(ArrayList<ArrayList<Record>> randomGroups, int sample){
		
		Set<Integer> randomIndices = new HashSet<Integer>();
		
		for(ArrayList<Record> group : randomGroups) {
			while (randomIndices.size() < 2)
				randomIndices.add(random.nextInt(group.size()));
			for(int x = group.size() - 1; x > -1; --x) {
				if(!randomIndices.contains(x))
					group.remove(x);
			}
			randomIndices.clear();
		}
		
		PrintRecords.print(randomGroups);
		trainingTheData(randomGroups, sample);
	}
	
	float matchPercent(String foo, String bar) {
		return (float)FuzzySearch.tokenSetPartialRatio(foo, bar)/100.0f;
	}
	
	public void trainingTheData(ArrayList<ArrayList<Record>> recordsToTrain, int sample){
		ArrayList<Integer> manualCheckList = new ArrayList<Integer>();
		
		Scanner s = new Scanner(System.in);
		
		
		float a, b, c;
		for(ArrayList<Record> group : recordsToTrain){
				PrintRecords.printRecords(group);;
				System.out.println("please enter 'yes' if records are Same or 'no' if records are not Same");
				String match;
				boolean valid = true;
				 while(valid){	

				     a = matchPercent(group.get(0).fetch("fname"), group.get(1).fetch("fname"));
				     b = matchPercent(group.get(0).fetch("lname"), group.get(1).fetch("lname"));
				     c = matchPercent(group.get(0).fetch("address"), group.get(1).fetch("address"));
				     match = s.nextLine();
				      if(match.equalsIgnoreCase("n") || match.equalsIgnoreCase("no")){
				        valid = false;
				        manualCheckList.add(-1);
				        gradientDescentAlgo.updateWeights(a, b, c, 1.0f, sample);
				      }else if (match.equalsIgnoreCase("y") || match.equalsIgnoreCase("yes")){
				        manualCheckList.add(1);
				        gradientDescentAlgo.updateWeights(a, b, c, -1.0f, sample);
				      //-------------------  Add or update weights here for YES				----------------------------------//        
				        valid = false;
				      }else{
				        System.out.println("Sorry, try again (y/n)...");
				      }
				    }
			}
			
//			for(Integer check : manualCheckList){
//				System.out.println(check);
//			}
//			
	}
}

