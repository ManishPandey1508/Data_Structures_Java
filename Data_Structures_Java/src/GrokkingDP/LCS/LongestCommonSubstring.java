package GrokkingDP.LCS;

public class LongestCommonSubstring {

	public static void main(String[] args) {

		System.out.println(" LCS is " + LCS("passport", "ppsspt", 0, 0, 0));
		
		String str1 = "";
		String str2 = "";
		
		Integer dp[][][] = new Integer[str1.length()][str2.length()][Math.max(str1.length(), str2.length())];
		
		System.out.println("LCS "+ LCSTopDownDP("abdca", "cbda", 0, 0, dp, 0));

	}

	public static int LCS(String str1, String str2, int i1, int i2, int count) {

		if (i1 >= str1.length() || i2 >= str2.length())
			return count;

		if (str1.charAt(i1) == str2.charAt(i2))
			count = LCS(str1, str2, i1 + 1, i2 + 1, count + 1);

		int count1 = LCS(str1, str2, i1 + 1, i2, 0);
		int count2 = LCS(str1, str2, i1, i2 + 1, 0);

		return Math.max(count, Math.max(count1, count2));
		

	}

	public static int LCSTopDownDP(String str1, String str2, int i1, int i2, Integer[][][] dp, int count) {

		if (i1 == str1.length() || i2 == str2.length())
			return 0;
		
		if (dp[i1][i2][count] != null)
			return dp[i1][i2][count];

		if (str1.charAt(i1) == str2.charAt(i2)) {

			count = LCSTopDownDP(str1, str2, i1 + 1, i2 + 1, dp, count + 1);
		}

		int count1 = LCSTopDownDP(str1, str2, i1+1, i2, dp, count);
		int count2 = LCSTopDownDP(str1, str2, i1, i2+1, dp, count);
		dp[i1][i2][count] = Math.max(count1, Math.max(count1, count2));
		return dp[i1][i2][count];
	}

}
