package GrokkingDPProblems.PalindromicSubsequence;
/*Given a sequence, find the length of its Longest Palindromic Subsequence (LPS). In a palindromic subsequence, elements read the same backward and forward.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

Example 1:

Explanation: LPS is "abdba"
Input: "abdbca"
Output: 5
Explanation: LPS is "abdba".
Example 2:

Input: = "cddpd"
Output: 3
Explanation: LPS is "ddd".
Example 3:

Input: = "pqr"
Output: 1
Explanation: LPS could be "p", "q" or "r".*/

public class LongestPalindromeSubSeq {

	public static void main(String[] args) {

		System.out.println(LPS("abdbca"));

		System.out.println(LSPTopDownDP("abdbca"));

		System.out.println(LPSBottmUPDP("abdbca"));

	}

	public static int LPS(String str) {

		int start = 0;
		int end = str.length() - 1;

		return LPSRecursive(str, start, end);

	}

	private static int LPSRecursive(String str, int start, int end) {

		if (start > end)
			return 0;

		if (start == end)
			return 1;

		int total = 0;

		if (str.charAt(start) == str.charAt(end)) {
			total = 2 + LPSRecursive(str, start + 1, end - 1);
		} else {

			int tot1 = LPSRecursive(str, start + 1, end);
			int tot2 = LPSRecursive(str, start, end - 1);
			total = Math.max(tot1, tot2);
		}

		return total;
	}

	private static int LSPTopDownDP(String str) {

		if (str == null || str.length() == 0)
			return 0;

		Integer[][] dp = new Integer[str.length()][str.length()];

		for (int i = 0; i < str.length(); i++) {

			dp[i][i] = 1;
		}

		return LSPTopDownDP(str, dp, 0, str.length() - 1);
	}

	private static Integer LSPTopDownDP(String str, Integer[][] dp, int start, int end) {

		if (start > end)
			return 0;

		if (dp[start][end] != null) {
			return dp[start][end];
		}

		if (str.charAt(start) == str.charAt(end))
			dp[start][end] = 2 + LSPTopDownDP(str, dp, start + 1, end - 1);
		else {
			int tot1 = LSPTopDownDP(str, dp, start + 1, end);
			int tot2 = LSPTopDownDP(str, dp, start, end - 1);

			dp[start][end] = Math.max(tot1, tot2);
		}

		return dp[start][end];

	}

	private static int LPSBottmUPDP(String str) {

		if (str == null || str.length() == 0)
			return 0;
		int[][] dp = new int[str.length()][str.length()];

		for (int i = 0; i < str.length(); i++) {
			dp[i][i] = 1;
		}

		for (int start = str.length() - 1; start >= 0; start--) {

			for (int end = start + 1; end < str.length(); end++) {

				if (str.charAt(start) == str.charAt(end)) {
					dp[start][end] = 2 + dp[start + 1][end - 1];
				} else
					dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);

			}

		}

		return dp[0][str.length() - 1];

	}

}
