package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
*/

public class ReversePolishNotation {

	public static void main(String[] args) {
		String[] arr = {"2","1","+","3","*"};
		System.out.println(evalRPN(arr)); 
	}
	
	
	public static int evalRPN(String[] tokens) {

		List<String> operator = new ArrayList<>();
		operator.add("+");
		operator.add("-");
		operator.add("*");
		operator.add("/");
		Stack<Integer> stack = new Stack<>();
		int operand1 = 0;
		int operand2 = 0;

		if (tokens.length == 0)
			return 0;

		for (int i = 0; i < tokens.length; i++) {

			if (operator.contains(tokens[i])) {
				operand1 = stack.pop();
				operand2 = stack.pop();
				stack.push(applyOperand(operand1, operand2, tokens[i]));
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}

		}
return stack.pop();
	}

	private static Integer applyOperand(int operand1, int operand2, String string) {

		if (string.equalsIgnoreCase("+") ) {
			return operand1 + operand2;
		}
		if (string.equalsIgnoreCase("-") ) {
			return operand1 - operand2;
		}
		if (string.equalsIgnoreCase("*")) {
			return operand1 * operand2;
		}
		if (string.equalsIgnoreCase("/")) {
			return operand1 / operand2;
		}

		return -1;
	}

}
