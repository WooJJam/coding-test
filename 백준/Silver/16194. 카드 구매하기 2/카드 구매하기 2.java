import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main {

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

	/*
	10
	5 10 11 12 13 30 35 40 45 47

	dp[n] = n번째 카드 구매한 비용 vs Dp[n - k] + dp[k] 비용
	 */
	private static void dynamic(int N, int[] card) {

		int[] dp = new int[N + 1];
		dp[0] = 0;

		for (int i = 1; i <= N; i++) {
			dp[i] = card[i - 1];
			for (int j = 0; j <= i ; j++) {
				dp[i] = Math.min(dp[i], dp[i-j] + dp[j]);
			}
		}

		System.out.println(dp[N]);
	}
}
