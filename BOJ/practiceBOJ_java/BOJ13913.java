package study_boj;

import java.util.*;
import java.io.*;

public class BOJ13913 {
	static int N, K;
	static int[] move = new int[100001];
	static int[] time = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();

		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		int idx = K;

		while (idx != N) {
			stack.push(move[idx]);
			idx = move[idx];
		}

		sb.append(time[K] - 1 + "\n");

		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}

		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(N);
		time[N] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == K)
				return;

			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0)
					next = now + 1;
				else if (i == 1)
					next = now - 1;
				else
					next = now * 2;

				if (next < 0 || next > 100000)
					continue;

				if (time[next] == 0) {
					queue.add(next);
					time[next] = time[now] + 1;
					move[next] = now;
				}

			}
		}
	}
}
