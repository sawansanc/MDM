package LevelTwo;

import Utility.*;
import me.xdrop.fuzzywuzzy.FuzzySearch;

import java.util.*;

import LevelTwoAlgorithms.Backpropagation;

public class LevelTwo {
	
	Backpropagation backpropagationAlgo = new Backpropagation();
	
	public LevelTwo(ArrayList<ArrayList<Record>> groupedRecords) {
		//PrintRecords.print(groupedRecords);
		randomGroupsRecords(groupedRecords);
		System.out.println(backpropagationAlgo.weights);
	}
	ArrayList<ArrayList<Record>> randomGroupedRecords;
	ArrayList<ArrayList<Record>> recordListToTrain;
	Random random = new Random();
	
	public void randomGroupsRecords(ArrayList<ArrayList<Record>> groupedRecords){
		randomGroupedRecords = new ArrayList<ArrayList<Record>>();
		
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		for(int i=1;i<=4;i++){
			int randomIndex = random.nextInt(groupedRecords.size());
			if(randomList.contains(randomIndex) || groupedRecords.get(randomIndex).size()==1){
				i--;
			}
			else{
				randomList.add(randomIndex);
			}
		}
		
		for(int i=0;i<randomList.size();i++){
			randomGroupedRecords.add(groupedRecords.get(randomList.get(i)));
		}
		
		System.out.println("random Records group---- >");
		//PrintRecords.print(randomGroupedRecords);
		randomRecords(randomGroupedRecords);
	}
	
	public void randomRecords(ArrayList<ArrayList<Record>> randomGroupedRecords){
		recordListToTrain =new ArrayList<ArrayList<Record>>();
		ArrayList<Integer> randomList ;
		ArrayList<Record> finalRecords;
		for(ArrayList<Record> group : randomGroupedRecords){
			randomList = new ArrayList<>();
			finalRecords =new ArrayList<Record>();
			for(int i=0;i<2;i++){
				int randomIndex =  random.nextInt(group.size());
				if(randomList.contains(randomIndex)){
					i--;
				}
				else{
					finalRecords.add(group.get(randomIndex));
				}
			}
			recordListToTrain.add(finalRecords);
		}
		
		PrintRecords.print(recordListToTrain);
		trainingTheData(recordListToTrain);
	}
	
	float matchPercent(String foo, String bar) {
		return (float)FuzzySearch.tokenSetPartialRatio(foo, bar)/100.0f;
	}
	
	public void trainingTheData(ArrayList<ArrayList<Record>> recordsToTrain){
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
				        backpropagationAlgo.updateWeights(a, b, c, 1.0f);
				      }else if (match.equalsIgnoreCase("y") || match.equalsIgnoreCase("yes")){
				        manualCheckList.add(1);
				        backpropagationAlgo.updateWeights(a, b, c, -1.0f);
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

