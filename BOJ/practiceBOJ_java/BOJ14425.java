package study_boj;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ14425 {
	public static class Node {
		Node[] child = new Node[26];
		boolean is_last;

		public Node() {
		};
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Node root = new Node();

		while (N-- > 0) {
			String str = br.readLine();
			Node cur = root;
			for (int i = 0; i < str.length(); i++) {
				char cha = str.charAt(i);
				if (cur.child[cha - 'a'] == null)
					cur.child[cha - 'a'] = new Node();
				cur = cur.child[cha - 'a'];

				if (i == str.length() - 1)
					cur.is_last = true;
			}
		}

		int answer = 0;
		while (M-- > 0) {
			String str = br.readLine();
			Node cur = root;
			for (int i = 0; i < str.length(); i++) {
				char cha = str.charAt(i);
				if (cur.child[cha - 'a'] == null)
					break;
				cur = cur.child[cha - 'a'];

				if (i == str.length() - 1 && cur.is_last)
					answer++;
			}
		}

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
