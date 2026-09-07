package study_boj;

import java.io.*;
import java.util.*;

public class BOJ1766 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] indegree = new int[N + 1];
		ArrayList<Integer>[] list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			list[s].add(e);
			indegree[e]++;
		}

		bw.write(topologicalSort(indegree, list) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	public static String topologicalSort(int[] indegree, ArrayList<Integer>[] list) {
		PriorityQueue<Integer> pque = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				pque.offer(i);
			}
		}

		while (!pque.isEmpty()) {
			int node = pque.poll();
			for (int i : list[node]) {

				indegree[i]--;

				if (indegree[i] == 0)
					pque.offer(i);
			}
			sb.append(node + " ");
		}
		return sb.toString();
	}
}
