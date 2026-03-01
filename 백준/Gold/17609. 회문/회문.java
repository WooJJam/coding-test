import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String words = br.readLine();
			int answer = solve(words, 0, words.length() -1, 0);
			System.out.println(answer);
		}
	}

	private static int solve(String words, int left, int right, int count) {

		while (left <= right) {
			if (words.charAt(left) == words.charAt(right)) {
				left++;
				right--;
			} else {
				if (count >= 1) {
					return 2;
				}

				count++;

				int leftDeleted = solve(words, left + 1, right, count);
				int rightDeleted = solve(words, left, right - 1, count);

				return Math.min(leftDeleted, rightDeleted);
			}
		}

		return count;
	}
}
