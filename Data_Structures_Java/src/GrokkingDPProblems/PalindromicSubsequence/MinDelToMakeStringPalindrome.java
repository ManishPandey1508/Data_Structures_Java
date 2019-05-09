package GrokkingDPProblems.PalindromicSubsequence;

public class MinDelToMakeStringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Max "+minDel("aadcaa", 0, "aadcaa".length()-1));
		
	}

	public static int minDel(String str, int start, int end) {

		if(start>end)
			return 0;
		int count1=0,count2=0,count3=0;
		
		if(str.charAt(start)==str.charAt(end))
			count1=minDel(str, start+1, end-1);
		
		count2 =minDel(str, start+1, end);
		count3 =minDel(str, start, end-1);
		
		return Math.min(count1, Math.min(count2, count3));
		
		
	}

}
