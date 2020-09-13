package Stacks;

import java.util.Stack;

/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6*/

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("Water Quantity  " + trap(height));

	}

	// Water at particualr index will dpened on Sum of (Math.Min(Max_Left_Height,
	// Max_Right_Height) at Index i - Current_Height)

	public static int trap(int[] height) {

		int water = 0;
		int[] leftToright = new int[height.length];
		int[] rightToLeft = new int[height.length];

		// Calculate max Left height at each index
		int maxLeft = Integer.MIN_VALUE;
		int maxRight = Integer.MIN_VALUE;

		for (int i = 0; i < height.length; i++) {
			maxLeft = Math.max(maxLeft, height[i]);
			leftToright[i] = maxLeft;

		}

		// Calculate max right height at each index
		for (int i = height.length-1; i >=0; i--) {
			maxRight = Math.max(maxRight, height[i]);
			rightToLeft[i] = maxRight;
		}

		// calcualte water

		for (int i = 0; i < height.length; i++) {

			water += Math.min(leftToright[i], rightToLeft[i]) - height[i];

		}
		return water;

	}

}
