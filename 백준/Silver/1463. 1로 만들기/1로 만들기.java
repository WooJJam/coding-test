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

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int size = (int)Math.pow(10, 6);
		int[] dp = new int[size + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[N] = 0;

		dynamic(N, dp);

		System.out.println(dp[1]);
	}

	private static void dynamic(int N, int[] dp) {

		for (int i = N; i > 0 ; i--) {

			if (i % 3 == 0) { // 3으로 나누기
				dp[i / 3] = Math.min(dp[i / 3], dp[i]  + 1);
			}

			if (i % 2 == 0) { // 2로 나누기
				dp[i / 2] = Math.min(dp[i / 2], dp[i]  + 1);
			}

			dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
		}

	}
}
