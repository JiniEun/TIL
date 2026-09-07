package study_boj;

import java.util.*;
import java.io.*;

public class BOJ11779 {

	static class Bus implements Comparable<Bus> {
		public int end, cost;

		public Bus(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bus o) {
			return cost - o.cost;
		}
	}

	static int INF = 100000000;
	static ArrayList<Bus>[] graph;
	static int N, M, cnt, s, e;
	static int[] dist, pcity;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		pcity = new int[N + 1];

		// 인접리스트 초기화
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[start].add(new Bus(end, cost));
		}

		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		Arrays.fill(dist, INF);

		dijkstra();

		Stack<Integer> stack = searchPath();

		while (!stack.isEmpty()) {
			int city = stack.pop();
			sb.append(city + " ");
		}

		bw.write(dist[e] + "\n");
		bw.write(cnt + "\n");
		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

	static void dijkstra() {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N + 1];

		pq.add(new Bus(s, 0));
		dist[s] = 0;

		while (!pq.isEmpty()) {
			Bus curBus = pq.poll();
			int cur = curBus.end;

			if (visit[cur] == true)
				continue;
			visit[cur] = true;

			for (Bus bus : graph[cur]) {
				if (dist[bus.end] > dist[cur] + bus.cost) {
					dist[bus.end] = dist[cur] + bus.cost;
					pq.add(new Bus(bus.end, dist[bus.end]));

					pcity[bus.end] = cur;
				}
			}
		}

	}

	public static Stack<Integer> searchPath() {
		Stack<Integer> stack = new Stack<>();
		int cur = e;

		while (cur != s) {
			stack.push(cur);
			cnt++;

			cur = pcity[cur];
		}
		stack.push(cur);
		cnt++;

		return stack;
	}
}