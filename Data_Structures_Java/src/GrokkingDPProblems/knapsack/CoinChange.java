package GrokkingDPProblems.knapsack;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {

		int[] denominations = { 1, 2, 3 };
		int change = 5;

		Integer[][] dp = new Integer[denominations.length][change + 1];

		System.out.println("Recursive solution      " + coinChange(denominations, 5, 0));
		System.out.println("Top Down DP   " + coinChangetopDownDP(denominations, change, dp, 0));
	

	}

	private static int coinChangetopDownDP(int[] denominations, int change, Integer[][] dp, int index) {

		if (change == 0) {
			return 1;
		}

		if (index < 0 || index >= denominations.length || change < 0)
			return 0;

		if (dp[index][change] != null)
			return dp[index][change];

		int total1 = 0;

		if (denominations[index] <= change)
			total1 = coinChangetopDownDP(denominations, change - denominations[index], dp, index);

		int total2 = coinChangetopDownDP(denominations, change, dp, index + 1);

		dp[index][change] = total1 + total2;

		return dp[index][change];

	}

	public static int coinChange(int[] denominations, int total, int index) {

		if (index < 0 || index >= denominations.length || total < 0)
			return 0;

		if (total == 0)
			return 1;

		int total1 = coinChange(denominations, total - denominations[index], index);

		int total2 = coinChange(denominations, total, index + 1);

		return total1 + total2;

	}

	

}
