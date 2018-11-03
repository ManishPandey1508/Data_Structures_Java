package BinaryTree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.*/

public class SerializeDesializeBinaryTree {

	private String NN = "null";
	private String splitter = ",";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();

	}

	private void buildString(TreeNode root, StringBuilder sb) {

		if (root == null) {
			sb.append(NN).append(splitter);
		} else {
			sb.append(root.val).append(splitter);
			buildString(root.left, sb);
			buildString(root.right, sb);
		}

	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Deque<String> queue = new LinkedList<>();
		queue.addAll(Arrays.asList(data.split(splitter)));		
		TreeNode root  = makeTreeFromString(queue);
		return root;
	}

	private TreeNode makeTreeFromString(Deque<String> queue) {
	
		String s = queue.remove();
		if(s.equals(NN))
		return null;
		else{
			TreeNode root = new TreeNode(Integer.parseInt(s));
			root.left = makeTreeFromString(queue);					
			root.right = makeTreeFromString(queue);
			return root;
		}
		
	}

}
