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

		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		dynamic(N, num);
	}

	private static void dynamic(int N, int[] num) {

		int[] dp = new int[N];
		dp[0] = num[0];

		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
		}

		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}
