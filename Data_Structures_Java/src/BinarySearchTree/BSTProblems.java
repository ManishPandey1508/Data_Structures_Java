package BinarySearchTree;

import java.util.ArrayList;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class BSTProblems {

	void inOrder(Node root) {
		if (root == null)
			return;

		if (root.left != null)
			inOrder(root.left);

		System.out.print(root.data + " ");

		if (root.right != null)
			inOrder(root.right);
	}

	void preOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");

		if (root.left != null)
			preOrder(root.left);

		if (root.right != null)
			preOrder(root.right);
	}

	public static ArrayList<Node> constructAllPossibleBSTs(int start, int end) {
		ArrayList<Node> arr = new ArrayList<Node>();

		if (start > end) {
			arr.add(null);
			return arr;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<Node> leftSubTree = constructAllPossibleBSTs(start, i - 1);
			ArrayList<Node> rightSubTree = constructAllPossibleBSTs(i + 1, end);

			for (int j = 0; j < leftSubTree.size(); j++) {
				Node left = leftSubTree.get(j);
				for (int k = 0; k < rightSubTree.size(); k++) {
					Node right = rightSubTree.get(k);
					Node root = new Node(i);
					root.left = left;
					root.right = right;
					arr.add(root);
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		ArrayList<Node> arr = constructAllPossibleBSTs(1, 3);
		BSTProblems bstProbs = new BSTProblems();
		for (int i = 0; i < arr.size(); i++) {
			System.out.println("inOrder");
			bstProbs.inOrder(arr.get(i));
			System.out.println();

			System.out.println("preOrder");
			bstProbs.preOrder(arr.get(i));
			System.out.println("\n");
		}
	}

}
