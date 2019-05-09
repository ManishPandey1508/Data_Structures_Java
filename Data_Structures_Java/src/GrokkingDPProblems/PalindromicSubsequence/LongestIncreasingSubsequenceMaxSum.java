package GrokkingDPProblems.PalindromicSubsequence;

public class LongestIncreasingSubsequenceMaxSum {

	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 6, 10, 1, 12 };

		System.out.println("Max Sum " + longIncreaseSubSeqMaxSum(nums, -1, 0));
		
		System.out.println("Max Sum BPDP " + longIncreaseSubSeqBPUP(nums));
	}

	public static int longIncreaseSubSeqMaxSum(int[] num, int preindex, int currentIndex) {

		if (currentIndex >= num.length)
			return 0;

		int sum1 = Integer.MIN_VALUE;
		int sum2 = Integer.MIN_VALUE;
		if (preindex == -1 || num[currentIndex] > num[preindex])
			sum1 = num[currentIndex] + longIncreaseSubSeqMaxSum(num, currentIndex, currentIndex + 1);

		sum2 = longIncreaseSubSeqMaxSum(num, preindex, currentIndex + 1);

		return Math.max(sum1, sum2);

	}

	public static int longIncreaseSubSeqBPUP(int[] num) {

		if (num == null || num.length == 0)
			return 0;
		int[] dp = new int[num.length];
		dp[0] = num[0];
		int maxSum = 0;

		for (int i = 1; i < num.length; i++) {
			dp[i] = num[i];
			for (int j = 0; j < i; j++) {

				if (num[i] > num[j] && dp[i] < dp[j] + num[i]) {
					dp[i] = num[i] + dp[j];
				}

			}
			maxSum = Math.max(maxSum, dp[i]);
		}

		return maxSum;

	}

}
