package GrokkingDPProblems.PalindromicSubsequence;

public class CountOfPalindromicSubsString {

	private boolean isPalindrome(String st, int x, int y) {
		while (x < y) {
			if (st.charAt(x++) != st.charAt(y--))
				return false;
		}
		return true;
	}

	public static int findCountOFPalindromicSubstring(String str) {

		boolean[][] dp = new boolean[str.length()][str.length()];
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			dp[i][i] = true;
			count++;
		}

		for (int i = str.length() - 1; i >= 0; i--) {

			for (int j = i + 1; j < str.length() - 1; j++) {

				if (str.charAt(i) == str.charAt(j)) {
					if (Math.abs(i - j) == 1 || dp[i + 1][j - 1]) {
						dp[i][j] = true;
						count++;
					}

				}

			}

		}
		return count;

	}

	public static void main(String[] args) {

		System.out.println("Palindrom count" + findCountOFPalindromicSubstring("abdbca"));

	}
}
