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

		int[] num = {1, 2, 7, 1, 5};

		int sum = 0;
		for (int i : num) {
			sum += i;
		}
	
		System.out.println(canPartitionRecursive(num, sum));

	}

	public static int canPartitionRecursive(int[] num, int sum) {

		// Populate subset sun dp with T F
		int minDiff = 0;
		

		boolean[] dp1 = createSubsetSumDP(num, sum);

		for (int j = sum / 2; j >= 0; j--) {
			if (dp1[j] == true) {
				minDiff = j;
				break;
			}

		}

		return sum - (2 * minDiff);
	}

	private static boolean[] createSubsetSumDP(int[] num, int sum)

	{
		boolean[][] dp = new boolean[num.length + 1][sum + 1];
		
		for (int i = 0; i < num.length + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {

				if(i==0 && j!=0)
					dp[i][j]=false;
				else if(j==0)
					dp[i][j] = true;
				else if(num[i-1] <= j) {
					dp[i][j] = dp[i-1][j-num[i-1]] || dp[i-1][j];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}

		return dp[num.length];
	}

}
