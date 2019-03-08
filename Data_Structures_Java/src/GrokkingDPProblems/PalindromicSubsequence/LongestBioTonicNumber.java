package GrokkingDPProblems.PalindromicSubsequence;

public class LongestBioTonicNumber {

	public static void main(String[] args) {
		int[] num = { 4, 2, 5, 9, 7, 6, 10, 3, 1 };

		System.out.println(" Longest Biotonic " + longestBitonicNo(num, 0));

	}

	public static int longestBitonicNo(int[] num, int i1) {

		if (i1 == num.length) {
			return 0;

		}

		int backLength = 0;
		int tempBack = i1;
		while (tempBack > 0) {
			if (num[tempBack - 1] < num[tempBack])
				backLength++;
			tempBack--;
		}
		int forwardLength = 0;
		int tempforward = i1;
		while (tempforward < num.length - 1) {
			if (num[tempforward + 1] < num[tempforward])
				forwardLength++;
			tempforward++;
		}

		int length1 = backLength + forwardLength + 1;
		int length2 = longestBitonicNo(num, i1 + 1);

		return Math.max(length2, length1);

	}

}
