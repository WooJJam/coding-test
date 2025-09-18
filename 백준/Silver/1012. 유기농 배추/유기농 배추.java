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
	private static int[][] land;

	/*
	M: 가로 길이
	N: 세로 길이
	K: 배추의 갯수
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			land = new int[N][M];
			int answer = 0;

			for (int j = 0; j < N; j++) {
				Arrays.fill(land[j], 0);
			}

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());

				land[x][y] = 1;
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (land[j][k] == 1) {
						dfs(j, k, M, N);
						answer++;
					}
				}
			}

			System.out.println(answer);
		}

	}

	private static void dfs(int x, int y, int M, int N) {

		land[x][y] = 0;

		for (int i = 0; i < 4; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && land[nextX][nextY] == 1) {
				dfs(nextX, nextY, M, N);
			}
		}
	}
}
