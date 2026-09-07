package study_boj;

import java.io.*;
import java.util.*;

public class BOJ3648 {
	static int N, V, num;
	static ArrayList<Integer>[] graph;
	static int[] parent, CNF;
	static boolean[] visit; // SCC 확정된 정점 확인
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			String input = br.readLine();
			if (input == null)
				break;
			st = new StringTokenizer(input, " ");

			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			parent = new int[2 * N + 1];
			visit = new boolean[2 * N + 1];
			stack = new Stack<>();
			num = 0;
			V = 0;
			CNF = new int[2 * N + 1];
			graph = new ArrayList[2 * N + 1];

			for (int i = 0; i < 2 * N + 1; i++) {
				graph[i] = new ArrayList<>();
			}
			graph[validate(-1)].add(1);

			while (M-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");

				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				graph[validate(-u)].add(validate(v));
				graph[validate(-v)].add(validate(u));
			}

			for (int i = 1; i < 2 * N + 1; i++) {
				if (!visit[i]) {
					SCC(i);
				}
			}

			bw.write(printR());
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static int validate(int n) {
		return (0 < n && n < N + 1) ? n : -n + N;
	}
	
	private static String printR() {
		for (int i = 1; i < N + 1; i++) {
            if (CNF[i] == CNF[i + N]) return "no\n";
        }
        return "yes\n";
	}

	private static int SCC(int idx) {
		parent[idx] = ++num;
		stack.push(idx);
		int root = parent[idx];

		for (int next : graph[idx]) {
			if (parent[next] == 0)
				root = Math.min(root, SCC(next));
			else if (!visit[next])
				root = Math.min(root, parent[next]);
		}

		if (root == parent[idx]) {
			while (!stack.isEmpty()) {
				int top = stack.pop();
				CNF[top] = V;
				visit[top] = true;
				if (top == idx)
					break;
			}
			V++;
		}
		return root;
	}
}