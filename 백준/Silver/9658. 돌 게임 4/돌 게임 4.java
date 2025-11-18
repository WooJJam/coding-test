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

		dynamic(N);

	}

	/*
	먼저 뽑는 사람이 이기는 경우 -> 0
	뒤에 뽑는 사람이 이기는 경우 -> 1

	N = 1 -> 창영 (뒤에 뽑는 사람이 이김) 1
	N = 2 -> 상근 (먼저 뽑는 사람이 이김) 0
	N = 3 -> 창영 (뒤에 뽑는 사람이 이김) 1
	N = 4 -> 상근 (먼저 뽑는 사람이 이김) 0
	N = 5
	- 4개 뽑는 경우 (dp[1] = 1)
		-> 돌이 1개 남고, 현재 기준으로 뒤에 뽑는 사람이 이김 -> 즉, 먼저 뽑은놈이 이김 
	- 3개 뽑는 경우 (dp[2] = 0)
		-> 돌이 3개 남고, 현재 기준으로 먼저 뽑는 사람이 이김 -> 즉, 먼저 뽑은놈이 짐
	- 1개 뽑는 경우 (dp[4] = 1)
		-> 돌이 4개 남고, 현재 기준으로 먼저 뽑는 사람이 이김 -> 즉, 먼저 뽑은놈이 짐
	
	즉, dp[n-4] + dp[n-3] + dp[n-1] > 0 이라면 상근이가 이김
	-> 1개 뽑은 경우 돌은 4개가 남고,
	 */
	private static void dynamic(int N) {
		
		int[] dp = new int[1_001];
		
		dp[1] = 1;
		dp[2] = 0;
		dp[3] = 1;
		dp[4] = 0;

		for (int i = 5; i <= N; i++) {
			if (dp[i - 4] + dp[i - 3] + dp[i - 1] > 0) {
				dp[i] = 0;
			} else {
				dp[i] = 1;
			}
		}

		if (dp[N] == 0) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}
}
