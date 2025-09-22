import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	/*
	동그라미된 곳은 무조건 지나야 하니깐..
	1. k가 0일때와 아닐때로 조건 분기
	2-1. k가 0이라면 그냥 dp[N*M] 을 찾는다.
	2-2. k가 0이 아니라면 dp[K] * dp[k ~ N*M]

	dp[i] -> i까지 이동의 가짓수
	dp[i] = dp[i-M] + dp[i-1];
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][M + 1];

		dynamic(N, M, K, dp);
	}

	private static void dynamic(int N, int M, int K, int[][] dp) {

		dp[1][1] = 1;

		if (K == 0) {
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= M; j++) {
					if (i == 1 && j == 1) {
						continue;
					}

					if (i == 0 || j == 0) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					}

				}
			}

			System.out.println(dp[N][M]);
		} else {
			int y = ((K - 1) / M) + 1;
			int x = ((K - 1) % M) + 1;

			// System.out.println(y);
			// System.out.println(x);
			for (int i = 0; i <= y; i++) {
				for (int j = 0; j <= x; j++) {
					if (i == 1 && j == 1) {
						continue;
					}

					if (i == 0 || j == 0) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					}

				}
			}

			for (int i = y; i <= N; i++) {
				for (int j = x; j <= M; j++) {
					if (i == y && j == x) {
						continue;
					}

					if (i == y) {
						dp[i][j] = 1;
					} else if (j == x) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}
				}
			}

			// for (int i = 1; i <= N; i++) {
			// 	for (int j = 1; j <= M; j++) {
			// 		System.out.println("i = " + i + ", j = " + j +", dp = " + dp[i][j]);
			// 	}
			// }

			System.out.println(dp[y][x] * dp[N][M]);

		}
	}

}
