package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
		}

		public Node(int _val, List<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	public Node cloneGraph(Node node) {

		if (node == null)
			return node;

		Queue<Node> queue = new LinkedList<>();
		Map<Integer, Node> map = new HashMap<>();
		Node newNode = new Node(node.val, new ArrayList<Node>());
		map.put(node.val, newNode);

		queue.offer(node);

		while (!queue.isEmpty()) {

			Node temp = queue.poll();

			for (Node neighbour : temp.neighbors) {

				if (!map.containsKey(neighbour.val)) {
					map.put(neighbour.val, new Node(neighbour.val, new ArrayList<Node>()));
					queue.add(neighbour);

				}
				map.get(temp.val).neighbors.add(map.get(neighbour.val));

			}

		}

		return newNode;
	}
}
