package Array_Leetcode;

public class MinimumSizeSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8 };

		System.out.println(minSubArrayLen(80, nums));

	}

	public static int minSubArrayLen(int s, int[] nums) {

		int minLength = Integer.MAX_VALUE;
		if (nums == null || nums.length == 0)
			return 0;

		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			int j = i;
			while (j < nums.length && sum < s) {
				sum = sum + nums[j];
				if (sum >= s) {
					minLength = Math.min(minLength, j - i + 1);
					break;
				} else {
					j++;
				}
			}

			System.out.println(minLength);

		}

		return minLength== Integer.MAX_VALUE?0:minLength;

	}

}
