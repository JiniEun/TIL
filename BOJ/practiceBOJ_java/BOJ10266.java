package study_boj;
import java.io.*;
import java.util.*;

public class BOJ10266 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] clock1 = new int[720000];
		int[] clock2 = new int[360000];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(st.nextToken());
			clock1[t] = 1;
			clock1[t + 360000] = 1;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			clock2[Integer.parseInt(st.nextToken())] = 1;
		}

		bw.write(KMP(clock1, clock2));

		bw.flush();
		bw.close();
		br.close();
	}

	public static String KMP(int[] t, int[] p) {
		int pi[] = getPi(p);
		int j = 0;
		for (int i = 0; i < t.length; i++) {
			while (j > 0 && t[i] != p[j]) {
				j = pi[j - 1];
			}
			if (t[i] == p[j]) {
				if (j + 1 == p.length) {
					return "possible";
				} else {
					++j;
				}
			}
		}
		return "impossible";
	}

	public static int[] getPi(int[] pattern) {
		int[] pi = new int[pattern.length];
		int j = 0;
		for (int i = 1; i < pattern.length; i++) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = pi[j - 1];
			}
			if (pattern[i] == pattern[j])
				pi[i] = ++j;
		}
		return pi;
	}
}
