/*Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1
*/

package linklists;

public class ImplementstrStr {

	public static void main(String[] args) {
	
		String haystack = "mississipi"; 
				
		String needle="issipi";
		System.out.println("Index  "+ strStr(haystack,needle));
		

	}

	public static int strStr(String haystack, String needle) { 
		if(needle==null || needle=="")
			return 0;
		if(needle.length() > haystack.length())
			return -1;
		
		char[] needl = needle.toCharArray();
		if(needle.length() ==0)
            return 0;
		for(int i=0;i<haystack.length();i++) {
		char c = haystack.charAt(i);
			if(c==needl[0]) {
				int k = i;
				boolean isMatch =false;
				for (int j = 0; j < needl.length; j++) {
					if( k < haystack.length() && haystack.charAt(k)==needl[j]) {
						k++;
					}
				}
				if(k-i == needl.length)
				{
					k=-999;
					return i;
				}
			}
		}
		return -1;
		
		
		
    }
	
	
}
