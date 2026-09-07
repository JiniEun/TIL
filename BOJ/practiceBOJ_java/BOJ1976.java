package study_boj;
import java.io.*;
import java.util.*;

public class BOJ1976 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int map = Integer.parseInt(st.nextToken());

				// 연결된 부분은 합집합 연산함.
				if (map == 1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			int idx = Integer.parseInt(st.nextToken());

			if (start != find(idx)) {
				bw.write("NO\n");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
		}

		bw.write("YES\n");
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
