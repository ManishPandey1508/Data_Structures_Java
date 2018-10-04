package Strings;
/*Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"
Example 2:

Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"*/

public class ReverseString {

	 public String reverseString(String s) {
	    if(s=="")
	    	return "";
		 char[] chars = s.toCharArray();
		 int start =0;
	     int end =s.length()-1;
	   
	     while(start<end) {
	    	 
	    	 char temp = s.charAt(end);
	    	 chars[end] = chars[start];
	    	 chars[start]= temp;
	    	 start++;
	    	 end--;
	     }
	     
	     return String.copyValueOf(chars);
	    		 
	    	 
	     }
	     
	
}
