import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] files = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			files[i] = Integer.parseInt(st.nextToken());
		}

		dynamic(n, files);
	}

	/*
	dp[i] = i번째에 담긴 상자의 최대 갯수

	dp[i] = max(dp[i], dp[j] + 1)
	1. 모든 dp 배열을 1로 초기화 (현재 상자를 선택)
	2. 현재 index 이전의 파일 배열을 탐색
	3. 만약 이전의 파일을 담을 수 있다면 해당 dp[j] + 1 과 dp[i] (현재) 의 최대값

	 */
	private static void dynamic(int n, int[] files) {

		int[] dp = new int[n];

		Arrays.fill(dp, 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (files[i] > files[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int result = Arrays.stream(dp).max().getAsInt();
		System.out.println(result);
	}

}
