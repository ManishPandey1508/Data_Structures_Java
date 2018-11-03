/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/
package Array_Leetcode;

public class MoveZeroes {

	public static void main(String[] args) {

		int[] nums = { 0, 0, 1 };

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}

		moveZeroes(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

	}

	public static void moveZeroes2(int[] nums) {
		int zeroCount = 0;

		for (int k = 0; k < nums.length; k++) {

			if (nums[k] == 0) {
				zeroCount++;
			}else
			{
				nums[k-zeroCount]=nums[k];
			}

		}

		for (int i = nums.length-1; i> nums.length-i-1; i--) {

			nums[i] = 0;
		}

	}
	
	
	public static void moveZeroes(int[] nums) {
		int nonzeroCount = 0;

		for (int k = 0; k < nums.length; k++) {

			if (nums[k] != 0) {
				nums[nonzeroCount++] = nums[k];
			}

		}

		for (int k = nonzeroCount; k < nums.length; k++) {

			nums[k] = 0;
		}

	}

}
