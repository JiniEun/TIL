//  BOJ N.14888
import java.util.Scanner;
 
public class Main {
 
	public static int MAX = Integer.MIN_VALUE;	// 최댓값 
	public static int MIN = Integer.MAX_VALUE;	// 최솟값 
	public static int[] oper = new int[4];	    // 연산자 개수 
	public static int[] nums;					// 숫자 
	public static int N;						// 숫자 개수 
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		N = sc.nextInt();
		nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
 
		for (int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();
		}
		dfs(nums[0], 1);
		sc.close();
		System.out.println(MAX);
		System.out.println(MIN);

	}
 
	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {

			if (oper[i] > 0) {
 
				oper[i]--;
 
				switch (i) {
				    case 0:	dfs(num + nums[idx], idx + 1);	break;
				    case 1:	dfs(num - nums[idx], idx + 1);	break;
				    case 2:	dfs(num * nums[idx], idx + 1);	break;
				    case 3:	dfs(num / nums[idx], idx + 1);	break;
				}
				oper[i]++;
			}
		}
	}
}
