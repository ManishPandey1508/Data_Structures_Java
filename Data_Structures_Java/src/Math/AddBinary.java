package Math;

/*Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"*/

public class AddBinary {

	public static void main(String[] args) {
		System.out.println("Result   " + addBinary("11", "10"));
		// "010101010"
	}

	public static String addBinary(String a, String b) {

		StringBuilder res = new StringBuilder();
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		while (i >= 0 || j >= 0) {
			int sum = 0;
			if (i >= 0) {
				sum += a.charAt(i--) - '0';
			}
			if (j >= 0) {
				sum += b.charAt(j--) - '0';
			}
			sum = sum + carry;

			res.insert(0, sum % 2);
			carry = sum / 2;

		}
		if(carry!=0)
			res.insert(0, carry);
			
		return res.toString();
	}

}
