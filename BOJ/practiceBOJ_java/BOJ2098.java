package study_boj;
import java.util.*;
import java.io.*;

public class BOJ2098 {
	static final int INF = 16000000;
	static int N; // 도시의 수
	static int[][] W, dp; // W:비용 행렬

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		dp = new int[N][(1 << N) - 1];

		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], INF);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				W[i][j] = cost;
			}
		}

		bw.write(dfs(0, 1) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	public static int dfs(int node, int visit) {

		if (visit == (1 << N) - 1) {	// 모든 지점 방문
			if (W[node][0] == 0)
				return INF;
			return W[node][0];
		}

		if (dp[node][visit] != INF) {	// 이미 계산
			return dp[node][visit];
		}

		for (int i = 0; i < N; i++) {
			if ((visit & (1 << i)) == 0 && W[node][i] != 0) { // 방문한 적 없음
				dp[node][visit] = Math.min(dp[node][visit], dfs(i, visit | (1 << i)) + W[node][i]);
			}
		}

		return dp[node][visit];
	}
}