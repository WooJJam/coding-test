import java.io.*;
import java.util.*;

public class Main {
	/*
2 20 50
50 30
20 40
	 */

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static int[][] country;
	static ArrayList<int[]> moveInfo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		country = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = solve(N, L, R);
		System.out.println(answer);
	}

	private static int solve(int N, int L, int R) {

		int day = 0;

		while(day <= 2000) {
			int moveCount = 0;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						moveInfo = new ArrayList<>();
						dfs(N, L, R, i, j);

						if (moveInfo.size() > 1) {
							move();
							moveCount++;
						}
					}
				}
			}

			if (moveCount == 0) {
				break;
			}

			day++;

		}

		return day;
	}

	private static void dfs(int N, int L, int R, int x, int y) {

		visited[x][y] = true;
		moveInfo.add(new int[] {x, y});

		for (int i = 0; i < 4; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !visited[nextX][nextY]) {
				int result = Math.abs(country[x][y] - country[nextX][nextY]);
				if (L <= result && result <= R) {
					dfs(N, L, R, nextX, nextY);
				}
			}
		}
	}

	private static void move() {

		int human = 0;

		for(int[] pos: moveInfo) {
			human += country[pos[0]][pos[1]];
		}

		int result = human / moveInfo.size();

		for (int[] pos : moveInfo) {
			country[pos[0]][pos[1]] = result;
		}
	}

}

