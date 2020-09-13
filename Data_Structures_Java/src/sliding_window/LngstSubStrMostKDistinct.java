package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LngstSubStrMostKDistinct {
	 
	public static void main(String[] args) {
		
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
		
	}
	
	
	
	 public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		    
	        int windowStart = 0 ;
	        int windowEnd = 0;
	        int maxLength = Integer.MIN_VALUE;        
	        Map<Character,Integer> map = new HashMap<>();
	        
	        while(windowEnd < s.length()){
	            
	            char c = s.charAt(windowEnd);
	            
	           
	            if(!map.containsKey(c)){
	                map.put(c,1);
	            }
	            else{
	                map.put(c,map.get(c)+1);
	            }
	           
	            while(map.size() > k){
	           
	                maxLength = Math.max(maxLength,windowEnd - windowStart );
	                char start = s.charAt(windowStart);
	            
	                int frq = map.get(start);
	                
	                if(frq==1){
	                    map.remove(start);
	                    
	                }else{
	                    map.put(start,frq-1);
	                }
	                
	                windowStart++;    
	           }
	            
	            windowEnd++;
	        }
	           
	        return maxLength;
	        
	    }
}
