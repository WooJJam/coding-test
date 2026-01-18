import java.io.*;
import java.util.*;

public class Main {

	static Stack<Integer> stack = new Stack<>();
	static int order = 1;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int human  = Integer.parseInt(st.nextToken());
			solve(human);
		}

		while(!stack.isEmpty()) {
			if (stack.peek() == order) {
				stack.pop();
				order++;
			} else {
				break;
			}
		}

		System.out.println(order - 1 != N ? "Sad" : "Nice");
	}

	private static void solve(int human) {
		// System.out.println(stack);
		// System.out.println(order);
		if (human == order) {
			order ++;
		}
		else {
			while (!stack.isEmpty()) {
				if (stack.peek() == order) {
					stack.pop();
					order++;
				} else {
					break;
				}
			}

			stack.push(human);
		}
	}
}
