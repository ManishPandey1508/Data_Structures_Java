package BinarySearchTree;

import BinaryTree.TreeNode;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {

		return helper(root, null, null);
	}

	private boolean helper(TreeNode root, Integer min, Integer max) {

		if (root == null)
			return true;

		else if ((min != null && root.val <= min) || (max != null && root.val >= max))
			return false;
		else
			return helper(root.left, min, root.val) && helper(root.right, root.val, max);

	}

}
