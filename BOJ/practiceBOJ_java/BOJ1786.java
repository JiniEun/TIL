package study_boj;
import java.io.*;
import java.util.*;

public class BOJ1786 {
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String T = br.readLine();
		String P = br.readLine();

		list = new ArrayList<Integer>();
		KMP(T, P);

		bw.write(list.size() + "\n");
		for (int l : list) {
			bw.write(l + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void KMP(String o, String p) {
		int pi[] = getPi(p);
		int j = 0;
		for (int i = 0; i < o.length(); i++) {
			while (j > 0 && o.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			if (o.charAt(i) == p.charAt(j)) {
				if (j + 1 == p.length()) {
					list.add(i - p.length() + 2);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
	}

	public static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j))
				pi[i] = ++j;
		}
		return pi;
	}
}
