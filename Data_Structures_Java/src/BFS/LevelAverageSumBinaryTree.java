package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.TreeNode;

public class LevelAverageSumBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {

		List<Double> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		while (!queue.isEmpty()) {

			int size = queue.size();
			int sum = 0;
			for (int i = 0; i < size; i++) {

				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);

			}
			result.add(sum / size + 0.0);

		}

		return result;

	}

}
