package GrokkingDPProblems.knapsack;

/*Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’.
We can assume an infinite supply of item quantities; therefore, each item can be selected multiple times.
Items: { Apple, Orange, Melon }
Weights: { 1, 2, 3 }
Profits: { 15, 20, 50 }
Knapsack capacity: 5*/

public class UnBoundedKnapSack {

	public int UnboundedKnapSackRecursiveBrutForce(int[] profits, int[] weights, int capacity, int index) {

		// base conditions

		if (index < 0 || index >= profits.length || capacity <= 0 || profits.length != weights.length
				|| profits.length == 0)
			return 0;

		int profit1 = 0;

		// recursive call after choosing the items at the currentIndex, note that we
		// recursive call on all
		// items as we did not increment currentIndex

		if (profit1 > capacity)
			profit1 = profits[index]
					+ UnboundedKnapSackRecursiveBrutForce(profits, weights, capacity - weights[index], index);

		// recursive call after excluding the element at the currentIndex
		int profit2 = UnboundedKnapSackRecursiveBrutForce(profits, weights, capacity, index + 1);
		return Math.max(profit1, profit2);

	}

	public int UnboundedKSTopDownDP(int[] profits, int[] weights, int capacity) {

		Integer[][] dp = new Integer[profits.length][capacity + 1];

		return helperTopDownDP(profits, weights, dp, capacity, 0);

	}

	private int helperTopDownDP(int[] profits, int[] weights, Integer[][] dp, int capacity, int index) {

		// Base Condition
		if (capacity <= 0 || index < 0 || index >= profits.length || profits.length == 0)
			return 0;

		if (dp[index][capacity] != null)
			return dp[index][capacity];

		int profit1 = 0;
		// include index[i] in profit
		if (weights[index] <= capacity) {
			profit1 = profits[index] + helperTopDownDP(profits, weights, dp, capacity - profits[index], index);
		}

		int profit2 = helperTopDownDP(profits, weights, dp, capacity, index + 1);

		dp[index][capacity] = Math.max(profit1, profit2);

		return dp[index][capacity];
	}

	private int helperBottomUpDP(int[] profits, int[] weights, int[][] dp, int capacity, int index) {

		// base condition
		if (index < 0 || index >= profits.length || capacity < 0 || profits.length != weights.length)
			return 0;

		// if capacity is 0 profits should be 0

		for (int i = 0; i < profits.length; i++) {
			dp[i][0] = 0;
		}

		for (int i = 0; i < profits.length; i++) {

			for (int c = 1; c <= capacity; c++) {

				int profit1 = 0,profit2=0;

				if (weights[i] <= capacity) {
					profit1 = profits[i] + dp[i][c-weights[i]];
				}
				
				if(i>0)
					profit2= dp[i-1][c];
				
				 dp[i][c] = profit1 > profit2 ? profit1 : profit2;
			}
		}

		
		return dp[profits.length-1][capacity];
	}

}
