package DynamicProgramming;

public class IntegerBreak {

	public static void main(String[] args) {
	
		int res  = integerBreak(10);
		System.out.println("Result "+ res);
		
	}

	static int integerBreak(int n) {

		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;

		if (n == 2)
			return 1;

		for (int i = 3; i <= n; i++) {
			
			int max = Integer.MIN_VALUE;
			
			for (int j = 1; j <= i/ 2; j++) {
				int k = i - j;
				max = Math.max(max, Math.max(dp[k]*j, k * j ));
			}
			dp[i] = max;

		}

		return dp[n];
	}

}
