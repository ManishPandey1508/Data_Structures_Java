package PriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

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

	public static String rearrangeString(String str) {
		Map<Character, Integer> map = new HashMap<>();

		char[] arr = str.toCharArray();
		for (char c : arr) {
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

		StringBuilder sb = new StringBuilder();
		Element prev=null;
        Element current=null;
        
		while(!pq.isEmpty()) {
			current = pq.poll(); 
            if(sb.length()!=0 && sb.charAt(sb.length()-1)==current.ch)
                return ""; 
            
             if(prev!=null && prev.freq>=1){
                pq.offer(prev);
            }
            
            sb.append(current.ch);
            current.freq = current.freq-1;
            prev = current;        			
		}
		if(prev !=null && prev.freq>0)
                return ""; 
        
		return sb.toString();
	
}

	public static void main(String[] args) {
		System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
		System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
		System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
	}
}
