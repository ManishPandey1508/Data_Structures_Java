package GrokkingDPProblems.knapsack;

public class MinimumCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denominations = {1, 2, 3};
		int result=countChange(denominations, 5, 0);
		System.out.println(result==Integer.MAX_VALUE?-1:result);
	}

	public static int countChange(int[] denominations, int total,int index)
	{
		if(index<0|| index >= denominations.length || total < 0 || denominations.length==0) {
			return Integer.MAX_VALUE;
		}
		if(total==0)return 0;
		
		int total1=Integer.MAX_VALUE;
		
		if(denominations[index]<=total) {
			int res = countChange(denominations, total - denominations[index], index);
			if(res!=Integer.MAX_VALUE)
				total1 = res+1;
		}
		
		int total2 = countChange(denominations, total, index+1);
		
		return Math.min(total1, total2);
		
	}
	
	
}
