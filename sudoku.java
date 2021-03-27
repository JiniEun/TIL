import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static int[][] arr = new int[9][9];
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 분리 StringTokenizer 이용
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0, 0);
	}
 
	public static void sudoku(int row, int col) {

		// 현재 row가 다 채워진 경우, 다음 row의 첫 col부터 시작
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}
 
		// row, col 다 채워진 경우 출력 후, 종료
		if (row == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
 
		// 1부터 9까지 중 가능한 수 탐색
		if (arr[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (Check(row, col, i)) {    // i 값 중복 검사
					arr[row][col] = i;
					sudoku(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}
		sudoku(row, col + 1); // 다음 열 재귀 호출
	}
 
	public static boolean Check(int row, int col, int value) {
 
		// 같은 행에 겹치는 열 원소 검사
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == value) {
				return false;
			}
		}
 
		// 같은 열에 겹치는 행 원소 검사
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == value) {
				return false;
			}
		}
 
		// 3*3 칸 중복 검사
		int set_row = (row / 3) * 3;
		int set_col = (col / 3) * 3;
 
		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (arr[i][j] == value) {
					return false;
				}
			}
		}
		return true; // 중복되는 것이 없을 경우
	}
 
}
