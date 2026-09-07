package study_boj;
import java.io.*;

public class BOJ2482 {
	private static final int MOD = 1_000_000_003;
	static int N, K;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		dp = new int[N + 1][N + 1];

		// dp 초기화
		for (int i = 1; i <= N; i++) {
			dp[i][1] = i;
			dp[i][0] = 1;
		}

		for (int i = 3; i <= N; i++) {
			for (int j = 2; j <= (i + 1) / 2; j++) {
				// i번째 색을 선택하지 않은 경우 + i번째 색을 선택한 경우
				dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
			}
		}

		bw.write((dp[N - 3][K - 1] + dp[N - 1][K]) % MOD + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}