package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
	
		List<String> list = new ArrayList();
		
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");
		System.out.println(ladderLength("hit","cog",list ));
		
	}
	
	
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		 // Use queue to help BFS
		  Queue<String> queue = new LinkedList<String>();
		  queue.add(beginWord);
		  queue.add(null);
		  
		  // Mark visited word
		  Set<String> visited = new HashSet<String>();
		  visited.add(beginWord);
		  
		  int level = 1;
		  
		  while (!queue.isEmpty()) {
		    String str = queue.poll();
		    
		    if (str != null) {
		      // Modify str's each character (so word distance is 1)
		      for (int i = 0; i < str.length(); i++) {
		        char[] chars = str.toCharArray();
		        
		        for (char c = 'a'; c <= 'z'; c++) {
		          chars[i] = c;
		          
		          String word = new String(chars);
		          
		          // Found the end word
		          if (word.equals(endWord)) return level + 1;
		          
		          // Put it to the queue
		          if (wordList.contains(word) && !visited.contains(word)) {
		            queue.add(word);
		            visited.add(word);
		          }
		        }
		      }
		    } else {
		      level++;
		      
		      if (!queue.isEmpty()) { 
		        queue.add(null);
		      }
		    }
		  }
		  
		  return 0;
	}
}
