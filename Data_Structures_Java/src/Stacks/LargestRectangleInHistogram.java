package Stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int[] heights = { 2, 1};

		System.out.println("Area is " + largestRectangleAreaBrutForce(heights));
		
		System.out.println("Area is " + largestRectangleArea(heights));
	}

	public static int largestRectangleArea(int[] heights) {

		if (heights == null || heights.length == 0)
			return 0;

		int max = 0;
		int i = 0;
		Stack<Integer> stack = new Stack<>();

		while (i < heights.length) {

			int height = heights[i];
			// If stack is empty or top element push index in stack increment i

			if (stack.isEmpty() || height >= heights[stack.peek()]) {
				stack.push(i++);
			} else {
				int p = stack.pop();
				int h = heights[p];
				int width = 0;
				if (stack.isEmpty())
					width = i;
				else {
					width = i - stack.peek() - 1;
				}
				max = Math.max(h*width, max);

			}

		}
		
		while(!stack.isEmpty()) {
			int p = stack.pop();
			int h = heights[p];
			int w = stack.isEmpty()?i: i - stack.peek()-1;
			max = Math.max(h*w, max);
		}
		
		
		
		return max;

	}

	public static int largestRectangleAreaBrutForce(int[] heights) {

		if (heights == null || heights.length == 0)
			return 0;

		int max = 0;

		for (int i = 0; i < heights.length; i++) {

			max = Math.max(max, heights[i]);
			int minHeight = heights[i];
			for (int j = i + 1; j < heights.length; j++) {
				minHeight = Math.min(minHeight, heights[j]);
				int rectangeWidth = j - i + 1;
				max = Math.max(max, minHeight * rectangeWidth);

			}

		}
		return max;
	}

}
