package GrokkingDPProblems.PalindromicSubsequence;

public class MinimumDeletion {

	public static void main(String[] args) {

		int[] num = {3,2,1,0};
		
		System.out.println("Min Deletion "+ minDeletion(num, 0, -1));
		
	}

	public static int minDeletion(int[] num, int currentIndex,int preIndex) {

		if (currentIndex >= num.length)
			return 0;
		
		int len1 = Integer.MAX_VALUE;
		int len2 = Integer.MAX_VALUE;
		
		if (preIndex== -1 || num[currentIndex] > num[preIndex]) {

		len1 = minDeletion(num,currentIndex+1,currentIndex);
			
		}
		
		len2 =1+ minDeletion(num, currentIndex+1, preIndex); 
		
		return Math.min(len1, len2);

	}

}
