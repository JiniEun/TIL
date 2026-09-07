package study_boj;

import java.io.*;
import java.util.*;

public class BOJ11438 {
	private static int N, M, K;
	private static int[] depth;
	private static int[][] parent;
	private static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		K = 0;
		int tmp = 1;
		while (tmp < N + 1) {
			tmp <<= 1;
			K++;
		}

		depth = new int[N + 1];
		parent = new int[N + 1][K];

		dfs(1, 1);
		for (int i = 1; i < K; i++) {
			// 2^K 번째 조상 노드 저장
			for (int j = 1; j <= N; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(LCA(a, b)).append("\n");
		}

		bw.write(sb.toString() + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int node, int cur) {
		depth[node] = cur;
		for (Integer next : list[node]) {
			if (depth[next] == 0) {
				dfs(next, cur + 1);
				parent[next][0] = node;
			}
		}
	}

	private static int LCA(int a, int b) {
		if (depth[a] < depth[b]) {
			// a가 더 얕으면 swap
			int temp = a;
			a = b;
			b = temp;
		}

		for (int i = K - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				// 높이 차이 만큼 a 높이 올리기 
				a = parent[a][i];
			}
		}

		if (a == b)
			return a;

		for (int i = K - 1; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}
}
