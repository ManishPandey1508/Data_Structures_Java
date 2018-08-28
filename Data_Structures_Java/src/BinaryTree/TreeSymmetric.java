package BinaryTree;

import java.util.Stack;

public class TreeSymmetric {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(1);
		left.left = new TreeNode(2);
		left.right = new TreeNode(2);
		left.left.left = new TreeNode(3);
		left.left.right =  new TreeNode(4);
		
		left.right.left = new TreeNode(4);
		left.right.right =  new TreeNode(3);
		
		
		System.out.println("Is Tree Symmetric "+ isSymmetric(left));
	}

	public static boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;
		else
			return isSymmetricHelper(root.left, root.right);

	}

	public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {

		if (left == null || right == null)
			return left == right;
		
		if(left.val!=right.val)return false;
		
		return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);


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
