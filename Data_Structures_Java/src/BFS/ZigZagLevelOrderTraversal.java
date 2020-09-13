package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.TreeNode;

public class ZigZagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();

		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		boolean isleftFirst = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currentLevel = new ArrayList<Integer>();

			for (int i = 0; i < size; i++) {
				TreeNode t = queue.poll();
				if (isleftFirst)
					currentLevel.add(0, t.val);
				else
					currentLevel.add(t.val);
				if (t.left != null)
					queue.add(t.left);
				if (t.right != null)
					queue.add(t.right);

			}
			result.add(currentLevel);
			isleftFirst = !isleftFirst;
		}
		return result;
	}
}
