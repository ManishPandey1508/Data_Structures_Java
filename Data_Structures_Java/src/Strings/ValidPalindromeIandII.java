package Strings;

/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false*/
public class ValidPalindromeIandII {

	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";
		System.out.println("String " + s + " is valid Palindrome ?? " + isPalindrome(s));
		System.out.println("String " + s + " is valid Palindrome ?? " + isPalindromeNew(s));

		System.out.println("Valid Palindrome 2 " + validPalindrome("abca"));

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

	public static boolean isPalindromeNew(String s) {

		s = s.trim();
		s = s.toLowerCase();

		String alphanumeric = "0123456789abcdefghijklmnopqrstuvwxyz";
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			char front = s.charAt(i);
			while (!alphanumeric.contains(front + "")) {
				i++;
				front = s.charAt(i);
			}

			char back = s.charAt(j);
			while (!alphanumeric.contains(back + "")) {
				j--;
				back = s.charAt(j);
			}

			if (front != back)
				return false;

			i++;
			j--;
		}

		return true;
	}

	public static boolean validPalindrome(String s) {

		if (s == null || s.length() == 0)
			return true;

		return validPalindrome(s, 0, s.length() - 1,0);

	}
	public  static boolean validPalindrome(String s, int i, int j,int count) {

		if(count>1)
            return false;
		if (i > j )
			return true;
		else if (i == j )
			return true;
      
		else if (s.charAt(i) == s.charAt(j))
			return validPalindrome(s, i + 1, j - 1, count);
		else {

			boolean temp1 = validPalindrome(s, i + 1, j,count+1);
            
           if(temp1)
               return temp1;
            
            else return validPalindrome(s, i, j - 1,count+1);
			
		}

	}
}
