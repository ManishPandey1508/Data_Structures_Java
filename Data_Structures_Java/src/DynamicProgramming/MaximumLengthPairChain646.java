package DynamicProgramming;

import java.util.Arrays;

public class MaximumLengthPairChain646 {

	public static void main(String[] args) {

		int[][] pairs = { { 5, 24 }, { 15, 28 }, { 27, 40 }, { 39, 60 }, { 50, 90 } };
		
		int res = findLongestChain(pairs);
		System.out.println("Longest Chain length is " + res);
	}

	static int findLongestChain(int[][] pairs) {

		int length = pairs.length;
		int[] dp = new int[length];

		if (pairs.length == 0 || pairs == null)
			return 0;
		// Fill Array with 1 because this is the base case, in worst case chain length would
		// be 1
		Arrays.fill(dp, 1);

		// Now for every chain pair.. compare first col value with all previou (j) pairs second col.. 
		//if its more thn add 1 and store at i index
		
		for (int i = 1; i < length; i++) {

			for (int j = 0; j < i; j++) {

				dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);

			}

		}

		return dp[length - 1];

	}

}
