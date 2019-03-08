package GrokkingDPProblems.PalindromicSubsequence;

public class MinDelInsertToTransform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int c1 = minDelInsertRecursive("horse", "ros", 0, 0);

		System.out.println("Min needed " + c1);
		
		int c2 = bottomUPDP("intention", "execution");
		System.out.println("Min needed " + c2);

	}

	public static int minDelInsertRecursive(String s1, String s2, int i1, int i2) {

		if (i1 >= s1.length() || i2 >= s2.length())
			if (i1 != i2)
				return Math.abs(i2 - i1) + 1;
			else
				return 0;

		int count1 = 0, count2 = 0;

		if (s1.charAt(i1) == s2.charAt(i2))
			return minDelInsertRecursive(s1, s2, i1 + 1, i2 + 1);

		// insert a character in s1
		count1 = 1 + minDelInsertRecursive(s1, s2, i1, i2 + 1);
		// insert a character in s2
		count2 = 1 + minDelInsertRecursive(s1, s2, i1 + 1, i2);

		int count3 = 1 + minDelInsertRecursive(s1, s2, i1 + 1, i2 + 1);

		return Math.min(count1, Math.min(count2, count3));

	}

	public static int bottomUPDP(String s1, String s2) {

		if (s1.length() == 0 && s2.length() == 0)
			return 0;
		if (s1.length() == 0)
			return s2.length();

		if (s2.length() == 0)
			return s1.length();

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s2.length(); i++)
			dp[0][i] = i;

		for (int i = 1; i <= s1.length(); i++)
			dp[i][0] = i;

		for (int i = 1; i <= s1.length(); i++) {

			for (int j = 1; j <= s2.length(); j++) {

				if (s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i - 1][j - 1];
				else {
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
				}

			}

		}
		
		return dp[s1.length()][s2.length()];

	}

}
