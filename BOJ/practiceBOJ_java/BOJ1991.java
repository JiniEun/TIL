package study_boj;

import java.util.*;
import java.io.*;

public class BOJ1991 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static class Node {
		char data;
		Node Left, Right;

		public Node(char data) {
			this.data = data;
		}
	}

	static class Tree {
		Node root; // 초기화 null 상태

		public void AddNode(char data, char leftData, char rightData) {
			if (root == null) { // 아무것도 없는 초기 상태 - A 루트 노드 생성
				root = new Node(data);

				// 좌우 값 존재시 노드 생성
				if (leftData != '.') {
					root.Left = new Node(leftData);
				}
				if (rightData != '.') {
					root.Right = new Node(rightData);
				}
			} else { // 초기상태가 아닌 경우 위치 찾기 - A 루트 노드 이후
				Search(root, data, leftData, rightData);
			}
		}

		public void Search(Node root, char data, char leftData, char rightData) {
			if (root == null) { // 도착 노드 null이면 재귀 종료 - 삽입할 노드 X
				return;
			} else if (root.data == data) { // 들어갈 위치
				if (leftData != '.') { // 값이 있는 경우만 좌우 노드 생성 (. - X)
					root.Left = new Node(leftData);
				}
				if (rightData != '.') {
					root.Right = new Node(rightData);
				}
			} else { // 탐색할 노드가 남아 있는 경
				Search(root.Left, data, leftData, rightData); // 왼쪽 재귀 탐색
				Search(root.Right, data, leftData, rightData); // 오른쪽 재귀 탐색
			}
		}

		// 전위순회 : 루트 -> 좌 -> 우
		public void PreOrder(Node root) throws IOException {
			bw.write(root.data); // 중
			if (root.Left != null)
				PreOrder(root.Left); // 왼쪽
			if (root.Right != null)
				PreOrder(root.Right); // 오른쪽
		}

		// 중위순회 : 좌 -> 루트 -> 우
		public void InOrder(Node root) throws IOException {
			if (root.Left != null)
				InOrder(root.Left); // 왼쪽 
			bw.write(root.data); // 중앙 
			if (root.Right != null)
				InOrder(root.Right); // 오른쪽
		}

		// 후위순회 : 좌 -> 우 -> 루트
		public void PostOrder(Node root) throws IOException {
			if (root.Left != null)
				PostOrder(root.Left); // 왼쪽 
			if (root.Right != null)
				PostOrder(root.Right); // 오른쪽
			bw.write(root.data); // 증
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Tree tree = new Tree();

		for (int i = 0; i < N; i++) {
			char[] data;
			data = br.readLine().replaceAll(" ", "").toCharArray();
			tree.AddNode(data[0], data[1], data[2]);
		}

		// 전위 순회
		tree.PreOrder(tree.root);
		bw.write("\n");

		// 중위 순회
		tree.InOrder(tree.root);
		bw.write("\n");

		// 후위 순회
		tree.PostOrder(tree.root);

		bw.flush();
		br.close();
		bw.close();
	}
}
