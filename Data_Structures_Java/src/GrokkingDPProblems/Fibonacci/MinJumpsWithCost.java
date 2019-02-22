package GrokkingDPProblems.Fibonacci;

import java.util.Arrays;

public class MinJumpsWithCost {

	/*
	 * Given a staircase with ‘n’ steps and an array of ‘n’ numbers representing the
	 * fee that you have to pay if you take the step. Implement a method to
	 * calculate the minimum fee required to reach the top of the staircase. At
	 * every step, you have an option to take either 1 step, 2 steps, or 3 steps.
	 * You should assume that you are standing at the first step.
	 * 
	 * Example 1:
	 * 
	 * Number of stairs (n) : 6 Fee: {1,2,5,2,1,2} Output: 3 Explanation: Starting
	 * from index '0', we can reach the last index through: 0->3->top The total fee
	 * we have to pay will be (1+2). Example 2:
	 * 
	 * Number of stairs (n): 4 Fee: {2,3,4,5} Output: 5 Explanation: Starting from
	 * index '0', we can reach the last index through: 0->1->top The total fee we
	 * have to pay will be (2+3). Let’s first start with a recursive brute-force
	 * solution
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fee = { 2, 3, 4, 5 };
		int[] dp = new int[fee.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		System.out.println(findMinFee(fee));
		System.out.println(findMinFeeTopDown(fee,dp,0));
		
	}

	private static int findMinFee(int[] fee) {

		if (fee.length == 0)
			return Integer.MAX_VALUE;

		return findMinFeeRecursive(fee, 0);

	}

	private static int findMinFeeRecursive(int[] fee, int index) {
		// base condition

		if (index > fee.length - 1)
			return 0;

		int cost1 = fee[index] + findMinFeeRecursive(fee, index + 1);
		int cost2 = fee[index] + findMinFeeRecursive(fee, index + 2);
		int cost3 = fee[index] + findMinFeeRecursive(fee, index + 3);

		return Math.min(Math.min(cost1, cost2), cost3) + fee[index];
	}

	private static int findMinFeeTopDown(int[] fee,int[]dp, int index) {
		// base condition

		if (index > fee.length - 1)
			return 0;
		if(dp[index]!=Integer.MAX_VALUE)
			return dp[index];

		int cost1 = fee[index] + findMinFeeRecursive(fee, index + 1);
		int cost2 = fee[index] + findMinFeeRecursive(fee, index + 2);
		int cost3 = fee[index] + findMinFeeRecursive(fee, index + 3);

		dp[index]= Math.min(Math.min(cost1, cost2), cost3) + fee[index];
		
		return dp[index];
	}
	
	
}
