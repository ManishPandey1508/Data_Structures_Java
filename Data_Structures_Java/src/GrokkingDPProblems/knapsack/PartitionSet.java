package GrokkingDPProblems.knapsack;

import java.util.Arrays;

// Equal subset sum partitioning 

public class PartitionSet {

	public static void main(String[] args) {

		int[] num = { 1, 1, 3, 4, 7 };

		System.out.println("Equal Partiotion " + canPartition(num));

		System.out.println("Equal Partiotion " + canPartitionDP(num));

	}

	// Brut Force
	static boolean canPartition(int[] num) {

		if (num == null || num.length == 0)
			return true;

		int sum = 0;
		for (int i : num) {
			sum += i;

		}

		if (sum % 2 != 0)
			return false;

		int[][] dp = new int[num.length][sum / 2 + 1];
		for (int i = 0; i < dp.length; i++) {

			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}

		boolean result = helperBrutForce(num, 0, sum / 2);

		result = canPartitionDPTopToBottom(num, dp, sum / 2, 0);
		return result;

	}

	private static boolean canPartitionDPTopToBottom(int[] num, int[][] dp, int sum, int index) {

		// base case DP
		if (sum == 0)
			return true;

		if (index < 0 || index >= num.length || num.length == 0)
			return false;

		if (dp[index][sum] != -1) {

			if (dp[index][sum] == 1)
				return true;
			else
				return false;
		}

		// if we include current element in the result
		if (num[index] <= sum) {
			if (canPartitionDPTopToBottom(num, dp, sum - num[index], index + 1)) {
				dp[index][sum] = 1;
				return true;
			}
		}

		// check for the next index and store the result in DP

		boolean result = canPartitionDPTopToBottom(num, dp, sum, index + 1);

		dp[index][sum] = result ? 1 : 0;

		return result;
	}

	private static boolean helperBrutForce(int[] num, int index, int sum) {

		// terminating condition
		if (sum == 0)
			return true;

		// check inputs validity
		if (index < 0 || index >= num.length || num.length == 0)
			return false;

		boolean includedSum = false;
		boolean notIncludedSum = false;

		// if index is included in 0/1 knapsack

		if (num[index] <= sum)
			includedSum = helperBrutForce(num, index + 1, sum - num[index]);

		notIncludedSum = helperBrutForce(num, index + 1, sum);

		return notIncludedSum || includedSum;
	}

	// BottomUP DP
	static boolean canPartitionDP(int[] num) {

		if (num == null || num.length == 0)
			return true;

		int sum = 0;

		for (int i : num) {
			sum += i;
		}

		if (sum % 2 != 0)
			return false;

		sum = sum / 2;

		// dp[i][j] will be true if a subset of sum j can be made till i index
		boolean[][] dp = new boolean[num.length][sum + 1];

		// initialize dp 0th col for 0 sum, coz sum 0 can be divided in
		// two set by choosing one set as empty set

		for (int i = 0; i < num.length; i++)
			dp[i][0] = true;

		// if there is just one number thn it should be equal to the sum

		for (int s = 1; s <= sum; s++) {
			dp[0][s] = (num[0] == s ? true : false);
		}
		// check for all indexes and sum

		for (int i = 1; i < num.length; i++) {

			for (int j = 1; j <= sum; j++) {

				if (dp[i - 1][j])
					dp[i][j] = dp[i - 1][j];
				else if (num[i] <= sum) {
					dp[i][j] = dp[i - 1][j - num[i]];
				}

			}

		}

		return dp[num.length - 1][sum];
	}

}
