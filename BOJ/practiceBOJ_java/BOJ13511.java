package study_boj;

import java.io.*;
import java.util.*;

public class BOJ13511 {

	static int N, M; // N : 정점수, M : 쿼리 수

	static int[] depth;
	static long[] dist;
	static int[][] parent; // parent[j][i] = parent[parent[j][i - 1]][i - 1];
	static ArrayList<Node>[] tree;

	static class Node {
		int target, cost;

		public Node(int target, int cost) {
			this.target = target;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		depth = new int[N + 1];
		dist = new long[N + 1];
		parent = new int[N + 1][18];
		tree = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			tree[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			tree[a].add(new Node(b, c));
			tree[b].add(new Node(a, c));
		}

		DFS(1, 1);

		// parent 채우기
		for (int i = 1; i < 18; i++) {
			for (int j = 2; j <= N; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}

		// LCA
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int root = LCA(u, v);
			if (a == 1) {
				sb.append(dist[u] + dist[v] - 2 * dist[root] + "\n");
			} else {
				int k = Integer.parseInt(st.nextToken());
				int cnt = depth[u] - depth[root] + 1;
				if (cnt == k)
					sb.append(root + "\n");
				else if (cnt > k) {
					k--;
					int tmp = u;
					for (int j = 0; j < 18; j++) {
						if ((k & 1 << j) != 0) {
							k -= 1 << j;
							tmp = parent[tmp][j];
						}
					}
					sb.append(tmp + "\n");
				} else {
					k = cnt + depth[v] - depth[root] - k + 1;
					k--;
					int tmp = v;
					for (int j = 0; j < 18; j++) {
						if ((k & 1 << j) != 0) {
							k -= 1 << j;
							tmp = parent[tmp][j];
						}
					}
					sb.append(tmp + "\n");
				}
			}
		}
		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	// depth 확인
	// dist 추가
	static void DFS(int node, int cur) {
		depth[node] = cur;

		for (Node next : tree[node]) {
			if (depth[next.target] == 0) {
				parent[next.target][0] = node;
				dist[next.target] = dist[node] + next.cost;
				DFS(next.target, cur + 1);
			}
		}
		return;
	}

	static int LCA(int a, int b) {
		if (depth[a] < depth[b]) {
			// a가 더 얕으면 swap
			int temp = a;
			a = b;
			b = temp;
		}
		for (int i = 18; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				a = parent[a][i]; // 높이 차이 만큼 a 높이 올리기
			}
		}
		if (a == b) return a;

		for (int i = 17; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) { 
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}
}
