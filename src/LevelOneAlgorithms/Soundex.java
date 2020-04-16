package LevelOneAlgorithms;

import Utility.Algorithm;
import Utility.Record;

public class Soundex implements Algorithm {
	
	String getCode(String s) 
    {
        char[] x = s.toUpperCase().toCharArray();
        char firstLetter = x[0];
        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {
            case 'B':
            case 'F':
            case 'P':
            case 'V': {
                x[i] = '1';
                break;
            }
 
            case 'C':
            case 'G':
            case 'J':
            case 'K':
            case 'Q':
            case 'S':
            case 'X':
            case 'Z': {
                x[i] = '2';
                break;
            }
 
            case 'D':
            case 'T': {
                x[i] = '3';
                break;
            }
 
            case 'L': {
                x[i] = '4';
                break;
            }
 
            case 'M':
            case 'N': {
                x[i] = '5';
                break;
            }
 
            case 'R': {
                x[i] = '6';
                break;
            }
 
            default: {
                x[i] = '0';
                break;
            }
            }
        }
        String output = "" + firstLetter;
        for (int i = 1; i < x.length; i++)
            if (x[i] != x[i - 1] && x[i] != '0')
                output += x[i];
        output = output + "0000";
        return output.substring(0, 4);
    }
	
	public boolean run(Record foo, Record bar) {
		return getCode(foo.fetch("fname")).equals(getCode(bar.fetch("fname"))) && getCode(foo.fetch("lname")).equals(getCode(bar.fetch("lname"))) && getCode(foo.fetch("address")).equals(getCode(bar.fetch("address")));
	}
}
