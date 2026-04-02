import java.io.*;
import java.util.*;

public class Main {

	/*
	5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0
	 */

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static class Node {
		int x;
		int y;
		int count;

		public Node(final int x, final int y, final int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] ice = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = solve(ice, N, M);
		bw.write(answer + "\n");
		bw.flush();
		bw.close();

	}

	private static int solve(int[][] ice, int N, int M) {

		int iceberg = 0;
		int year = 0;

		while (iceberg < 2) {
			iceberg = 0;
			ArrayList<Node> iceInfo = new ArrayList<Node>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (ice[i][j] != 0) {
						int iceCount = search(ice, N, M, i, j);
						iceInfo.add(new Node(i, j, iceCount));
					}
				}
			}

			melt(ice, iceInfo);

			boolean[][] visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (ice[i][j] != 0 && !visited[i][j]) {
						dfs(ice, N, M, i, j, visited);
						iceberg++;
					}
				}
			}

			if (iceberg == 0) {
				return 0;
			}

			year ++;
		}

		return year;
	}

	/*
	1. 4방향으로 탐색한다.
	2. 만약 0이 존재한다면 그 갯수를 센다.
	3. 배열에 (좌표, 녹일 횟수) 를 저장한다
	 */
	private static int search(int[][] ice, int N, int M, int x, int y) {

		int count = 0;

		for (int i = 0; i < 4; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && ice[nextX][nextY] == 0) {
				count++;
			}
		}

		return count;

	}

	private static void melt(int[][] ice, ArrayList<Node> ices) {

		for(Node node : ices) {
			int x = node.x;
			int y = node.y;
			int count = node.count;

			ice[x][y] -= count;
			if (ice[x][y] < 0) {
				ice[x][y] = 0;
			}
		}
	}

	private static void dfs(int[][] ice, int N, int M, int x, int y, boolean[][] visited) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && ice[nextX][nextY] != 0 && !visited[nextX][nextY]) {
				dfs(ice, N, M, nextX, nextY, visited);
			}
		}
	}
}
