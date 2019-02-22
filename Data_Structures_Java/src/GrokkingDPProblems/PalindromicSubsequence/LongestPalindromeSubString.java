package GrokkingDPProblems.PalindromicSubsequence;

public class LongestPalindromeSubString {

	public static void main(String[] args) {

	}

	public static int LPSrecursive(String str, int start, int end) {

		if (start > end)
			return 0;
		if (start == end)
			return 1;
		int remainingLength = end - start - 1;
		int c1 = 0;
		if (str.charAt(start) == str.charAt(end)) {

			c1 = 2 + LPSrecursive(str, start + 1, end - 1);

		}
		int c2 = LPSrecursive(str, start + 1, end);

		int c3 = LPSrecursive(str, start, end - 1);

		return Math.max(c1, Math.max(c2, c3));
	}

}
