/*On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].
*/
package DynamicProgramming;

public class MinCostClimbingStar746 {

	public static void main(String[] args) {

		int[] cost = { 0, 1, 2, 2 };

		int result2 = minCostDP(cost);

		System.out.println("Result2  " + result2);

	}

	public static int minCostDP(int[] cost) {

		int[] sum = new int[cost.length + 1];
		sum[0] = cost[0];
		sum[1] = cost[1];

		for (int i = 2; i <= cost.length; i++) {

			int tempCost = (i == cost.length) ? 0 : cost[i];

			sum[i] = Math.min(sum[i - 1] + tempCost, sum[i - 2] + tempCost);

		}

		return sum[cost.length];
	}

}
