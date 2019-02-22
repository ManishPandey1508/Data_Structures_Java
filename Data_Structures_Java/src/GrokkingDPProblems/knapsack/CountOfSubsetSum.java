package GrokkingDPProblems.knapsack;

public class CountOfSubsetSum {

	public static void main(String[] args) {
		int[] num = { 1, 1, 2, 3 };
		System.out.println();
	}

	public static int countOfSubset(int[] num, int sum) {
		Integer[][] dp = new Integer[num.length][sum + 1];
		return countOfSubSetBrutForce(num, 0, sum);
	}

	public static int countOfSubSetTopDownDP(int[] num, int sum) {

		Integer[][] dp = new Integer[num.length][sum + 1];
		return countOfSubSetTopDownDP(num, dp, sum, 0);
	}

	public static int countOfSubSetBrutForce(int[] num, int index, int currentSum) {

		if (num.length == 0 || index < 0 || index >= num.length)
			return 0;

		int c2 = 0;

		if (currentSum == 0)
			return 1;
		if (num[index] <= currentSum) {
			c2 = countOfSubSetBrutForce(num, index + 1, currentSum);
		}

		int c1 = countOfSubSetBrutForce(num, index + 1, currentSum - num[index]);

		return c1 + c2;
	}

	public static int countOfSubSetTopDownDP(int[] num, Integer[][] dp, int sum, int index) {
		// dp[i][s] = no of subset having i elements and s as sum

		if (sum == 0)
			return 1;

		if (index < 0 || index >= num.length || num.length == 0)
			return 0;

		if (dp[index][sum] != null)
			return dp[index][sum];

		int count1 = 0;

		if (num[index] <= sum)
			count1 = countOfSubSetTopDownDP(num, dp, sum - num[index], index + 1);
		int count2 = countOfSubSetTopDownDP(num, dp, sum, index + 1);

		dp[index][sum] = count1 + count2;

		return count1 + count2;
	}

	public static int countOfSubSetBottomUPDP(int[] num, int[][] dp, int sum, int index) {
		// dp[i][s] = no of subset having i elements and s as sum
		// dp[i][s]= dp[i-1][s]+dp[i-1][s-num[i]]

		// base case
		for (int i = 0; i < num.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < num.length; i++) {

			for (int s = 1; s <= sum; s++) {

				dp[i][s] = dp[i - 1][s];
				if (num[i] <= sum) {
					dp[i][s] += dp[i - 1][s - num[i]];
				}

			}

		}

		return dp[num.length - 1][sum];

	}

}
