package GrokkingDPProblems.PalindromicSubsequence;

public class MinCountToMakePalindrome {

	public static void main(String[] args) {

		String str = "abbba";
		System.out.println(" The min length of char to delete " + finMinDel(str));

	}

	public static int finMinDel(String str) {

		return str.length() - findMinDeletions(str, 0, str.length() - 1);

	}

	public static int findMinDeletions(String str, int start, int end) {

		if (start > end)
			return 0;

		if (start == end)
			return 1;

		int total = 0;

		if (str.charAt(start) == str.charAt(end)) {
			total = 2 + findMinDeletions(str, start + 1, end - 1);
		} else {

			int tot1 = findMinDeletions(str, start + 1, end);
			int tot2 = findMinDeletions(str, start, end - 1);
			total = Math.max(tot1, tot2);
		}

		return total;

	}

}
