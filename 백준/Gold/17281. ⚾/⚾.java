import java.io.*;
import java.util.*;

public class Main {

	static int[] battingLine = new int[10];
	static boolean[] selected = new boolean[10];
	static int[][] player;
	static int N;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		player = new int[N][10];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= 9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		battingLine[4] = 1;
		selected[4] = true;

		lineUp(2);

		// battingLine = new int[] {0, 2, 3, 4, 1, 5, 6, 7, 8, 9};
		// playBall();

		System.out.println(answer);
	}

	private static void lineUp(int depth) {

		if (depth == 10) {
			playBall();
			return;
		}

		for (int i = 1; i < 10; i++) {

			if (selected[i]) {
				continue;
			}

			battingLine[i] = depth;
			selected[i] = true;
			lineUp(depth + 1);
			selected[i] = false;
		}
	}

	private static void playBall() {

		int point = 0;
		int startBatter = 1;

		// 이닝 수 만큼 반복
		for (int i = 0; i < N; i++) {
			int outCount = 0;
			boolean[] base = new boolean[5];
			// System.out.println("------------" + i + " 회 시작 ----------");
			boolean isOver = false;
			while (outCount != 3) {
				for (int j = startBatter; j < 10; j++) {
					int batter = battingLine[j]; // 타자
					int hitting = player[i][batter]; // 타격 결과

					/*
					0 -> OUT : 아웃카운트는 증가하고, 3개면 다음 이닝으로 넘어감 -> 이때 현재 타자로부터 다음 타자
					1 -> 1루타: 모든 주자는 현재 base 기준으로 1개씩 이동
					2 -> 2루타: 모든 주자는 현재 base 기준으로 2개씩 이동
					3 -> 3루타: 모든 주자는 현재 base 기준으로 3개씩 이동
					4 -> 홈런: 모든 주자는 현재 base 기준으로 4개씩 이동 -> base[4] 에
		 			*/

					switch (hitting) {

						case 0: {
							outCount++;
							break;
						}

						case 1: {
							for (int k = 3; k >= 1; k--) {
								if (base[k]) { // 주자가 베이스에 있다면
									if (k == 3) { // 3루에 있다면 1점 획득, 주자 사라짐
										point++;
										base[3] = false;
										continue;
									}

									base[k] = false;
									base[k + 1] = true;
								}
							}

							base[1] = true;
							break;
						}
						case 2: {
							for (int k = 3; k >= 1; k--) {
								if (base[k]) { // 주자가 베이스에 있다면
									if (k == 3 || k == 2) { // 3루와 2루에 있다면 1점씩 획득, 주자 사라짐
										point++;
										base[k] = false;
										continue;
									}

									base[k] = false;
									base[k + 2] = true;
								}
							}

							base[2] = true;
							break;
						}
						case 3: {
							for (int k = 3; k >= 1; k--) {
								if (base[k]) { // 주자가 베이스에 있다면
									point++;
									base[k] = false;
								}
							}

							base[3] = true;
							break;
						}
						case 4: {
							for (int k = 3; k >= 1; k--) {
								if (base[k]) { // 주자가 베이스에 있다면
									point++;
									base[k] = false;
									continue;
								}
							}
							point++;
							break;
						}
					}

					if (outCount == 3) {
						startBatter = j + 1;

						if (startBatter == 10) {
							startBatter = 1;
						}

						isOver = true;
						break;
					}
				}

				if (!isOver) {
					startBatter = 1;
				}

			}
		}

		answer = Math.max(answer, point);
	}
}
