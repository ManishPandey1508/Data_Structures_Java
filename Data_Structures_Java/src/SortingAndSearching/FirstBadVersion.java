package SortingAndSearching;

class VersionControl {
	boolean isBadVersion(int version) {
		return false;
	}
}

public class FirstBadVersion extends VersionControl {

	 
	  public int firstBadVersion(int n) {
	      if(n==1)  
	         return isBadVersion(n)==true?1:-1;
	         
	        int low = 1;
	        int high =n;
	        return badVersionHelper(low,high); 
	    }
	    
	    public int badVersionHelper(int low,int high){
	       
	       int mid = low + (high-low) /2;
	       boolean bool = isBadVersion(mid);
	        
	        
	        if(low==high)
	            return low;
	        
	        if(mid==1 && bool)
	            return 1;
	        if(!bool)
	            return badVersionHelper(mid+1,high);
	        else
	           return isBadVersion(mid-1)==false?mid:badVersionHelper(low,mid-1); 
	        }

}
