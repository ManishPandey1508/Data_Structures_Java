package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatedCharacters {

	
	  public int lengthOfLongestSubstring(String s) {
	       
	        if(s==null || s.length()==0){
	            return 0;
	        }
	        
	        int max=0;
	        Map<Character,Integer> map = new HashMap<>();
	        
	        for(int i=0,j=0; i< s.length();i++){
	           
	            char c = s.charAt(i);
	            if(map.containsKey(c)){
	                
	                j = Math.max(j, map.get(c)+1);
	            }
	            map.put(c,i);
	            max = Math.max(max,i+1-j);    
	        }
	        
	        
	        return max;
	    }
	
	
}
