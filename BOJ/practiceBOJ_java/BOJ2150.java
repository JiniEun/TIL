package study_boj;

import java.io.*;
import java.util.*;

public class BOJ2150 {
	static int V, E, size, num;
	static ArrayList<Integer>[] graph, result;
	static int[] order;
	static boolean[] visit; // SCC 확정된 정점 확인
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수

		graph = new ArrayList[V + 1];
		result = new ArrayList[V + 1];

		for (int i = 0; i < V + 1; i++) {
			graph[i] = new ArrayList<>();
			result[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
		}
		
		order = new int[V + 1];
		visit = new boolean[V + 1];
		size = 0;
		num = 0;
		stack = new Stack<>();

		for (int i = 1; i < V + 1; i++) {
			if (order[i] == 0)
				SCC(i);
		}
		sb.append(size + "\n");

		for (int i = 0; i < V + 1; i++) {
			int s = result[i].size();
			// 2^K 번째 조상 노드 저장
			if (s > 0) {
				for (int j = 0; j < s; j++) {
					sb.append(result[i].get(j) + " ");
				}
				sb.append("-1\n");
			}
		}
		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	private static int SCC(int idx) {
		order[idx] = ++num;
		stack.add(idx);
		int root = order[idx];

		for (int i = 0; i < graph[idx].size(); i++) {
			int temp = graph[idx].get(i);
			if (order[temp] == 0)
				root = Math.min(root, SCC(temp));
			else if (!visit[temp])
				root = Math.min(root, order[temp]);
		}

		if (root == order[idx]) {
			ArrayList<Integer> tempArr = new ArrayList<>();
			while (true) {
				int top = stack.pop();
				tempArr.add(top);
				visit[top] = true;
				if (top == idx)
					break;
			}
			Collections.sort(tempArr);
			int min = Collections.min(tempArr);
			result[min] = tempArr;
			size++;
		}
		return root;
	}
}
