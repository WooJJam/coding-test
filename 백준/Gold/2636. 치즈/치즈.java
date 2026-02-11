import java.io.*;
import java.util.*;

/*
input:
13 12
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0
0 1 1 1 0 0 0 1 1 0 0 0
0 1 1 1 1 1 1 0 0 0 0 0
0 1 1 1 1 1 0 1 1 0 0 0
0 1 1 1 1 0 0 1 1 0 0 0
0 0 1 1 0 0 0 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
 */

public class Main {
	
	static int[][] maps;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로

		maps = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int air = Integer.parseInt(st.nextToken());
				maps[i][j] = air;
			}
		}

		int time = solve(N, M);
		System.out.println(time);
		System.out.println(answer);
	}

	private static int solve(int N, int M) {

		int time = 0;
		int x = 0;
		int y = 0;

		while(true) {
			visited = new boolean[N][M];
			int cnt = bfs(N, M, x, y);

			if (cnt == 0) {
				break;
			}

			answer = cnt;
			time++;
		}

		return time;
	}

	// 0,0애서 외부 공기와 맞닿은 치즈 찾기
	private static int bfs(int N, int M, int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x * M + y);

		while(!q.isEmpty()) {
			int pos = q.poll();
			int curX = pos / M;
			int curY = pos % M;
			visited[curX][curY] = true;

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if(0 <= nextX && nextX < N && 0 <= nextY && nextY < M && !visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					// 다음 위치가 공기인 경우
					if(maps[nextX][nextY] == 0) {
						q.offer(nextX * M + nextY);
					} else { // 다음 위치가 치즈인 경우
						maps[nextX][nextY] = -1;
					}
				}
			}

		}

		return melt(N, M);
	}

	private static int melt(int N, int M) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(maps[i][j] == -1) {
					maps[i][j] = 0;
					cnt++;
				}
			}
		}

		return cnt;
	}
}
