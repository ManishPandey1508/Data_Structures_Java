package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrder(TreeNode root) {

		
		Queue<TreeNode> queue = new LinkedList<>();

		List<List<Integer>> listOfList = new LinkedList<List<Integer>>();
		if (root == null)
			return listOfList;

		queue.add(root);
		
		while(!queue.isEmpty()) {
		
			int size = queue.size();
			LinkedList<Integer> level = new LinkedList<>();
			
			for(int i =0;i<size;i++) {
				TreeNode temp = queue.poll();
				
				if(temp.left!=null)queue.add(temp.left);
				
				if(temp.right!=null)queue.add(temp.right);
				
				level.add(temp.val);
				
			}
			listOfList.add(level);
			
		}
		
		return listOfList;
		
	}

}
