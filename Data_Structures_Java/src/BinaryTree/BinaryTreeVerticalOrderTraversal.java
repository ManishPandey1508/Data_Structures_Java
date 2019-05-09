package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {

	class Node {

		TreeNode td;
		int hd;

		public Node(TreeNode td) {
			this.td = td;
		}

	}

	public List<List<Integer>> verticalOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();

		if (root == null)
			return result;

		Queue<Node> queue = new LinkedList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();

		Node node = new Node(root);
		node.hd = 0;
		queue.add(node);
		int minhd = Integer.MAX_VALUE;
		int maxhd = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {

			Node temp = queue.poll();
			int temphd = temp.hd;
			minhd = Math.min(temphd, minhd);
			maxhd = Math.max(temphd, maxhd);

			if (!map.containsKey(temphd)) {
				List<Integer> templist = new ArrayList<>();
				map.put(temphd, templist);
			} else {
				List<Integer> templist = map.get(temphd);
				templist.add(temp.td.val);
				map.put(temphd, templist);
			}

			if (temp.td.left != null) {
				Node nd = new Node(temp.td.left);
				nd.hd = temphd - 1;
				queue.add(nd);
			}
			if (temp.td.right != null) {
				Node nd = new Node(temp.td.right);
				nd.hd = temphd + 1;
				queue.add(nd);
			}

		}

		for (int i = minhd; i <= maxhd; i++) {
			result.add(map.get(i));
		}

		return result;
	}

}
