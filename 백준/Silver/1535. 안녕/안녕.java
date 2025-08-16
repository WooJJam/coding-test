import java.io.*;
import java.util.*;

public class Main {

	static int[] L;
	static int[] J;

	/*
	사람의 수 N명
	체력 L
	기쁨 J

	dp(N, 99) -> N명의 사람이 있고, 최대 체력 제한이 99
	dp[20][100] = i번째 사람에게 인사 하였을 때, 최대 체력이 j라면 세준이가 느끼는 행복
	1. i번째 사람에게 인사하지 않는 경우
		- dp[i-1][j] (i번째 사람을 인사하지 않음)
	2. i번째 사람에게 인사하는 경우
		- dp[i-1][j - L[i]] + J[i] (i번째 사람을 인사함, 체력 감소)
	점화식 -> dp[i][j] = max(dp[i-1][j], dp[i-1][j-L[i]] + J[i])
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		L = new int[N];
		J = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}

		int answer = knapsack(N);

		System.out.println(answer);
	}

	private static int knapsack(int N) {
		int[][] dp = new int[N+1][100];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 99; j++) {
				if (L[i-1] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - L[i - 1]] + J[i - 1]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[N][99];
	}
}
