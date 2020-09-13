package PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {

	static class Element implements Comparable<Element> {
		int key;
		int val;

		public Element(int k, int v) {
			key = k;
			val = v;
		}

		@Override
		public int compareTo(Element o) {

			if (this.val > o.val)
				return -1;
			else if (this.val < o.val)
				return 1;
			else
				return 0;

		}

	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 4, x = 3;

		List<Integer> res = findClosestElements(arr, k, x);

		for (Integer i : res) {

			System.out.println(i);

		}

	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {

		PriorityQueue<Element> pq = new PriorityQueue<Element>(k);

		for (int i = 0; i < arr.length; i++) {

			Element temp = new Element(arr[i], Math.abs(arr[i] - x));

			if (pq.size() > k) {
				pq.offer(temp);
				pq.poll();
			} else
				pq.offer(temp);

		}

		if (pq.size() > k)
			pq.poll();
		List<Integer> result = new ArrayList<>();
		while (!pq.isEmpty()) {
			Element e = pq.poll();
			result.add(e.key);

		}

		return result;
	}

}
