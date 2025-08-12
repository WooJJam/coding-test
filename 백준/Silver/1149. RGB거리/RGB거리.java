import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<ArrayList<Integer>> paints = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		/**
		 * 첫번째 Red 선택 -> 두번째는 Green or Blue만 가능
		 * 첫번째 Green 선택 -> 두번째는 Red or Blue만 가능
		 * 첫번째 Blue 선택 -> 두번째는 Red or Green만 가능
		 * 전체 탐색을 해야함.. 근데 시초는 0.5초이므로 완탐은 안될 것 같고,, DP로 풀어야 할 것 같다.
		 *
		 * 아이디어
		 * - 2차원 DP 배열 (paint[N][3]) 사용
		 *  - paint[i][0] : i번째 집을 Red로 칠했을 때의 최소 비용
		 *  - paint[i][1] : i번째 집을 Green으로 칠했을 때의 최소 비용
		 *  - paint[i][2] : i번째 집을 Blue로 칠했을 때의 최소 비용
		 *
		 *  paint[0][0] = 첫번째 레드
		 *  paint[0][1] = 첫번째 그린
		 *  paint[0][2] = 첫번째 블루
		 *
		 *  paint[1][0] -> 첫번째 그린 or 블루 선택 + 레드선택 (dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + paint[i][0])
		 *  paint[1][1] -> 첫번째 레드 or 블루 선택 + 그린선택 (dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + paint[i][1])
		 *  paint[1][2] -> 첫번째 레드 or 그린 선택 + 블루선택 (dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + paint[i][2])
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			paints.add(new ArrayList<>());
			for (int j = 0; j < 3; j++) {
				paints.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		dynamic(N);

	}

	private static void dynamic(int N) {
		int[][] dp = new int[N][3];

		dp[0][0] = paints.get(0).get(0); // 첫번째 집을 Red로 칠했을 때의 비용
		dp[0][1] = paints.get(0).get(1); // 첫번째 집을 Green으로 칠했을 때의 비용
		dp[0][2] = paints.get(0).get(2); // 첫번째 집을 Blue로 칠했을 때의 비용

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + paints.get(i).get(0); // Red 선택
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + paints.get(i).get(1); // Green 선택
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + paints.get(i).get(2); // Blue 선택
		}

		int answer = Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
		System.out.println(answer);
	}
}
