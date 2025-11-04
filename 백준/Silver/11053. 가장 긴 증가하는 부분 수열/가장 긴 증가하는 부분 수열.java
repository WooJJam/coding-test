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
		int[] array = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		dynamic(N, array);
	}

	private static void dynamic(int N, int[] array) {

		int[] dp = new int[1_001];

		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (array[i - 1] > array[j - 1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}
