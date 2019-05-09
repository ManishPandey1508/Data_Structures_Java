package Design;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

import BinaryTree.TreeNode;

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
		serializeHelper(root, sb);
		System.out.println(sb.toString());
		return sb.toString();

	}

	public void serializeHelper(TreeNode root, StringBuilder sb) {
		if (root == null)
			sb.append(NN).append(splitter);
		else {
			sb.append(root.val+"").append(splitter);
			serializeHelper(root.left, sb);
			serializeHelper(root.right, sb);
		}
		
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		Deque<String> dq = new LinkedList<>();
		dq.addAll(Arrays.asList(data.split(splitter)));

		TreeNode root = deserialize(dq);
		return root;

	}

	public TreeNode deserialize(Deque<String> dq) {
		TreeNode root;
		String str = dq.remove();
		if (str.equals(NN)) {
			return null;
		} else {
			root = new TreeNode(Integer.parseInt(str));
			root.left = deserialize(dq);
			root.right = deserialize(dq);
			return root;
		}

		
	}
}
