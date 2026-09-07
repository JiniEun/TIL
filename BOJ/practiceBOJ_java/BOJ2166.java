package study_boj;

import java.util.*;
import java.io.*;

public class BOJ2166 {
	static class Point {
		long x, y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Point[] point = new Point[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());

			point[i] = new Point(x, y);
		}
		long result = 0;
		for (int i = 0; i < N - 1; i++) {
			result += (point[i].x * point[i + 1].y) - (point[i + 1].x * point[i].y);
		}
		result += (point[N - 1].x * point[0].y) - (point[0].x * point[N - 1].y);

		bw.write(String.format("%.1f", (Math.abs(result) / 2.0)) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
