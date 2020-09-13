package GrokkingDPProblems.knapsack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative
weight is not more than a given number ‘C’. 
Each item can only be selected once, which means either we put an item in the knapsack or we skip it.*/

public class Knapsack01 {

	public static void main(String[] args) {
		int[] value = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };
		int capacity = 7;

		System.out.println("Max Value " + maxvalue(weights, value, capacity));
		System.out.println("Max Value " + maxvalueDP(weights, value, capacity));

	}

	// Naive Brute force Solution , Use recursion
	public static int maxvalue(int[] weight, int[] value, int capacity) {

		int max = helperBruteForce(weight, value, capacity, weight.length);

		return max;
	}

	// Naive Brute force Solution , Use recursion
	public static int maxvalueDP(int[] weight, int[] value, int capacity) {

		int[][] dp = new int[weight.length + 1][capacity + 1];

		for (int i = 0; i <= weight.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		int max = helpermemoization(weight, value, capacity, dp, weight.length);

		return max;
	}

	private static int helperBruteForce(int[] weight, int[] value, int capacity, int size) {

		// base condition
		if (size == 0 || capacity == 0)
			return 0;
		// weight[i] < capacity-- > either include the item or dont, find max in both
		// condition
		if (weight[size - 1] <= capacity) {

			return Math.max(value[size - 1] + helperBruteForce(weight, value, capacity - weight[size - 1], size - 1),
					helperBruteForce(weight, value, capacity, size - 1));

		} else {

			return helperBruteForce(weight, value, capacity, size - 1);
		}

	}

	private static int helpermemoization(int[] weights, int[] value, int capacity, int[][] dp, int size) {
		if (size == 0 || capacity == 0) {
			dp[size][capacity] = 0;
			return dp[size][capacity];
		}

		if (dp[size][capacity] != -1)
			return dp[size][capacity];

		else if (weights[size - 1] <= capacity) {

			dp[size][capacity] = Math.max(
					value[size - 1] + helperBruteForce(weights, value, capacity - weights[size - 1], size - 1),
					helperBruteForce(weights, value, capacity, size - 1));

		} else {

			dp[size][capacity] = helperBruteForce(weights, value, capacity, size - 1);
		}

		return dp[size][capacity];

	}

}
