import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			triangle.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j <= i; j++) {
				triangle.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		dynamic(N, triangle);

	}

	private static void dynamic(int N, ArrayList<ArrayList<Integer>> triangle) {

		int[][] dp = new int[501][501];

		dp[0][0] = triangle.get(0).get(0); // 젤 윗층은 입력값 고정

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (i + 1 < N) {
					dp[i+1][j] = Math.max(dp[i+1][j], triangle.get(i+1).get(j) + dp[i][j]);
					dp[i+1][j+1] = Math.max(dp[i+1][j+1], triangle.get(i+1).get(j+1) + dp[i][j]);
				}
			}
		}

		System.out.println(Arrays.stream(dp[N-1]).max().getAsInt());

	}
}
