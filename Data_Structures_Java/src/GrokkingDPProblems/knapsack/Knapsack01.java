package GrokkingDPProblems.knapsack;

import java.util.HashSet;
import java.util.Set;

/*Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative
weight is not more than a given number ‘C’. 
Each item can only be selected once, which means either we put an item in the knapsack or we skip it.*/

public class Knapsack01 {

	public static void main(String[] args) {
		int[] weights = { 2, 3, 1, 4 };
		int[] value = { 4, 5, 3, 7 };
		int capacity = 5;

		System.out.println("Max Value " + maxvalue(weights, value, capacity));
		System.out.println("Max Value " + maxvalueBottomUpDP(weights, value, capacity));
	}

	// Naive Brute force Solution , Use recursion
	public static int maxvalue(int[] weight, int[] value, int capacity) {

		int max = helperBruteForce(weight, value, capacity, 0);

		return max;
	}

	private static int helperBruteForce(int[] weight, int[] value, int capacity, int currentIndex) {

		if (capacity <= 0 || currentIndex < 0 || currentIndex >= weight.length)
			return 0;

		int currentWeight = weight[currentIndex];
		int currentValue = value[currentIndex];
		int total1 = 0, total2 = 0;

		// total by including current index

		if (currentWeight <= capacity) {
			total1 = currentValue + helperBruteForce(weight, value, capacity - currentWeight, currentIndex + 1);
		}
		// total by excluding current index
		total2 = helperBruteForce(weight, value, capacity, currentIndex + 1);

		// return the max
		return Math.max(total1, total2);
	}

	// Naive Brute force Solution , Using DP
	public static int maxvalueBottomUpDP(int[] weights, int[] value, int capacity) {

		Integer[][] dp = new Integer[weights.length][capacity + 1];

		int max = helpermemoization(weights, value, capacity, dp, 0);

		return max;
	}

	private static int helpermemoization(int[] weights, int[] profits, int capacity, Integer[][] dp, int currentIndex) {

		if (capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length)
			return 0;

		if (dp[currentIndex][capacity] != null)
			return dp[currentIndex][capacity];

		int profit1 = 0, profit2 = 0;

		// profit including current Index

		if (weights[currentIndex] <= capacity)
			profit1 = profits[currentIndex]
					+ helpermemoization(weights, profits, capacity - weights[currentIndex], dp, currentIndex + 1);

		profit2 = helpermemoization(weights, profits, capacity, dp, currentIndex + 1);

		dp[currentIndex][capacity] = Math.max(profit1, profit2);

		return dp[currentIndex][capacity];
	}

}
