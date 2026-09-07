package study_boj;
import java.io.*;

public class BOJ1305 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		// KMP 알고리즘
		// 접두사&접미사 동일한 문자열 최대 길이 구하기
		int[] pi = getLastPi(str);
		bw.write(N - pi[N - 1] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	// pi배열 최대 패턴의 길이 구하기
	static int[] getLastPi(String ptn) {
		int j = 0;
		int len = ptn.length();
		int[] pi = new int[len];

		for (int i = 1; i < len; i++) {
			while (j > 0 && ptn.charAt(i) != ptn.charAt(j)) {
				j = pi[j - 1];
			}
			if (ptn.charAt(i) == ptn.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}
