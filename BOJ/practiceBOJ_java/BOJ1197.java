package study_boj;

import java.io.*;
import java.util.*;

public class BOJ1197 {

	static class Edge implements Comparable<Edge> {
		int s, e, cost;

		Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge arg0) {
			// Comparable을 통해 정렬 우선순위 (cost 기준)
			return arg0.cost >= this.cost ? -1 : 1;
		}
	}

	static int[] parent;
	static int V, E, result;
	static PriorityQueue<Edge> pque = new PriorityQueue<Edge>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			pque.add(new Edge(start, end, cost));
		}

		for (int i = 0; i < E; i++) {
			Edge tmp = pque.poll();

			int a = find(tmp.s);
			int b = find(tmp.e);

			if (a != b) {
				union(a, b);
				result += tmp.cost;
			}
		}
		bw.write(result + "\n");
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
