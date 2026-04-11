import java.io.*;
import java.util.*;

public class Main {

	/*
	3
	3 3 0 1
	4 2 1 3
	4 2 2 1
	 */

	static ArrayList<Integer> direction;
	static int answer = 0;

	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {1, 0, -1, 0};
	static boolean[][] map = new boolean[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken()); // 가로
			int y = Integer.parseInt(st.nextToken()); // 세로
			int d = Integer.parseInt(st.nextToken()); // 방향
			int g = Integer.parseInt(st.nextToken()); // 세대

			getGeneration(d, g);
			draw(x, y);
		}

		getAnswer();
		System.out.println(answer);
	}

	/*
	1. 각 방향을 기준으로 세대를 구해야 한다.
		- 첫 방향을 배열에 삽입
		- 배열의 마지막 요소부터 1개씩 꺼내 방향을 + 1 더한다.
			- 만약 방향이 4이상 -> 0
			- 만약 방향이 0미만 -> 3
		- 더한 방향을 다시 배열에 삽입
		- 0부터 g까지 반복
	 */
	private static void getGeneration(int d, int g) {

		direction = new ArrayList<>();
		direction.add(d);

		while(g-- > 0) {
			for (int i = direction.size() - 1; i >= 0; i--) {
				int dir = direction.get(i);
				dir = (dir + 1) % 4;
				direction.add(dir);
			}
		}
	}

	/*
	2. 구한 방향을 기준으로 그림을 그린다
		- boolean[][] map = new Boolean[101][101];
		- dir == 0
			-> x + 1
		- dir == 1
			-> y + 1
		- dir == 2
			-> x - 1
		- dir == 3
			-> y - 1
	 */
	private static void draw(int x, int y) {

		int nextY = y;
		int nextX = x;

		map[nextY][nextX] = true;

		for (int dir : direction) {
			nextY += dy[dir];
			nextX += dx[dir];
			map[nextY][nextX] = true;
		}
	}

	private static void getAnswer() {

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (i == 100 || j == 100) {
					break;
				}
				if (map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) {
					answer++;
				}
			}
		}
	}

}
