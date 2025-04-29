import java.io.*;

import java.util.*;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

import com.sun.source.tree.Tree;

public class Main {
	
	static Node head = new Node('A', null, null);
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N-1; i++) {
			String[] nodes = br.readLine().split(" ");

			char root = nodes[0].charAt(0);
			char left = nodes[1].charAt(0);
			char right = nodes[2].charAt(0);
			insertNode(head, root, left, right);

		}

		preorder(head);
		System.out.println();
		inorder(head);
		System.out.println();
		postorder(head);
	}

	static void insertNode(Node node, char root, char left, char right) {

		if (node.val == root) {
			node.left = (left == '.' ? null : new Node(left, null, null));
			node.right = (right == '.' ? null : new Node(right, null, null));
		} else {
			if (node.left != null) {
				insertNode(node.left, root, left, right);
			}

			if (node.right != null) {
				insertNode(node.right, root, left, right);
			}
		}
	}

	static void preorder(Node node) {

		if (node == null) {
			return;
		}

		System.out.print(node.val);
		preorder(node.left);
		preorder(node.right);
	}

	static void inorder(Node node) {

		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.val);
		inorder(node.right);
	}

	static void postorder(Node node) {

		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.val);
	}

	static class Node {
		char val;
		Node left;
		Node right;

		public Node(final char val, final Node left, final Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		public void setLeftNode(Node node) {
			this.left = node;
		}

		public void setRightNode(Node node) {
			this.right = node;
		}
	}
}
