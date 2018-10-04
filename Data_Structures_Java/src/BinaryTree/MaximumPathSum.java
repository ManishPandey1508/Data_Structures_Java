/*Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42*/

package BinaryTree;

public class MaximumPathSum {

	// Using a class so that can be used in recursion. 
	class Res {
		int num;
	}

	public int maxPathSum(TreeNode root) {
		
		if(root ==null)
			return 0;
		Res res = new Res();
		res.num=Integer.MIN_VALUE;
		helper(root,res);
		
		return res.num;
	}

	private int helper(TreeNode root, Res res) {
		
		//Base condition
		if(root ==null)
			return 0;
		
		// left and right store maximum path sum going through left and
        // right child of root respectively
		int left = helper(root.left, res);
		int right = helper(root.right, res);
		
		
		// Max path for parent call of root. This path must
        // include at-most one child of root
		int max_Single = Math.max(Math.max(left, right)+root.val, root.val);
		
		 // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
		int max_top = Math.max(max_Single, left+right+root.val);
		 // Store the Maximum Result.
		res.num = Math.max(max_top, res.num);
		
		return max_Single;
	}

}
