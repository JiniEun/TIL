package study_boj;

import java.io.*;
import java.util.*;

public class BOJ2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer>[] list = new LinkedList[N + 1];
		int[] indegree = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			indegree[y]++;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			bw.write(queue.peek() + " ");
			int cur = queue.poll();

			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
