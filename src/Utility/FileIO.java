package Utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
//			    System.out.println(data[2]);
			    records.add(new Record(data[0], data[2], data[1]));
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
	
	public void writeTo (ArrayList<ArrayList<Record>> groupedRecords, String path) {
		BufferedWriter bw = null;
		try {
			 File file = new File(path);
			  if (!file.exists()) {
			     file.createNewFile();
			  }

			  FileWriter fw = new FileWriter(file);
			  bw = new BufferedWriter(fw);
			  
			  int groupId = 0;
			  for(ArrayList<Record> group : groupedRecords) {
				  for(Record x : group)
					  bw.write(groupId + "," + x.getRecord());
				  groupId++;
			  }
			  
		          System.out.println("File written Successfully");

		      } catch (IOException ioe) {
			   ioe.printStackTrace();
			}
			finally
			{ 
			   try{
			      if(bw!=null)
				 bw.close();
			   }catch(Exception ex){
			       System.out.println("Error in closing the BufferedWriter"+ex);
			    }
			}
	}
}
