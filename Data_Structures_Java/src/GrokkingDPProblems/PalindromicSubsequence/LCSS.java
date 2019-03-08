package GrokkingDPProblems.PalindromicSubsequence;

public class LCSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Longest Common Sub Sequence :- " + LCSS("abdca", "cbda", 0, 0));
		System.out.println("Longest Common Sub Sequence :- " + TopDownLCCS("passport", "ppsspt", 0, 0,new Integer["passport".length()+1]["ppsspt".length()+1]));
	}

	public static int LCSS(String s1, String s2, int i1, int i2) {

		if (i1 >= s1.length() || i2 >= s2.length())
			return 0;
		int count1 = 0, count2 = 0, count3 = 0;
		if (s1.charAt(i1) == s2.charAt(i2)) {
			count1 = 1 + LCSS(s1, s2, i1 + 1, i2 + 1);
			return count1;
		} else {
			count2 = LCSS(s1, s2, i1 + 1, i2);
			count3 = LCSS(s1, s2, i1, i2 + 1);
			return Math.max(count2, count3);
		}

	}

	public static int TopDownLCCS(String s1, String s2, int i1, int i2, Integer[][] dp) {
		if (i1 >= s1.length() || i2 >= s2.length()) {
			return 0;
		}

		if(dp[i1][i2] !=null)
			return dp[i1][i2];
		
		int count1 =0;
		if(s1.charAt(i1)==s2.charAt(i2))
		{
			 count1 = 1+TopDownLCCS(s1, s2, i1+1, i2+1, dp);
			 dp[i1][i2]= count1;
			 return count1;
		}
		else {
			int count2 = TopDownLCCS(s1, s2, i1+1, i2, dp);
			int count3 = TopDownLCCS(s1, s2, i1, i2+1, dp);
			dp[i1][i2] = Math.max(count2, count3);
			return dp[i1][i2];
		}
		
		
	}

}
