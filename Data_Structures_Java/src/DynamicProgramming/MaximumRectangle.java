package DynamicProgramming;

import java.util.Stack;

public class MaximumRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };

		System.out.println("Total Rectangle   " + maximalRectangle(matrix));
	}

	public static int maximalRectangle(char[][] matrix) {

		// convert it to a largest rectangle in Histogram

		if (matrix == null || matrix.length == 0)
			return 0;

		int[] dp = new int[matrix[0].length];

		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == '1')
					dp[j] += 1;
				else
					dp[j] = 0;

			}

			maxArea = Math.max(maxArea, largestAreaOfHistogram(dp));
		}

		return maxArea;
		// use stack to find largest rectangle in this converted histogram

	}

	private static int largestAreaOfHistogram(int[] heights) {

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
		// this case is for the case where histogram heights are in sorted increasing order
		while(!stack.isEmpty()) {
			int p = stack.pop();
			int h = heights[p];
			int w = stack.isEmpty()?i: i - stack.peek()-1;
			max = Math.max(h*w, max);
		}
		
		
		
		return max;

	}

}
