import java.io.*;
import java.util.*;

public class Main {

	static int[][] graph;
	static int sum = 1;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				graph[i][j] = 0;
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[r-1][c-1] = -1;
		}

		// for (int i = 0; i < N; i++) {
		// 	for (int j = 0; j < M; j++) {
		// 		System.out.print(graph[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == -1) {
					// System.out.println("----------");
					sum = 1;
					dfs(N, M, i, j);
				}
			}
		}

		System.out.println(answer);
	}

	private static void dfs(int N, int M, int x, int y) {

		graph[x][y] = 0;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && graph[nextX][nextY] == -1) {
				sum += 1;
				dfs(N, M, nextX, nextY);
			}
		}
		answer = Math.max(answer, sum);
	}
}

/*
5 5 10
1 1
2 1
3 1
4 1
5 1
1 3
2 3
3 3
1 5
3 2
 */
