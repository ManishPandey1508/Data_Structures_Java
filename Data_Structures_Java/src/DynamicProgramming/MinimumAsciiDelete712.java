package DynamicProgramming;

public class MinimumAsciiDelete712 {

	public static void main(String[] args) {
		String str1 = "leet";
		String str2 = "delete";

		int res = minimumDeleteSum(str1, str2);
		System.out.println("Result   " + res);

	}

	static int minimumDeleteSum(String s1, String s2) {

		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m + 1][n + 1];

		// Base case fill 1st Row for String 1 in DP matrix
		for (int i = 1; i <= n; i++) {
			dp[0][i] = dp[0][i - 1] + str2[i - 1];
		}

		// Base case fill 1st Row for String 2 in DP matrix
		for (int i = 1; i <= m; i++) {
			dp[i][0] = dp[i - 1][0] + str1[i - 1];
		}

		// No loop through all characters

		for (int i = 1; i <= m; i++) {

			for (int j = 1; j <= n; j++) {
				// If last character of both strings match take the diagonal value
				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j] + str1[i - 1], dp[i][j - 1] + str2[j - 1]);
				}

			}

		}
		return dp[s1.length()][s2.length()];

	}

}
