package study_boj;
import java.io.*;
import java.util.*;

public class BOJ1311 {
	static final int INF = 99999999;
	static int N;
	static int[][] dp;
	static int[][] cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][1 << N];

		bw.write(DP(0, 0) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	static int DP(int now, int flag) {
		if (now == N)
			return 0;
		if (dp[now][flag] != 0)
			return dp[now][flag];

		int result = INF;
		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) == 0)
				result = Math.min(result, cost[now][i] + DP(now + 1, flag | (1 << i)));
		}
		dp[now][flag] = result;
		return dp[now][flag];
	}
}
