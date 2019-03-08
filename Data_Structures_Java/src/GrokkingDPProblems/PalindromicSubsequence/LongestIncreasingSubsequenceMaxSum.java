package GrokkingDPProblems.PalindromicSubsequence;

public class LongestIncreasingSubsequenceMaxSum {

	public static void main(String[] args) {
		int[] nums = { -4,10,3,7,15 };

		System.out.println("Max Sum " + longIncreaseSubSeqMaxSum(nums, -1, 0));
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

}
