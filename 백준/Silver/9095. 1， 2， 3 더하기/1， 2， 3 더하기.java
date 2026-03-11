import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int[] dp = init();

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}

	private static int[] init() {

		int[] dp = new int[12];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < 12; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}

		return dp;
	}
}
