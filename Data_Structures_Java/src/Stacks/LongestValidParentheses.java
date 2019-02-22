package Stacks;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
	
		System.out.println(" Length of longets valid parentheses  "+ longestValidParentheses(")()()()()(()(()"));
		
		
	}
	
	public static int longestValidParentheses(String s) {

		int result = 0;

		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			// if char is '(' put it in stack
			if (c == '(') {
				stack.push(new int[] { i, 0 });
			} else {

				// if char is ')' first check if stack is empty or top element is also ')' in
				// these two cases its not a valid pair
				if (stack.isEmpty() || stack.peek()[1] == 1) {
					stack.push(new int[] { i, 1 });
				} else {
					// remove the top element of stack, top must be '('
					stack.pop();
					// initialize the current length
					int currentLength = 0;
					// if stack is empty now.. means i equals to length
					if(stack.isEmpty()) {
						currentLength = i+1;
					}else {
						currentLength = i- stack.peek()[0];
								
					}
					result= Math.max(result, currentLength);	
				}
			}

		}

		return result;
	}

}
