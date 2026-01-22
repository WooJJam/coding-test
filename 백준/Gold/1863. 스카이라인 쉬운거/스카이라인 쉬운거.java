import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<int[]> skylines = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			skylines.add(new int[] {x, y});
		}

		solve();
	}

	private static void solve() {

		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		int answer = 0;

		for (int[] skyline : skylines) {
			int y = skyline[1];

			if (stack.peek() < y) {
				stack.add(y);
			} else if (stack.peek() > y) {
				while (!stack.isEmpty() && stack.peek() > y) {
					stack.pop();
					answer++;
				}

				if (stack.peek() < y) {
					stack.add(y);
				}
			}
		}

		while (!stack.isEmpty() && stack.peek() != 0) {
			stack.pop();
			answer += 1;
		}

		System.out.println(answer);
	}
}
