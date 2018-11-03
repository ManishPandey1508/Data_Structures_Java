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
		 List<Integer> list = new ArrayList<>();
		  helper(root,list);
		 return list;
	 }

	 
	 
	private void helper(TreeNode root, List<Integer> list) {
		
		if(root==null)
			return;
		list.add(root.val);
		helper(root.left, list);
		helper(root.right,list);
		
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



}
