package BinaryTree;

public class TreeSymmetric {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(1);
		left.left = new TreeNode(2);
		left.right = new TreeNode(2);
		left.left.left = new TreeNode(3);
		left.left.right =  new TreeNode(4);
		
		left.right.left = new TreeNode(4);
		left.right.right =  new TreeNode(3);
		
		
		System.out.println("Is Tree Symmetric "+ isSymmetric(left));
	}

	public static boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;
		else
			return isSymmetricHelper(root.left, root.right);

	}

	public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {

		if (left == null || right == null)
			return left == right;
		
		if(left.val!=right.val)return false;
		
		return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);


	}

}
