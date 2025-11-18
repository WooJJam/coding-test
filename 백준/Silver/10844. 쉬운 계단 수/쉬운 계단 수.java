import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		dynamic(N);

	}

	private static void dynamic(int N) {

		long[][] dp = new long[100][10];

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], 1);
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][1] % 1_000_000_000;
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][j - 1] % 1_000_000_000;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
				}
			}
		}

		System.out.println((Arrays.stream(dp[N - 1]).sum() - dp[N - 1][0]) % 1_000_000_000) ;

	}
}
