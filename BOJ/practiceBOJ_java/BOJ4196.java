package study_boj;

import java.io.*;
import java.util.*;

public class BOJ4196 {
	static int size, num;
	static ArrayList<Integer>[] graph, result;
	static int[] order, scc_arr;
	static boolean[] visit; // SCC 확정된 정점 확인
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 정점의 개수
			int M = Integer.parseInt(st.nextToken()); // 간선의 개수

			graph = new ArrayList[N + 1];
			result = new ArrayList[N + 1];

			for (int i = 0; i < N + 1; i++) {
				graph[i] = new ArrayList<>();
				result[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				graph[x].add(y);
			}

			scc_arr = new int[N + 1];
			order = new int[N + 1];
			visit = new boolean[N + 1];
			size = num = 0;
			stack = new Stack<>();

			for (int i = 1; i < N + 1; i++) {
				if (order[i] == 0)
					SCC(i);
			}

			boolean[] indegree = new boolean[size];

			for (int i = 1; i < N + 1; i++) {
				int s = graph[i].size();

				for (int j = 0; j < s; j++) {
					int end = graph[i].get(j);

					if (scc_arr[end] != scc_arr[i])
						indegree[scc_arr[end]] = true;
				}

			}
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				if (!indegree[i])
					cnt++;
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int SCC(int idx) {
		order[idx] = ++num;
		stack.add(idx);
		int root = order[idx];

		for (int i = 0; i < graph[idx].size(); i++) {
			int temp = graph[idx].get(i);
			if (order[temp] == 0)
				root = Math.min(root, SCC(temp));
			else if (!visit[temp])
				root = Math.min(root, order[temp]);
		}

		if (root == order[idx]) {
			while (true) {
				int top = stack.pop();
				result[size].add(top);
				scc_arr[top] = size;
				visit[top] = true;
				if (top == idx)
					break;
			}
			size++;
		}
		return root;
	}
}
