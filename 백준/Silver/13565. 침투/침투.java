import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] grid = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < line.length(); j++) {
				int num = Integer.parseInt(String.valueOf(line.charAt(j)));
				grid[i][j] = num;

				if (num == 1) {
					visited[i][j] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			dfs(M, N, 0, i ,grid);
		}

		for (int i = 0; i < N; i++) {
			if (grid[M-1][i] == 0 && visited[M-1][i]) {
				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");
	}

	private static void dfs(int M, int N, int x, int y, int[][] grid) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N && grid[nextX][nextY] != 1 && !visited[nextX][nextY]) {
				dfs(M, N, nextX, nextY, grid);
			}
		}
	}

}
