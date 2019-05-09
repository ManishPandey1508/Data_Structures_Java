package Stacks;

import java.util.Stack;

public class DecodeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "100[leetcode]";
		System.out.println("Decoded String  " + decodeString(s));
	}

	public static String decodeString(String s) {
		// will take two stacks, one to keep track of frequency and other to keep track
		// of the last done String

		// To Store last found frequency
		Stack<Integer> freqStack = new Stack<>();

		// To Store last found result string
		Stack<String> resultStack = new Stack<>();

		String res = "";
		StringBuilder result = new StringBuilder();

		int idx = 0;
		while (idx < s.length()) {

			if (Character.isDigit(s.charAt(idx))) {
				int freq = Integer.parseInt(s.charAt(idx++)+"");
				while (Character.isDigit(s.charAt(idx))) {
					freq = freq * 10 + Integer.parseInt(s.charAt(idx++)+"");
				}
				freqStack.push(freq);
			} else if (s.charAt(idx) == '[') {
				resultStack.push(res);
				res = "";
				idx++;

			} else if (s.charAt(idx) == ']') {
				int freq = freqStack.pop();
				StringBuilder temp = new StringBuilder(resultStack.pop());

				for (int i = 0; i < freq; i++) {
					temp.append(res);
				}
				res = temp.toString();

				idx++;
			} else {
				res += s.charAt(idx++);
			}

		}
		result.append(res);
		return result.toString();

	}

}
