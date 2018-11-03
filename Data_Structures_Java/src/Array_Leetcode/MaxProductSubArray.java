package Array_Leetcode;

/*Input: arr[] = {6, -3, -10, 0, 2}
Output:   180  // The subarray is {6, -3, -10}

Input: arr[] = {-1, -3, -10, 0, 60}
Output:   60  // The subarray is {60}

Input: arr[] = {-2, -3, 0, -2, -40}
Output:   80  // The subarray is {-2, -40}
*/public class MaxProductSubArray {

	public static void main(String[] args) {

	}

	public int maxProduct(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;
		int max_Prod = nums[0];
		int min_Prod = nums[0];
		int res =nums[0];
		for (int i = 1; i < nums.length; i++) {

			if (nums[i] >= 0) {

				max_Prod = Math.max(max_Prod * nums[i], nums[i]);
				min_Prod = Math.max(min_Prod * nums[i], nums[i]);
			} else {
				int temp = max_Prod;
				max_Prod = Math.max(min_Prod * nums[i], nums[i]);
				min_Prod = Math.max(temp * nums[i], nums[i]);

			}
			
			res = Math.max(max_Prod, res);
		}
		
		return res;
	}


}
