package study_boj;
import java.io.*;

public class BOJ4354 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String ptn;
		StringBuilder sb = new StringBuilder();
		while(!(ptn = br.readLine()).equals(".")) {
			int max = getMaxPi(ptn);
			sb.append(max).append("\n");
		}
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	// pi배열의 최댓값 구하기 
	static int getMaxPi(String ptn) {
		int j = 0;
		int len = ptn.length();
		int[] pi = new int[len];
		
		for(int i = 1; i < len; i++) {
			while(j > 0 && ptn.charAt(i) != ptn.charAt(j)) {
				j = pi[j - 1];
			}
			if(ptn.charAt(i) == ptn.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return len % (len - pi[len - 1]) != 0 ? 1 : len / (len - pi[len - 1]);
	}
}