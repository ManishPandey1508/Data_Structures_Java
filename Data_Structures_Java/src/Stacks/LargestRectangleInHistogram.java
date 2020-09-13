package Stacks;

import java.util.Stack;



// Find Nearest smaller to left and nearest smaller to right.
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int[] heights = {};

		System.out.println("Area is " + largestRectangleArea(heights));
	}

	public static int largestRectangleArea(int[] heights) {

		int[] nsr = findNSRIndex(heights);
		int[] nsl = findNSLIndex(heights);
		int[] width = new int[heights.length];

		for (int i = 0; i < heights.length; i++) {
			width[i] = nsr[i] - nsl[i] - 1;
		}

		int max = 0;

		for (int i = 0; i < heights.length; i++) {
			max = Math.max(max, width[i] * heights[i]);
		}

		return max;

	}

	private static int[] findNSLIndex(int[] heights) {

		int start = 0;

		int[] res = new int[heights.length];

		Stack<Integer> stack = new Stack<Integer>();

		while (start < heights.length) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[start]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				res[start] = -1;
			} else {
				res[start] = stack.peek();
			}
			stack.push(start);
			start++;
		}

		return res;
	}

	private static int[] findNSRIndex(int[] heights) {
		
		int end = heights.length-1;

		int[] res = new int[heights.length];

		Stack<Integer> stack = new Stack<Integer>();

		while (end >= 0) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[end]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				res[end] = heights.length;
			} else {
				res[end] = stack.peek();
			}
			stack.push(end);
			end--;
		}

		return res;
	}

}
