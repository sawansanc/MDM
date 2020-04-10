package Utility;

public class Record {
	String fname, lname, address;
	
	public Record(String fname, String lname, String address) {
		this.fname = fname;
		this.lname = lname;
		this.address = address;
	}
	
	public String fetch(String field) {
		switch(field) {
		case "fname" : return fname;
		case "lname" : return lname;
		case "address" : return address;
		default : return null;
		}
	}
}