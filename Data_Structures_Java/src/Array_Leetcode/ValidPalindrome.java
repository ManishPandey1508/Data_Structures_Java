package Array_Leetcode;

public class ValidPalindrome {

	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";
		System.out.println("String " + s + " is valid Palindrome ?? " + isPalindrome(s));

	}

	public static boolean isPalindrome(String s) {

		if (s == null || s == "")
			return false;
		s = s.toLowerCase();
		System.out.println("New String is : " + s);
		int start = 0;
		int last = s.length() - 1;

		while (start < last) {

			while (start < last && !Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start))) {
				start++;
			}
			while (start < last && !Character.isLetter(s.charAt(last)) && !Character.isDigit(s.charAt(last))) {
				last--;
			}
			if (s.charAt(start) != s.charAt(last))
				return false;

			start++;
			last--;
		}

		return true;
	}

}
