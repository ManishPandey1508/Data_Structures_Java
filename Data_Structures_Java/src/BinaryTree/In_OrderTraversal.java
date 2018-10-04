package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
 Inorder (Left, Root, Right) 
*/

public class In_OrderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		list.addAll(inorderTraversal(root.left));
		list.add(root.val);
		list.addAll(inorderTraversal(root.right));

		return list;

	}

	public List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return list;
		TreeNode curr = root;

		// Loop till stack is empty or we visited all nodes

		while (curr != null || !stack.isEmpty()) {
			// go left till possible and add left to stack
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			// add left most to list

			curr = stack.pop();
			list.add(curr.val);
			// go right
			curr = curr.right;

		}
		return list;
	}

}
