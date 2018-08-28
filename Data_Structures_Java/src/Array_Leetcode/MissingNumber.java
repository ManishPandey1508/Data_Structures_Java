package Array_Leetcode;

import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args) {
		int[] nums = {9,6,4,2,3,5,7,0,1};
		
		System.out.println("Missing Number  "+ missingNumber(nums));
	}

	public static int missingNumber(int[] nums) {

		
		int[] temp = new int[nums.length+1];
		Arrays.fill(temp, -1);
		int missingIndex =0;

		for (int i = 0; i < nums.length; i++) {

			int index = nums[i];
			temp[index] = 1;
		}

		for (int i = 0; i < temp.length; i++) {

			if (temp[i] == -1)
				missingIndex= i;

		}

		return missingIndex;
	}

}
