package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]*/
public class ZigZagTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> listOfList = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean order = true;
		while (queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			TreeNode temp = queue.poll();
			for (int i = 0; i < size; i++) {
				if (order)
					list.add(temp.val);
				else
					list.add(0, temp.val);

				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}

			}
			listOfList.add(list);
			size = queue.size();
			if (order)
				order = false;
			else
				order = true;

		}

		return listOfList;
	}

}
