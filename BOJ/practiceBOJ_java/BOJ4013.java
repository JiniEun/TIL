package study_boj;

import java.io.*;
import java.util.*;

public class BOJ4013 {
	static int scc_total, num;
	static ArrayList<Integer>[] edges;
	static int[] order, scc_arr;
	static boolean[] visit; // SCC 확정된 정점 확인
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수

		edges = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			edges[a].add(b);
		}

		scc_arr = new int[N + 1];
		order = new int[N + 1];
		visit = new boolean[N + 1];
		scc_total = num = 0;
		stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			if (!visit[i])
				SCC(i);
		}

		int[] dp = new int[scc_total];
		int[] indegree = new int[scc_total];
		List<Integer>[] scc = new ArrayList[scc_total];
		for (int i = 0; i < scc_total; i++) {
			scc[i] = new ArrayList<>();
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			indegree[scc_arr[i]] += Integer.parseInt(st.nextToken());
			for (int j : edges[i]) {
				if (scc_arr[i] != scc_arr[j])
					scc[scc_arr[i]].add(scc_arr[j]);
			}
		}

		st = new StringTokenizer(br.readLine());
		int s = scc_arr[Integer.parseInt(st.nextToken())];
		int p = Integer.parseInt(st.nextToken());
		int answer = 0;

		Queue<Integer> que = new LinkedList<Integer>();
		dp[s] = indegree[s];
		que.add(s);

		while (!que.isEmpty()) {
			int now = que.poll();
			for (int next : scc[now]) {
				if (dp[next] < dp[now] + indegree[next]) {
					dp[next] = dp[now] + indegree[next];
					que.add(next);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		while (p-- > 0)
			answer = Math.max(answer, dp[scc_arr[Integer.parseInt(st.nextToken())]]);
		bw.write(answer + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	private static int SCC(int idx) {
		order[idx] = ++num;
		stack.add(idx);
		int root = order[idx];

		for (int next : edges[idx]) {
			if (order[next] == 0)
				root = Math.min(root, SCC(next));
			else if (!visit[next])
				root = Math.min(root, order[next]);
		}

		if (root == order[idx]) {
			while (true) {
				int top = stack.pop();
				scc_arr[top] = scc_total;
				visit[top] = true;
				if (top == idx)
					break;
			}
			scc_total++;
		}
		return root;
	}
}
