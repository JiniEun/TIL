package study_boj;

import java.io.*;
import java.util.*;

public class BOJ4803 {
	static ArrayList<Integer>[] graph;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int testcase = 1;

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			graph = new ArrayList[N + 1];
			visit = new boolean[N + 1];

			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());

				graph[v1].add(v2);
				graph[v2].add(v1);
			}
			int cnt = 0;
//
//			for (int i = 1; i <= N; i++) {
//				if (!visit[i]) {
//					cnt += TreeCheck(i);
//				}
//			}

			for (int i = 1; i <= N; i++) {
				if (!visit[i] && DFS(i, 0)) {
					cnt++;
				}
			}
			sb.append(String.format("Case %d: ", testcase++));

			if (cnt == 0)
				sb.append("No trees.");
			else if (cnt == 1)
				sb.append("There is one tree.");
			else
				sb.append(String.format("A forest of %d trees.", cnt));

			sb.append('\n');
		}
		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

//	static int TreeCheck(int start) {
//		Queue<Integer> que = new LinkedList<>();
//		que.offer(start);
//		int node = 0, edge = 0;
//
//		while (!que.isEmpty()) {
//			int cur = que.poll();
//			node++;
//			visit[cur] = true;
//			for (int n : graph[cur]) {
//				edge += 1;
//				if (!visit[n]) {
//					que.offer(n);
//				}
//			}
//		}
//		return (edge / 2) + 1 == node ? 1 : 0;
//	}

	static boolean DFS(int before, int cur) {
		if (visit[before])
			return false;

		boolean result = true;
		visit[before] = true;

		for (int n : graph[before]) {
			if (n != cur)
				result &= DFS(n, before);
		}
		return result;
	}
}
