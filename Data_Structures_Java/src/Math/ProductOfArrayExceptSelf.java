package Math;

/*Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {

		int[] nums= {5,4,3,2};
		
		int[] result = productExceptSelf(nums);
		
	for (int i = 0; i < result.length; i++) {
		
		System.out.println(result[i]);
		
	}
		
		
	}

	public static int[] productExceptSelf(int[] nums) {
		int length = nums.length;

		int[] ret = new int[length];

		if (length == 0)
			return ret;

		int preFix = 1;

		for (int i = 0; i < nums.length; i++) {
			ret[i] = preFix;
			preFix *= nums[i];
		}
		int suffix = 1;

		for (int i = nums.length - 1; i >= 0; i--) {

			ret[i] = suffix * ret[i];

			suffix *= nums[i];
		}
		return ret;
	}

}
