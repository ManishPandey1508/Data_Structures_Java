package Array_Leetcode;

public class MinSubArrayToSortArray {
	public static void main(String[] args) {

		System.out.println(findUnsortedSubarray(new int[] { 1, 2, 3, 3, 3 }));
	}

	public static int findUnsortedSubarray(int[] nums) {

		int i = 0, j = nums.length - 1;

		if (nums.length <= 1)
			return nums.length;

		while (i < nums.length - 1 && nums[i + 1] >= nums[i]) {
			i++;
		}

		while (j > 0 && nums[j - 1] <= nums[j]) {
			j--;
		}
		if (i >= j)
			return 0;

		int startIndex = i;
		int endIndex = j;

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		while (i <= j) {

			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
			i++;

		}

		i = 0;
		j = nums.length - 1;

		while (i < startIndex) {
			if (min < nums[i])
				break;
			else
				i++;
		}
		while (j > endIndex) {
			if (nums[j] < max)
				break;
			else
				j--;
		}

		return j - i + 1;

	}

}
