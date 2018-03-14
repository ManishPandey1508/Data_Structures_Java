package DynamicProgramming;

public class ArithmeticSlices413 {

	public static void main(String[] args) {

		int arr[] = {1,3,5,7,9,15,20,25,28,29};
		
		int res = numberOfArithmeticSlices(arr);
		System.out.println("Arithmetic Slices are "+ res);
		
	}

	static int numberOfArithmeticSlices(int[] arr) {
		int[] dp = new int[arr.length];
		int sum = 0;
		for (int i = 2; i < arr.length; i++) {

			if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
				dp[i] = dp[i - 1] + 1;
			 sum += dp[i];
			}
			
		}
		
		return sum;
	}
}
