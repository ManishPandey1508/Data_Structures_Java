package Trie;

import java.util.HashMap;
import java.util.Map.Entry;

/*Add and Search Word - Data structure design
Go to Discuss
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true*/
class TrieNode {

	public Character c = null;
	boolean isEnd = false;

	HashMap<Character, TrieNode> childs = new HashMap<>();

}

public class WordDictionary {
	private TrieNode root = null;

	public WordDictionary() {

		this.root = new TrieNode();

	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {

		if (word == null || word.length() == 0)
			return;

		if (root == null)
			return;

		insertWordHelper(root, word, 0);

	}

	private void insertWordHelper(TrieNode node, String word, int index) {
		if (index == word.length()) {
			node.isEnd = true;
			return;
		}
		char c = word.charAt(index);

		// if node
		if (node.childs.containsKey(c)) {
			insertWordHelper(node.childs.get(c), word, index + 1);
			return;

		}

		TrieNode t = new TrieNode();
		t.c = c;
		node.childs.put(c, t);
		insertWordHelper(t, word, index + 1);

	}

	public boolean search(String word) {
		if (word == null || word.length() == 0)
			return false;

		return searchHelper(root, word, 0);

	}

	private boolean searchHelper(TrieNode node, String word, int index) {
		if (index == word.length()) {
			return node.isEnd;
		}

		char c = word.charAt(index);
		if (c == '.') {

			for (Entry<Character, TrieNode> temp : node.childs.entrySet()) {
				if (searchHelper(temp.getValue(), word, index + 1)) {
					return true;
				}
			}

		} else {
			if (node.childs.containsKey(c))
				return searchHelper(node.childs.get(c), word, index + 1);
			else
				return false;

		}

		return false;
	}

}
