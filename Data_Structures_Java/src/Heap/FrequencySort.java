package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

	public static String frequencySort(String s) {

		// create a map of frequency
		char[] chars = s.toCharArray();

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < chars.length; i++) {

			if (map.containsKey(chars[i])) {

				map.put(chars[i], map.get(chars[i]) + 1);

			} else {

				map.put(chars[i], 1);

			}

		}

		// loop through map, get key value , create Freq class and add this class in Max
		// Priority Queue
		// Priority Queue Compare method should compare two Freq objects using frequency
		 PriorityQueue<Freq> pq = new PriorityQueue<Freq>(new Comparator<Freq>(){
		        
	    	  public int compare(Freq f1, Freq f2){
	              return f2.freq - f1.freq;
	          }
	      });

		for (char c : map.keySet()) {
			pq.offer(new FrequencySort().new Freq(c, map.get(c)));
		}

		StringBuilder sb = new StringBuilder();

		while (!pq.isEmpty()) {

			Freq fq = pq.poll();
			for (int i = 0; i < fq.freq; i++) {
				sb.append(fq.c);
			}
		}

		return sb.toString();
	}

	// CLass to be used in Priority Queue Comporator
	class Freq {

		char c;
		int freq;

		public Freq(char c, int freq) {
			this.c = c;
			this.freq = freq;
		}
	}

}
