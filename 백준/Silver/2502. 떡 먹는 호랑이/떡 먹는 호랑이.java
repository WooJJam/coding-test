import java.io.*;
import java.util.*;

public class Main {

	static int[] dp = new int[31];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		solve(D, K);
		
		System.out.println(dp[1]);
		System.out.println(dp[2]);
	}

	private static void solve(int D, int K) {

		dp[D] = K;

		for (int i = K - 1; i >= 1; i--) { // 떡의 갯수는 K -1개부터 시작
			dp[D - 1] = i;

			for (int j = D - 1; j > 1; j--) { // D - 1일부터 시작
				dp[j - 1] = dp[j + 1] - dp[j]; // 3일차 = 5일차 - 4일차

				if(dp[j - 1] >= dp[j]) { // n일차 떡의 갯수보다 n + 1일차의 떡이 더 많아야 함 (3일차 < 4일차)
					dp[j - 1] = 0;
					break;
				}
			}

			if (dp[1] > 0) {
				break;
			}
		}

	}
}
