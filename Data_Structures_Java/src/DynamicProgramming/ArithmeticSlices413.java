package DynamicProgramming;

public class ArithmeticSlices413 {

	public static void main(String[] args) {

		int arr[] = {1,2,3,4};
		
		int res = numberOfArithmeticSlices(arr);
		System.out.println("Arithmetic Slices are "+ res);
		
		int res1 = numberOfArithmeticSlicesBrutForce(arr);
		System.out.println("Arithmetic Slices are "+ res1);
		
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
	static int numberOfArithmeticSlicesBrutForce(int[] A) {
        int count = 0;
        for (int s = 0; s < A.length - 2; s++) {
            int d = A[s + 1] - A[s];
            for (int e = s + 2; e < A.length; e++) {
                if (A[e] - A[e - 1] == d)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
	
	
	
}
