package BinaryTree;

public class SumOfLeftLeaves {

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;

		return sumOfLeftLeavesRecursive(root);

	}

	private int sumOfLeftLeavesRecursive(TreeNode root) {

		if (root == null) {
			return 0;
		} else if (root.left != null && root.left.left == null && root.left.right == null) {
			return root.left.val + sumOfLeftLeavesRecursive(root.right);
		} else {
			return sumOfLeftLeavesRecursive(root.left) + sumOfLeftLeavesRecursive(root.right);
		}

	}

}
