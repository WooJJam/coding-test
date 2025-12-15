import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String line = br.readLine();
		ArrayList<Character> blank = new ArrayList<>();

		for (int i = 0; i < line.length(); i++) {
			blank.add(line.charAt(i));
		}

		solve(blank);

	}

	private static void solve(ArrayList<Character> blank) {
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		int result = 1;

		for (int i = 0; i < blank.size(); i++) {
			Character c = blank.get(i);
			if (c == '(') {
				stack.push(c);
				result *= 2;
			} else if (c == '[') {
				stack.push(c);
				result *= 3;
			} else {

				if (c == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						answer = 0;
						break;
					}

					if (blank.get(i-1) == '(') {
						answer += result;
					}

					result /= 2;
				}

				if (c == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						answer = 0;
						break;
					}

					if (blank.get(i-1) == '[') {
						answer += result;
					}

					result /= 3;
				}
				stack.pop();
			}
		}

		if (!stack.isEmpty()) {
			answer = 0;
		}

		System.out.println(answer);
	}
}
