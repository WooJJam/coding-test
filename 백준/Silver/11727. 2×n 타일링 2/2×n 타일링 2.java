import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1_001];

		solve(N, dp);
	}

	private static void solve(int N, int[] dp) {
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1] + (2 * dp[i-2])) % 10_007;
		}

		System.out.println(dp[N]);
	}
}
