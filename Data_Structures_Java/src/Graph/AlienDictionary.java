package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/*There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
] 

Output: "" 

Explanation: The order is invalid, so return "".*/
public class AlienDictionary {
	
	
	public static void main(String[] args) {
		
		String[] arr = {
				 "wrt",
				  "wrf",
				  "er",
				  "ett",
				  "rftt"
		};
		
		System.out.println("Answer : " + new AlienDictionary().alienOrder(arr));
		
	}
	

	Graph<Character> graph = new Graph<Character>(true);

	public String alienOrder(String[] words) {

		// Make Graph first
		for (String str : words) {

			for (int i = 0; i < str.length() - 1; i++) {

				graph.addEdge(str.charAt(i), str.charAt(i + 1));
			}

		}

		Set<Character> visited = new HashSet<>();
		Stack<Character> stack = new Stack<>();

		for (Vertex<Character> v : graph.getAllVertex()) {

			if (visited.contains(v.getData())) {
				continue;
			}
			topSortHelper(stack, visited, v);

		}
		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.toString();
	}

	public void topSortHelper(Stack<Character> stack, Set<Character> visited, Vertex<Character> v) {
		visited.add(v.getData());
		
		for (Vertex<Character> vr : v.getAdjacentVertexes()) {

			if (visited.contains(vr.getData())) {
				continue;
			}
			topSortHelper(stack,visited,vr);
		}
		stack.push(v.getData());
	}

}
