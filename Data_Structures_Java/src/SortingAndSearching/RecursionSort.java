package SortingAndSearching;

public class RecursionSort {

	public static void main(String[] args) {
		
		int arr[]  = {2,3,1,21,4,9,55,3,88};
		
		int[] sorted= sortUtil(arr, arr.length);
		for (int i = 0; i < sorted.length; i++) {
			
			System.out.println(sorted[i]);
		}
	}

	  public static int[] sortUtil(int[] nums, int length){
	        
	        if(length==1)
	        {
	            int[] a= new int[1];
	            a[0] = nums[length-1];
	            return a;
	            
	        }
	        int currentElement = nums[length-1];    
	        int[] temp = sortUtil(nums,length-1);
	        int[] result = new int[length];
	        
	        int t=0;
	        int r=0;
	        boolean found = false;
	        while(t < length-1){
	            if(!found && currentElement < temp[t]){
	                result[r] = currentElement;
	                found = true;
	                r++;
	               }
	        else {
	           result[r] = temp[t];
	               r++; 
	              t++;  
	          }
	           
	        }
	        
	        if(r==length-1)
	            result[r] =currentElement;
	    
	        return result;
	   
	    }
	    
	
	
	
}



