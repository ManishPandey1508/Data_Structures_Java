package Stacks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s ="()[]{";
		
		System.out.println("Is Valid Parentheses  "+ isValid(s));
	}
	
	
	
	public static boolean isValid(String s) {

		if(s.isEmpty()||s.length()%2!=0)
			return false;
		
		
		HashMap<Character, Character> map = new HashMap<>();

		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');

		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (map.keySet().contains(c)) {
				if (!stack.pop().equals(map.get(c))) {
					return false;
				}

			}
			else {
				stack.push(c);
			}
		}

		if(!stack.isEmpty())
			return false;
		
		return true;
	}

}
