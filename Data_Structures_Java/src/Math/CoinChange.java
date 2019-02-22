package Math;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {

		int[] coins = { 186, 419, 83, 408 };
		System.out.println("result " + coinChangeBottomUpDP(coins, 6249));
		
		int[] coins2= {186, 419, 83, 408 };
		System.out.println("result " + coinChangeTotalNoOFWays(coins2, 6249));
	}

	// find Total no of ways
	private static int coinChangeTotalNoOFWays(int[] coins, int total) {

		if (coins == null || coins.length == 0)
			return 0;

		Arrays.sort(coins);

		return (coinChangeTotalNoOFWays(coins, total, coins.length - 1));
	}

	public static int coinChangeTotalNoOFWays(int[] coins, int total, int index) {
		if (total == 0)
			return 1;

		if (total < 0)
			return 0;
		if(index <0)
			return 0;

		return coinChangeTotalNoOFWays(coins, total, index - 1)
				+ coinChangeTotalNoOFWays(coins, total - coins[index], index);

	}

	// T[i] = Min(T[i], 1+ T[i-coins(j)]) for all j and if i>= coins(j)

	// DP Solution

	private static int coinChangeBottomUpDP(int[] coins, int total) {

		Arrays.sort(coins);

		int[] T = new int[total + 1];

		Arrays.fill(T, Integer.MAX_VALUE - 1);

		T[0] = 0;

		for (int j = 0; j < coins.length; j++) {

			for (int i = 1; i <= total; i++) {

				if (i >= coins[j]) {

					T[i] = Math.min(T[i], 1 + T[i - coins[j]]);

				}

			}

		}
		return T[total];

	}

}
