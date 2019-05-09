package Strings;

public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(4));

	}

	public static String countAndSay(int n) {

		String str = "1";

		if(n==1)
			return str;
		if(n<1)
			return null;
		
		// calculate for every number
		// Start from 2 as we already know for 1

		for (int i = 2; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < str.length(); j++) {

				// if we found a new character
				char c = str.charAt(j);
				int freq = 1;
				while (j<str.length()-1 && str.charAt(j) == str.charAt(j + 1)) {
					j++;
					freq++;
				}
				sb.append(freq + "");
				sb.append(c + "");
			}
			str = sb.toString();
		}

		
		return str;
	}
}