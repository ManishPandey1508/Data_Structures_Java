package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3*/

public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {

		 List<String> answer = new ArrayList<String>();
		    if (root != null) helper(root,  answer,"");
		    return answer;
		
	}

	private void helper(TreeNode root, List<String> list, String path) {
		
		if(root==null)
			return;
		
		if(root.left==null && root.right==null)
			list.add(path+ root.val);
		
		if(root.left!=null) {
			helper(root.left,list,path+root.val+" -> ");
		}
		if(root.right!=null) {
			helper(root.right,list,path+root.val+" -> ");
		}
		
	}

}
