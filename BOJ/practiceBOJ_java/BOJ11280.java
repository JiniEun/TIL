package study_boj;

import java.io.*;
import java.util.*;

public class BOJ11280 {
	static int N, num;
	static ArrayList<Integer>[] graph;
	static int[] order;
	static boolean[] visit; // SCC 확정된 정점 확인
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[2 * N + 1];
		order = new int[2 * N + 1];
		visit = new boolean[2 * N + 1];
		stack = new Stack<>();

		for (int i = 0; i < 2 * N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[validate(-u)].add(validate(v));
			graph[validate(-v)].add(validate(u));
		}

		boolean flag = true;
		for (int i = 1; i < 2 * N + 1; i++) {
			if (!visit[i]) {
				if (SCC(i) == -1) {
					flag = false;
					break;
				}
			}
		}

		if (flag)
			bw.write("1\n");
		else
			bw.write("0\n");

		bw.flush();
		bw.close();
		br.close();
	}

	private static int validate(int n) {
		if (0 < n && n < N + 1)
			return n;
		return -n + N;
	}

	private static int SCC(int idx) {
		order[idx] = ++num;
		stack.add(idx);
		int root = order[idx];

		for (int next : graph[idx]) {
			if (order[next] == 0)
				root = Math.min(root, SCC(next));
			else if (!visit[next])
				root = Math.min(root, order[next]);
		}

		if (root == order[idx]) {
			boolean[] check = new boolean[N + 1];
			while (!stack.isEmpty()) {
				int top = stack.pop();
				int temp = validate(top);

				if (temp < 0)
					temp *= -1;
				if (check[temp])
					return -1;

				check[temp] = true;
				visit[top] = true;

				if (top == idx)
					break;
			}
		}
		return root;
	}
}
