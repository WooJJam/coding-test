import java.io.*;
import java.util.*;

public class Main {

	static class Camera {
		int type;
		int x;
		int y;

		public Camera(int type, int x, int y) {
			this.type = type;
			this.x = x;
			this.y = y;
		}
	}

	static int[][] room;
	static ArrayList<Camera> camera = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		room = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(N, M, room);
		System.out.println(answer);
	}

	private static void solve(int N, int M, int[][] room) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (room[i][j] != 0 && room[i][j] != 6) {
					camera.add(new Camera(room[i][j], i, j));
				}
			}
		}

		rotate(N, M, 0, camera.size(), new int[camera.size()]);
	}

	/* 회전을 포함한 모든 경우의 수를 백트래킹으로 찾기 */
	private static void rotate(int N, int M, int depth, int size, int[] list) {

		if (depth == size) {
			// 해당 경우의 수로 탐색 시작
			int count = monitor(N, M, list);
			answer = Math.min(answer, count);
			return;
		}

		for (int i = 0; i < 4; i++) {
			list[depth] = i;
			rotate(N, M, depth + 1, size, list);
		}
	}

	/*
	1 -> dir로 한쪽 방향만 쭉 탐색하면 됨
	2 -> dir 2개면 충분
	3 -> (위, 오), (오, 아래), (왼, 아래), (위, 오)
	4 -> (위, 오, 아), (오, 아래, 왼), (아래, 왼, 위), (왼, 위, 아래)
	 */
	private static int monitor(int N, int M, int[] list) {

		int[][] copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			copy[i] = Arrays.copyOf(room[i], room[i].length);
		}

		for (int i = 0; i < camera.size(); i++) {
			int type = camera.get(i).type;
			int x = camera.get(i).x;
			int y = camera.get(i).y;

			int dir = list[i];

			switch (type) {
				case 1: {
					search(dir, N, M, x, y, copy);
					break;
				}
				case 2: {
					search(dir, N, M, x, y, copy);
					search((dir + 2) % 4, N, M, x, y, copy);
					break;
				}
				case 3: {
					if (dir == 0) {
						search(0, N, M, x, y, copy);
						search(1, N, M, x, y, copy);
					}

					if (dir == 1) {
						search(1, N, M, x, y, copy);
						search(2, N, M, x, y, copy);
					}

					if (dir == 2) {
						search(2, N, M, x, y, copy);
						search(3, N, M, x, y, copy);
					}

					if (dir == 3) {
						search(3, N, M, x, y, copy);
						search(0, N, M, x, y, copy);
					}
					break;
				}
				case 4: {
					if (dir == 0) {
						search(0, N, M, x, y, copy);
						search(1, N, M, x, y, copy);
						search(2, N, M, x, y, copy);
					}

					if (dir == 1) {
						search(1, N, M, x, y, copy);
						search(2, N, M, x, y, copy);
						search(3, N, M, x, y, copy);
					}

					if (dir == 2) {
						search(2, N, M, x, y, copy);
						search(3, N, M, x, y, copy);
						search(0, N, M, x, y, copy);
					}

					if (dir == 3) {
						search(3, N, M, x, y, copy);
						search(0, N, M, x, y, copy);
						search(1, N, M, x, y, copy);
					}

					break;
				}
				case 5 : {
					for (int j = 0; j < 4; j++) {
						search(j, N, M, x, y, copy);
					}
				}

			}
		}

		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0) {
					count++;
				}
			}
		}

		return count;
	}

	private static void search(int dir, int N, int M, int x, int y, int[][] copy) {

		int nextX = x;
		int nextY = y;

		if (dir == 0) { // 위로만 탐색
			nextX -= 1;
		}

		if (dir == 1) { // 오른쪽으로만 탐색
			nextY += 1;
		}

		if (dir == 2) { // 아래로만 탐색
			nextX += 1;
		}

		if (dir == 3) { // 왼쪽로만 탐색
			nextY -= 1;
		}

		if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && room[nextX][nextY] != 6) {
			if (copy[nextX][nextY] == 0) {
				copy[nextX][nextY] = -1;
			}

			search(dir, N, M, nextX, nextY, copy);
		}

	}
}
