package study_boj;

import java.io.*;
import java.util.*;

public class BOJ5639 {
	static class Node {
		int num;
		Node left, right;

		Node(int num) {
			this.num = num;
		}

		Node(int num, Node left, Node right) {
			this.num = num;
			this.left = left;
			this.right = right;
		}

		void insert(int n) {
			if (n < this.num) {
				if (this.left == null) {
					this.left = new Node(n);
				} else
					this.left.insert(n);
			} else {
				if (this.right == null) {
					this.right = new Node(n);
				} else
					this.right.insert(n);
			}
		}
	}

	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Node root = new Node(Integer.parseInt(br.readLine()));
		sb = new StringBuilder();

		String input;
		while ((input = br.readLine()) != null) {
			root.insert(Integer.parseInt(input));
		}
		postOrder(root);
		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

	public static void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.num + "\n");
	}
}
