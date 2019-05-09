package Math;

/*Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"*/

public class IntegerToEnglish {

	public static void main(String[] args) {

		int num = 12345;

		System.out.println(new IntegerToEnglish().numberToWords(num));

	}

	public String numberToWords(int num) {

		if (num == 0) {

			return "Zero";

		}
		return helper(num);

	}

	public String helper(int num) {

		String[] words = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight","Nine", "Ten", "Eleven",
				"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen", "Twenty",
				"Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty" };
		StringBuilder result = new StringBuilder();

		if (num >= 1000000000) {
			result.append(helper(num / 1000000000)).append(" Billion ");
			num = num % 1000000000;
		}
		if (num >= 1000000) {
			result.append(helper(num/1000000)).append(" Million ");
			num = num % 1000000;
		}
		if(num >=1000) {
			result.append(helper(num/1000)).append(" Thousand ");
			num = num %1000;
		}
		if(num >= 100) {
			result.append(helper(num/100)).append(" Hundred ");
			num = num%100;
		}
		if(num > 20) {
			int p = (num-20) / 10 +20;
			result.append(""+ words[p]);
			num = num%10;
		}
		if(num>0)
		{
			result.append(" "+ words[num]);
		}

		
		return result.toString();
	}

}
