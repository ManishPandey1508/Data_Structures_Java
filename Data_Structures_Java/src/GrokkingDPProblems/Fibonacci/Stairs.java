package GrokkingDPProblems.Fibonacci;

public class Stairs {

	public static void main(String[] args) {
			System.out.println(countStairsRec(4));
		System.out.println(countStairsDP(50));
		//System.out.println(countStairsBottomUP(50));
	}

	public static int countStairsRec(int n) {

		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else if (n == 3)
			return 4;
		else
			return countStairsRec(n - 3) + countStairsRec(n - 2) + countStairsRec(n - 1);

	}

	public static int countStairsDP(int n) {

		Integer[] dp = new Integer[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		if (n <= 3)
			return dp[n];
		else
			return countStairsDPTopDown(n, dp);

	}

	private static int countStairsDPTopDown(int n, Integer[] dp) {

		if (dp[n] != null)
			return dp[n];

		else {

			dp[n - 1] = countStairsDPTopDown(n - 1, dp);
			dp[n - 2] = countStairsDPTopDown(n - 2, dp);
			dp[n - 3] = countStairsDPTopDown(n - 3, dp);
			dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
			return dp[n];

		}

	}

	private static int countStairsBottomUP(int n) {

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for(int i=4;i<=n;i++) 
		{
		dp[i] = dp[i-1]+dp[i-2]+dp[i-3];	
		}
		
		return dp[n];
	}

}
