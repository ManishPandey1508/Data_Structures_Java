package GrokkingDPProblems.knapsack;
/*Given a set of positive numbers, partition the set into two subsets with a minimum difference between their subset sums.

Example 1:

Explanation: We can partition the given set into two subsets where minimum absolute difference 
between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
Input: {1, 2, 3, 9}
Output: 3
Explanation: We can partition the given set into two subsets where minimum absolute difference 
between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
Example 2:

Input: {1, 2, 7, 1, 5}
Output: 0
Explanation: We can partition the given set into two subsets where minimum absolute difference 
between the sum of number is '0'. Following are the two subsets: {1, 2, 5} & {7, 1}.
Example 3:

Input: {1, 3, 100, 4}
Output: 92
Explanation: We can partition the given set into two subsets where minimum absolute difference 
between the sum of numbers is '92'. Here are the two subsets: {1, 3, 4} & {100}.*/

public class MinimumSubsetDifference {

	public static void main(String[] args) {

		int[] num = { 1, 2, 3, 9 };

		System.out.println(canPartitionRecursive(num, 0, 0, 0));

		System.out.println(canPartitionTopDownDP(num));

		System.out.println(canPartitionBottomUPDP(num));

	}

	public static int canPartitionRecursive(int[] num, int index, int sum1, int sum2) {

		if (index == num.length)
			return Math.abs(sum1 - sum2);

		// recursive call after including the number at the currentIndex in the first
		// set
		int diff1 = canPartitionRecursive(num, index + 1, sum1 + num[index], sum2);

		// recursive call after including the number at the currentIndex in the second
		// set
		int diff2 = canPartitionRecursive(num, index + 1, sum1, sum2 + num[index]);

		return Math.min(diff1, diff2);
	}

	public static int canPartitionTopDownDP(int[] num) {

		int sum = 0;

		for (int i : num) {
			sum += i;
		}

		Integer[][] dp = new Integer[num.length][sum + 1];
		return canPartitionTopDownDP(num, dp, 0, 0, 0);

	}

	// we will store the result
	public static int canPartitionTopDownDP(int[] num, Integer[][] dp, int index, int sum1, int sum2) {

		// base condition
		if (index == num.length)
			return Math.abs(sum1 - sum2);

		// check if we have already had the same problem solved

		if (dp[index][sum1] == null) {

			int diff1 = canPartitionTopDownDP(num, dp, index + 1, sum1 + num[index], sum2);
			int diff2 = canPartitionTopDownDP(num, dp, index + 1, sum1, sum2 + num[index]);

			dp[index][sum1] = Math.min(diff1, diff2);
		}

		return dp[index][sum1];

	}

	// for bottom up we have to find subset with closest sum to sum/2

	public static int canPartitionBottomUPDP(int[] num) {

		int sum = 0;

		for (int i : num) {
			sum += i;
		}

		;
		boolean[][] dp = new boolean[num.length][sum/2 + 1];

		return canPartitionBottomUPDP(num, dp, 0, sum);

	}

	private static int canPartitionBottomUPDP(int[] num, boolean[][] dp, int index, int sum) {

		// if sum is 0
		for (int i = 0; i < num.length; i++) {

			dp[i][0] = true;

		}

		// if there is just one element in that case

		for (int s = 0; s < sum/2; s++) {

			dp[0][s] = num[0] == s ? true : false;
		}

		int maxsum = Integer.MIN_VALUE;

		for (int i = 1; i < num.length; i++) {

			for (int s = 1; s <= sum/2; s++) {

				if (dp[i - 1][s]) {
					dp[i][s] = true;
				} else if (num[i] <= s) {

					dp[i][s] = dp[i - 1][s - num[i]];
				}

			}

		}

		for (int s = sum/2; s > 0; s--) {

			if (dp[num.length - 1][s]) {

				maxsum = s;

				break;
			}

		}
		
		System.out.println("Max sum is "+ maxsum);
		return Math.abs(( sum - maxsum) - maxsum);

	}

}
