package GrokkingDPProblems.PalindromicSubsequence;

public class PalindromePatitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "cddpd";

		System.out.println(" Minimum Partition Required " + publicPartitioning(str, 0, str.length() - 1));

	}

	public static int publicPartitioning(String str, int start, int end) {

		// check base conditions
		if (start > end || isPalindrome(str, start, end))
			return 0;

		int minCutRequired = end - start;

		for (int i = start; i <= end; i++) {

			if (isPalindrome(str, start, i)) {

				minCutRequired = Math.min(minCutRequired, 1 + publicPartitioning(str, i + 1, end));
			}

		}

		return minCutRequired;
	}

	public static boolean isPalindrome(String str, int start, int end) {
		while (start <= end) {
			if (str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}

		return true;

	}

}
