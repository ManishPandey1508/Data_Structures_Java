/*here are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is
 *  different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of 
painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint 
all houses.

Note:
All costs are positive integers.

Example:

Input: [[1,5,3],[2,9,4]]
Output: 5
Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5. */

package DynamicProgramming;

/*Understand the problem:
This is a classic back pack problem. 
 -- Define dp[n][k], where dp[i][j] means for house i with color j the minimum cost. 
 -- Initial value: dp[0][j] = costs[0][j]. For others, dp[i][j] = Integer.MAX_VALUE;, i >= 1
 -- Transit function: dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + cost[i][j]), where k != j.
 -- Final state: Min(dp[n - 1][k]).*/

// its a DP code, not a high performance but easy to understand 

public class Paint_House_2_KnapSackProb {

	public int minCostII(int[][] costs) {

		if (costs == null || costs.length == 0)
			return 0;

		int n = costs.length;
		int k = costs[0].length;

		// Create DP array
		int[][] dp = new int[n][k];

		// 0th row that is base case

		for (int i = 0; i < k; i++) {
			dp[0][k] = costs[0][k];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int l = 0; l < j; l++) {
					if (l != j)
						dp[i][j] = Math.min(dp[i - 1][l] + costs[i][j], dp[i][j]);
				}

			}

		}

		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			minCost = Math.min(minCost, dp[n - 1][i]);
		}

		return minCost;

	}

}
