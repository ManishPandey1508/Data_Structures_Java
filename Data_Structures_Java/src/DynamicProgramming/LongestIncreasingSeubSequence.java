package DynamicProgramming;

public class LongestIncreasingSeubSequence {

	public static void main(String[] args) {
		
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is "
                           + lis(arr));
		
		
	}
	
	static int lis(int[] x) {
		
		int[] result = new int[x.length];
		
		// Initialize the result array with 1
		 for ( int i = 0; i < result.length; i++ )
             result[i] = 1;

		
		for(int i =1;i< x.length;i++) {
			
			for(int j =0; j<i;j++ ) {
				
				if(x[i] > x[j] && result[i] < result[j] +1) {
					
					result[i] = result[j]+1;
				}
				
			}
			
		}
		int max= Integer.MIN_VALUE;
		for (int i = 0; i < result.length; i++) {
			max = Math.max(max, result[i]);
		}
		
	return max;	
	}
	
	
	

}
