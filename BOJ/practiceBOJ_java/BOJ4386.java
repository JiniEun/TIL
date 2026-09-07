package study_boj;

import java.io.*;
import java.util.*;

public class BOJ4386 {

	static class Star {
		int number;
		double x, y;

		Star(int number, double x, double y) {
			this.number = number;
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {
		int s, e;
		double cost;

		Edge(int s, int e, double cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// Comparable을 통해 정렬 우선순위 (cost 기준)
			return o.cost >= this.cost ? -1 : 1;
		}
	}

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Star[] star = new Star[N];

		parent = new int[N + 1];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			star[i] = new Star(i, a, b);
		}

		PriorityQueue<Edge> pque = new PriorityQueue<>();

		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++)
				pque.offer(new Edge(i, j,
						Math.sqrt(Math.pow(star[i].x - star[j].x, 2) + Math.pow(star[i].y - star[j].y, 2))));

		double cost = 0;
		while (!pque.isEmpty()) {
			Edge now = pque.poll();

			if (find(now.s) != find(now.e)) {
				union(now.s, now.e);
				cost += now.cost;
			}
		}

		bw.write(Math.round(cost * 100) / 100.0 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	// x의 부모 찾기
	public static int find(int x) {
		if (x == parent[x])
			return x;

		return parent[x] = find(parent[x]);
	}

	// y 부모를 x 부모로 치환하기 (x > y 일 경우 반대)
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}
}
