package study_boj;
import java.io.*;
import java.util.*;

public class BOJ14725 {
	static StringBuilder sb;

	public static class Trie {
		// 이름, 자식 저장
		ArrayList<Trie> list;
		String name;

		Trie(String name) {
			list = new ArrayList<>();
			this.name = name;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Trie trie = new Trie("");
		Trie node;

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			node = trie;

			while (k-- > 0) {
				String name = st.nextToken();
				int idx = -1;

				for (int i = 0; i < node.list.size(); i++) {
					if (node.list.get(i).name.equals(name)) {
						idx = i;
						break;
					}
				}

				if (idx == -1) {
					// 현재 노드의 list에 name 추
					// 노드 추가한 변수의 위치로 이동
					node.list.add(new Trie(name));
					node = node.list.get(node.list.size() - 1);
				} else {
					// 자식으로 이
					node = node.list.get(idx);
				}
			}
		}

		print(trie, -1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void print(Trie trie, int depth) {
		// 재귀 형식
		// 현재 노드의 list를 이름 순으로 정렬하고 현재 노드의 name을 StringBuilder에 추가
		// list의 값에 차례대로 접근하여 dfs
		Collections.sort(trie.list, new Comparator<Trie>() {
			@Override
			public int compare(Trie o1, Trie o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		if (depth != -1) {
			for (int i = 0; i < depth; i++) {
				sb.append("--");
			}
			sb.append(trie.name).append("\n");
		}

		for (Trie tr : trie.list) {
			print(tr, depth + 1);
		}
	}
}
