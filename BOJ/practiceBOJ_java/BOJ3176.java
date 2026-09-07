package study_boj;

import java.io.*;
import java.util.*;

public class BOJ3176 {

	static int N, K, k; // N : 정점수, k : 쿼리 수, k: 2의 지수

	static int[] depth;
	static int[][] parent; // parent[j][i] = parent[parent[j][i - 1]][i - 1];
	static ArrayList<Node>[] tree;

	// 도로 네트워크 변수
	// min(max)Dist[k][V] 정점 V의 2^K번째 조상까지의
	static int[][] minDist; // 최소거리
	static int[][] maxDist; // 최대거리

	static int min, max;

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

		k = 0;
		for (int i = 1; i <= N; i *= 2) {
			k++;
		}

		depth = new int[N + 1];
		parent = new int[N + 1][k];

		minDist = new int[N + 1][k];
		maxDist = new int[N + 1][k];

		tree = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			tree[i] = new ArrayList<Node>();
		}

		int a, b, c;
		for (int i = 1; i <= N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			tree[a].add(new Node(b, c));
			tree[b].add(new Node(a, c));
		}

		DFS(1, 1);

		// parent 채우기 
		for (int i = 1; i < k; i++) {
			for (int j = 1; j <= N; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];

				minDist[j][i] = Math.min(minDist[j][i - 1], minDist[parent[j][i - 1]][i - 1]);
				maxDist[j][i] = Math.max(maxDist[j][i - 1], maxDist[parent[j][i - 1]][i - 1]);
			}
		}

		// LCA
		K = Integer.parseInt(br.readLine());

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			LCA(a, b);
			sb.append(min + " " + max + "\n");
		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	// depth 확인
	static void DFS(int node, int cur) {
		depth[node] = cur;

		for (Node next : tree[node]) {
			if (depth[next.target] == 0) {
				DFS(next.target, cur + 1);
				parent[next.target][0] = node;

				// 현재 cost로 갱신
				minDist[next.target][0] = next.cost;
				maxDist[next.target][0] = next.cost;
			}
		}
		return;
	}

	static void LCA(int a, int b) {
		if (depth[a] < depth[b]) {
			// a가 더 얕으면 swap
			int temp = a;
			a = b;
			b = temp;
		}

		min = Integer.MAX_VALUE;
		max = -1;

		for (int i = k - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				min = Math.min(min, minDist[a][i]);
				max = Math.max(max, maxDist[a][i]);

				a = parent[a][i]; // 높이 차이 만큼 a 높이 올리기
			}
		}

		if (a == b)
			return;

		for (int i = k - 1; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				min = Math.min(min, Math.min(minDist[a][i], minDist[b][i]));
				max = Math.max(max, Math.max(maxDist[a][i], maxDist[b][i]));

				a = parent[a][i];
				b = parent[b][i];
			}
		}

		min = Math.min(min, Math.min(minDist[a][0], minDist[b][0]));
		max = Math.max(max, Math.max(maxDist[a][0], maxDist[b][0]));

		return;
	}
}