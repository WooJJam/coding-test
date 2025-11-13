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

		int[] s = new int[N];

		for (int i = 0; i < N; i++) {
			s[i] = Integer.parseInt(br.readLine());
		}

		if (N == 1) {
			System.out.println(s[0]);
		} else if (N == 2) {
			System.out.println(s[0] + s[1]);
		} else {
			dynamic(N, s);
		}

	}

	private static void dynamic(int N, int[] s) {

		int[] dp = new int[301];

		dp[0] = 0;
		dp[1] = s[0];
		dp[2] = dp[1] + s[1];

		for (int i = 2; i < N; i++) {
			dp[i + 1] = Math.max(dp[i - 2] + s[i - 1] + s[i], dp[i - 1] + s[i]);
		}

		System.out.println(dp[N]);
	}
}
