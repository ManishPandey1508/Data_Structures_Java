package Amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class WordsAndFrequency {

	public static void main(String[] args) {
		String test = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's Faviourite food";

		List<String> tets = new ArrayList<>();
		tets.add("and");
		tets.add("he");
		tets.add("the");
		tets.add("to");
		tets.add("is");

		System.out.println(retrieveMostFreqUsedWords(test, tets));
	}

	public static List<String> retrieveMostFreqUsedWords(String literatureText, List<String> wordsToExclude) {
		String letters = "abcdefghijklmnopqrstuvwxyz";

		List<String> result = new ArrayList<String>();

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < literatureText.length(); i++) {

			if (!letters.contains((literatureText.charAt(i) + "").toLowerCase()))

				literatureText = literatureText.replace(literatureText.charAt(i) + "", " ");
		}
		String[] array = literatureText.split(" ");

		for (String str : array) {
			str = str.toLowerCase();
			if (wordsToExclude.contains(str))
				continue;
			else {
				if (map.containsKey(str))
					map.put(str, map.get(str) + 1);
				else
					map.put(str, 1);
			}
		}

		PriorityQueue<Map.Entry<String, Integer>> p = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

				return o2.getValue().compareTo(o1.getValue());
			}

		});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			p.add(entry);

		}
		Map.Entry<String, Integer> entry = p.peek();
		int max = entry.getValue();
		while (!p.isEmpty()) {
			Map.Entry<String, Integer> entry1 = p.remove();
			int current = entry1.getValue();
			if (current == max)
				result.add(entry1.getKey());

		}
		return result;

	}
}
