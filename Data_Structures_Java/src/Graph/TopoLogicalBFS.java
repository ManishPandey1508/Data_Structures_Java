package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopoLogicalBFS {

	public static List<Integer> topoSort(int vertices, int[][] edges) {

		// An array list which will hold the result

		List<Integer> sortedList = new ArrayList<>();
		// edge case
		if (vertices <= 0)
			return sortedList;

		// Initilization

		Map<Integer, Integer> Indegree = new HashMap<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < vertices; i++) {

			Indegree.put(i, 0);
			graph.put(i, new ArrayList<>());

		}

		// Populate indegree and graph

		for (int[] edge : edges) {

			int source = edge[0];
			int target = edge[1];

			graph.get(source).add(target);

			Indegree.put(target, Indegree.get(target) + 1);

		}
		// Queue for BFS
		Queue<Integer> source = new LinkedList<>();

		// initialize source queue with vertex(indegree value ==0)
		for (Map.Entry<Integer, Integer> entry : Indegree.entrySet()) {
			if (entry.getValue() == 0) {
				source.add(entry.getKey());
			}

		}

		// Start BFS

		while (!source.isEmpty()) {

			int current = source.poll();
			sortedList.add(current);
			List<Integer> currEdges = graph.get(current);
			for (int i : currEdges) {
				Indegree.put(i, Indegree.get(i) - 1);
				if (Indegree.get(i) == 0)
					source.offer(i);
			}

		}
		if (sortedList.size() != vertices)
			return new ArrayList<>();

		return sortedList;

	}

	public static void main(String[] args) {
		List<Integer> result = TopoLogicalBFS.topoSort(4,
		        new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		    System.out.println(result);

		    result = TopoLogicalBFS.topoSort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
		        new int[] { 2, 1 }, new int[] { 3, 1 } });
		    System.out.println(result);

		    result = TopoLogicalBFS.topoSort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
		        new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		    System.out.println(result);
	}

}
