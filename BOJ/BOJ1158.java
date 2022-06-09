import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();

		StringBuilder sb = new StringBuilder();

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		sb.append("<");

		for (int i = 1; i < N + 1; i++) {
			queue.offer(i);
		}
		while (queue.size() != 1) {
			for (int i = 0; i < K - 1; i++) {
				queue.offer(queue.poll());
			}

			sb.append(queue.poll()).append(", ");
		}
		sb.append(queue.poll()).append(">");

		System.out.println(sb.toString());
	}
}