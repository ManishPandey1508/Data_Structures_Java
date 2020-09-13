package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutation_in_String {

	public static void main(String[] args) {

		System.out.println(findAnagrams("cbaebabacd", "abc"));

	}

	 public static List<Integer> findAnagrams(String s, String p) {
	        
	        List<Integer> result = new ArrayList<>();
	        
	        int winStart = 0;
	        int matched = 0;
	        Map<Character,Integer> map = new HashMap<>();
	        
	        for(char c: p.toCharArray()){
	            map.put(c,map.getOrDefault(c,0)+1);
	        }
	        
	        
	        for(int winEnd = 0; winEnd < s.length();winEnd++ ){
	             char c = s.charAt(winEnd);
	            if(map.containsKey(c)){  
	               map.put(c,map.get(c)-1);    
	                if(map.get(c)==0){
	                    matched++;
	                    System.out.println(" Matched at End "+ matched);
	                }
	            }
	             if(matched==map.size()){
	                    
	                    result.add(winStart);
	                }
	           // Process Wind End
	            
	            if(winEnd-winStart+1 >= p.length()){
	                
	                char start = s.charAt(winStart);
	                 System.out.println(" Window Start  "+ winStart);
	                winStart++;
	                
	               if(map.containsKey(start)){
	                    if(map.get(start)==0)
	                        matched--;   
	                System.out.println(" Matched at Start "+ matched);
	                  map.put(start,map.get(start)+1);
	            }               
	        }
	            
	    }
	 return result;
	}
}
