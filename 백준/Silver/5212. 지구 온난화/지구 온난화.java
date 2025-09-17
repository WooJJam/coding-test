import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static char[][] future;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R+2][C+2];

		for (int i = 0; i < R+2; i++) {
			Arrays.fill(map[i], '.');
		}

		future = new char[R+2][C+2];

		for (int i = 1; i < R + 1; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 1; j < C + 1; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}

		for (int i = 1; i < R + 2; i++) {
			for (int j = 1; j < C + 2; j++) {
				future[i][j] = map[i][j];

				if (map[i][j] == 'X') {
					search(i, j, R, C, map);
				}
			}
		}

		cutMap(R, C, map);
	}

	private static void search(int x, int y, int R, int C, char[][] map) {

		int count = 0;
		future[x][y] = map[x][y];

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (0 <= nextX && nextX < R + 2 && 0 <= nextY && nextY < C + 2&& map[nextX][nextY] == '.') {
				count++;
			}
		}

		// 50년 뒤에 바다가 되는 곳
		if (count >= 3) {
			future[x][y] = '.';
		}
	}

	private static void cutMap(int R, int C, char[][] map) {
		int up = R;
		int down = 0;
		int left = C;
		int right = 0;

		for (int i = 1; i < R + 2; i++) {
			for (int j = 1; j < C + 2; j++) {
				if (future[i][j] == 'X') {
					up = Math.min(up, i);
					left = Math.min(left, j);
					down = Math.max(down, i);
					right = Math.max(right, j);
				}
			}
		}
		
		for (int i = up; i <= down; i++) {
			for (int j = left; j <= right; j++) {
				System.out.print(future[i][j]);
			}
			System.out.println();
		}
	}

}
