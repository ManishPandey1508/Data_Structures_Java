package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

public class WordLadder {

	public static void main(String[] args) {

		List<String> list = new ArrayList();

		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");
		System.out.println(ladderLength("hit", "cog", list));

	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		// A Map to store all immediate word and all words in word list which can be
		// made using this intermediate words

		Map<String, List<String>> allIntermediateWords = new HashMap<>();

		int L = beginWord.length();

		for (String word : wordList) {

			for (int i = 0; i < L; i++) {

				String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);

				List<String> words = allIntermediateWords.getOrDefault(newWord, new ArrayList<String>());
				words.add(word);
				allIntermediateWords.put(newWord, words);
			}

		}

		// Make one queue for BFS and add Pair(Word,Level) in to it
		Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();

		// a list to keep track if word is visited or not

		List<String> visited = new ArrayList<>();

		queue.add(new Pair(beginWord, 1));

		visited.add(beginWord);

		while (!queue.isEmpty()) {

			Pair p = queue.remove();

			String word = (String) p.getKey();
			int level = (int) p.getValue();

			if (word.equals(endWord))
				return level;

			for (int i = 0; i < L; i++) {

				String temp = word.substring(0, i) + "*" + word.substring(i + 1, L);

				List<String> nodes = allIntermediateWords.getOrDefault(temp, new ArrayList<String>());

				for (String node : nodes) {

					if (!visited.contains(node)) {
						level = level + 1;
						queue.add(new Pair(node, level));
						visited.add(node);
					}
				}

			}

		}

		return 0;

	}
}
