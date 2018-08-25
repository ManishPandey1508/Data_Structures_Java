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
	// iterative method using Stack (DFS)

	public static boolean isTreeStmmetricDFS(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<>();

		// Initialize the stack

		if (root.left != null) {
			if (root.right == null) {
				return false;
			}
			stack.push(root.left);
			stack.push(root.right);
		} else if (root.right != null) {
			return false;
		}

		while (!stack.isEmpty()) {
			// if stack size is odd it means no symmetry

			if (stack.size() % 2 != 0)
				return false;

			TreeNode left = stack.pop();
			TreeNode right = stack.pop();

			if (left.val != right.val)
				return false;

			// push left's kids to the stack

			if (left.left != null) {
				if (right.right == null)
					return false;
				stack.push(left.left);
				stack.push(right.right);
			} else if (right.right != null) {
				return false;
			}

			// push right kids to the stack

			if (left.right != null) {
				if (right.left == null) {
					return false;
				}
				stack.push(left.right);
				stack.push(right.left);
			} else if (right.left != null) {
				return false;
			}

		}
		return true;

	}

}
