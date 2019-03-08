package GrokkingDPProblems.PalindromicSubsequence;

/*Given two strings ‘s1’ and ‘s2’, find the length of the longest substring which is common in both the strings.

Example 1:

Input: s1 = "abdca"
       s2 = "cbda"
Output: 2
Explanation: The longest common substring is "bd".
Example 2:

Input: s1 = "passport"
       s2 = "ppsspt"
Output: 3
Explanation: The longest common substring is "ssp".*/

public class LongestCommonSubstring {

	public static void main(String[] args) {

		System.out.println("LCS " + LCS("abdca", "cbda", 0, 0, 0));
		int[][] dp = new int["abdca".length() + 1]["cbda".length() + 1];
		System.out.println("LCS " + LCSBottomUP("abdca", "cbda", dp));

	}

	public static int LCS(String s1, String s2, int i1, int i2, int count) {

		if (i1 >= s1.length() || i2 >= s2.length()) {

			return count;
		}
		int count3 = 0;

		if (s1.charAt(i1) == s2.charAt(i2)) {
			count3 = LCS(s1, s2, i1 + 1, i2 + 1, count + 1);
		}
		int count1 = LCS(s1, s2, i1 + 1, i2, 0);
		int count2 = LCS(s1, s2, i1, i2 + 1, 0);

		return Math.max(count3, Math.max(count1, count2));

	}

	public static int LCSBottomUP(String s1, String s2, int[][] dp) {

		int maxLength = 0;
		for (int i = 1; i <= s1.length(); i++) {

			for (int j = 1; j <= s2.length(); j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					maxLength = Math.max(maxLength, dp[i][j]);
				}

			}
		}

		return maxLength;

	}

}
