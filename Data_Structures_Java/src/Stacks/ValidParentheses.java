package Stacks;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s = "()[]{";

		System.out.println("Is Valid Parentheses  " + isValid(s));
	}

	public static boolean isValid(String s) {

		if (s == null || s.length() == 0)
			return true;

		char[] brackets = s.toCharArray();
		if (brackets.length % 2 != 0)
			return false;

		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i < brackets.length) {

			if (stack.isEmpty())
				stack.push(brackets[i]);
			else if (brackets[i] == '(' || brackets[i] == '{' || brackets[i] == '[')
				stack.push(brackets[i]);
			else if (brackets[i] == ']' && stack.peek() == '[')
				stack.pop();
			else if (brackets[i] == '}' && stack.peek() == '{')
				stack.pop();
			else if (brackets[i] == ')' && stack.peek() == '(')
				stack.pop();
			else {
				stack.push(brackets[i]);
			}

			i++;

		}
		
		return stack.isEmpty();

	}
	

}
