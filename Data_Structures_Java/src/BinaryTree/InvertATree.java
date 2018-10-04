package BinaryTree;

/*Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1*/
public class InvertATree {

	public TreeNode invertTree(TreeNode root) {

		if (root == null)
			return null;

		if (root.left != null && root.right != null) {
			TreeNode temp = invertTree(root.left);
			root.left = invertTree(root.right);
			root.right = temp;
		} else if (root.left != null) {
			root.right = invertTree(root.left);
			root.left = null;
		} else if (root.right != null) {
			root.left = invertTree(root.right);
			root.right = null;
		}

		return root;

	}

}
