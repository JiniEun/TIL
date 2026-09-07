package study_boj;

import java.io.*;
import java.util.*;

public class BOJ2887 {

	static class Point {
		int number;
		int x, y, z;

		Point(int number, int x, int y, int z) {
			this.number = number;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class Edge implements Comparable<Edge> {
		int s, e;
		int cost;

		Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// Comparable을 통해 정렬 우선순위 (cost 기준)
			return cost - o.cost;
		}
	}

	static int[] parent;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int result = 0;
		edgeList = new ArrayList<>();

		parent = new int[N + 1];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			points[i] = new Point(i, x, y, z);
		}

		// x, y, z에 대해 정렬

		Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
		for (int i = 0; i < N - 1; i++) {
			int cost = Math.abs(points[i].x - points[i + 1].x);
			// 각 행성의 번호와 비용 edgeList에 추가
			edgeList.add(new Edge(points[i].number, points[i + 1].number, cost));
		}

		Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < N - 1; i++) {
			int cost = Math.abs(points[i].y - points[i + 1].y);

			edgeList.add(new Edge(points[i].number, points[i + 1].number, cost));
		}

		Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
		for (int i = 0; i < N - 1; i++) {
			int cost = Math.abs(points[i].z - points[i + 1].z);

			edgeList.add(new Edge(points[i].number, points[i + 1].number, cost));
		}

		Collections.sort(edgeList);

		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			if (find(edge.s) != find(edge.e)) {
				result += edge.cost;
				union(edge.s, edge.e);
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
