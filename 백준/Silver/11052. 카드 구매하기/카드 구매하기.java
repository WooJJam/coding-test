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
		int[] card = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		dynamic(N, card);
	}

	private static void dynamic(int N, int[] card) {

		int[] dp = new int[1_001];

		dp[0] = 0;
		dp[1] = card[0];

		for (int i = 2; i <= N; i++) {
			dp[i] = card[i - 1];
			for (int j = 0; j < i; j++) {
				dp[i] = Math.max(dp[i], card[i - j - 1] + dp[j]);
			}
		}

		System.out.println(dp[N]);
	}
}
