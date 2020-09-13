package GrokkingDPProblems.knapsack;

import java.util.Arrays;

public class CountOfSubsetSum {

	public static void main(String[] args) {
		int[] num = { 1, 1, 2, 3 };
		int target = 4;

		int[][] dp = new int[num.length + 1][target + 1];

		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}

		System.out.println("Total Subset " + countOfSubsetSumRecur(num, target, num.length));

		System.out.println("Total Subset Memo " + countOfSubsetSumMemo(num, target, dp, num.length));
	}

	private static int countOfSubsetSumMemo(int[] num, int target, int[][] dp, int length) {

		if (dp[length][target] != -1)
			return dp[length][target];
		else if (length==0 && target!=0) {
			dp[length][target] = 0;
		} else if (target == 0) {
			dp[length][target] = 1;
		} else {
			if (num[length - 1] <= target) {
				dp[length][target] = countOfSubsetSumMemo(num, target - num[length - 1], dp, length - 1)
						+ countOfSubsetSumMemo(num, target, dp, length - 1);
			} else {
				dp[length][target] = countOfSubsetSumMemo(num, target, dp, length - 1);
			}
		}

		return dp[length][target];
	}

	private static int countOfSubsetSumRecur(int[] nums, int target, int length) {

		if (target == 0)
			return 1;
		if (length == 0)
			return 0;

		if (nums[length - 1] <= target) {

			return countOfSubsetSumRecur(nums, target - nums[length - 1], length - 1)
					+ countOfSubsetSumRecur(nums, target, length - 1);

		} else {

			return countOfSubsetSumRecur(nums, target, length - 1);
		}

	}

}
