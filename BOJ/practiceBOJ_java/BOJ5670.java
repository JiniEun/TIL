package study_boj;
import java.io.*;
import java.util.*;

public class BOJ5670 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String str;

		while ((str = br.readLine()) != null) {
			int N = Integer.valueOf(str);
			List<String> list = new ArrayList<String>();
			Trie trie = new Trie();
			double answer = 0;

			for (int i = 0; i < N; i++) {
				String word = br.readLine(); // 입력 받기
				list.add(word);
				trie.insert(word);
			}

			for (String l : list) {
				answer += trie.contains(l);
			}

			// 평균 출력
			sb.append(String.format("%.2f", answer / N)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static class Trie {
		public TrieNode root;

		Trie() {
			this.root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode tempNode = this.root;

			for (int i = 0; i < word.length(); i++) {
				tempNode = tempNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}

			tempNode.setLastChar(true);
		}

		public int contains(String word) { // 존재 여부
			TrieNode tempNode = this.root;
			int cnt = 1;

			tempNode = tempNode.getChildNodes().get(word.charAt(0));

			for (int i = 1; i < word.length(); i++) {
				if (tempNode.getChildNodes().size() >= 2) {
					cnt++;
				}

				else if (tempNode.getChildNodes().size() == 1 && tempNode.isLastChar()) {
					cnt++;
				}

				char ch = word.charAt(i);
				TrieNode node = tempNode.getChildNodes().get(ch);

				tempNode = node;
			}

			return cnt;
		}
	}

	static class TrieNode {
		private Map<Character, TrieNode> childNode = new HashMap<>();
		private boolean isLastChar;

		public boolean isLastChar() { // 마지막 문자 확인
			return this.isLastChar;
		}

		public void setLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}

		public Map<Character, TrieNode> getChildNodes() {
			return this.childNode;
		}
	}
}
