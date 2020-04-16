//package LevelOneAlgorithms;
//
//public class SequenceMatcher implements Algorithm {
//	int lcs( char[] X, char[] Y, int m, int n ) 
//	{ 
//		if (m == 0 || n == 0) 
//			return 0; 
//	    if (X[m-1] == Y[n-1]) 
//	    	return 1 + lcs(X, Y, m-1, n-1); 
//	    else
//	    	return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n)); 
//	} 
//	
//	int max(int a, int b) 
//	{ 
//		return (a > b)? a : b; 
//	}
//	  
//	public boolean run(String foo, String bar) {
//		return (double)lcs(foo.toCharArray(), bar.toCharArray(), foo.length(), bar.length()) / (double)max(foo.length(), bar.length()) >= 0.6;
//	}
//	  
//}
