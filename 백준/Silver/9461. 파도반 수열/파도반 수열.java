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

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			dynamic(N);
		}

	}

	private static void dynamic(int N) {

		long[] dp = new long[101];

		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i-3] + dp[i-2];
		}

		System.out.println(dp[N]);
	}
}
