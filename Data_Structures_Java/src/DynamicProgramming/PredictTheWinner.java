package DynamicProgramming;

public class PredictTheWinner {

	public static void main(String[] args) {

		int[] nums = { 1, 5, 2 };
		boolean res = PredictTheWinner(nums);

		System.out.println("Result " + res);

		res = predictTheWinner2ndApproach(nums);

		System.out.println("Result " + res);

	}

	static class Pair {
		int first, second;

		public String toString() {
			return first + " " + second;
		}
	}

	static boolean predictTheWinner2ndApproach(int[] nums) {
		int n = nums.length;
		int sum = 0;
		// If total no is even its always the one who start will win, no matter what
		if (n % 2 == 0)
			return true;
		// Create a 2d Array of Type Pair, dp[i][j] will be the value through which 1st
		// player will
		// win in i to j input size.

		Pair[][] dp = new Pair[n][n];
		// base case for diagonal elements
		for (int i = 0; i < n; i++) {
			dp[i][i] = new Pair();
			dp[i][i].first = nums[i];
			dp[i][i].second = 0;
			sum += nums[i];
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = new Pair();
			}
		}

		// Now fill dp for other cases
		for (int i = 0; i < dp.length; i++) {

			for (int j = i + 1; j < dp[0].length; j++) {

				if (nums[i] + dp[i + 1][j].second > nums[j] + dp[i][j - 1].second) {

					dp[i][j].first = nums[i] + dp[i + 1][j].second;
					dp[i][j].second = dp[i + 1][j].first;
				} else {

					dp[i][j].first = nums[j] + dp[i][j - 1].second;
					dp[i][j].second = dp[i][j - 1].first;
				}

				System.out.println("dp[" + i + "]" + "[" + j + "]" + dp[i][j].first + "  " + dp[i][j].second);

			}

		}

		return dp[0][n - 1].first * 2 >= sum;

	}

	static boolean PredictTheWinner(int[] nums) {

		int n = nums.length;
		int sum = 0;
		// If total no is even its always the one who start will win, no matter what
		if (n % 2 == 0)
			return true;
		// Create a 2d Array, dp[i][j] will be the value through which 1st player will
		// win in i to j input size.

		int[][] dp = new int[n][n];

		// base case what will happen if nums hase just one value

		for (int i = 0; i < n; i++) {

			dp[i][i] = nums[i];
			sum += nums[i];

		}
		// The most critical loop and logic within that.. I still do not understand this
		// loop part.

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n - j; i++) {
				int a = (i + 1 < n && j - 1 >= 0) ? dp[i + 1][j - 1] : 0;
				int b = (i + 2 < n) ? dp[i + 2][j] : 0;
				int c = (j - 2 >= 0) ? dp[i][j - 2] : 0;
				dp[i][j] = Math.max(Math.min(a, b) + nums[i], Math.min(a, c) + nums[j]);
				System.out.println("dp[" + i + "]" + "[" + j + "]" + dp[i][j]);
			}
		}

		return dp[0][n - 1] * 2 >= sum;

	}

}
