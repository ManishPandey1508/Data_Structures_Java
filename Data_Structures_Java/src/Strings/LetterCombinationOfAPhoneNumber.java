package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {

	public static void main(String[] args) {

		System.out.println(letterCombinations("234"));
		
		
	}

	public static  List<String> letterCombinations(String digits) {

		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0)
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

		char[] initializeList = phone.get(digits.charAt(0)).toCharArray();
		// Initialize the result list with first number, characters

		for (int i = 0; i < initializeList.length; i++) {
			result.add("" + initializeList[i]);
		}

		for (int i = 1; i < digits.length(); i++) {

			char[] tempChars = phone.get(digits.charAt(i)).toCharArray();

			List<String> tempResult = new ArrayList<String>();

			for (String str : result) {

				for (Character c : tempChars) {
					tempResult.add(str + c);
				}

			}
			result = tempResult;

		}
		
		return result;
	}

}