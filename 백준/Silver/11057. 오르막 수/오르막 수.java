import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static boolean[] selected;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		dynamic(N);
	}

	private static void dynamic(int N) {

		int[][] dp = new int[1_001][10];

		for (int i = 0; i < 10; i++) {
			dp[0][i] = i + 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10_007;
				}
			}
		}

		System.out.println(dp[N-1][9]);
	}
}
