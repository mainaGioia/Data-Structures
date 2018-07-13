package Algorithms;

public class LCS {
		
	public int longestCommonSubsequence(char[] A, char[] B, int m, int n) {
		//i add a column and a row to allow the case L[1][1] = L[i-1]... j-1 otherwise it goes out of b
		int L[][] = new int[m+1][n+1];
		
		for (int i = 0; i < m+1; i++)
			for (int j = 0; j < n+1; j++) 
			{
				 if (i == 0 || j == 0)
					 L[i][j] = 0;  //first row and first column = 0
				 else
					 L[i][j] = A[i-1] == B[j-1] ? L[i-1][j-1]+1 : max(L[i][j-1], L[i-1][j]);
			}
		
		return L[m][n];		
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
	 
	    System.out.println("Length of LCS is" + " " +
	                                  lcs.longestCommonSubsequence( X, Y, m, n ) );
	  }

}
