import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main { ;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dynamic(N, board);

	}

	private static void dynamic(int N, int[][] board) {

		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				int cur = board[i][j];

				if (dp[i][j] == 0 || cur == 0) {
					continue;
				}

				// 아래 쪽으로 이동
				if (i + cur < N) {
					dp[i + cur][j] += dp[i][j];
				}

				// 오른쪽으로 이동
				if (j + cur < N) {
					dp[i][j + cur] += dp[i][j];
				}

			}
		}

		System.out.println(dp[N-1][N-1]);
	}
}
