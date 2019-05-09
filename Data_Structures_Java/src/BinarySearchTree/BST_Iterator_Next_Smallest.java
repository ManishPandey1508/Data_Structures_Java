package BinarySearchTree;

import java.util.Stack;

import BinaryTree.TreeNode;

/*Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.*/

public class BST_Iterator_Next_Smallest {

	Stack<TreeNode> stack = new Stack<>();
	TreeNode root = null;

	public  BST_Iterator_Next_Smallest(TreeNode root) {
		this.root = root;
		TreeNode current = root;
		while (current != null) {
			stack.push(current);
			current = current.left;
		}

	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode top = stack.pop();
		int rvalue = top.val;
		
		if(top.right!=null) {
			TreeNode current = top.right;
			while(current!=null) {
				stack.push(current);
				current = current.left;
			}
		}
		
		return rvalue;
	}
}
