package study_boj;

import java.io.*;
import java.util.*;

public class BOJ20149 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Point[] point = new Point[4];

		int x1, y1, x2, y2, x3, y3, x4, y4;

		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		x3 = Integer.parseInt(st.nextToken());
		y3 = Integer.parseInt(st.nextToken());
		x4 = Integer.parseInt(st.nextToken());
		y4 = Integer.parseInt(st.nextToken());

		point[0] = new Point(x1, y1);
		point[1] = new Point(x2, y2);
		point[2] = new Point(x3, y3);
		point[3] = new Point(x4, y4);

		bw.write(solve(point) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	public static String solve(Point[] p) {
		StringBuilder sb = new StringBuilder();

		int p123 = ccw(p[0], p[1], p[2]);
		int p124 = ccw(p[0], p[1], p[3]);
		int p341 = ccw(p[2], p[3], p[0]);
		int p342 = ccw(p[2], p[3], p[1]);
		int S12 = p123 * p124;
		int S34 = p341 * p342;

		if (S12 <= 0 && S34 < 0 || S12 < 0 && S34 <= 0) {
			sb.append(1).append('\n');
			String T1 = getSlope(p[0], p[1]), T2 = getSlope(p[2], p[3]);
			double x, y;
			if (T1.equals("INF")) {
				x = p[0].x;
				double sl2 = Double.parseDouble(T2);
				y = sl2 * (x - p[2].x) + p[2].y;
			} else if (T2.equals("INF")) {
				x = p[2].x;
				double sl1 = Double.parseDouble(T1);
				y = sl1 * (x - p[0].x) + p[0].y;
			} else {
				double sl1 = Double.parseDouble(T1), sl2 = Double.parseDouble(T2);
				x = (sl1 * p[0].x - sl2 * p[2].x + p[2].y - p[0].y) / (sl1 - sl2);
				y = sl1 * (x - p[0].x) + p[0].y;
			}
			sb.append(x).append(' ').append(y);
		} else if (S12 == 0 && S34 == 0) {
			if (p123 == 0 && p124 == 0 && p341 == 0 && p342 == 0) {
				int n = isCrossed(p);
				if (n > 0)
					sb.append(1);
				else
					sb.append(0);

				if (n == 2) {
					sb.append('\n');
					if (p[0].x == p[2].x && p[0].y == p[2].y || p[0].x == p[3].x && p[0].y == p[3].y)
						sb.append(p[0].x).append(' ').append(p[0].y);
					else if (p[1].x == p[2].x && p[1].y == p[2].y || p[1].x == p[3].x && p[1].y == p[3].y)
						sb.append(p[1].x).append(' ').append(p[1].y);
				}
			} else {
				sb.append(1).append('\n');
				if (p[0].x == p[2].x && p[0].y == p[2].y || p[0].x == p[3].x && p[0].y == p[3].y)
					sb.append(p[0].x).append(' ').append(p[0].y);
				else if (p[1].x == p[2].x && p[1].y == p[2].y || p[1].x == p[3].x && p[1].y == p[3].y)
					sb.append(p[1].x).append(' ').append(p[1].y);
			}
		} else
			sb.append(0);

		return sb.toString();
	}

	public static int ccw(Point p1, Point p2, Point p3) {
		// CCW 공식 (x1y2+x2y3+x3y1)−(y1x2+y2x3+y3x1)
		long result = ((long)p1.x * p2.y + (long)p2.x * p3.y + (long)p3.x * p1.y) - ((long)p1.y * p2.x + (long)p2.y * p3.x + (long)p3.y * p1.x);
		if (result == 0) // 일직선
			return 0;
		return result > 0 ? 1 : -1;
	}

	private static String getSlope(Point p1, Point p2) {
		if (p1.x == p2.x)
			return "INF";
		double s = ((double) p2.y - p1.y) / (p2.x - p1.x);
		return String.valueOf(s);
	}

	public static int isCrossed(Point[] p) {
		int A, B, C, D;
		if (p[0].x == p[1].x) {
			A = Math.min(p[0].y, p[1].y);
			B = Math.max(p[0].y, p[1].y);
			C = Math.min(p[2].y, p[3].y);
			D = Math.max(p[2].y, p[3].y);
		} else {
			A = Math.min(p[0].x, p[1].x);
			B = Math.max(p[0].x, p[1].x);
			C = Math.min(p[2].x, p[3].x);
			D = Math.max(p[2].x, p[3].x);
		}

		if (A == D || B == C)
			return 2;
		else if (A < D && C < B)
			return 1;
		else
			return 0;
	}
}