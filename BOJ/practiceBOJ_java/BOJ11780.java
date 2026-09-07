package study_boj;

import java.io.*;
import java.util.*;

public class BOJ11780 {
	static int[][] map;
	static int[][] dist;
	static int N, M;
	static int INF = 10000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		dist = new int[N + 1][N + 1];
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dist[i][j] = INF;
				if (i != j)
					map[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int cost = Integer.parseInt(input[2]);

			map[start][end] = Math.min(map[start][end], cost);
			dist[start][end] = start;
		}
		floydWarshall();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == INF)
					sb.append(0 + " ");
				else
					sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] == INF)
					sb.append(0 + "\n");

				else {
					int pre = j;
					stack.push(j);
					while (i != dist[i][pre]) {
						pre = dist[i][pre];
						stack.push(pre);
					}
					sb.append((stack.size() + 1) + " ");
					sb.append(i + " ");
					while (!stack.empty())
						sb.append(stack.pop() + " ");
					sb.append("\n");
				}
			}
		}
		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

	public static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						dist[i][j] = dist[k][j];
					}
				}
			}
		}
	}
}
