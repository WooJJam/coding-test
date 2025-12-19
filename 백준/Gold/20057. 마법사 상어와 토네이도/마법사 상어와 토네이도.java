import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static Sand[] left = {
		new Sand(-2, 0, 0.02), new Sand(-1, -1, 0.1), new Sand(-1, 0, 0.07), new Sand(-1, 1, 0.01),
		new Sand(0, -2, 0.05), new Sand(1, -1, 0.1), new Sand(1, 0, 0.07), new Sand(1, 1, 0.01),
		new Sand(2, 0, 0.02), new Sand(0, -1, 0)
	};

	static Sand[] down = {
		new Sand(0, -2, 0.02), new Sand(1, -1, 0.1), new Sand(0, -1, 0.07), new Sand(-1, -1, 0.01),
		new Sand(2, 0, 0.05), new Sand(1, 1, 0.1), new Sand(0, 1, 0.07), new Sand(-1, 1, 0.01),
		new Sand(0, 2, 0.02), new Sand(1, 0, 0)
	};

	static Sand[] right = {
		new Sand(2, 0, 0.02), new Sand(1, 1, 0.1), new Sand(1, 0, 0.07), new Sand(1, -1, 0.01),
		new Sand(0, 2, 0.05), new Sand(-1, 1, 0.1), new Sand(-1, 0, 0.07), new Sand(-1, -1, 0.01),
		new Sand(-2, 0, 0.02), new Sand(0, 1, 0)
	};

	static Sand[] up = {
		new Sand(0, 2, 0.02), new Sand(-1, 1, 0.1), new Sand(0, 1, 0.07), new Sand(1, 1, 0.01),
		new Sand(-2, 0, 0.05), new Sand(-1, -1, 0.1), new Sand(0, -1, 0.07), new Sand(1, -1, 0.01),
		new Sand(0, -2, 0.02), new Sand(-1, 0, 0)
	};

	static int[][] grid;
	static int answer = 0;
	static int sx;
	static int sy;

	static class Sand {
		int x;
		int y;
		double rate;

		public Sand(final int x, final int y, final double rate) {
			this.x = x;
			this.y = y;
			this.rate = rate;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		grid = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(N);
	}

	private static void solve(int N) {
		sx = N / 2;
		sy = N / 2;

		/*
		0 -> 왼쪽
		1 -> 아래
		2 -> 오른쪽
		3 -> 위
		 */
		for (int i = 0; i < N; i++) { // 1, 1 / 2, 2 / 3, 3/ 4, 4 ...
			if ((i + 1) % 2 != 0) { // 홀수 일때 왼쪽, 아래 이동
				move(N, i, 0);
				move(N, i, 1);
			} else {
				move(N, i, 2);
				move(N, i, 3);
			}
		}
	}

	private static void move(int N, int count, int dir) {

		for (int i = 0; i < count + 1; i++) {
			switch (dir) {
				case 0: // 토네이도가 왼쪽으로 이동
					sy--;
					blow(N, left);
					break;
				case 1: // 토네이도가 아래쪽으로 이동
					sx++;
					blow(N, down);
					break;
				case 2: // 토네이도가 오른쪽으로 이동
					sy++;
					blow(N, right);
					break;
				case 3: // 토네이도가 위쪽으로 이동
					sx--;
					blow(N, up);
					break;
			}
		}
	}

	private static void blow(int N, Sand[] sand) {

		if (sx < 0 || sy < 0) {
			System.out.println(answer);
			System.exit(0);
		}

		int totalBlownSand = 0;

		for (Sand s : sand) {
			int nextX = sx + s.x;
			int nextY = sy + s.y;
			double nextRate = s.rate;
			int blownSand;

			// 각 좌표별 비율에 따른 날린 모래를 구한다. (버림 활용)
			if (nextRate == 0.0) {
				blownSand = grid[sx][sy] - totalBlownSand;
				grid[sx][sy] = 0;
			} else {
				blownSand = (int)(nextRate * grid[sx][sy]);
			}

			// 다음 좌표가 격자 범위 안이라면 날린 모래를 다음 좌표에 넣어준다.
			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
				grid[nextX][nextY] += blownSand;
			} else {
				// 만약 좌표 밖이라면 격자 밖으로 날린 모래이기 때문에 총합을 구한다.
				answer += blownSand;
			}
			totalBlownSand += blownSand;
		}

	}
}
