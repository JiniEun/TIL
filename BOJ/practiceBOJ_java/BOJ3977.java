package study_boj;

import java.io.*;
import java.util.*;

public class BOJ3977 {
	static int scc_total, num;
	static ArrayList<Integer>[] edges;
	static int[] order, scc_arr;
	static boolean[] visit; // SCC 확정된 정점 확인
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			if (t != 0) {
				br.readLine();
			}

			st = new StringTokenizer(br.readLine());

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
				if (order[i] == 0)
					SCC(i);
			}

			int[] indegree = new int[scc_total];

			for (int i = 0; i < N; i++) {
				int s = edges[i].size();

				for (int j = 0; j < s; j++) {
					int end = edges[i].get(j);

					if (scc_arr[end] != scc_arr[i])
						indegree[scc_arr[end]]++;
				}

			}
			int cnt = 0;
			int tag = 0;

			for (int i = 0; i < scc_total; i++) {
				if (indegree[i] == 0) {
					tag = i;
					cnt++;
				}
			}

			if (cnt > 1)
				bw.write("Confused\n");
			else {
				for (int i = 0; i < N; i++) {
					if (scc_arr[i] == tag)
						bw.write(i + "\n");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int SCC(int idx) {
		order[idx] = ++num;
		stack.add(idx);
		int root = order[idx];

		for (int i = 0; i < edges[idx].size(); i++) {
			int temp = edges[idx].get(i);
			if (order[temp] == 0)
				root = Math.min(root, SCC(temp));
			else if (!visit[temp])
				root = Math.min(root, order[temp]);
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
