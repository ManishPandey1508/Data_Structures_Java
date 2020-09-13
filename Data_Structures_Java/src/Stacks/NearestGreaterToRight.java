package Stacks;

import java.util.Stack;

public class NearestGreaterToRight {

	public static void main(String[] args) {

		int[] arr = {10, 5, 11, 6, 20, 12 };
		int[] res = nextGreater(arr);
		int [] resleft = nextGreaterLeft(arr);
		

		for (int i : res) {
			System.out.println("Next Greater on Right Side  " + i);
		}

		for (int i : resleft) {
			System.out.println("Next Greater on Left Side    " + i);
		}
		
	}	
	
	private static int[] nextGreaterLeft(int[] arr) {
		int[] res = new int[arr.length];
		if (arr.length == 0)
			return res;

		int resIndex = 0;

		Stack<Integer> stack = new Stack<>();

		while (resIndex < arr.length) {

			while (!stack.isEmpty() && stack.peek() < arr[resIndex]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				
				res[resIndex] = -1;
			} else {
				res[resIndex] = stack.peek();
				
			}
			stack.push(arr[resIndex]);
			resIndex++;

		}

		return res;
	}

	private static int[] nextGreater(int[] arr) {

		int[] res = new int[arr.length];
		if (arr.length == 0)
			return res;

		int resIndex = arr.length - 1;

		Stack<Integer> stack = new Stack<>();

		while (resIndex >= 0) {

			while (!stack.isEmpty() && stack.peek() < arr[resIndex]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				
				res[resIndex] = -1;
			} else {
				res[resIndex] = stack.peek();
				
			}
			stack.push(arr[resIndex]);
			resIndex--;

		}

		return res;
	}

}
