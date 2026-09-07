package study_boj;

import java.io.*;
import java.util.*;

public class BOJ3584 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			parent = new int[N + 1];
			ArrayList<Integer>[] list = new ArrayList[N + 1];

			for (int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());

				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				parent[c] = p;
				list[p].add(c);
			}
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			int u_depth = getDepth(u);
			int v_depth = getDepth(v);

			bw.write(LCA(u, u_depth, v, v_depth) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static int getDepth(int i) {
		int cnt = 0;
		int now = i;
		while (now != 0) {
			cnt++;
			now = parent[now];
		}
		return cnt - 1;
	}

	public static int LCA(int x, int x_depth, int y, int y_depth) {
		// 깊이가 같아지게 한다.
		if (x_depth > y_depth) {
			while (x_depth != y_depth) {
				x_depth--;
				x = parent[x];
			}
		} else if (x_depth < y_depth) {
			while (x_depth != y_depth) {
				y_depth--;
				y = parent[y];
			}
		}
		while (x != y) {
			x = parent[x];
			y = parent[y];
		}

		return x;
	}
}
