package study_boj;

import java.io.*;
import java.util.*;

public class BOJ20040 {
	static int[] parent;
	static int N, M, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N];

		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (!union(a, b)) {
				result = i;
				break;
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

	// y 부모를 x 부모로 치환하기 
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;
		parent[y] = x;
		return true;
	}
}
