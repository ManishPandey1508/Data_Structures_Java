package BinarySearchTree;

import java.util.ArrayList;

import BinaryTree.TreeNode;

public class Kth_Smallest_Element_BST {


    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inOrderList = inOrderTraversal(root);
		return inOrderList.get(k-1);
    }
    
    private ArrayList<Integer> inOrderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		list.addAll(inOrderTraversal(root.left));
		list.add(root.val);
		list.addAll(inOrderTraversal(root.right));

		return list;

	
	}
}
