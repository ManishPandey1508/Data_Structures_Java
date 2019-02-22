package GrokkingDPProblems.knapsack;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lengths = { 1, 2, 3, 4, 5 };
		int[] profits = { 2, 6, 7, 10, 13 };
		int rodLength = 5;

		System.out.println("   " + rodCuttingProfit(lengths, profits, rodLength, 0));
		
		Integer[][] dp = new Integer[lengths.length][rodLength+1];
		
		System.out.println("Top Down DP   "+ rodCuttingProfitTopDownDP(lengths, profits, dp, rodLength, 0));
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

		return dp[lengths.length -1][rodLength];

	}

}
