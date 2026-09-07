package study_boj;

import java.io.*;
import java.util.*;

public class BOJ1949 {
	static int N;
	static int[] tree;
	static int[][] dp;
	static LinkedList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1][2];
		list = new LinkedList[N + 1];
		tree = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new LinkedList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list[u].add(v);
			list[v].add(u);
		}

		dfs(1, -1);

		bw.write(String.valueOf(Math.max(dp[1][0], dp[1][1])) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int now, int p) {
		for (int next : list[now]) {
			if (next != p) {
				dfs(next, now);
				dp[now][1] += dp[next][0];
				dp[now][0] += Math.max(dp[next][0], dp[next][1]);
			}
		}
		dp[now][1] += tree[now];
	}
}
