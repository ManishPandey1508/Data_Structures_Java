package DynamicProgramming;
/*
dp[i][j]: the longest palindromic subsequence’s length of substring(i, j)
State transition:
dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
Initialization: dp[i][i] = 1*/

public class LongestPalindromeSubSequence {

	public static void main(String[] args) {

		String str = "bbbd";
		int res = longestPalandromicSubSequence(str);
		System.out.println("Length of longest Palndromic Sub Sequence is-- "+ res);
		
		
	}

	static int longestPalandromicSubSequence(String str) {

		int n = str.length();
		int[][] dp = new int[n][n];

		char[] arr = str.toCharArray();

		for (int i = n - 1; i >= 0; i--) {

			dp[i][i] = 1;
			for (int j = i + 1; j < n; j++) {

				if (arr[i] == arr[j]) {

					dp[i][j] = dp[i + 1][j - 1] + 2;

				} else {

					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);

				}

			}

		}
		
		
		return dp[0][n-1];

	}

}
