import java.io.*;

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;


		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			int[][] a = new int[2][N+1];
			int[][] dp = new int[2][N+1];

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				int point = Integer.parseInt(st.nextToken());
				a[0][j] = point;
			}

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				int point = Integer.parseInt(st.nextToken());
				a[1][j] = point;
			}

			bw.write(dynamic(a, dp, N)+"\n");

		}


		bw.flush();
		bw.close();
	}

	static int dynamic(int[][] a, int[][] dp, int N) {

		dp[0][0] = 0;
		dp[1][0] = 0;
		dp[0][1] = a[0][0];
		dp[1][1] = a[1][0];

		for (int i = 2; i <= N; i++) {
			dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + a[0][i-1];
			dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + a[1][i-1];
		}

		return Math.max(dp[0][N], dp[1][N]);

	}

}
