package BinaryTree;

import util.ArrayUtil;

public class ConstructBinaryTree4mInOrderAndPreOrder {

	 int preIndex = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		int inStartIndex = 0;
		int inEndIndex = inorder.length - 1;

		TreeNode tNode = constructTree(inorder, preorder, inStartIndex, inEndIndex);

		return tNode;
	}

	public TreeNode constructTree(int[] inorder, int[] preorder, int inStartIndex, int inEndIndex) {
		// Terminating Condition
		if (inStartIndex > inEndIndex)
			return null;

		// Create root of the tree
		TreeNode tNode = new TreeNode(preorder[preIndex++]);

		// if inStartIndex and inEndIndex are same means all nodes are created
		if (inStartIndex == inEndIndex)
			return tNode;

		// find index in InOrder
		int index = search(inorder, inStartIndex, inEndIndex, tNode.val);
	

		tNode.left = constructTree(inorder, preorder, inStartIndex, index - 1);
		tNode.right = constructTree(inorder, preorder, index + 1, inEndIndex);

		return tNode;

	}

	public int search(int[] inorder, int inStartIndex, int inEndIndex, int val) {
		int i;
		for (i = inStartIndex; i <=inEndIndex; i++) {
			if (inorder[i] == val)
				return i;
		}
		return i;

	}

}
