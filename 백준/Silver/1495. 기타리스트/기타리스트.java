import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main {

	/*
	N : 곡의 개수
	S : 시작 볼륨
	M : 최대 볼륨

	dp[i][j] = i번째 곡에 대한 j 볼륨 가능 여부
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] V = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}

		solve(V, N, S, M);

	}

	/*
	dp[0][S] = true

	for (i) {
		for (j) {
			j - V[i] >= 0 --> dp[i][j - V[i]]] = true
			j + V[i] <= M --> dp[i][j + V[i]] = true
		}
	}
	 */
	private static void solve(int[] V, int N, int S, int M) {

		boolean[][] dp = new boolean[N+1][M+1];

		dp[0][S] = true;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (!dp[i-1][j]) {
					continue;
				}

				if (j - V[i-1] >= 0) {
					dp[i][j - V[i-1]] = true;
				}

				if (j + V[i-1] <= M) {
					dp[i][j + V[i-1]] = true;
				}
			}
		}

		for (int i = M; i >= 0; i--) {
			if (dp[N][i]) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(-1);
	}

}
