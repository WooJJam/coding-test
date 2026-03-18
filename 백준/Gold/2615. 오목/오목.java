import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = {1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1};
	/*
	아래 (0)
	오른쪽 아래 (1) : (1, 1) -> (-1, -1)
	오른쪽 (2) : (0, 1) -> (0, -1)
	오른쪽 위 (3)
	 */
	static int[][] board = new int[19][19];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] answer = solve();

		System.out.println(answer[0]);

		if (answer[0] != 0) {
			System.out.printf("%d %d", answer[1], answer[2]);
		}
	}

	private static int[] solve() {

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				for (int k = 0; k < 4; k++) {
					if (board[i][j] != 0) {
						int count = search(i, j, k, board[i][j], 1);

						if (count == 5) {
							return new int[] {board[i][j], i + 1, j + 1};
						}
					}
				}
			}
		}

		return new int[] {0};
	}

	private static int search(int x, int y, int dir, int target, int count) {

		int nextX = x;
		int nextY = y;

		while (true) {

			nextX += dx[dir];
			nextY += dy[dir];

			if (0 <= nextX && nextX < 19 && 0 <= nextY && nextY < 19 && board[nextX][nextY] == target) {
				count++;
			} else {
				break;
			}
		}

		if (count == 5) {
			int prevX = x + dx[dir] * -1;
			int prevY = y + dy[dir] * -1;

			if (0 <= prevX && prevX < 19 && 0 <= prevY && prevY < 19 && board[prevX][prevY] == target) {
				count += 1;
			}
		}

		return count;
	}
}
