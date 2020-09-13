package Stacks;

import java.util.Stack;

/*Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
*/
public class StackSpanProblem {

	// this is the same problem as next greater element to left.

	public static void main(String[] args) {
		int[] arr = { 80, 56, 60, 10, 20, 75, 90 };

		int[] resleft = getStockSpan(arr);

		for (int i : resleft) {
			System.out.println(i);
		}

	}

	private static int[] getStockSpan(int[] arr) {

		int[] res = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		int start = 0;

		while (start < arr.length) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[start]) {

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

		for (int i = 0; i < arr.length; i++) {
			res[i] = i - res[i];
		}

		return res;
	}

}
