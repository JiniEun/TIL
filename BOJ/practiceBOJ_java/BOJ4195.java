package study_boj;

import java.io.*;
import java.util.*;

public class BOJ4195 {
	static int[] parent;
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int F = Integer.parseInt(br.readLine());

			parent = new int[F * 2];
			cnt = new int[F * 2];

			for (int i = 0; i < F * 2; i++) {
				parent[i] = i;
				cnt[i] = 1;
			}

			int idx = 0;
			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();

				if (!map.containsKey(f1)) {
					map.put(f1, idx++);
				}

				if (!map.containsKey(f2)) {
					map.put(f2, idx++);
				}

				sb.append(union(map.get(f1), map.get(f2)) + "\n");
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
	public static int union(int x, int y) {
		x = find(x);
		y = find(y);

		// 항상 x < y인 값이 들어온다고 가정
		if (x != y) {
			parent[y] = x;
			cnt[x] += cnt[y]; // y에 있던 층의 개수를 더해 줌.

			cnt[y] = 1;
		}
		return cnt[x];
	}
}
