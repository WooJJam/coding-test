import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		solve(N, K);
	}

	private static void solve(int N, int K) {
		int[][] dp = new int[1_001][1_001];

		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10_007;
				}
			}
		}

		System.out.println(dp[N][K]);
	}
}
