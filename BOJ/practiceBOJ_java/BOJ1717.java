package study_boj;

import java.io.*;
import java.util.*;

public class BOJ1717 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (cmd == 0) {
				union(a, b);
			} else if (cmd == 1) {
				sb.append((isSameParent(a, b) ? "YES" : "NO") + "\n");
			}
		}

		bw.write(sb.toString());
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
			} 
			else {
				parent[x] = y;
			}
		}
	}

	// x, y 부모가 같은지 확인
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return true;

		return false;
	}

}
