package BFS;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
};

class LevelOrderSuccessor {
	public static TreeNode findSuccessor(TreeNode root, int key) {

		if (root == null)
			return null;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean isFound = false;

		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {

				TreeNode tnode = queue.poll();
				if (isFound) {
					return tnode;
				}
				if (!isFound && tnode.val == key)
					isFound = true;
				if (tnode.left != null)
					queue.offer(tnode.left);

				if (tnode.right != null)
					queue.offer(tnode.right);

			}

		}

		return null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
		if (result != null)
			System.out.println(result.val + " ");
		result = LevelOrderSuccessor.findSuccessor(root, 9);
		if (result != null)
			System.out.println(result.val + " ");
	}
}
