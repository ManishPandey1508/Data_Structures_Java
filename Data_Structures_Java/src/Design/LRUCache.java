package Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class Node {
		int key;
		int value;
		Node pre;
		Node post;

		public Node(int key, int value) {

			this.key = key;
			this.value = value;

		}
	}

	// LRU Cache properties

	Map<Integer, Node> map = new HashMap<>();
	Node head = null;
	Node tail = null;
	int count;
	int capacity;

	// Initial
	public LRUCache(int capacity) {

		this.capacity = capacity;
		this.count = 0;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.pre = null;
		tail.post = null;
		head.post = tail;
		tail.pre = head;

	}

	// Delete a particular Node
	public void delete(Node node) {

		node.pre.post = node.post;
		node.post.pre = node.pre;
		count--;
	}

	// Add node at head
	public void addAthead(Node node) {

		Node temp = head.post;

		temp.pre = node;
		node.post = temp;
		head.post = node;
		node.pre = head;
		count++;

	}

	public int get(int key) {

		if (map.containsKey(key)) {
			Node node = map.get(key);
			delete(node);
			addAthead(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {

		if (!map.containsKey(key)) {

			if (map.size() >= capacity) {
				Node node = tail.pre;
				map.remove(node.key);
				delete(node);
				Node newNode = new Node(key, value);
				addAthead(newNode);
				map.put(key, newNode);
			} else {
				Node newNode = new Node(key, value);
				addAthead(newNode);
				map.put(key, newNode);
			}

		} else {
			Node node = map.get(key);
			delete(node);
			Node newNode = new Node(key, value);
			addAthead(newNode);
			map.put(key, newNode);

		}

	}

}
