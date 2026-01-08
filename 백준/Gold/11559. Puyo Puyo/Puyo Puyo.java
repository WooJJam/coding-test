import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static char[][] maps;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<int[]> records = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		maps = new char[12][6];
		visited = new boolean[12][6];

		for (int i = 0; i < 12; i++) {
			String line = new StringTokenizer(br.readLine()).nextToken();

			for (int j = 0; j < 6; j++) {
				char letter = line.charAt(j);
				maps[i][j] = letter;
			}
		}

		play();
		// print();
	}

	/*
	1. 반복문을 통해 뿌요를 찾는다.
	2. 뿌요를 찾을 경우 상하좌우 bfs를 돌린다.
		- 총 몇개와 연결이 되어있는지 찾기
		- 좌표는 모두 기록하고, 그 갯수를 계산
	2-1) 만약 4개 이상 연결
		- 기록한 좌표를 하나씩 '.' 으로 바꾸기
	2-2) 만약 4개 미만이라면 pass
		- 기록한 배열 clear


	3. 색깔인 좌표를 처음부터 찾는다.
		- 찾은 좌표의 아래 좌표들을 탐색
		- '.'이 있다면 갯수를 센다.
	4. 만약 '.'이 있다면
		- '.'의 갯수 + 문자의 좌표에 해당 문자 기록
		- 아래 좌표들의 수를 1개씩 줄여가며, 위로 탐색.
		- if) 다음 좌표가 0보다 작아지면 pass

	 */

	private static void play() {

		int answer = 0;

		while (true) {

			boolean flag = false;
			visited = new boolean[12][6];

			// System.out.println("-----------------");
			// System.out.println("answer = " + answer);
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (maps[i][j] != '.' && !visited[i][j]) {
						records.clear();
						bfs(i, j);
						// System.out.println("records = " + records.size());
						// 연쇄 작용 일어나야함 -> '.'으로 바꾸기
						if (records.size() >= 4) {
							destroy();
							fall();
							flag = true;
						}
					}
				}
			}
			// print();
			// System.out.println("-----------------");


			if (!flag) {
				break;
			}

			answer += 1;

		}

		System.out.println(answer);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {x, y});
		records.add(new int[] {x, y});
		visited[x][y] = true;
		char target = maps[x][y];

		while (!q.isEmpty()) {
			int[] loc = q.poll();
			int nowX = loc[0];
			int nowY = loc[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (0 <= nextX && nextX < 12 && 0 <= nextY && nextY < 6 && !visited[nextX][nextY]
					&& maps[nextX][nextY] == target) {
					q.offer(new int[] {nextX, nextY});
					records.add(new int[] {nextX, nextY});
					visited[nextX][nextY] = true;
				}
			}
		}
	}

	// 연쇄 작용
	private static void destroy() {

		for (int[] record : records) {
			int x = record[0];
			int y = record[1];
			maps[x][y] = '.';
		}
	}

	// 떨어뜨리는 작업
	// 4. 만약 '.'이 있다면
	// 	- '.'의 갯수 + 문자의 좌표에 해당 문자 기록
	// 	- 아래 좌표들의 수를 1개씩 줄여가며, 위로 탐색.
	// 	- if) 다음 좌표가 0보다 작아지면 pass

	private static void fall() {
		for (int i = 11; i >= 0; i--) {
			for (int j = 5; j >= 0; j--) {
				// System.out.println("i = " + i);
				// System.out.println("j = " + j);
				if (maps[i][j] != '.') {
					// System.out.printf("%d, %d", i, j);
					int count = searchFallCount(i, j);
					// System.out.println("count = " + count);
					// System.out.println(i + ", " + j);

					if (count > 0) {
						down(i, j, count);
					}
				}
			}
		}
	}

	// 3. 색깔인 좌표를 처음부터 찾는다.
	// 	- 찾은 좌표의 아래 좌표들을 탐색
	// 	- '.'이 있다면 갯수를 센다.
	private static int searchFallCount(int x, int y) {

		int nextX = x + 1;
		int count = 0;
		while (nextX < 12) {
			if (maps[nextX][y] != '.') {
				break;
			}
			// System.out.println("nextX = " + nextX);
			// System.out.println("y = " + y);
			// print();
			count += 1;
			nextX += 1;
		}

		return count;
	}

	// 4. 만약 '.'이 있다면
	// 	- '.'의 갯수 + 문자의 좌표에 해당 문자 기록
	// 	- 아래 좌표들의 수를 1개씩 줄여가며, 위로 탐색.
	// 	- if) 다음 좌표가 0보다 작아지면 pass
	private static void down(int x, int y, int count) {
		maps[count + x][y] = maps[x][y];
		maps[x][y] = '.';
		int nextX = x - 1;

		while (nextX >= 0) {
			if (maps[nextX][y] != '.') {
				maps[count + nextX][y] = maps[nextX][y];
				maps[nextX][y] = '.';
			}

			nextX -= 1;
		}
	}

	private static void print() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}
}

/*
input)
......
..YY..
.YGB..
.BGY..
.BGY..
.BYB..
.GBY..
.GBBB.
.BGGG.
.YGGY.
.YGGY.
.YBBB.

======
......
..YY..
.YGB..
.BGY..
.BGY..
.BYB..
.G.Y..
.G....
.B....
.Y..Y.
.Y..Y.
.YBBB.

......
......
.Y....
.B....
.B....
.B.Y..
.GYB..
.GGY..
.BGY..
.YGBY.
.YYYY.
.YBBB.

---------

......
......
.Y....
.B....
.B....
.B.Y..
..YB..
...Y..
.B.Y..
..GB..
......
..BBB.

......
......
.Y....
.B....
.B....
.B.Y..
..YB..
...Y..
.B.Y..
..GB..
......
..BBB.

 */
