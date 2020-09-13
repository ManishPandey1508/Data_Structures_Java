package GrokkingDPProblems.knapsack;
//Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both the subsets is equal.

//Input: {1, 1, 3, 4, 7}
//Output: True

public class EqualSubsetSumPartition {
	public static void main(String[] args) {
		int[] num = { 2, 6, 4, 6 };

		System.out.println(subSetSumRecurMemoize(num));
		System.out.println("Recursive " + equalSubsetSumPartRecur(num));
	}

	private static boolean subSetSumRecurMemoize(int[] num) {
		int sum = 0;
		for (int i : num) {
			sum += i;
		}
		if (sum % 2 != 0)
			return false;
		int target = sum / 2;
		Boolean[][] dp = new Boolean[num.length + 1][target + 1];

		return subSetSumRecurMemoizeHelper(num, target, dp, num.length);
	}

	private static boolean subSetSumRecurMemoizeHelper(int[] num, int target, Boolean[][] dp, int length) {
		
		
		if (target == 0) {
			dp[length][target] = true;
		} else if (length == 0) {

			dp[length][target] = false;
		} else if (dp[length][target] !=null ) {
			return dp[length][target] ;
		} else {
			if (num[length - 1] <= target) {
				boolean a = subSetSumRecurMemoizeHelper(num, target - num[length - 1], dp, length - 1);
				boolean b = subSetSumRecurMemoizeHelper(num, target, dp, length - 1);
				dp[length][target] = a || b;
			} else {

				dp[length][target] = subSetSumRecurMemoizeHelper(num, target, dp, length - 1);
			}

		}
		return dp[length][target];
	}

	private static boolean equalSubsetSumPartRecur(int[] num) {

		int sum = 0;
		for (int i : num) {
			sum += i;
		}
		if (sum % 2 != 0)
			return false;
		else
			return equalSubsetSumPartRecur(num, sum / 2, num.length);

	}

	private static boolean equalSubsetSumPartRecur(int[] num, int target, int length) {

		if (target == 0)
			return true;
		else if (length == 0)
			return false;
		else {

			if (num[length - 1] <= target) {

				boolean a = equalSubsetSumPartRecur(num, target - num[length - 1], length - 1);
				boolean b = equalSubsetSumPartRecur(num, target, length - 1);
				return a || b;
			} else {
				return equalSubsetSumPartRecur(num, target, length - 1);
			}

		}

	}

}
