package BFS;

import java.util.LinkedList;
import java.util.Queue;

import BinaryTree.TreeNode;

public class MinimumHeightOfBinaryTree {

	public int minDepth(TreeNode root) {

		int height = 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (root == null)
			return 0;

		else {
			queue.add(root);
			height++;
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				TreeNode t = queue.poll();
			
			}
			
			height++;
		}
		return height;
	}

}
