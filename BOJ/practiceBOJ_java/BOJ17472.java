package study_boj;

import java.io.*;
import java.util.*;

public class BOJ17472 {

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
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
			return o.cost >= this.cost ? -1 : 1;
		}
	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static PriorityQueue<Edge> pque = new PriorityQueue<Edge>();
	static int[] parent;
	static int island = 0;
	static int bridge_cnt = 0;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		// 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// bfs 이용 - 섬 번호 부여
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					island++;
					bfs(new Point(i, j));
				}
			}
		}

		// 다리 만들기
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					makeBridge(new Point(i, j), map[i][j]);
				}
			}
		}

		// 크루스칼 알고리즘
		parent = new int[island + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		int size = pque.size();
		for (int i = 0; i < size; i++) {
			Edge tmp = pque.poll();

			int a = find(tmp.s);
			int b = find(tmp.e);

			if (a == b)
				continue;

			union(tmp.s, tmp.e);
			result += tmp.cost;
			bridge_cnt++;
		}

		// result == 0 or 다리의 개수가 섬의 개수 - 1이 아닌 경우 -1 출력
		if (result == 0 || bridge_cnt != island - 1) {
			bw.write("-1\n");
		} else {
			bw.write(result + "\n");
		}

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
			parent[x] = y;
		} else {
			return;
		}
	}

	public static void bfs(Point p) {
		Queue<Point> q = new LinkedList<Point>();
		visit[p.x][p.y] = true;
		map[p.x][p.y] = island;
		q.add(p);

		while (!q.isEmpty()) {
			Point temp = q.poll();
			int x = temp.x;
			int y = temp.y;

			for (int i = 0; i < 4; i++) {
				int x2 = x + dx[i];
				int y2 = y + dy[i];

				if (x2 >= 0 && x2 < N && y2 >= 0 && y2 < M && map[x2][y2] == 1 && !visit[x2][y2]) {
					q.add(new Point(x2, y2));
					map[x2][y2] = island;
					visit[x2][y2] = true;
				}
			}

		}
	}

	// 상하좌우 중 한 방향으로 계속 이동, 다른 섬이 나올 때까지 반복
	public static void makeBridge(Point p, int num) {
		int x2 = p.x;
		int y2 = p.y;
		int length = 0;

		for (int i = 0; i < 4; i++) {
			while (true) {
				x2 = x2 + dx[i];
				y2 = y2 + dy[i];

				if (x2 >= 0 && x2 < N && y2 >= 0 && y2 < M) {
					if (map[x2][y2] == num) {
						// 자신과 같은 번호가 나오면
						// 좌표와 length 초기화
						length = 0;
						x2 = p.x;
						y2 = p.y;
						break;
					} else if (map[x2][y2] == 0) {
						length++;
					} else {
						// 1보다 큰 경우 pque에 추가
						if (length > 1) {
							pque.add(new Edge(num, map[x2][y2], length));
						}
						length = 0;
						x2 = p.x;
						y2 = p.y;
						break;
					}
				} else {
					length = 0;
					x2 = p.x;
					y2 = p.y;
					break;
				}
			}
		}
	}
}
