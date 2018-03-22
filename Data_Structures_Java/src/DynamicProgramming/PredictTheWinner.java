package DynamicProgramming;

public class PredictTheWinner {

	public static void main(String[] args) {

		int[] nums = { 1, 5, 2 };
		boolean res = PredictTheWinner(nums);

		System.out.println("Result " + res);
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
		// The most critical loop and logic within that.. I still do not understand this loop part. 
		
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n - j; i++) {
				int a = (i + 1 < n && j - 1 >= 0) ? dp[i + 1][j - 1] : 0;
				int b = (i + 2 < n) ? dp[i + 2][j] : 0;
				int c = (j - 2 >= 0) ? dp[i][j - 2] : 0;
				dp[i][j] = Math.max(Math.min(a, b) + nums[i], Math.min(a, c) + nums[j]);
				System.out.println("dp["+i+"]"+"["+j+"]"+ dp[i][j]);
			}
		}

		return dp[0][n - 1] * 2 >= sum;

	}

}
