package study_boj;
import java.io.*;
import java.util.*;

public class BOJ17404 {
	private static final int INF = 1_000 * 1_000;
	static int N;
	static int[][] house;
	static int[][] dp;
	static int result = INF;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		house = new int[N + 1][3];
		dp = new int[N + 1][3];

		// 입력 값 저장
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// k = 0 -> RED, 1 -> GREEN, 2 -> BLUE
		for (int k = 0; k < 3; k++) {

			for (int i = 0; i < 3; i++) {
				if (i == k) // RED, GREEN, BLUE 색
					dp[1][i] = house[1][i];
				else // 나머지 INF로 초기화
					dp[1][i] = INF;
			}

			for (int i = 2; i <= N; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][2];
			}

			for (int i = 0; i < 3; i++) {
				if (i != k)
					result = Math.min(result, dp[N][i]);
			}
		}

		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
