import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String words = br.readLine();
			int answer = solve(words);
			System.out.println(answer);
		}
	}

	private static int solve(String words) {

		int left = 0;
		int right = words.length() - 1;

		while (left <= right) {
			if (words.charAt(left) == words.charAt(right)) {
				left++;
				right--;
			} else {
				if (compare(words, left + 1, right) || compare(words, left, right - 1)) { // 둘중에 하나라도 true이면 유사
					return 1;
				} else {
					return 2;
				}
			}
		}
		return 0;
	}

	private static boolean compare(String words, int left, int right) {

		while (left <= right) {
			if (words.charAt(left) == words.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}

		return true;
	}
}
