package Math;

public class CoinChange {

	public static void main(String[] args) {

		int[] coins = { 186, 419, 83, 408 };

		System.out.println("result " + coinChange(coins, 6249));
	}

	/*
	 * Bottom Up DP The idea is very classic dynamic programming: think of the last
	 * step we take. Suppose we have already found out the best way to sum up to
	 * amount a, then for the last step, we can choose any coin type which gives us
	 * a remainder r where r = a-coins[i] for all i's. For every remainder, go
	 * through exactly the same process as before until either the remainder is 0 or
	 * less than 0 (meaning not a valid solution). With this idea, the only
	 * remaining detail is to store the minimum number of coins needed to sum up to
	 * r so that we don't need to recompute it over and over again.
	 */
	private static int coinChange(int[] coins, int amount) {

		if (amount < 1)
			return 0;

		int[] dp = new int[amount + 1];

		int sum = 0;

		// fill each element of dp array
		while (++sum <= amount) {
			// default value of dp[i] if sum is not possible
			int min = -1;
			// check dp[i] for each coin
			for (int coin : coins) {

				if (sum >= coin && dp[sum - coin] != -1) {

					int temp = 1 + dp[sum - coin];
					if (min < 0)
						min = temp;
					else
						min = Math.min(min, temp);
				}
				
			}
			dp[sum] = min;
		}
		
		return dp[amount];
	}

}
