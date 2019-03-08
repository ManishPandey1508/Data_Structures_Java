package GrokkingDPProblems.PalindromicSubsequence;

import java.util.Arrays;

public class LongestPalindromeSubString {

	public static void main(String[] args) {

		String str = "abdbca";
		System.out.println("Longest Palindromic SubString is  " + LPSrecursive(str, 0, str.length() - 1));
		int[][] dp = new int[str.length()][str.length()];

		for (int i = 0; i < str.length(); i++)
			Arrays.fill(dp[i], -1);

		System.out.println("Longest Palindromic SubString is  " + LPSTopDownDP(str, dp, 0, str.length() - 1));

		System.out.println("Longest Palindromic SubString through BOTTOMUP DP  is  " + LPSBottomUp(str));

	}

	public static int LPSrecursive(String str, int start, int end) {

		if (start > end)
			return 0;
		if (start == end)
			return 1;

		int c1 = 0;
		if (str.charAt(start) == str.charAt(end)) {
			int remainingLength = end - start - 1;
			if (remainingLength == LPSrecursive(str, start + 1, end - 1))
				c1 = 2 + remainingLength;

		}
		int c2 = LPSrecursive(str, start + 1, end);

		int c3 = LPSrecursive(str, start, end - 1);

		return Math.max(c1, Math.max(c2, c3));
	}

	public static int LPSTopDownDP(String str, int[][] dp, int start, int end) {

		if (start > end)
			return 0;
		if (start == end) {
			dp[start][end] = 1;
			return 1;
		}

		if (dp[start][end] != -1)
			return dp[start][end];
		int c1 = 0;

		if (str.charAt(start) == str.charAt(end)) {
			int lengthremaining = end - start - 1;
			if (lengthremaining == LPSTopDownDP(str, dp, start + 1, end - 1)) {

				c1 = 2 + lengthremaining;
			}

		}

		int c2 = LPSTopDownDP(str, dp, start + 1, end);
		int c3 = LPSTopDownDP(str, dp, start, end - 1);

		dp[start][end] = Math.max(c1, Math.max(c2, c3));

		return dp[start][end];
	}

	public static int LPSBottomUp(String str) {

		if (str == null || str.length() == 0)
			return 0;

		boolean[][] dp = new boolean[str.length()][str.length()];
		int maxCount = 1;

		// every string with one character is a palindrome
		for (int i = 0; i < str.length(); i++)
			dp[i][i] = true;

		for (int start = str.length() - 1; start >= 0; start--) {

			for (int end = start + 1; end < str.length(); end++) {

				if (str.charAt(end) == str.charAt(start)) {

					if (end - start == 1 || dp[start + 1][end - 1]) {
						dp[start][end] = true;

						maxCount = Math.max(maxCount, end - start + 1);
					}
				}

			}

		}

		return maxCount;
	}

}
