import java.io.*;
import java.util.*;

import com.sun.jdi.IntegerType;

public class Main {

	static int[][] maps;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	// 0이 아래, 1이 오른쪽

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
			if (search(N, L, 0, i, 0)) {
				answer++;
			}

			if (search(N, L, i, 0, 1)) {
				answer++;
			}
		}

		return answer;
	}

	// dir = 0 아래, dir = 1 오른쪽
	/*
	아래이면..
	(1,0), (2,0) ... y가 고정이다.

	오른쪽이면
	(0,1), (0,2) ... x가 고정이다.
	 */
	private static boolean search(int N, int L, int x, int y, int dir) {

		int count = 1;
		boolean isValid = true;

		while (true) {
			int nextX = dx[dir] + x;
			int nextY = dy[dir] + y;

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
				if (Math.abs(maps[x][y] - maps[nextX][nextY]) >= 2) {
					isValid = false;
					break;
				}

				if (maps[x][y] == maps[nextX][nextY]) {
					count++;

					if (dir == 0) {
						x = nextX;
					} else {
						y = nextY;
					}
				} else if (maps[x][y] < maps[nextX][nextY]) {
					if (count < L) {
						isValid = false;
						break;
					}

					count = 1;

					if (dir == 0) {
						x = nextX;
					} else {
						y = nextY;
					}

				} else if (maps[x][y] > maps[nextX][nextY]) {
					if (!search2(L, N, x, y, dir, maps[nextX][nextY])) {
						isValid = false;
						break;
					}

					count = 0;

					if (dir == 0) {
						x = nextX + L - 1;
					} else {
						y = nextY + L - 1;
					}
				}

			} else {
				break;
			}
		}

		return isValid;
	}

	private static boolean search2(int L, int N, int x, int y, int dir, int target) {

		int nextX = x;
		int nextY = y;

		int count = 0;
		while(count != L) {

			nextX += dx[dir];
			nextY += dy[dir];

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
				if (target != maps[nextX][nextY]) {
					return false;
				}
				count++;
			} else {
				return false;
			}
		}

		return true;
	}
}
