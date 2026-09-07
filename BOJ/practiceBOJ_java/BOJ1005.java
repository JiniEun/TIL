package study_boj;

import java.util.*;
import java.io.*;

public class BOJ1005 {

	static int N, K;
	static int[] time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = new int[N + 1];

			ArrayList<Integer>[] list = new ArrayList[N];
			int[] indegree = new int[N + 1];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
				time[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				list[s - 1].add(e - 1);
				indegree[e - 1]++;
			}

			int w = Integer.parseInt(br.readLine()); // 건물 번호 

			bw.write(topologicalSort(indegree, list, w) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static int topologicalSort(int[] indegree, ArrayList<Integer>[] list, int w) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] result = new int[N + 1];

		// 건물 기본 소요시간
		for (int i = 0; i < N; i++) {
			if (indegree[i] == 0) {
				result[i] = time[i];
				queue.offer(i);
			}
		}

		// 총 소요시간 = 이전 건물까지의 소요시간 + 현재 건물 소요시간
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i : list[node]) {
				result[i] = Math.max(result[i], result[node] + time[i]);
				indegree[i]--;

				if (indegree[i] == 0)
					queue.offer(i);
			}
		}
		return result[w - 1];
	}
}
