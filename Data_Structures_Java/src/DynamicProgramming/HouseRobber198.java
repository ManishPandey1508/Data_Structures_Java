/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only 
 * constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically
 *  contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can 
rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.

*/
package DynamicProgramming;

public class HouseRobber198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] houses = { 0, 1, 5, 3, 1, 1 };
		int result = rob(houses);
		int res = rob_dp(houses);
		System.out.println("Result is " + result);
		System.out.println("Result is " + res);

	}

	static int rob(int[] houses) {

		int even_sum = 0;// To track Maximu at even places
		int odd_sum = 0; // To track maximum at odd places

		for (int i = 0; i < houses.length; i++) {

			if (i % 2 == 0) {
				even_sum = Math.max(even_sum + houses[i], odd_sum);
			} else
				odd_sum = Math.max(even_sum, odd_sum + houses[i]);

			System.out.println(
					"I : " + i + " Houses[i]: " + houses[i] + " Even Sum: " + even_sum + " Odd_Sum: " + odd_sum);
		}

		return Math.max(even_sum, odd_sum);

	}

	static int rob_dp(int[] houses) {

		int n = houses.length;
		int[] dp = new int[n];
		if (n == 0)
			return 0;
		if (n == 1) {
			return houses[1];
		}
		if (n == 2) {

			return Math.max(houses[0], houses[1]);
		}

		dp[0] = houses[0];
		dp[1] = Math.max(houses[0], houses[1]);
		for (int i = 2; i < n; i++) {

			dp[i] = Math.max(houses[i] + dp[i - 2], dp[i - 1]);

		}

		return dp[n - 1];

	}

}
