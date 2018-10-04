package BinaryTree;

/*Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> arrayList = new ArrayList<>();
		if (root == null)
			return arrayList;
		arrayList.add(root.val);
		arrayList.addAll(preOrderIterative(root.left));
		arrayList.addAll(preOrderIterative(root.right));
		return arrayList;
	}

	/*
	 * Create an empty stack, Push root node to the stack. Do following while stack
	 * is not empty. 2.1. pop an item from the stack and print it.
	 * 
	 * 2.2. push the right child of popped item to stack.
	 * 
	 * 2.3. push the left child of popped item to stack.
	 */
	private List<Integer> preOrderIterativeUsingStack(TreeNode root) {

		List<Integer> arrayList = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return arrayList;
		stack.push(root);
		while (!stack.isEmpty()) {
			 root = stack.pop();
			arrayList.add(root.val);
			if (root.right != null)
				stack.push(root.right);
			if (root.left != null) {
				stack.push(root.left);
			}
		}

		return arrayList;
	}

	private List<Integer> preOrderIterative(TreeNode root) {
		List<Integer> arrayList = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root == null)
			return arrayList;

		// While all nodes are covered
		while (root != null) {

			arrayList.add(root.val);
			// Put right tree in stack
			if (root.right != null) {
				stack.push(root.right);
			}
			// go towards left
			root = root.left;
			// in case there is no left, go right
			if (root == null && !stack.isEmpty()) {
				root = stack.pop();
			}

		}
		return arrayList;
	}

}
