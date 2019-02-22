package GrokkingDPProblems.Fibonacci;
/*Given an array of positive numbers, where each element represents the max number of jumps that can be made forward from that element,
write a program to find the minimum number of jumps needed to reach the end of the array (starting from the first element). 
If an element is 0, then we cannot move through that element*/

/*Input = {1,1,3,6,9,3,0,1,3}
Output = 4
Explanation: Starting from index '0', we can reach the last index through: 0->1->2->3->8*/

public class MinimumJumps {

	public static void main(String[] args) {

		int[] jumps = { 2, 1, 1, 1, 4 };
		System.out.println(countMinJumps(jumps));
	}

	public static int countMinJumps(int[] jumps) {

		return countMinJumps(jumps, 0);

	}

	//

	private static int countMinJumps(int[] jumps, int index) {

		// check base condition
		if (index == jumps.length - 1)
			return 0;

		if (jumps[index] == 0)
			return Integer.MAX_VALUE;

		int start = index + 1;

		int end = index + jumps[index];
		int total_jumps = Integer.MAX_VALUE;
		while (start < jumps.length && start <= end) {

			int min_jump = countMinJumps(jumps, start++);
			if (min_jump != Integer.MAX_VALUE) {
				total_jumps = Math.min(total_jumps, min_jump + 1);
			}

		}

		return total_jumps;

	}

	// We can use dp[] array where dp[i] is minimum no of jumps at ith index
	private static int countMinJumpsTopDownDP(int[] jumps, int[] dp, int index) {
		if (index == jumps.length - 1) {
			return 0;
		}
		if (jumps[index] == 0)
			return Integer.MAX_VALUE;

		if (dp[index] != Integer.MAX_VALUE)
			return dp[index];

		int start = index + 1;
		int end = index + jumps[index];
		int total_jump = Integer.MAX_VALUE;
		while (start < jumps.length && start <= end) {
			int min_jump = countMinJumpsTopDownDP(jumps, dp, start++);
			total_jump = Math.min(total_jump, min_jump + 1);
		}
		dp[index] = total_jump;
		return dp[index];
	}

}
