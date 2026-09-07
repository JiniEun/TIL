package study_boj;
import java.io.*;
import java.util.*;

public class BOJ1069 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		double dist = Math.sqrt(x * x + y * y);
		double result = dist;

		if (t > d) {
			bw.write(dist + "\n");
		} else {
			int jump = (int) (dist / d);

			double time = dist - d * jump;

			result = Math.min(result, time + t * jump);

			result = Math.min(result, d * (jump + 1) - dist + t * (jump + 1));

			if (jump > 0)
				result = Math.min(result, (double) (jump + 1) * t);
			else if (dist < d)
				result = Math.min(result, t * 2.0);

			bw.write(result + "\n");
		}
		bw.write(String.format("%.3f", result));

		bw.flush();
		bw.close();
		br.close();
	}
}
