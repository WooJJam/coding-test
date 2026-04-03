import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int answer = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(N, M);

		System.out.println(answer);
	}

	/*
	1. 백 트래킹으로 세울 수 있는 모든 벽의 위치 구하기 -> 조합
	2. 해당 위치에 벽 세우기
	3. 바이러스 전파 과정 시뮬레이션
	4. 바이러스 전파가 되지 않은곳 구하기 -> 0의 갯수
	 */
	private static void solve(int N, int M) {
		combination(N, M, 0, new int[3], 1);
	}

	private static void combination(int N, int M, int depth, int[] wall, int start) {

		if (depth == 3) {
			int[][] newMap = setWall(N, M, wall);
			spreadVirus(N, M, newMap);
			int safetyZone = getSafetyZone(N, M, newMap);
			answer = Math.max(answer, safetyZone);
			return;
		}

		for (int i = start; i <= N * M; i++) {
			int x = (i - 1) / M;
			int y = (i - 1) % M;

			if (map[x][y] != 0) {
				continue;
			}

			wall[depth] = i;
			combination(N, M, depth + 1, wall, i + 1);

		}
	}

	private static int[][] setWall(int N, int M, int[] wall) {

		int[][] copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}

		for (int w : wall) {
			int x = (w - 1) / M;
			int y = (w - 1) % M;

			copy[x][y] = 1;
		}

		return copy;
	}

	private static void spreadVirus(int N, int M, int[][] newMap) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newMap[i][j] == 2) {
					bfs(N, M, i, j, newMap);
				}
			}
		}
	}

	private static void bfs(int N, int M, int x, int y, int[][] newMap) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});

		while (!q.isEmpty()) {
			int[] loc = q.poll();
			int curX = loc[0];
			int curY = loc[1];

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && newMap[nextX][nextY] == 0) {
					q.add(new int[] {nextX, nextY});
					newMap[nextX][nextY] = -1;
				}
			}
		}
	}

	private static int getSafetyZone(int N, int M, int[][] newMap) {

		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newMap[i][j] == 0) {
					count++;
				}
			}
		}

		return count;
	}

	private static void print(int[] wall) {

		for (int i = 0; i < wall.length; i++) {
			System.out.printf("%d ", wall[i]);
		}
		System.out.println();
	}
}

/*
0: 빈 칸
1: 벽
2: 바이러스

N * M 2차원 배열에서 벽을 3개만 세운 뒤 바이러스가 전파 X 지역 찾기 -> 안전영역
0 <= N, M <= 8
64C3 ->
 */
