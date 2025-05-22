import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] room;
	static int answer = 1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		room = new int[N][M];

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(N, M, r, c, d);

	}

	private static void solve(int N, int M, int r, int c, int d) {

		room[r][c] = -1;
		// System.out.printf("r = %d, c = %d, d = %d ", r, c, d);
		// System.out.println();

		// 주변 칸중 청소되지 않은칸이 존재
		if (isDirtyRoom(N, M, r, c)) {
			d = rotate(d);
			// System.out.println("d = " + d);

			int nextX = r + dx[d];
			int nextY = c + dy[d];

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
				if (room[nextX][nextY] == 0) {
					answer += 1;
					solve(N, M, nextX, nextY, d);
				} else {
					solve(N, M, r, c, d);
				}
			}
		}

		// 청소되지 않은 칸이 존재하지 않음
		else {
			int nextX = r - dx[d];
			int nextY = c - dy[d];

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
				if (room[nextX][nextY] == 1) {
					System.out.println(answer);
					return;
				} else {
					solve(N, M, nextX, nextY, d);
				}
			}
		}


	}

	private static boolean isDirtyRoom(int N, int M, int r, int c) {

		for (int i = 0; i < 4; i++) {
			int nextX = r + dx[i];
			int nextY = c + dy[i];

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
				// 청소되지 않은 칸이 존재
				if (room[nextX][nextY] == 0) {
					return true;
				}
			}
		}

		return false;
	}

	private static int rotate(int d) {

		d -= 1;

		if (d < 0) {
			d = 3;
		}

		return d;
	}

}
