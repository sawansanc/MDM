package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
	public FileIO(String path, ArrayList<Record> records) {
		BufferedReader csvReader = null;
		try {
			csvReader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String row;
		try {
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    records.add(new Record(data[0], data[1], data[2]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
