package PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSortedArray {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
		int k = 2;

		System.out.println(sortKSortedArray(list, k));

	}

	private static List<Integer> sortKSortedArray(List<Integer> list, int k) {

		List<Integer> result = new ArrayList<Integer>();

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < list.size(); i++) {

			pq.add(list.get(i));
			if (pq.size() > k) {
				result.add(pq.poll());

			}
		}

		while (!pq.isEmpty()) {

			result.add(pq.poll());

		}
		return result;
	}

}
