package study_boj;

import java.util.*;
import java.io.*;

public class BOJ2213 {
	static int N;
	static int[] dp, arr, select;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static PriorityQueue<Integer> pque = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		dp = new int[N + 1];
		select = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			tree.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		buildTree(1, -1);

		int t1 = dp(1, 0);
		int t2 = dp(1, 1);

		if (t1 > t2) {
			select[1] = 0;
		} else {
			select[1] = 1;
		}
		sb.append(String.valueOf(Math.max(t1, t2))).append("\n");

		findNode(1, select[1]);

		while (!pque.isEmpty()) {
			sb.append(pque.poll()).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static int dp(int now, int node) {
		int result = 0;

		if (node == 1) {
			for (int next : tree.get(now)) {
				result += dp(next, 0);

			}
			return result + arr[now];
		} else {
			for (int next : tree.get(now)) {
				int t1 = dp(next, 0);
				int t2 = dp(next, 1);

				if (t1 > t2) {
					select[next] = 0;
				} else {
					select[next] = 1;
				}
				result += Math.max(t1, t2);
			}
			return result;
		}
	}

	static void buildTree(int now, int p) {
		for (int child : list.get(now)) {
			if (child != p) {
				tree.get(now).add(child);
				buildTree(child, now);
			}
		}
	}

	static void findNode(int now, int node) {
		if (node == 0) {
			for (int next : tree.get(now)) {
				findNode(next, select[next]);
			}
		} else if (node == 1) {
			pque.offer(now);
			for (int next : tree.get(now)) {
				findNode(next, 0);
			}
		}
	}
}
