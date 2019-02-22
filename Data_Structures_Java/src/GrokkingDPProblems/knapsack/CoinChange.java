package GrokkingDPProblems.knapsack;

public class CoinChange {

	public static void main(String[] args) {

		int[] denominations = { 1, 2, 3 };
		int change = 5;

		Integer[][] dp = new Integer[denominations.length][change + 1];

		System.out.println("Recursive solution      " + coinChange(denominations, 5, 0));
		System.out.println("Top Down DP   " + coinChangetopDownDP(denominations, change, dp, 0));
		System.out.println("Bottom UP  DP   " + coindChangeBUPDP(denominations, change));

	}

	private static int coinChangetopDownDP(int[] denominations, int change, Integer[][] dp, int index) {

		if (change == 0) {
			return 1;
		}

		if (index < 0 || index >= denominations.length || change < 0)
			return 0;

		if (dp[index][change] != null)
			return dp[index][change];

		int total1 = 0;

		if (denominations[index] <= change)
			total1 = coinChangetopDownDP(denominations, change - denominations[index], dp, index);

		int total2 = coinChangetopDownDP(denominations, change, dp, index + 1);

		dp[index][change] = total1 + total2;

		return dp[index][change];

	}

	public static int coinChange(int[] denominations, int total, int index) {

		if (index < 0 || index >= denominations.length || total < 0)
			return 0;

		if (total == 0)
			return 1;

		int total1 = coinChange(denominations, total - denominations[index], index);

		int total2 = coinChange(denominations, total, index + 1);

		return total1 + total2;

	}

	public static int coindChangeBUPDP(int[] denominations, int change) {

		int[][] dp = new int[denominations.length][change + 1];

		for (int i = 0; i < denominations.length; i++) {
			dp[i][0] = 1;
		}

		for(int i=0 ; i<denominations.length;i++) {
			
			for (int j = 1; j <=change; j++) {
				
				if(i>0)
					dp[i][j]=dp[i-1][j];
				if(denominations[i] <= j)
				dp[i][j]+= dp[i][j-denominations[i]];
			}
			
		}
		return dp[denominations.length-1][change];
		
	}

}
