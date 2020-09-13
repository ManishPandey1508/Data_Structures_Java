package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.TreeNode;

public class LevelOrderTraversal {

	public static void main(String[] args) {

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {

		// Preparing list of list for result
		List<List<Integer>> result = new ArrayList<>();

		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		// add root to Queue
		queue.offer(root);

		// process queue till it gets empty
		while (!queue.isEmpty()) {
			// find the size of current level
			int size = queue.size();
			// Make List for current level
			List<Integer> currentLevel = new ArrayList<Integer>();

			// process all element of current level and add to the queue 
			for (int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				currentLevel.add(current.val);
				if (current.left != null)
					queue.offer(current.left);
				if (current.right != null)
					queue.add(current.right);

			}

			result.add(currentLevel);
		}
		return result;
	}

}
