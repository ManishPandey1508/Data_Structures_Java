package HackerRank;

public class PocketGems {

	/*
	 * arr = zeros(N + 1) arr[0] = 1 for coin in range(1, N): for i in range(N -
	 * coin, -1, -1): arr[i + coin] += arr[i] return arr[N]
	 */

	public static int ways(int total, int k) {

		int[][] dp = new int[total+1][k+1];
		dp[0][0] = 1;
		dp[total][0]=1;
		
		for(int i=0;i<)
	}

	
	public static void main(String[] args) {
		System.out.println(ways(8, 2));
	}
}
