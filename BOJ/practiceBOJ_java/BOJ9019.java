package study_boj;

import java.util.*;
import java.io.*;

public class BOJ9019 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
		int T = Integer.parseInt(br.readLine());
        
		while(T-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			String[] cmd = new String[10000]; // 정답 담는곳
			boolean[] visit = new boolean[10000]; // BFS 탐색의 방문 여부 체크
			Queue<Integer> queue = new LinkedList<>();
			
			visit[A] = true;
			queue.add(A);
			Arrays.fill(cmd, "");
			
			while(!queue.isEmpty() && !visit[B]) {
				int now = queue.poll();
				int D = (2 * now) % 10000;
				int S = (now == 0) ? 9999 : now-1 ;
				int L = (now % 1000) * 10 + now/1000;
				int R = (now % 10) * 1000 + now/10;    
				
				if(!visit[D]) {
					queue.add(D);
					visit[D] = true;
					cmd[D] = cmd[now]+"D";
				}
				if(!visit[S]) {
					queue.add(S);
					visit[S] = true;
					cmd[S] = cmd[now]+"S";
				}
				if(!visit[L]) {
					queue.add(L);
					visit[L] = true;
					cmd[L] = cmd[now]+"L";
				}
				if(!visit[R]) {
					queue.add(R);
					visit[R] = true;
					cmd[R] = cmd[now]+"R";
				}
			}
			bw.write(cmd[B] + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
