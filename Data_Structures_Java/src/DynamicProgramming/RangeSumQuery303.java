package DynamicProgramming;

public class RangeSumQuery303 {

	public static void main(String[] args) {

		int[] arr = {-2, 0, 3, -5, 2, -1};
		
		int result = rangeSum(2, 5, arr);
		System.out.println("Result of i =1 and j =4 of [-2, 0, 3, -5, 2, -1] is :-  "+ result);
		
		
	}

	static int rangeSum(int i, int j, int[] arr) {
		
		int sum=0;
		
		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		System.out.println("Dynamic Array is ");
		System.out.println(dp[0]);
		for (int k = 1; k < arr.length; k++) {
			dp[k] = dp[k-1]+arr[k];
			
			System.out.println(dp[k]);
		}

		if(i==0)
			return dp[j];
		else
			return dp[j] - dp[i-1];
		
		
	}

}
