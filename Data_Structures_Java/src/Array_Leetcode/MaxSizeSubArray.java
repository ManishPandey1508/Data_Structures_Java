package Array_Leetcode;

public class MaxSizeSubArray {

	public static void main(String[] args) {

		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		System.out.println("Maximum Sum of SubArray  " + maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {

		int max_current = nums[0];
		int max_global = nums[0];

		for (int i = 0; i < nums.length; i++) {

			max_current = Math.max(nums[i], nums[i] + max_current);
			max_global = Math.max(max_global, max_current);

		}

		return max_global;
	}

}
