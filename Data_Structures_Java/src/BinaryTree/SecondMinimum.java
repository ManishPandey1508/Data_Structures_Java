/*Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. 
 * If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
*/
package BinaryTree;

public class SecondMinimum {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);

		int val = findSecondMinimumValue(root);
		System.out.println(val);

	}

	public static int findSecondMinimumValue(TreeNode root) {

		if (root == null)
			return -1;

		if (root.left == null && root.right == null)
			return -1;

		int left = root.left.val;
		int right = root.right.val;

		if (left == root.val) {
			left = findSecondMinimumValue(root.left);
		}

		if (right == root.val) {
			right = findSecondMinimumValue(root.right);
		}

		if (left != -1 && right != -1) {
			return Math.min(left, right);
		} else if (left == -1) {
			return right;
		} else
			return left;

	}

}
