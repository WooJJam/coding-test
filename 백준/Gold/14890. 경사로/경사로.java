import java.io.*;
import java.util.*;

public class Main {

	static int[][] maps;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	// 0이 아래, 1이 오른쪽

	/*
	조건 1: 경사로는 낮은 칸에 놓을 수 있다.
	조건 2: L개의 연속된 칸에 접해야한다.
	조건 3: 낮은 칸과 높은 칸의 차이는 1
	조건 4: 이미 설치한 칸에는 설치가 불가능
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		maps = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = solve(N, L);
		System.out.println(answer);

	}

	private static int solve(int N, int L) {

		int answer = 0;
		for (int i = 0; i < N; i++) {
			boolean[][] visited = new boolean[N][N];
			if (search(N, L, visited, 0, i, 0)) {
				answer++;
			}
		}

		for (int i = 0; i < N; i++) {
			boolean[][] visited = new boolean[N][N];
			if (search(N, L, visited, i, 0, 1)) {
				answer++;
			}
		}

		return answer;
	}

	private static boolean search(int N, int L, boolean[][] visited, int x, int y, int dir) {

		for (int i = 0; i < N; i++) {

			int nextX = x + dx[dir];
			int nextY = y + dy[dir];

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
				// 차이가 2보다 크다면 false
				if (Math.abs(maps[x][y] - maps[nextX][nextY]) >= 2) {
					return false;
				}

				else if (maps[x][y] < maps[nextX][nextY]) {
					if (!prevSearch(N, L, visited, i, x, y, dir)) {
						return false;
					}
					x = nextX;
					y = nextY;
				}
				// 앞에가 더 크다면 다음 칸부터 쭉 탐색
				else if (maps[x][y] > maps[nextX][nextY]) {
					if (!nextSearch(N, L, visited, i, nextX, nextY, dir)) {
						return false;
					}

					if (dir == 0) {
						x += L;
					} else {
						y += L;
					}
				} else {
					x = nextX;
					y = nextY;
				}
			}
		}

		return true;
	}

	private static boolean prevSearch(int N, int L, boolean[][] visited, int i, int prevX, int prevY,
		int dir) {

		int target = maps[prevX][prevY];

		for (int j = 0; j < L; j++) {

			if (0 <= prevX && prevX < N && 0 <= prevY && prevY < N && target == maps[prevX][prevY]
				&& !visited[prevX][prevY]) {
				visited[prevX][prevY] = true;
				prevX -= dx[dir];
				prevY -= dy[dir];
			} else {
				return false;
			}
		}

		return true;
	}

	private static boolean nextSearch(int N, int L, boolean[][] visited, int i, int nextX, int nextY,
		int dir) {

		int target = maps[nextX][nextY];

		for (int j = 0; j < L; j++) {

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && target == maps[nextX][nextY] && !visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				nextX += dx[dir];
				nextY += dy[dir];
			} else {
				return false;
			}
		}

		return true;
	}
}
