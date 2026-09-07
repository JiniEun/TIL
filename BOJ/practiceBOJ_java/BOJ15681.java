package study_boj;

import java.io.*;
import java.util.*;

public class BOJ15681 {
	static int[] parent;
	static int[] size;
	static ArrayList<Integer>[] list, tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		size = new int[N + 1];
		list = new ArrayList[N + 1];
		tree = new ArrayList[N + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		makeTree(R, -1);
		countSubtreeNodes(R);

		while (Q-- > 0) {
			int query = Integer.parseInt(br.readLine());
			sb.append(size[query]).append("\n");
		}

		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void makeTree(int curNode, int p) {
		for (int node : list[curNode]) {
			if (node != p) {
				tree[curNode].add(node);
				parent[node] = curNode;
				makeTree(node, curNode);
			}
		}
	}

	public static void countSubtreeNodes(int curNode) {
		size[curNode] = 1;
		for (int node : tree[curNode]) {
			countSubtreeNodes(node);
			size[curNode] += size[node];
		}
	}
}
