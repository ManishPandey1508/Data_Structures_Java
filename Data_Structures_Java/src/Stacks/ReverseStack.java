package Stacks;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);

		reverse(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

	private static void reverse(Stack<Integer> stack) {

		if (stack.isEmpty())
			return;

		if (stack.size() == 1)
			return;
		int temp = stack.pop();
		
		reverse(stack);

		insertAtLast(stack, temp);

	}

	private static void insertAtLast(Stack<Integer> stack, int key) {
		
		if(stack.isEmpty()) {
			stack.push(key);
			return;
		}
		int temp = stack.pop();
		insertAtLast(stack,key);
		stack.push(temp);
	}

	
}
