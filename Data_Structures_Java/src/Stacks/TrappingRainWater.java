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
		System.out.println("Water Quantity"+ trap(height));

	}

	public static int trap(int[] height) {

		// Will push indexes of array in the stack not actual height
		Stack<Integer> stack = new Stack<>();

		int i = 0, maxBotWater = 0, maxWater = 0;

		while (i < height.length) {

			if (stack.isEmpty() || height[stack.peek()] > height[i]) {
				stack.push(i++);
			} else {
				int bot = stack.pop();

				if (stack.isEmpty())
					
					maxBotWater = 0;
				
				else {
					
					maxBotWater = (Math.min(height[i], height[stack.peek()]) - height[bot]) * (i - stack.peek() - 1);
				}

			}
			maxWater+=maxBotWater;
		}
		return maxWater;
	}

}
