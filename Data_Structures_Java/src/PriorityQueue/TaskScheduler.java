package PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
	
	
	public static void main(String[] args) {
		  char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
		    System.out.println("Minimum intervals needed to execute all tasks: " + leastInterval(tasks, 2));

		    tasks = new char[] { 'a', 'b', 'a' };
		    System.out.println("Minimum intervals needed to execute all tasks: " + leastInterval(tasks, 3));
		  }
	
	
	
	static class Element implements Comparable<Element> {

		char ch;
		int freq;

		public Element(char c, int f) {
			ch = c;
			freq = f;
		}

		@Override
		public int compareTo(Element o) {
			if (freq > o.freq)
				return -1;
			else if (freq < o.freq)
				return 1;
			else
				return 0;
		}
	}

	public static int leastInterval(char[] tasks, int n) {

		Map<Character, Integer> map = new HashMap<>();

		for (char c : tasks) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		PriorityQueue<Element> pq = new PriorityQueue<>();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {

			Element e = new Element(entry.getKey(), entry.getValue());
			pq.offer(e);

		}

		int result = 0;

		List<String> res = new ArrayList<>();
		Queue<Element> queue = new LinkedList<>();

		while (!pq.isEmpty() || !queue.isEmpty()) {
			if(pq.isEmpty()) {
				res.add("idle");
			}
			else {
			Element curr = pq.peek();
			if (res.size() >= n) {
				if (res.get(res.size() - n).equals(curr.ch + "")) {
					res.add("idle");
				} else {
					pq.poll();
					res.add(curr.ch + "");
					curr.freq = curr.freq - 1;
					queue.offer(curr);
				}
			} else {
				pq.poll();
				res.add(curr.ch + "");
				curr.freq = curr.freq - 1;
				queue.offer(curr);
			}
		}
		
		if (pq.isEmpty()&&res.size()>=n || queue.size() >= n) {
				Element e = queue.poll();
				if (e.freq > 0)
					pq.offer(e);
			}
			result++;

		}
		System.out.println(res);
		return result;

	}
}
