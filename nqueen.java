// BOJ 9663
import java.util.Scanner;
 
public class Main {
	public static int N;
	public static int[] arr;
	public static int result = 0;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		sc.close();
		nQueen(0);
		System.out.println(result);
	}
 
	public static void nQueen(int depth) {
	
		if (depth == N) {	// 모든 원소가 채워진 상태 경우 result 증가, return 
			result++;
			return;
		}
 
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			if (Possibility(depth)) { // 퀸을 놓을 수 있는 위치의 경우 재귀호출
				nQueen(depth + 1);
			}
		}
	}
 
	public static boolean Possibility(int col) {
 
		for (int i = 0; i < col; i++) {
			
			if (arr[col] == arr[i]) {    // 같은 행에 존재할 경우
				return false;
			} else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			} // 대각선상에 놓여있는 경우
			 // (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우
		}
		
		return true;
	}
}
