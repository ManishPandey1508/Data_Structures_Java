package GrokkingDPProblems.knapsack;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lengths = { 1, 2, 3, 4, 5 };
		int[] profits = { 2, 6, 7, 10, 13 };
		int rodLength = 5;

		System.out.println("   " + rodCuttingProfit(lengths, profits, rodLength, 0));

		Integer[][] dp = new Integer[lengths.length][rodLength + 1];

		System.out.println("Top Down DP   " + rodCuttingProfitTopDownDP(lengths, profits, dp, rodLength, 0));
		System.out.println("Bottom Up DP " + rodCuttingBUPDP(lengths, profits, rodLength));
	}

	public static int rodCuttingProfit(int[] lengths, int[] profits, int rodLength, int index) {

		// base condition
		if (index < 0 || index >= lengths.length || rodLength <= 0 || profits.length != lengths.length)
			return 0;

		int profit1 = 0;

		if (lengths[index] <= rodLength)
			profit1 = profits[index] + rodCuttingProfit(lengths, profits, rodLength - lengths[index], index);

		int profit2 = rodCuttingProfit(lengths, profits, rodLength, index + 1);

		return Math.max(profit1, profit2);

	}

	public static int rodCuttingProfitTopDownDP(int[] lengths, int[] profits, Integer[][] dp, int rodLength,
			int index) {

		// Base condition

		if (index >= lengths.length || index < 0 || rodLength <= 0) {
			return 0;
		}
		if (dp[index][rodLength] != null)
			return dp[index][rodLength];
		int profit1 = 0;

		if (lengths[index] <= rodLength) {
			profit1 = profits[index]
					+ rodCuttingProfitTopDownDP(lengths, profits, dp, rodLength - lengths[index], index + 1);
		}

		int profit2 = rodCuttingProfitTopDownDP(lengths, profits, dp, rodLength, index + 1);

		dp[index][rodLength] = Math.max(profit1, profit2);

		return dp[lengths.length - 1][rodLength];

	}

	public static int rodCuttingBUPDP(int[] lengths, int[] prices, int n) {

		// base checks
		if (n <= 0 || prices.length == 0 || prices.length != lengths.length)
			return 0;

		int lengthCount = lengths.length;
		int[][] dp = new int[lengthCount][n + 1];

		// process all rod lengths for all prices
		for (int i = 0; i < lengthCount; i++) {
			for (int len = 0; len <= n; len++) {
				int p1 = 0, p2 = 0;
				if (lengths[i] <= len)
					p1 = prices[i] + dp[i][len - lengths[i]];
				if (i > 0)
					p2 = dp[i - 1][len];
				dp[i][len] = Math.max(p1, p2);
			}
		}

		// maximum price will be at the bottom-right corner.
		
		return dp[lengthCount - 1][n];
	}

}
