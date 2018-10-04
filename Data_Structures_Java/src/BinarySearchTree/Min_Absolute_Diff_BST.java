package BinarySearchTree;

import BinaryTree.TreeNode;

/*Basically, its an InOrder Traversal.. keep track of previous element and track Minimum difference through a class level variable.*/

public class Min_Absolute_Diff_BST {

	private int min_diff = Integer.MAX_VALUE;
	TreeNode prev = null;

	public int getMinimumDifference(TreeNode root) {

		inOrder(root);
		return min_diff;
	}

	private void inOrder(TreeNode root) {
		// base COndition
		if (root == null)
			return;
		// Find min_diff from left
		getMinimumDifference(root.left);
		if (prev != null)
			min_diff = Math.min(min_diff, Math.abs(prev.val - root.val));
		prev = root;
		getMinimumDifference(root.right);

	}

}
