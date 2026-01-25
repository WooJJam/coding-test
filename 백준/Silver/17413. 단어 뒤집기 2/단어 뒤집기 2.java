import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String S = br.readLine();
		solve(S);
	}

	private static void solve(String S) {
		Stack<Character> stack = new Stack<>();
		boolean flag = false;

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);

			if (c == '<') {
				if (!stack.isEmpty()) {
					reverse(stack);
				}
				flag = true;
				System.out.print(c);
				continue;
			}

			if (c == '>') {
				flag = false;
				System.out.print(c);
				continue;
			}

			if (flag) {
				System.out.print(c);
			}

			if (!flag) {
				if (c == ' ') {
					reverse(stack);
					System.out.print(' ');
				} else {
					stack.push(c);
				}

			}
		}

		if (!stack.isEmpty()) {
			reverse(stack);
		}
	}

	private static void reverse(Stack<Character> stack) {

		while (!stack.isEmpty()) {
			Character word = stack.pop();
			System.out.print(word);
		}
	}
}
