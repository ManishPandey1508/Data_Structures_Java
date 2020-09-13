package BFS;
import java.util.*;

class TreeNode1 {
  int val;
  TreeNode1 left;
  TreeNode1 right;
  TreeNode1 next;

  TreeNode1(int x) {
    val = x;
    left = right = next = null;
  }
};

public class ConnectAllSiblings {
  public static void connect(TreeNode1 root) {
   	if (root == null)
			return;

		Queue<TreeNode1> q = new LinkedList<TreeNode1>();
		q.offer(root);
		TreeNode1 prev = null;
		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode1 curr = q.poll();
				if (prev == null)
					prev = curr;
				else {
					prev.next = curr;
					prev = curr;
				}

				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			}

		}

  }

  public static void main(String[] args) {
    TreeNode1 root = new TreeNode1(12);
    root.left = new TreeNode1(7);
    root.right = new TreeNode1(1);
    root.left.left = new TreeNode1(9);
    root.right.left = new TreeNode1(10);
    root.right.right = new TreeNode1(5);
    ConnectAllSiblings.connect(root);

    // level order traversal using 'next' pointer
    TreeNode1 current = root;
    System.out.println("Traversal using 'next' pointer: ");
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}
