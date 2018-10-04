package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
             according to the LCA definition.
Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.*/

public class LowestLCABinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// Use a Map to store parents of all nodes starting from root till we find both
		// p and q
		// Use stack to traverse nodes

		if (p == root || q == root)
			return root;

		HashMap<TreeNode, TreeNode> parents = new HashMap<>();
		Stack<TreeNode> stack = new Stack<>();
		// Initialize parents and stack

		parents.put(root, null);
		stack.push(root);
		// traverse tree till both p and q parents added to Parents map

		while (!parents.containsKey(p) || !parents.containsKey(q)) {

			TreeNode node = stack.pop();
			if (node.left != null) {
				stack.push(node.left);
				parents.put(node.left, node);
			}
			if (node.right != null) {
				stack.push(node.right);
				parents.put(node.right, node);
			}
		}

		// Use a set to track P parents
		Set<TreeNode> ancestors = new HashSet<>();

		while (p != null) {
			ancestors.add(p);
			p = parents.get(p);
		}
		while (!ancestors.contains(q))
			q = parents.get(q);

		return q;

	}

}
