package LevelOneAlgorithms;

import Utility.Algorithm;
import Utility.Record;

public class Levenshtein implements Algorithm {
	
	double admissible_distance = 2.0;
	
	double getAdmissibleDistance() {
		return admissible_distance;
	}
	
	void setAdmissibleDistance(double d) {
		admissible_distance = d;
	}
	
	public final double distance(final String s1, final String s2) {
        return distance(s1, s2, Integer.MAX_VALUE);
    }
    public final double distance(final String s1, final String s2,
                                 final int limit) {
        if (s1 == null) {
            throw new NullPointerException("s1 must not be null");
        }

        if (s2 == null) {
            throw new NullPointerException("s2 must not be null");
        }

        if (s1.equals(s2)) {
            return 0;
        }

        if (s1.length() == 0) {
            return s2.length();
        }

        if (s2.length() == 0) {
            return s1.length();
        }
        int[] v0 = new int[s2.length() + 1];
        int[] v1 = new int[s2.length() + 1];
        int[] vtemp;

        for (int i = 0; i < v0.length; i++) {
            v0[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            v1[0] = i + 1;

            int minv1 = v1[0];

            for (int j = 0; j < s2.length(); j++) {
                int cost = 1;
                if (s1.charAt(i) == s2.charAt(j)) {
                    cost = 0;
                }
                v1[j + 1] = Math.min(
                        v1[j] + 1,
                        Math.min(
                                v0[j + 1] + 1,  
                                v0[j] + cost));

                minv1 = Math.min(minv1, v1[j + 1]);
            }

            if (minv1 >= limit) {
                return limit;
            }

            vtemp = v0;
            v0 = v1;
            v1 = vtemp;

        }

        return v0[s2.length()];
    }
    
    public boolean run(Record foo, Record bar) {
    	return (distance(foo.fetch("fname"), bar.fetch("fname")) <= admissible_distance) && (distance(foo.fetch("lname"), bar.fetch("lname")) <= admissible_distance) && (distance(foo.fetch("address"), bar.fetch("address")) <= admissible_distance); 
    }
    
}
