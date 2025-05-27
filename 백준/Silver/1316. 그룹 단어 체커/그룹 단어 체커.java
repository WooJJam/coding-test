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

		boolean[] checker = new boolean[26];

		for (int i = 0; i < input.length() - 1; i++) {
			char first = input.charAt(i);
			char second = input.charAt(i + 1);

			checker[first - 'a'] = true;

			if (!check(first, second, checker)) {
				return;
			}
		}

		answer += 1;
	}

	// 연속된 문자가 같지 않다면 그룹 단어인지 검증해야함
	private static boolean check(char first, char second, boolean[] checker) {
		if (first != second) {
			if (checker[second - 'a']) {
				return false;
			}

			checker[second - 'a'] = true;
		}

		return true;
	}
}
