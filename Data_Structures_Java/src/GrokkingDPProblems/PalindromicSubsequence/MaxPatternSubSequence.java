package GrokkingDPProblems.PalindromicSubsequence;

public class MaxPatternSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(" Max Pattern Match "+ MaxPatternCount("tomorrow", "tor", 0, 0));
	}

	public static int MaxPatternCount(String str,String pattern,int i1,int i2) {
		
		
		if(i1==str.length()) {
			return 0;
		}
		
		if(i2==pattern.length()) {
			return 1;
		}
	
		int count1=0,count2=0;
		
		if(str.charAt(i1)==pattern.charAt(i2))
		{
			count1= MaxPatternCount(str, pattern, i1+1, i2+1);
		}
		
			count2= MaxPatternCount(str, pattern, i1+1, i2);
				
		return count1+count2;
		
	}
	
	
}
