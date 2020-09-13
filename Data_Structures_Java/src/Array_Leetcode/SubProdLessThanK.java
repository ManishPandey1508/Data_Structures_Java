package Array_Leetcode;

public class SubProdLessThanK {

	public static void main(String[] args) {

		System.out.println(numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));

	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {

		int result = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] >= k)
				continue;

			result++;

			int j = i + 1;

			int newTarget = k / nums[i];

			while (j < nums.length) {
				if(newTarget / nums[j] == 1 && nums[j]!=newTarget) {
					result++;
					break;
				}
					
				if (newTarget / nums[j] > 1) {
					newTarget = newTarget / nums[j];
					result++;
				}
				j++;
			}
		}

		return result;
	}
}
