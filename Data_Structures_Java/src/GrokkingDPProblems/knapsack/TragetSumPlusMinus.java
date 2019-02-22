package GrokkingDPProblems.knapsack;

public class TragetSumPlusMinus {

	public static void main(String[] args) {

		int[] num = { 1, 1, 2, 3 };
		System.out.println("Answer using brutforce " + findTargetSubsetSumRecursive(num, 1, 0));
		System.out.println("Answer using brutforce " + targetSumUsingDP(num, 1));
	}

	public static int findTargetSubsetSumRecursive(int[] num, int target, int index) {

		if (index >= num.length) {
			return target == 0 ? 1 : 0;
		}

		int plusCount = findTargetSubsetSumRecursive(num, target - num[index], index + 1);

		int minusCount = findTargetSubsetSumRecursive(num, target + num[index], index + 1);

		return plusCount + minusCount;

	}

	// two set s1-s2 = target
	// s1+s1 = sum --> 2*s1 = target+sum , s1 = target+sum /2;

	public static int targetSumUsingDP(int[] num, int target) {
		int sum = 0;

		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}

		int s1 = (target + sum) / 2;

		Integer[][] dp = new Integer[num.length][s1 + 1];

		for (int i = 0; i < num.length; i++) {
			dp[i][0] = 1;
		}

		// if just one element thn it should equal to sum s

		for (int s = 1; s <= s1; s++) {
			dp[0][s] = num[0] == s ? 1 : 0;
		}

		for (int i = 1; i < num.length; i++) {

			for (int s = 1; s <= s1; s++) {

				dp[i][s] = dp[i-1][s];
				if(num[i]<=s) {
					dp[i][s]+= dp[i-1][s-num[i]];
				}
				
			}

		}

		return dp[num.length-1][s1];
		
	}

}
