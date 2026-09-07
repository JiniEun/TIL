package study_boj;

import java.io.*;
import java.util.*;

public class BOJ11725 {
	static int[] parents;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();

		visit = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			list[s].add(e);
			list[e].add(s);
		}

		dfs(1);
		for (int i = 2; i <= N; i++)
			bw.write(parents[i]+"\n");

		bw.flush();
		br.close();
		bw.close();
	}

	public static void dfs(int v) {
		visit[v] = true;

		for (int i : list[v]) {
			if (!visit[i]) {
				parents[i] = v;
				dfs(i);
			}
		}
	}
}