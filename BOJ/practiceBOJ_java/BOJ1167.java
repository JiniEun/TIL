package study_boj;

import java.util.*;
import java.io.*;

public class BOJ1167 {
	static class Node {
		int node, dist;

		public Node(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	static ArrayList<Node>[] list;
	static boolean[] visit;
	static int max = 0;
	static int node, V;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());

		list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());

			int nodenum = Integer.parseInt(st.nextToken());
			String str;
			while (!(str = st.nextToken()).equals("-1")) {
				int node = Integer.parseInt(str);
				int dist = Integer.parseInt(st.nextToken());
				list[nodenum].add(new Node(node, dist));
			}
		}

		visit = new boolean[V + 1];
		dfs(1, 0);

		visit = new boolean[V + 1];
		dfs(node, 0);

		bw.write(max + "\n");

		bw.flush();
		br.close();
		bw.close();
	}

	public static void dfs(int v, int len) {
		if (len > max) {
			max = len;
			node = v;
		}

		visit[v] = true;

		for (Node n : list[v]) {
			if (!visit[n.node]) {
				dfs(n.node, n.dist + len);
				visit[n.node] = true;
			}
		}
	}
}
