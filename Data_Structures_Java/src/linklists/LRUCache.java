package linklists;

import java.util.HashMap;

class Node {
	int key;
	int value;
	Node pre;
	Node post;

	public Node(int key, int val) {

		this.key = key;
		this.value = val;
	}
}

public class LRUCache {

	int capacity = 0;
	int count = 0;
	HashMap<Integer, Node> map = new HashMap<>();
	Node head = null;
	Node tail = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		head = new Node(0, 0);
		tail = new Node(0, 0);

		head.post = tail;
		head.pre = null;
		tail.pre = head;
		tail.post = null;
	}

	// Delete a Node from LinkedList
	public void deleteNode(Node node) {
		node.pre.post = node.post;
		node.post.pre = node.pre;
	}

	// Add a node just after the head of linked list

	public void addHeadNode(Node node) {
		head.post.pre = node;
		node.post = head.post;
		head.post = node;
		node.pre = head;
	}

	public void put(int key, int value) {

		// First check if key exist in the map

		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			deleteNode(node);
			addHeadNode(node);
		} else {
			Node node = new Node(key, value);
			map.put(key, node);
			if (count < capacity) {
				addHeadNode(node);
				count++;
			} else {
				Node tailnode = tail.pre;
				map.remove(tailnode.key);
				deleteNode(tailnode);
				addHeadNode(node);
			}

		}
	}

	public int get(int key) {

		if(map.containsKey(key)) {
			Node node = map.get(key);
			int val = node.value;
			deleteNode(node);
			addHeadNode(node);
			return val;
		}
		else
			return -1;
	}

}
