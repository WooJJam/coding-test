import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static PriorityQueue<Integer> pq;
	private static Boolean[][] visitied;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] zone = new int[N][N];
		// int maxHeight = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int height = Integer.parseInt(st.nextToken());
				zone[i][j] = height;
				// maxHeight = Math.max(maxHeight, height);
			}
		}

		int answer = 0;
		for (int k = 0; k < 101; k++) {
			initVisited(N);
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (zone[i][j] > k && !visitied[i][j]) {
						// System.out.println("i = " + i);
						// System.out.println("j = " + j);
						dfs(N, i, j, zone, k);
						count++;
					}
				}
			}

			// System.out.println("k: " + k + ", count: " + count);

			answer = Math.max(answer, count);
		}

		System.out.println(answer);

	}

	private static void dfs(int N, int x, int y, int[][] zone, int rain) {

		// System.out.println("x = " + x + " y = " + y);
		visitied[x][y] = true;

		for (int i = 0; i < 4; i++) {

			int nextX = dx[i] + x;
			int nextY = dy[i] + y;

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !visitied[nextX][nextY] && zone[nextX][nextY] > rain) {
				dfs(N, nextX, nextY, zone, rain);
			}
		}
	}

	private static void initVisited(int N) {
		visitied = new Boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visitied[i][j] = false;
			}
		}
	}
}
