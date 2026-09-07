package study_boj;

import java.io.*;
import java.util.*;

public class BOJ16367 {
	static int N, V, num;
	static ArrayList<ArrayList<Integer>> graph, scc_arr;
	static int[] parent, CNF;
	static boolean[] visit; // SCC 확정된 정점 확인
	static char[] color;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[2 * N + 1];
		visit = new boolean[2 * N + 1];
		stack = new Stack<>();
		num = V = 0;
		color = new char[N + 1];
		CNF = new int[2 * N + 1];
		graph = new ArrayList<>();
		scc_arr = new ArrayList<>();

		for (int i = 0; i < 2 * N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int[] E = new int[3];
			for (int i = 0; i < 3; i++) {
				int x = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				if (c == 'R')
					E[i] = x;
				else
					E[i] = -x;
			}

			graph.get(validate(-E[0])).add(validate(E[1]));
			graph.get(validate(-E[1])).add(validate(E[0]));
			graph.get(validate(-E[0])).add(validate(E[2]));
			graph.get(validate(-E[2])).add(validate(E[0]));
			graph.get(validate(-E[1])).add(validate(E[2]));
			graph.get(validate(-E[2])).add(validate(E[1]));
		}

		for (int i = 1; i < 2 * N + 1; i++) {
			if (!visit[i]) {
				SCC(i);
			}
		}

		if (isTrue()) {
			bw.write(topologySort() + "\n");
		} else {
			bw.write("-1\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static int validate(int n) {
		return (0 < n && n < N + 1) ? n : -n + N;
	}

	private static String topologySort() {
		for (int i = V - 1; i > -1; i--) {
			for (int j : scc_arr.get(i)) {
				int cur = Math.abs(validate(j));
				if (color[cur] == '\0') {
					if (j > N)
						color[cur] = 'R';
					else
						color[cur] = 'B';
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(color[i]);
		}

		return sb.toString();
	}

	private static boolean isTrue() {
		for (int i = 1; i < N + 1; i++) {
			if (CNF[i] == CNF[i + N])
				return false;
		}
		return true;
	}

	private static int SCC(int idx) {
		parent[idx] = ++num;
		stack.push(idx);
		int root = parent[idx];

		for (int next : graph.get(idx)) {
			if (parent[next] == 0)
				root = Math.min(root, SCC(next));
			else if (!visit[next])
				root = Math.min(root, parent[next]);
		}

		if (root == parent[idx]) {
			ArrayList<Integer> tmp = new ArrayList<>();
			while (!stack.isEmpty()) {
				int top = stack.pop();
				tmp.add(top);
				visit[top] = true;
				CNF[top] = V;

				if (top == idx)
					break;
			}
			V++;
			scc_arr.add(tmp);
		}
		return root;
	}
}