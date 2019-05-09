package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> lists = groupAnagrams(strs);

		for (List<String> list : lists) {
			System.out.println(list.toString());
		}

	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> lists = new ArrayList<>();
		Map<String, List<String>> maps = new HashMap<String, List<String>>();

		if (strs == null || strs.length == 0)
			return lists;

		for (String str : strs) {
			char[] ch = str.toCharArray();

			Arrays.sort(ch);

			String key = new String(ch);
			
			System.out.println("Key::::   " + key);
			if (maps.containsKey(key)) {
				List<String> list = maps.get(key);
				list.add(str);
			
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				maps.put(key, list);
				lists.add(list);
			}
		}

		return lists;
	}

}
