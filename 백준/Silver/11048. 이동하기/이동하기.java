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
		int M = Integer.parseInt(st.nextToken());

		int[][] miro = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dynamic(N, M, miro);
	}

	private static void dynamic(int N, int M, int[][] miro) {

		int[][] dp = new int[N][M];
		dp[0][0] = miro[0][0];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i + 1 < N) { // 아래로 이동 가능
					dp[i+1][j] = Math.max(dp[i][j] + miro[i+1][j], dp[i+1][j]);
				}

				if (i + 1 < N && j + 1 < M) {// 대각선으로 이동 가능
					dp[i+1][j+1] = Math.max(dp[i][j] + miro[i+1][j+1], dp[i+1][j+1]);
				}

				if (j + 1 < M) {
					dp[i][j+1] = Math.max(dp[i][j] + miro[i][j+1], dp[i][j+1]);
				}
			}
		}

		System.out.println(dp[N-1][M-1]);
	}
}
