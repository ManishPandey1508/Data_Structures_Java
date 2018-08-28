package BinaryTree;

import java.util.Stack;

public class IsTwoTreeSimilar {
	public static void main(String[] args) {

		TreeNode left = new TreeNode(1);
		left.left = new TreeNode(2);
		left.right = new TreeNode(3);
		left.left.left = new TreeNode(4);
		left.left.right = new TreeNode(5);

		left.right.left = new TreeNode(6);
		left.right.right = new TreeNode(7);

		TreeNode right = new TreeNode(1);
		right.left = new TreeNode(2);
		right.right = new TreeNode(3);
		right.left.left = new TreeNode(4);
		right.left.right = new TreeNode(5);

		right.right.left = new TreeNode(6);
		right.right.right = new TreeNode(8);

		System.out.println("Both Tree Symmetric :- " + isTreeSymmetric(left, right));

	}

	// Recursive Solution
	public static boolean isTreeSymmetric(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null)
			return true;
		else if (node1 == null || node2 == null)
			return false;
		else if (node1.val != node2.val)
			return false;
		else
			return isTreeSymmetric(node1.left, node2.left) && isTreeSymmetric(node1.right, node2.right);
	}
	
}
