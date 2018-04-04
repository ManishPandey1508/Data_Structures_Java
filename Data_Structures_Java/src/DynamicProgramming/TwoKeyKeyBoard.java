package DynamicProgramming;

public class TwoKeyKeyBoard {

	public static void main(String[] args) {
		
		int n=8;
		int res = minSteps(n);
		
		System.out.println("Result   "+ res);	
		
	}

	static int minSteps(int n) {

		int[] dp = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			dp[i] = i;
			
			// Find the highest divisor of I and you just need two step that 
			//is copy that number and paste it that many times.
			
			for (int j = i - 1; j > 1; j--) {

				if (i % j == 0) {

					dp[i] = dp[j] + i / j;
				}

			}	
			
		}
		return dp[n];

	}

}
