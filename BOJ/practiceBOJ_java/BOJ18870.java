package study_boj;
import java.io.*;
import java.util.*;

public class BOJ18870 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int[] sort_n = numbers.clone();
		Arrays.sort(sort_n);

		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		for (int n : sort_n)
			if (!map.containsKey(n))
				map.put(n, idx++);

		for (int n : numbers)
			sb.append(map.get(n)).append(' ');

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}
}
