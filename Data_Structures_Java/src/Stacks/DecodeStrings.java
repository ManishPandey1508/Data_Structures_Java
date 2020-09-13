package Stacks;

import java.util.Stack;

public class DecodeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "3[a2[c]]";
		System.out.println("Decoded String  " + decodeString(s));
	}

	public static String decodeString(String s) {
	
		Stack<Integer> freqStack = new Stack<Integer>();
		Stack<String> resStack = new Stack<>();
		
		int idx =0;
		String res = "";
		
		while(idx < s.length()) {

			char c = s.charAt(idx);
			if(Character.isDigit(c)) {
				
				int freq = Integer.parseInt(c+"");
				freqStack.push(freq);
				idx++;
			}
			else if(c=='['){
				
				resStack.push(res);
				res ="";
				idx++;
			}
			else if(c==']') {
				
				StringBuilder temp = new StringBuilder(resStack.pop());
				int freq = freqStack.pop();
				for (int i = 0; i < freq; i++) {
					temp.append(res);
				}
				res = temp.toString();
				idx++;
			}else {
				res+=c;
				idx++;
				
			}
			
		}
		return res;
	}

}
