package Algorithms;

public class LCS {
		
	public String longestCommonSubsequence(char[] A, char[] B, int m, int n) {
		//i add a column and a row to allow the case L[1][1] = L[i-1]... j-1 otherwise it goes out of b
		int L[][] = new int[m+1][n+1];
		StringBuffer LCS = new StringBuffer();
		
		for (int i = 0; i < m+1; i++)
			for (int j = 0; j < n+1; j++) 
			{
				 if (i == 0 || j == 0)
					 L[i][j] = 0;  //first row and first column = 0
				 else
					 L[i][j] = A[i-1] == B[j-1] ? L[i-1][j-1]+1 : max(L[i][j-1], L[i-1][j]);
			}
		
		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if(A[i-1] == B[j-1]) {//cause i added a column and a row for the 0s
				LCS.append(A[i-1]);
				i--;
				j--;
			} //we go to the entry with the largest value
			else if (L[i][j-1] > L[i-1][j])
				j--;
			else
				i--;			
		}
		
		return LCS.toString();	
	}
	
	
	private static int max(int x, int y) {
		return (x > y) ? x : y;
	}
	
	
	public static void main(String[] args)
	  {
	    LCS lcs = new LCS();
	    String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("LCS is" + " " +
	                                  lcs.longestCommonSubsequence( X, Y, m, n ) );
	    
	    String s3 = "ABCBDAB";
	    String s4 = "BDCABA";
	    char[] X1=s3.toCharArray();
	    char[] Y1=s4.toCharArray();
	    int m1 = X1.length;
	    int n1 = Y1.length;
	 
	    System.out.println("LCS is" + " " +
	                                  lcs.longestCommonSubsequence( X1, Y1, m1, n1 ) );
	    
	  }

}
