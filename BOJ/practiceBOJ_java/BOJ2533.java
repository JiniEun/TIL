package study_boj;

import java.io.*;
import java.util.*;

public class BOJ2533 {
	static int N;
	static int[][] dp;
	static LinkedList<Integer>[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1][2];
		tree = new LinkedList[N + 1];

		for (int i = 1; i <= N; i++) {
			tree[i] = new LinkedList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			tree[u].add(v);
			tree[v].add(u);
		}

		dfs(1, -1);

		bw.write(String.valueOf(Math.min(dp[1][0], dp[1][1])));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int node, int p) {
		dp[node][0] = 0;
		dp[node][1] = 1;

		for (int next : tree[node]) {
			if (next != p) {
				dfs(next, node);
				dp[node][0] += dp[next][1];
				dp[node][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
	}
}
