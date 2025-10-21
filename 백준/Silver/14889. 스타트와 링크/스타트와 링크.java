import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main {

	private static boolean[] selected;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] team = new int[N][N];
		selected = new boolean[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		selected[1] = true;
		selectTeam(team, N, 1, 2);
		System.out.println(answer);
	}

	private static void selectTeam(int[][] team, int N, int depth, int cur) {

		if (depth == N / 2) {
			int startTeam = 0;
			int linkTeam = 0;

			// 스타팀 능력치 계산
			for (int i = 1; i <= N; i++) {
				if (selected[i]) {
					for (int j = 1; j <= N; j++) {
						if (i != j && selected[j]) {
							startTeam += team[i - 1][j - 1];
						}
					}
				}
			}

			// 링크팀 능력치 계산
			for (int i = 1; i <= N; i++) {
				if (!selected[i]) {
					for (int j = 1; j <= N; j++) {
						if (i != j && !selected[j]) {
							linkTeam += team[i - 1][j - 1];
						}
					}
				}
			}

			answer = Math.min(answer, Math.abs(startTeam - linkTeam));
		} else {

			for (int i = cur; i <= N ; i++) {
				selected[i] = true;
				selectTeam(team, N, depth + 1, i + 1);
				selected[i] = false;
			}
		}

	}
}
