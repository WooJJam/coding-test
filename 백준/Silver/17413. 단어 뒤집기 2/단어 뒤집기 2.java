import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		solve(S);
	}

	private static void solve(String S) {
		StringBuilder out = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		boolean isTag = false;

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);

			if (c == '<') {
				reverse(stack, out);
				isTag = true;
				out.append(c);
				continue;
			}

			if (c == '>') {
				isTag = false;
				out.append(c);
				continue;
			}

			if (isTag) {
				out.append(c);
			} else {
				if (c == ' ') {
					reverse(stack, out);
					out.append(c);
				} else {
					stack.push(c);
				}
			}
		}
		reverse(stack, out);
		System.out.println(out);
	}

	private static void reverse(Stack<Character> stack, StringBuilder out) {

		while (!stack.isEmpty()) {
			Character word = stack.pop();
			out.append(word);
		}
	}
}
