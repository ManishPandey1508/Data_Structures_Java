package GrokkingDPProblems.PalindromicSubsequence;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -4, 10, 3, 7, 15 };
		System.out.println("Longest Sequence " + largestSum(nums, 0, -1));

	}

	public static int largestSum(int[] num, int currentIndex, int prevIndex) {

		if (currentIndex >= num.length)
			return 0;
		int length1 = 0;
		int length2 = 0;
		if (prevIndex == -1 || num[currentIndex] >= num[prevIndex]) {
			length1 = 1 + largestSum(num, currentIndex + 1, currentIndex);
		}
		length2 = largestSum(num, currentIndex + 1, prevIndex);

		return Math.max(length1, length2);

	}
	
	public static int largestSumTDDP(int[] num, int currentIndex, int preIndex, Integer[][] dp) {
		
		if(currentIndex >= num.length)
			return 0;
		if(dp[currentIndex][preIndex+1]!=null)
			return dp[preIndex][currentIndex];
		int c1=0;
		if(preIndex == -1 || num[currentIndex] >= num[preIndex]) {
			c1 = 1 + largestSumTDDP(num, currentIndex+1, currentIndex,dp);
		}
		
		int c2 = largestSumTDDP(num, currentIndex+1, preIndex, dp);
		
		dp[currentIndex][preIndex+1] = Math.max(c1, c2);
		
		return dp[currentIndex][preIndex+1];
		
	}
	
	

}
