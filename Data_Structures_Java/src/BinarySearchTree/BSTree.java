package BinarySearchTree;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Node {
	Node left, right;
	int data;

	public Node() {
		left = null;
		right = null;
		data = 0;
	}

	public Node(int n) {
		left = null;
		right = null;
		data = n;
	}

	public void setLeft(Node n) {
		left = n;
	}

	public void setRight(Node n) {
		right = n;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setData(int d) {
		data = d;
	}

	public int getData() {
		return data;
	}
}

class BSTree {
	private Node root;

	public BSTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null)
			node = new Node(data);
		else {
			if (data <= node.getData())
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		return node;
	}

	public void delete(int k) {
		if (isEmpty())
			System.out.println("Tree Empty");
		else if (search(k) == false)
			System.out.println("Sorry " + k + " is not present");
		else {
			root = delete(root, k);
			System.out.println(k + " deleted from the tree");
		}
	}

	private Node delete(Node root, int k) {
		Node p, p2, n;
		if (root.getData() == k) {
			Node lt, rt;
			lt = root.getLeft();
			rt = root.getRight();
			if (lt == null && rt == null)
				return null;
			else if (lt == null) {
				p = rt;
				return p;
			} else if (rt == null) {
				p = lt;
				return p;
			} else {
				p2 = rt;
				p = rt;
				while (p.getLeft() != null)
					p = p.getLeft();
				p.setLeft(lt);
				return p2;
			}
		}
		if (k < root.getData()) {
			n = delete(root.getLeft(), k);
			root.setLeft(n);
		} else {
			n = delete(root.getRight(), k);
			root.setRight(n);
		}
		return root;
	}

	public boolean search(int val) {
		return search(root, val);
	}

	private boolean search(Node r, int val) {
		boolean found = false;
		while ((r != null) && !found) {
			int rval = r.getData();
			if (val < rval)
				r = r.getLeft();
			else if (val > rval)
				r = r.getRight();
			else {
				found = true;
				break;
			}
			found = search(r, val);
		}
		return found;
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(Node r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + " ");
			inorder(r.getRight());
		}
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node r) {
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + " ");
		}
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
		BSTree bst = new BSTree();
		System.out.println("Binary Search Tree Deletion Test\n");

		bst.insert(5);
		bst.insert(2);
		bst.insert(-4);
		bst.insert(3);
		bst.insert(12);
		bst.insert(9);
		bst.insert(21);
		bst.insert(19);
		bst.insert(25);

		System.out.print("\n Before Deletion   : ");
		System.out.print("\n In order   : ");
		bst.inorder();

		System.out.println("\n Deleting the node 12");
		bst.delete(12);
		System.out.println("After Deletion");
		bst.inorder();

		ArrayList<Node> arr = constructAllPossibleBSTs(1, 3);
		for (int i = 0; i < arr.size(); i++) {
			System.out.println("inOrder");
			bst.inorder(arr.get(i));
			System.out.println();

			System.out.println("preOrder");
			bst.preorder(arr.get(i));
			System.out.println("\n");
		}
	}

}
