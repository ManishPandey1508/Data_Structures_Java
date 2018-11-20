package Strings;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestStrWithoutRepeatingChar {

	public static void main(String[] args) {
		
		String a = "abcabcdefgabcd";
		
		System.out.println("Length is "+ lengthOfLongestSubstring(a));
	}
	
	
	 public static int lengthOfLongestSubstring(String s) {
		 
		 if(s==null || s.length()==0)
			 return 0;
		 if(s.length()==1)
			 return 1;
		 
		 Map<Character,Integer> map = new HashMap<>();
		 int max = Integer.MIN_VALUE;
		 
		 
		 // now use two variable to find unique char length, to track if char is repated or not use map.
		 for(int i =0,j=0;i < s.length();i++ ) {
		
			 if(map.containsKey(s.charAt(i))) {
				 j=Math.max(j, map.get(s.charAt(i))+1);
			 }
			 map.put(s.charAt(i), i);
			 max = Math.max(max, i-j+1);
		
			 
		 }
		 
		 return max;
		 
		 
		 
		 
		 
		 
	 }
	
}
