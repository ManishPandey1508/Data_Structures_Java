package DynamicProgramming;

public class LongestRepeatedSubsequence {
	
	
	static int lrs(String str) {
		
		char[] arr = str.toCharArray();
		int n = str.length();
		
		int result[][] = new int[n+1][n+1];
		
		for (int i = 1; i <=n; i++) {
			
			for (int j = 1; j <=n ; j++) {
				
				if(arr[i-1] == arr[j-1] && i!=j) {
					result[i][j] = result[i-1][j-1] +1;
				}else {
					result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
				}
				
			}
			
		}
		
		return result[n][n];
	}
	
	
	
	
	public static void main(String[] args) {
	
		String str = "AABEBCDD";
		
		System.out.println("Result  " +lrs(str) );
		
	}

}
