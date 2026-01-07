import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[][] copyIce;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static int maxArea = 0;
	static int count = 0;
	static int totalSum;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int size = (int)Math.pow(2, N);
		int[][] ice = new int[size][size];
		visited = new boolean[size][size];
		copyIce = new int[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < size; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		/*
		1. L만큼 격자를 잘라서 90도 회전
		2. 회전한 배열의 매 좌표마다 4방향 인접 검사
			- 0인 좌표값을 찾아서 2개 이상이라면 -> 현재 얼음의 양 -1 감소
		3. dfs로 가장 큰 깊이 검색
		 */
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			rotate(ice, size, L);
			iceCheck(size, ice);
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(ice[i][j] != 0 && !visited[i][j]) {
					count = 1;
					dfs(i, j, size, ice);
					maxArea = Math.max(maxArea, count);
				}
			}
		}

		System.out.println(totalSum);
		System.out.println(maxArea);
	}

	private static void rotate(int[][] ice, int size, int L) {
		int level = (int)Math.pow(2, L);

		for (int i = 0; i < size; i+=level) {
			for (int j = 0; j < size; j+=level) {
				copy(ice, size);
				for (int x = 0; x < level; x++) {
					int k = level;
					for (int y = 0; y < level; y++) {
						ice[i + x][j + y] = copyIce[i + k - 1][j + x];
						k--;
					}

				}
			}
		}

		// print(ice);
	}

	static void iceCheck(int size, int[][] ice) {

		ArrayList<int[]> meltIce = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int cnt = 0;

				if(ice[i][j] == 0) {
					continue;
				}

				for (int k = 0; k < 4; k++) {
					int nextX = dx[k] + i;
					int nextY = dy[k] + j;

					if(0 <= nextX && nextX < size && 0 <= nextY && nextY < size) {
						if (ice[nextX][nextY] != 0) {
							cnt++;
						}
					}
				}

				if (cnt < 3) {
					meltIce.add(new int[] {i, j});
				}

			}

		}
		for (int[] i : meltIce) {

			ice[i[0]][i[1]] -= 1;
		}
	}

	private static void dfs(int x, int y, int size, int[][] ice) {

		visited[x][y] = true;
		totalSum += ice[x][y];

		for (int i = 0; i < 4; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;

			if(0 <= nextX && nextX < size && 0 <= nextY && nextY < size && !visited[nextX][nextY] && ice[nextX][nextY] != 0) {
				count++;
				dfs(nextX, nextY, size, ice);
			}
		}

	}

	private static void print(final int[][] ice) {
		for (int i = 0; i < 8; i++) {
			System.out.println();
			if(i==4) {
				System.out.println("-------------------");
			}
			for (int j = 0; j < 8; j++) {
				if(j == 4) {
					System.out.print(" | ");
				}
				System.out.print(ice[i][j] + " ");
			}
		}
	}

	private static void copy(int[][] ice, int size) {

		for (int i = 0; i < size; i++) {
			System.arraycopy(ice[i], 0, copyIce[i], 0, size);
		}
	}
}

/*

1. 시계방향으로 회전하는게 필요 (2^L 만큼 나눠서)
L = 1

1 2 3 4 |5 6 7 8
8 7 6 5 |4 3 2 1
1 2 3 4 |5 6 7 8
8 7 6 5 |4 3 2 1
----------------
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1

8 1 6 3 4 5 2 8
7 2 5 4 3 6 1 8

0번째 행 -> n번째 열
1번째 행 -> n-1번째 열
2번째 행 -> n-2번째 열
3번째 행 -> n-3번째 열

for (i) -> 격자 단위 세로 -> 0
for (j) -> 격자 단위 가로 -> 4
for (x) -> 격자 내 세로 -> 0, 1, 2, 3
for (y) -> 격자 내 가로 -> 0, 1, 2, 3

(0,4) -> (0,7)
(0,5) -> (1,7)

(1,4) -> (0,6)
(1,5) -> (1,6)


(0,4) = (3,4)
(0,5) = (2,4)
(0,6) = (1,4)
(0,7) = (0,4)

(1,4) = (3, 5)
(1,5) = (2, 5)
(1,6) = (1, 5)
(1,7) = (0, 5)

level == 4
(x + i, y + j) = (i + 변수 - 1) (level + x)
(0 + 0, 0 + 4) = (0 + 4 - 1), (level + x)
(0 + 0, 1 + 4) = (0 + 3 - 1), (level + x)
(0 + 0, 3 + 4) = (0 + 2 - 1)
(0 + 0, 4 + 4) = (0 + 1 - 1)
-> 변수는 매번 -- 해야함

(x + i, y + j) = (i + 변수 - 1) (level + x)
(1,4) = (3, 5)
(1,5) = (2, 5)
(1,6) = (1, 5)
(1,7) = (0, 5)

(1 + 0, 0 + 4) = (0 + 4 - 1), (4 + 1)
(1 + 0, 0 + 5) = (0 + 3 - 1), (4 + 1)
(1 + 0, 0 + 6) = (0 + 2 - 1), (4 + 1)
(1 + 0, 0 + 7) = (0 + 1 - 1), (4 + 1)

L = 1
(0,0) = (1,0)
(0,1) =(0,0)

(1,0) -> (1,1)
(1,1) -> (0,1)

(x + i, y + j) = (i + 변수 - 1) (j + x)

 */
