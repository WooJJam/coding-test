import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solve(N, arr));

	}

	private static int solve(int N, int[] arr) {
		int[] dp = new int[1001];
		dp[0] = arr[0];

		if (N >= 0) {
			System.arraycopy(arr, 1, dp, 1, N);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(arr[i] + dp[j], dp[i]);
				}
			}
		}

		return Arrays.stream(dp).max().getAsInt();
	}
}
