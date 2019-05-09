package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {

	public static void main(String[] args) {

		System.out.println(letterCombinations("234"));

	}

	public static List<String> letterCombinations(String digits) {
		
		List<String> result = new ArrayList<>();
		
		if(digits==null || digits.length()==0)
			return result;

		Map<Character, String> phone = new HashMap<>();

		phone.put('1', "");
		phone.put('2', "abc");
		phone.put('3', "def");
		phone.put('4', "ghi");
		phone.put('5', "jkl");
		phone.put('6', "mno");
		phone.put('7', "pqrs");
		phone.put('8', "tuv");
		phone.put('9', "wxyz");

		String str = phone.get(digits.charAt(0));

		for (char c : str.toCharArray()) {
			result.add("" + c);
		}

		for (int i = 1; i < digits.length(); i++) {

			String str1 = phone.get(digits.charAt(i));

			char[] ch = str1.toCharArray();

			List<String> tempList = new ArrayList<>();

			for (String s : result) {
				for (char c : ch)
					tempList.add(s + c);

			}
			result = tempList;

		}

		return result;
	}

	  public List<String> letterCombinations2(String digits) {
	        
	      Map<Character, String> phone = new HashMap<>();

			phone.put('1', "");
			phone.put('2', "abc");
			phone.put('3', "def");
			phone.put('4', "ghi");
			phone.put('5', "jkl");
			phone.put('6', "mno");
			phone.put('7', "pqrs");
			phone.put('8', "tuv");
			phone.put('9', "wxyz");

	        List<String> result = new ArrayList<>();
	         
	        String s = phone.get(digits.charAt(0));
	        
	        int i=0;
	        
	        while(i < s.length()){
	            result.add(s.charAt(i++)+"");
	            
	        }
	        int j =1;
	        while(j < digits.length() ){
	          
	            String str = phone.get(digits.charAt(j));
	            List<String> temp = new ArrayList<>(); 
	            for(String sa: result)
	            {            
	                for( char c: str.toCharArray())
	                {
	                    temp.add(sa+c);
	                }
	                
	                
	            }
	            result = temp;
	        }
	        
	        return result;
	        
	    }
	
}