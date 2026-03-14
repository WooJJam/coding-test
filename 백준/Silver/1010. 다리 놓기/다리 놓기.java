import java.io.*;
import java.util.*;

public class Main {

	static int[][] dp = new int[31][31];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			init(M);
			System.out.println(dp[M][N]);
		}
	}

	private static void init(int M) {

		dp[1][0] = 1;
		dp[1][1] = 1;

		for (int i = 2; i <= M; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
	}
}
