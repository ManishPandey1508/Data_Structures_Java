package BinarySearchTree;

import java.util.Stack;

import BinaryTree.TreeNode;

/*Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.*/

public class BST_Iterator_Next_Smallest {

	TreeNode root;
	Stack<TreeNode> stack = new Stack<>();

	public void BSTIterator(TreeNode root) {
		TreeNode curr = root;
		// Go towards left to store all left element in stack same like we do for in
		// order traversal

		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}

	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {

		TreeNode node = stack.pop();
		TreeNode curr = node;
		while (curr != null) {
			curr= curr.right;
			while(curr!=null) {
				stack.push(curr);
				curr = curr.left;
			}
			
		}
		return node.val;

	}
}
