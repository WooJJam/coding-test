import java.io.*;
import java.util.*;

public class Main {

	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			solve(input);
		}

		System.out.println(answer);

	}

	private static void solve(String input) {

		Map<Character, Boolean> checker = new HashMap<>();

		for (char i = 'a'; i <= 'z'; i++) {
			checker.put(i, false);
		}

		for (int i = 0; i < input.length() - 1; i++) {
			char first = input.charAt(i);
			char second = input.charAt(i + 1);

			checker.put(first, true);

			// 연속된 문자가 같지 않다면 그룹 단어인지 검증해야함
			if (first != second) {
				if (checker.get(second)) {
					return;
				}

				checker.put(second, true);
			}

		}

		answer += 1;
	}
}
