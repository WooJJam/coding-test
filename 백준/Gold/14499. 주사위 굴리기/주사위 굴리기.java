import java.io.*;
import java.util.*;

import org.w3c.dom.Node;

public class Main {

	static int[][] maps;
	static int[] order;
	static int[] dice = new int[7];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		maps = new int[N][M];
		order = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}

		solve(N, M, y, x);
	}

	private static void solve(int N, int M, int y, int x) {

		for (int dir : order) {
			if (dir == 1) {
				if (0 <= x && x + 1 < M) {
					move(dir, ++x, y);
				}
			}

			if (dir == 2) {
				if (0 <= x - 1 && x < M) {
					move(dir, --x, y);
				}
			}

			if (dir == 3) {
				if (0 <= y - 1 && y < N) {
					move(dir, x, --y);
				}
			}

			if (dir == 4) {
				if (0 <= y && y + 1 < N) {
					move(dir, x, ++y);
				}
			}
		}
	}



	private  static void move(int dir, int x, int y) {

		int temp = dice[1];
		// 오른쪽으로 이동
		if (dir == 1) {
			dice[1] = dice[6];
			dice[6] = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
		}

		// 왼쪽으로 이동
		if (dir == 2) {
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[6];
			dice[6] = temp;
		}

		// 위로 이동
		if (dir == 3) {
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = dice[4];
			dice[4] = temp;
		}

		// 아래로 이동
		if (dir == 4) {
			dice[1] = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[2];
			dice[2] = temp;
		}

		if (maps[y][x] != 0) {
			dice[3] = maps[y][x];
			maps[y][x] = 0;
		} else {
			maps[y][x] = dice[3];
		}
		
		System.out.println(dice[1]);
	}
}
