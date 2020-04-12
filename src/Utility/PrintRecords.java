package Utility;

import java.util.ArrayList;

public class PrintRecords {
	public static void print(ArrayList<ArrayList<Record>> groupedRecords) {
		System.out.println("=======================================");
		for (ArrayList<Record> entries : groupedRecords) {
			System.out.println("--------------------------------------");
			for(Record entry : entries)
		        System.out.println(entry.fetch("fname") + ", " + entry.fetch("lname") + ", " + entry.fetch("address"));
		    System.out.println("--------------------------------------");
		}
		System.out.println("=======================================\n\n");
	}
	
	public static void printRecords(ArrayList<Record> groupOfRecords){
		System.out.println("--------------------------------------");
		for(Record entry : groupOfRecords)
	        System.out.println(entry.fetch("fname") + ", " + entry.fetch("lname") + ", " + entry.fetch("address"));
	    System.out.println("--------------------------------------");
	}
}
