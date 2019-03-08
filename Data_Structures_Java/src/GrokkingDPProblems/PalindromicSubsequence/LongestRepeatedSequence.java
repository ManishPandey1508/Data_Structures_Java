package GrokkingDPProblems.PalindromicSubsequence;

public class LongestRepeatedSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" LRS " + LRS("aabdbcec", 0, 0));
	}

	public static int LRS(String str, int i1, int i2) {

		if (i1 >= str.length() || i2 >= str.length())
			return 0;

		int len1 = Integer.MIN_VALUE;

		if (i1 != i2 && str.charAt(i1) == str.charAt(i2)) {
			len1 = 1 + LRS(str, i1 + 1, i2 + 1);
		}
		int len2 = LRS(str, i1 + 1, i2);
		int len3 = LRS(str, i1, i2 + 1);

		return Math.max(len1, Math.max(len2, len3));

	}
}
