import java.io.*;
import java.util.*;

public class Main {

	static int[] dp = new int[1_001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[1_001];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, 1);

		int answer = solve(N, A);
		System.out.println(answer);
	}

	private static int solve(int N, int[] A) {
		for (int i = 2; i <= N; i++) {
			for (int j = i; j >= 0; j--) {
				if (A[i] < A[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		return Arrays.stream(dp).max().getAsInt();
	}
}
