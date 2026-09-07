package study_boj;

import java.io.*;
import java.util.*;

public class BOJ1774 {
	static class Point {
		int number;
		double x, y;

		Point(int number, double x, double y) {
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
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		Point[] points = new Point[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());

			points[i] = new Point(i, x, y);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			union(start, end);
		}

		edgeList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				double cost = distance(points[i], points[j]);

				edgeList.add(new Edge(points[i].number, points[j].number, cost));
			}
		}
		Collections.sort(edgeList);

		double result = 0;

		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			if (find(edge.s) != find(edge.e)) {
				result += edge.cost;
				union(edge.s, edge.e);
			}
		}

		bw.write(String.format("%.2f", result) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
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
