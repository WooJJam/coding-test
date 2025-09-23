import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		dynamic(N);
	}

	/*
	N = 3

	N = 1 -> 1
	N = 2 -> 10
	N = 3 -> 100, 101
	N = 4 -> 1000, 1001, 1010
	N = 5 -> 10000, 10001, 10100, 10010, 10101
	dp[i] = dp[i-1] + dp[i-2]
	 */
	private static void dynamic(int N) {

		long[] dp = new long[91];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		System.out.println(dp[N]);
	}

}
