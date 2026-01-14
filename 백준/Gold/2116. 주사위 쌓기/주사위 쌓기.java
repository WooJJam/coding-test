import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] dice;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		dice = new int[N][6];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(N);
	}

	private static void solve(int N) {

		int answer = 0;

		for (int i = 0; i < 6; i++) {
			int sum = 0;
			int downIndex = i;
			int upIndex = pickUpIndex(downIndex);
			sum += findOfMaxSide(0, downIndex, upIndex);

			for (int j = 1; j < N; j++) {
				downIndex = pickDownIndex(j, upIndex);
				upIndex = pickUpIndex(downIndex);

				sum += findOfMaxSide(j, downIndex, upIndex);
			}

			answer = Math.max(answer, sum);
		}

		System.out.println(answer);
	}

	private static int pickUpIndex(int downIndex) {

		if (downIndex == 0) {
			return 5;
		}

		if (downIndex == 1) {
			return 3;
		}

		if (downIndex == 2) {
			return 4;
		}

		if (downIndex == 3) {
			return 1;
		}

		if (downIndex == 4) {
			return 2;
		}

		return 0;
	}

	private static int findOfMaxSide(int stair, int downIndex, int upIndex) {

		int max = 0;
		for (int i = 0; i < 6; i++) {
			if (i != downIndex && i != upIndex) {
				max = Math.max(max, dice[stair][i]);
			}
		}

		return max;
	}

	private static int pickDownIndex(int stair, int upIndex) {

		int index = 0;
		for (int i = 0; i < 6; i++) {
			if (dice[stair][i] == dice[stair - 1][upIndex]) {
				index = i;
				break;
			}
		}

		return index;
	}
}
