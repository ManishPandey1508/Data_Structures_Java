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

		System.out.println(longestPalindrome(""));

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

		for (int i = 0; i < str.length(); i++)
			dp[i][i] = true;

		int maxCount = 1;

		for (int i = str.length() - 1; i > 0; i--) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))

					if (Math.abs(i - j) == 1 || dp[i + 1][j - 1]) {
						dp[i][j] = true;
						maxCount = Math.max(Math.abs(i - j) + 1, maxCount);
					}

			}

		}
		return maxCount;

	}

	public static String longestPalindrome(String s) {

		int length = s.length();

		if (length == 0)
			return "";

		if (length == 1)
			return s;

		int maxStartAt = 0;
		int maxLength = 1;

		// create a 2 d boolean array

		boolean[][] dp = new boolean[length][length];

		// populate dp for 1 length

		for (int i = 0; i < length; i++) {
			dp[i][i] = true;
		}

		// populate dp for 2 length

		for (int j = 1; j < length; j++) {
			if (s.charAt(j - 1) == s.charAt(j)) {
				dp[j - 1][j] = true;
				maxStartAt = j - 1;
				maxLength = 2;
			}

		}
		// for length 3 and more
		for (int j = 3; j <= length; j++) {

			for (int k = 0; k < length - j + 1; k++) {

				if (s.charAt(k) == s.charAt(k + j - 1) && dp[k + 1][k + j - 2]) {
					dp[k][k + j - 1] = true;
					maxStartAt = k;
					maxLength = j;
				}
			}

		}

		return s.substring(maxStartAt, maxStartAt + maxLength );

	}

}
